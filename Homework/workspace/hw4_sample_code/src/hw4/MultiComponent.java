package hw4;

import api.IComponent;

public class MultiComponent extends CompoundComponent
{
	/**
	 * Constructor to initialize the MultiComponent
	 * 
	 * @param components	Array of identical components.
	 */
	public MultiComponent(IComponent[] components) 
	{
		super(components.length*components[0].inputs().length, components.length);
		
		for (int i = 0; i < components.length; i++)
		{
			components[i].outputs()[0].connectTo(outputs()[i]);
		}
	}
	
	/**
	 * Sets outputs for all Components.
	 */
	public void propagate()
	{
		for (IComponent c : getComponents())
		{
			c.propagate();
		}
	}
}
