package PhysicTest;
import processing.core.PApplet;
import processing.core.PVector;

public class Ball
{
	PApplet parent;

	private PVector center;
	private PVector pos;

	private float radius;
	public PVector vel;

	public float resistance = 0.95f;

	public Ball(PApplet _parent, float _radius, PVector _vel)
	{
		parent = _parent;
		radius = _radius;
		vel = _vel;
	}

	public void setup()
	{
		center = new PVector(parent.width / 2, parent.height / 2);
		float rX = parent.random(-radius, radius);
		float rY = parent.random(-radius, radius);

		pos = center;
		pos.x += rX;
		pos.y += rY;
	}

	public void check()
	{
		boolean changed = false;

		if (pos.x <= 0 + radius || pos.x >= 1920 - radius)
		{
			PApplet.println("Change X");
			vel.x *= -1;
		}

		if (pos.y <= 0 + radius || pos.y >= 1080 - radius)
		{
			PApplet.println("Change Y");
			vel.y *= -1;
		}

		if (changed)
		{
			draw();
			vel.mult(resistance);
		}
	}

	public void draw()
	{
		pos.add(vel);

		float radii = radius * 2;
		parent.ellipse(pos.x, pos.y, radii, radii);
	}
}