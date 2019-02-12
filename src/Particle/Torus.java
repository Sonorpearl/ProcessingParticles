package Particle;

import processing.core.PVector;

public class Torus extends ParticleEffector
{
	public Torus(PVector _pos, float _strength)
	{
		super(_pos, _strength);
	}

	public void Apply(Particle[] _particles)
	{
		for (int i = 0; i < _particles.length; i++)
		{
			_particles[i].setTorus(false);

			PVector particlePos = _particles[i].getPos();
			if (particlePos.x > ParticleSystem.parent.width)
			{
				particlePos.x %= ParticleSystem.parent.width;
				_particles[i].setTorus(true);
			} else
			{
				if (particlePos.x < 0)
				{
					do
					{
						particlePos.x += ParticleSystem.parent.width;
					} while (particlePos.x < 0);
					_particles[i].setTorus(true);
				}
			}

			if (particlePos.y > ParticleSystem.parent.height)
			{
				particlePos.y %= ParticleSystem.parent.height;
				_particles[i].setTorus(true);
			} else
			{
				if (particlePos.y < 0)
				{
					do
					{
						particlePos.y += ParticleSystem.parent.height;
					} while (particlePos.y < 0);
					_particles[i].setTorus(true);
				}
			}
		}
	}
}