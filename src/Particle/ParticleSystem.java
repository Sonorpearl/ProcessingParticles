package Particle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Processing.QuadTree;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class ParticleSystem
{
	public static PApplet parent;

	private int particleCount = 50;
	private Particle[] particles;
	private QuadTree quadTree;

	private ParticleEffector attractor;
	private ParticleEffector torus;
	private ParticleEffector friction;
	private ParticleEffector tracer;
	private ParticleEffector reflector;

	private List<ParticleEffector> effectors;

	// private Particle myParticle;

	public ParticleSystem(PApplet _parent)
	{
		parent = _parent;
		quadTree = new QuadTree(this, 0, 0, parent.width, parent.height);

		particles = new Particle[particleCount];
		CreateEffectors();
		CreateParticles();
	}

	public ParticleSystem(PApplet _parent, int _particleCount)
	{
		parent = _parent;
		particleCount = _particleCount;
		quadTree = new QuadTree(this, 0, 0, parent.width, parent.height);

		particles = new Particle[particleCount];
		CreateEffectors();
		CreateParticles();
	}
	
	public int GetCount()
	{
		return particles.length;
	}
	
	public PVector GetPos(int _id)
	{
		return particles[_id].getPos();
	}

	public void CreateEffectors()
	{
		effectors = new ArrayList<ParticleEffector>();
	}

	public void CreateParticles()
	{
		for (int i = 0; i < particles.length; i++)
		{
			particles[i] = new Particle(parent, this,
					new PVector(parent.random(parent.width), parent.random(parent.height), parent.random(-1000, 1000)), 1, 1);
		}
	}

	public void Setup()
	{
		parent.colorMode(PConstants.HSB, 360, 100, 100, 100);

		SetupAttractor();
		SetupTorus();
		SetupFriction();
		SetupTracer();
		SetupReflector();

		/*
		 * myParticle = new Particle( parent, this, new
		 * PVector(parent.random(parent.width), parent.random(parent.height),
		 * parent.random(-1000, 1000)), 1, 1);
		 */
	}

	public void SetupAttractor()
	{
		attractor = new Attractor(new PVector(0, 0, 0), 1);
		AddEffector(attractor);
	}

	public void SetupTorus()
	{
		torus = new Torus(new PVector(0, 0, 0), 1);
		AddEffector(torus);
	}
	
	public void SetupFriction()
	{
		friction = new Friction(new PVector(0, 0, 0), 0.01f);
		AddEffector(friction);
	}
	
	public void SetupTracer()
	{
		tracer = new Tracer(new PVector(0, 0, 0), 1f);
		AddEffector(tracer);
	}
	
	public void SetupReflector()
	{
		//reflector = new Reflector(new PVector(0, 0, 0), 1f);
		reflector = new Reflector(new PVector(0, 0, 0), 1f, 20f);
		AddEffector(reflector);
	}

	public void Draw()
	{
		parent.background(0);

		Update();

		Display();

		/*
		 * myParticle.setPos(new PVector(parent.mouseX, parent.mouseY, 0));;
		 * 
		 * myParticle.display();
		 */
	}

	public void Display()
	{
		for (int i = 0; i < particles.length; i++)
		{
			particles[i].Display();
		}
		if(tracer != null)
		{
			((Tracer) tracer).Display(particles);
		}
		
		quadTree.Init();
		quadTree.Display();
		quadTree.Reset();
	}

	public void Update()
	{
		attractor.SetPos(new PVector(parent.mouseX, parent.mouseY, 0));

		for (ParticleEffector effector : effectors)
		{
			effector.Apply(particles);
		}

		for (int i = 0; i < particles.length; i++)
		{
			particles[i].Update();
		}
	}

	public void AddEffector(ParticleEffector _effector)
	{
		effectors.add(_effector);
	}
	
	public void ResizeArray()
	{
		particles = Arrays.copyOf(particles,  particles.length + 1);
	}
}