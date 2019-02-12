package Particle;
import processing.core.PApplet;
import processing.core.PVector;

public class Particle
{
	private PApplet parent;
	@SuppressWarnings("unused")
	private ParticleSystem ps;
	
	private PVector pos;
	public PVector getPos()
	{
		return pos;
	}
	public void setPos(PVector _pos)
	{
		pos = _pos;
	}
	public void addPos(PVector _vel)
	{
		pos.add(_vel);
	}
	
	private PVector vel;
	public PVector getVel()
	{
		return vel;
	}
	public void setVel(PVector _vel)
	{
		vel = _vel;
	}
	public void addVel(PVector _vel)
	{
		vel.add(_vel);
	}
	
	private float mass;
	public float getMass()
	{
		return mass;
	}
	
	private float size;
	public float getSize()
	{
		return size;
	}
	
	private boolean torus = false;
	public boolean getTorus()
	{
		return torus;
	}
	public void setTorus(boolean _torus)
	{
		torus = _torus;
	}
	
	public Particle(PApplet _parent, ParticleSystem _ps, PVector _pos, float _mass, float _size)
	{
		parent = _parent;
		ps = _ps;
		pos = _pos;
		vel = new PVector(0, 0, 0);
		mass = _mass;
		size = _size;
	}
	
	
	public void Display()
	{
		
		parent.stroke(0, 0, 100);
		parent.strokeWeight(size * PApplet.map(pos.z, -1000, 1000, 1, 20));
		parent.point(pos.x, pos.y);
	}
	
	public void Update()
	{
		addPos(vel);
	}
}