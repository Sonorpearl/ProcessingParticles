package Processing;

import java.util.ArrayList;
import java.util.List;

import Particle.ParticleSystem;
import processing.core.PVector;

public class QuadTree
{
	private Rect bounds;
	private QuadTree[] nodes;
	private List<Integer> particleIDs;

	private int MAX_PARTICLES = 10;

	private static ParticleSystem ps;

	public QuadTree(ParticleSystem _ps, float _x, float _y, float _width, float _height)
	{
		ps = _ps;
		bounds = new Rect(_x, _y, _width, _height);
		nodes = new QuadTree[4];
		particleIDs = new ArrayList<Integer>();
	}

	public QuadTree(float _x, float _y, float _width, float _height)
	{
		bounds = new Rect(_x, _y, _width, _height);
		nodes = new QuadTree[4];
		particleIDs = new ArrayList<Integer>();
	}

	public void Insert(int _partID)
	{
		if (nodes[0] == null)
		{
			particleIDs.add(_partID);
		} else
		{
			nodes[GetQuadrant(ps.GetPos(_partID))].Insert(_partID);
		}

		if (particleIDs.size() > MAX_PARTICLES)
		{
			Split();
			for (int ID : particleIDs)
			{
				nodes[GetQuadrant(ps.GetPos(ID))].Insert(ID);
			}
			particleIDs.clear();
		}
	}

	public void Init()
	{
		for (int i = 0; i < ps.GetCount(); i++)
		{
			Insert(i);
		}
	}

	public void Reset()
	{
		if (nodes[0] != null)
		{
			for (int i = 0; i < nodes.length; i++)
			{
				nodes[i].Reset();
			}
			nodes = new QuadTree[4];
		} else
		{
			particleIDs.clear();
		}
	}

	public List<Integer> Retrieve(int _partID, float _distance)
	{
		List<Integer> returnIDs = new ArrayList<Integer>();

		if (nodes[0] == null)
		{
			return particleIDs;
		} else
		{
			PVector partPos = ps.GetPos(_partID);
			Rect area = new Rect(partPos.x - _distance / 2, partPos.y - _distance / 2, _distance / 2, _distance / 2);
			for (QuadTree node : nodes)
			{
				if (node.IsOverlapping(area))
				{
					returnIDs.addAll(node.Retrieve(_partID, _distance));
				}
			}
			return returnIDs;
		}
	}

	private boolean IsOverlapping(Rect _area)
	{
		if (bounds.x + bounds.width < _area.x || bounds.y + bounds.height < _area.y || bounds.x > _area.x + _area.width
				|| bounds.y > _area.y + _area.height)
		{
			return false;
		} else
		{
			return true;
		}
	}

	private void Split()
	{
		float subWidth = bounds.width / 2;
		float subHeight = bounds.height / 2;

		nodes[0] = new QuadTree(bounds.x, bounds.y, subWidth, subHeight);
		nodes[1] = new QuadTree(bounds.x + subWidth, bounds.y, subWidth, subHeight);
		nodes[2] = new QuadTree(bounds.x, bounds.y + subHeight, subWidth, subHeight);
		nodes[3] = new QuadTree(bounds.x + subWidth, bounds.y + subHeight, subWidth, subHeight);
	}

	private int GetQuadrant(PVector _pos)
	{
		if (_pos.x < bounds.x + bounds.width / 2)
		{
			if (_pos.y < bounds.y + bounds.height / 2)
			{
				return 0;
			} else
			{
				return 2;
			}
		} else
		{
			if (_pos.y < bounds.y + bounds.height / 2)
			{
				return 1;
			} else
			{
				return 3;
			}
		}
	}

	public void Display()
	{
		ParticleSystem.parent.noFill();
		ParticleSystem.parent.stroke(0, 100, 100);
		ParticleSystem.parent.rect(bounds.x, bounds.y, bounds.width, bounds.height);
		for (QuadTree node : nodes)
		{
			if (node != null)
			{
				node.Display();
			}
		}
	}
}