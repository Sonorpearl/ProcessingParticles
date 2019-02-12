package Particle;

import processing.core.PVector;

public class Friction extends ParticleEffector
{

	public Friction(PVector _pos, float _strength)
	{
		super(_pos, _strength);
	}
	
	public void Apply(Particle[] _particles)
	{
		for (int i = 0; i < _particles.length; i++)
		{
			PVector particleVel = _particles[i].getVel();
			particleVel.mult(1/(1+strength));
		}
	}
}