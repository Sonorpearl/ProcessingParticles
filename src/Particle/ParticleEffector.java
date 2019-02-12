package Particle;

import processing.core.PVector;

public abstract class ParticleEffector
{
	public PVector pos;
	public float strength;
	
	public ParticleEffector(PVector _pos, float _strength)
	{
		pos = _pos;
		strength = _strength;
	}
	
	public abstract void Apply(Particle[] _particles);
	
	public void SetPos(PVector _pos)
	{
		pos = _pos;
	}
}