package PhysicTest;

import java.util.ArrayList;
import java.util.List;

import PhysicTest.Ball;
import processing.core.PVector;
import processing.core.*;

public class PhysicsManager
{
	PApplet parent;

	private List<Ball> balls;

	private float BALL_RADIUS = 50f;
	private PVector BALL_VEL = new PVector(8, 8);

	private PVector gravity = new PVector(0, -9.81f);

	public PhysicsManager(PApplet _parent)
	{
		parent = _parent;
		balls = new ArrayList<Ball>();
	}

	public void AddBall()
	{
		AddBall(BALL_RADIUS, BALL_VEL);
	}

	public void AddBall(float _radius, PVector _vel)
	{
		Ball ball = new Ball(parent, _radius, _vel);
		ball.setup();
		balls.add(ball);
	}

	public void CallDraw()
	{
		for (Ball ball : balls)
		{
			ball.draw();
			ball.check();
			ball.vel.add(gravity.mult(Processing.MainApplet.deltaTime));
		}
	}
}