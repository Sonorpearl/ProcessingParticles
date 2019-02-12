package PhysicTest;
import processing.core.PApplet;

public class Push extends PApplet
{
	float rotation = 0;

	public void setup()
	{

	}

	public void draw()
	{
		background(0);
		rect(width / 2, height / 2, 200, 1000);

		pushMatrix();
		translate(width / 2, height / 2);
		rotate(radians(rotation));
		rect(0, 0, 200, 100);
		popMatrix();

		rotation += 2;
	}
}