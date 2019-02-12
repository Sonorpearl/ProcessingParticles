package Processing;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import processing.core.PApplet;

public class InputManager
{
	private PApplet parent;

	public HashMap<Integer, Boolean> keyValues = new HashMap<Integer, Boolean>();

	public InputManager(PApplet _parent)
	{
		parent = _parent;
	}

	public boolean GetKey(int _keyCode)
	{
		return keyValues.get(_keyCode) == null ? false : keyValues.get(_keyCode);
	}

	public void keyPressed()
	{
		keyValues.put(parent.keyCode, true);
	}

	public void keyReleased()
	{
		keyValues.put(parent.keyCode, false);
	}

	public void displayPressedKeys()
	{
		int offset = 10;
		Iterator<Entry<Integer, Boolean>> it = keyValues.entrySet().iterator();
		while (it.hasNext())
		{
			Entry<Integer, Boolean> pair = it.next();
			if (pair.getValue())
			{
				parent.text(pair.getKey(), offset, 10);
				offset += 20;
			}
		}
	}
}
