package Particle;

import processing.core.PVector;

public class Attractor extends ParticleEffector
{

	public Attractor(PVector _pos, float _strength)
	{
		super(_pos, _strength);
	}

	public void Apply(Particle[] _particles)
	{
		PVector attraction;
		
		for (int i = 0; i < _particles.length; i++)
		{
			attraction = PVector.sub(pos, _particles[i].getPos());
			attraction.normalize();
			attraction.mult(strength);
			_particles[i].addVel(attraction);
		}
	}
}