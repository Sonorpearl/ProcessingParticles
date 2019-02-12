package Particle;

import processing.core.PVector;

public class ParticleTrace
{
	public PVector pos;
	public boolean trace;

	public ParticleTrace(PVector _pos)
	{
		pos = _pos;
		trace = false;
	}

	public ParticleTrace(PVector _pos, boolean _trace)
	{
		pos = _pos;
		trace = _trace;
	}
}