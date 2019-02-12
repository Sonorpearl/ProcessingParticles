package PhysicTest;
import processing.core.PApplet;
import processing.core.PConstants;

public class TestClass
{
	private PApplet parent;

//	private PShape myShape;

	@SuppressWarnings("unused")
	private float x, y, z;

	public TestClass(PApplet _parent)
	{
		parent = _parent;
	}

	public void Setup()
	{
		x = parent.width / 2;
		y = parent.height / 2;
		z = 0;

		//SetupShape();
	}

	public void Draw()
	{
		//DrawShape();
		//DrawInput();
	}

	@SuppressWarnings("unused")
	private void SetupShape()
	{
//	parent.rectMode(PConstants.CENTER);
//	myShape = parent.createShape(PConstants.RECT, 0, 0, 200, 100);
//	myShape.setFill(parent.color(0));
//	myShape.setStroke(parent.color(255));
//	myShape.setStrokeWeight(3);

//	 myShape = loadShape("");
//	 myShape.scale(50);
//	
	}
	
	@SuppressWarnings("unused")
	private void DrawShape()
	{
//	 parent.translate(x, y, z);

//	myShape.rotateX(PApplet.radians(2f));
//	parent.shape(myShape, parent.width / 2, parent.height / 2);
	}
	
	@SuppressWarnings("unused")
	private void DrawInput()
	{
		if(parent.keyPressed)
		{
			if(parent.key == PConstants.CODED)
			{
				if(parent.keyCode == PConstants.ALT)
				{
					parent.background(0, 255, 0);
				}
				else
				{
					parent.background(255, 0, 0);
				}
			}
			else
			{
				parent.background(255);
			}
		}
		else
		{
			parent.background(0);
		}
		
		
		parent.strokeWeight(4);
		if (parent.mouseButton == PConstants.RIGHT)
		{
			parent.stroke(255);
		} else
		{
			parent.stroke(255, 0, 0);
		}
		parent.line(parent.mouseX, parent.mouseY, parent.pmouseX, parent.pmouseY);
	}
}