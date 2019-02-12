package Processing;
import Particle.ParticleSystem;
import PhysicTest.PhysicsManager;
import PhysicTest.TestClass;
import processing.core.*;

public class MainApplet extends PApplet
{
	public static float fps = 100;
	public static float deltaTime = 1 / fps;

	private InputManager inputManager;
	private ParticleSystem ps;

	private PhysicsManager physicsManager;

	@SuppressWarnings("unused")
	private TestClass testClass;

	private PImage img;

	public static void main(String[] args)
	{
		// "PackageName.ClassName"
		PApplet.main("Processing.MainApplet");
	}

	public void settings()
	{
		fullScreen(P3D);
	}

	public void setup()
	{
		frameRate(fps);

		// inputManager = new InputManager(this);

		ps = new ParticleSystem(this);
		ps.Setup();

		// SetupPhysics();
		// testClass = new TestClass(this);
		// testClass.Setup();

		// img
		// SetupImage();

	}

	public void draw()
	{
		background(0);

		// inputManager.displayPressedKeys();
		ps.Draw();

		// DrawPhysics();
		// testClass.Draw();

		// img
		// DrawImage();
	}

	@SuppressWarnings("unused")
	private void SetupPhysics()
	{
		physicsManager = new PhysicsManager(this);
		physicsManager.AddBall();
	}

	@SuppressWarnings("unused")
	private void DrawPhysics()
	{
		physicsManager.CallDraw();
	}

//	public void mousePressed()
//	{
//
//	}
//
//	public void mouseReleased()
//	{
//
//	}
//
//	public void mouseMoved()
//	{
//
//	}
//
//	public void mouseDragged()
//	{
//
//	}

	public void keyPressed()
	{
		if (inputManager != null)
		{
			inputManager.keyPressed();
		}
	}

	public void keyReleased()
	{
		if (inputManager != null)
		{
			inputManager.keyReleased();
		}
	}

	@SuppressWarnings("unused")
	private void SetupImage()
	{
		colorMode(HSB, 360, 100, 100, 100);
		img = loadImage("C:\\Users\\Sonor\\Pictures\\Bilder\\unnamed.jpg");

		loadPixels();
		for (int i = 0; i < pixels.length; i++)
		{
			pixels[i] = color(random(360), random(360), random(360));
		}
		updatePixels();
	}

	@SuppressWarnings("unused")
	private void DrawImage()
	{
		image(img, 0, 0);
	}
}