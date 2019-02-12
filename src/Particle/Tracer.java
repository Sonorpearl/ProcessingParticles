package Particle;

import processing.core.PVector;

public class Tracer extends ParticleEffector
{
	private ParticleTrace[][] traces;
	private boolean firstFrame = true;
	private int frameCount = 0;
	private int frames = 50;
	private float colorMult = 255 / frames;

	public Tracer(PVector _pos, float _strength)
	{
		super(_pos, _strength);
	}

	public void Apply(Particle[] _particles)
	{
		if (traces == null)
		{
			traces = new ParticleTrace[_particles.length][frames];
		}

		for (int i = 0; i < _particles.length; i++)
		{
			traces[i][frameCount] = new ParticleTrace(_particles[i].getPos().copy(), _particles[i].getTorus());
		}

		frameCount++;
		if (frameCount >= frames)
		{
			frameCount = 0;
		}
		if (firstFrame)
		{
			firstFrame = false;
		}

	}

	public void Display(Particle[] _particles)
	{
		PVector pos1;
		PVector pos2;

		if (firstFrame)
		{
			return;
		}

		for (int i = 0; i < traces.length; i++)
		{
			ParticleSystem.parent.beginShape();

			ParticleSystem.parent.stroke(0, 0, 100);
			ParticleSystem.parent.strokeWeight(strength);
			ParticleSystem.parent.noFill();

			for (int f = frameCount + 1; f < frames + frameCount; f++)
			{
				int jp = f - 1;
				if (jp >= frames)
				{
					jp -= frames;
				}
				int jc = f;
				if (jc >= frames)
				{
					jc -= frames;
				}

				if (traces[i][jp] != null && traces[i][jc] != null)
				{
					if(traces[i][jp].trace)
					{
						ParticleSystem.parent.endShape();
						ParticleSystem.parent.beginShape();
					}
					pos1 = traces[i][jp].pos;
					pos2 = traces[i][jc].pos;

					ParticleSystem.parent.vertex(pos1.x, pos1.y, pos2.x, pos2.y);
					ParticleSystem.parent.stroke(jc * colorMult, 100, 100);
				}
			}
			ParticleSystem.parent.endShape();

		}
	}
}