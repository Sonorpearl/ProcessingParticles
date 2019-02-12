package PhysicTest;
import processing.core.PApplet;
import processing.core.PVector;

public class Arc extends PApplet
{
	PVector cp1;
	PVector p1;
	PVector cp2;
	PVector p2;

	PVector[] curvePoints;
	PVector[] watchPoints1;
	PVector[] watchPoints2;

	public void setup()
	{
		curvePoints = new PVector[20];
		watchPoints1 = new PVector[curvePoints.length];
		watchPoints2 = new PVector[curvePoints.length];
		for (int i = 0; i < curvePoints.length; i++)
		{
			curvePoints[i] = new PVector(random(width), random(height));
			watchPoints1[i] = new PVector(random(width), random(height));
			watchPoints2[i] = new PVector(random(width), random(height));
		}
	}

	public void draw()
	{
		background(0, 255, 255);

		pushMatrix();

		beginShape();
		for (int i = 0; i < curvePoints.length; i++)
		{
			PVector cp = curvePoints[i];
			PVector wp1 = watchPoints1[i];
			PVector wp2 = watchPoints2[i];

			ellipse(cp.x, cp.y, 10, 10);

			// curveVertex(cp.x, cp.y);
			bezierVertex(wp1.x, wp1.y, wp2.x, wp2.y, cp.x, cp.y);
		}
		endShape();

		popMatrix();

	}

	public void setupCurve()
	{
		// cp1 = new PVector(0, 0);
		// cp2 = new PVector(width, height);
		// p1 = new PVector(random(width), random(height));
		// p2 = new PVector(random(width), random(height));
	}

	public void drawCurve()
	{
		// ellipse(cp1.x, cp1.y, 10, 10);
		// ellipse(cp2.x, cp2.y, 10, 10);
		// ellipse(p1.x, p1.y, 10, 10);
		// ellipse(p2.x, p2.y, 10, 10);

		// curve(cp1.x, cp1.y, p1.x, p1.y, p2.x, p2.y, cp2.x, cp2.y);
	}
}
