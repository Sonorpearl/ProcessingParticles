package Particle;

import processing.core.PVector;

public class Reflector extends ParticleEffector
{
	private float minDistance;
	
	public Reflector(PVector _pos, float _strength, float _minDistance)
	{
		super(_pos, _strength);
		minDistance = _minDistance;
	}

	public void Apply(Particle[] _particles)
	{
		PVector distance;
		for (int i = 0; i < _particles.length; i++)
		{
			for (int j = i + 1; j < _particles.length; j++)
			{
				Particle particle1 = _particles[i];
				Particle particle2 = _particles[j];

				distance = PVector.sub(particle1.getPos(), particle2.getPos());
				//if (distance.magSq() < (float) Math.pow(particle1.getSize() + particle2.getSize(), 2))
				if (distance.magSq() < (float) Math.pow(minDistance, 2))
				{
					distance.normalize().mult(strength);
					particle1.addVel(distance.mult(1/(1+distance.mag())));
					particle2.addVel(distance.mult(1/(1+distance.mag())).mult(-1));
				}
			}
		}
	}
}