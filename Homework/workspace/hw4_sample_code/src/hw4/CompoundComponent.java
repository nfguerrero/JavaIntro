package hw4;

import java.util.ArrayList;
import api.IComponent;

public class CompoundComponent extends AbstractComponent
{
	/**
	 * List of components connected.
	 */
	private ArrayList<IComponent> components;
	
	/**
	 * Constructor to make initialize a compound component.
	 * 
	 * @param in	Number of inputs
	 * @param out	Number of outputs
	 */
	public CompoundComponent(int in, int out)
	{
		super(in, out);
		this.components = new ArrayList<IComponent>();
	}
	
	/**
	 * Adds a new component to the list of current components.
	 * 
	 * @param c		new IComponent to add to the list.
	 */
	public void addComponent(IComponent c)
	{
		this.components.add(c);
	}
	
	/**
	 * Returns the current list of components
	 * 
	 * @return		List of components currently connected.
	 */
	public ArrayList<IComponent> getComponents()
	{
		return this.components;
	}
	
	/**
	 * Invalidates all outputs of all components.
	 */
	@Override
	public void invalidateOutputs()
	{
		for (IComponent c : this.components)
		{
			c.invalidateOutputs();
		}
	}
	
	/**
	 * Invalidates all inputs of all components.
	 */
	@Override
	public void invalidateInputs()
	{
		for (IComponent c : this.components)
		{
			c.invalidateInputs();
		}
	}
	
	/**
	 * Sets outputs for all components connected.
	 */
	public void propagate()
	{
		while (true)
		{
			int key = 0;
			for (IComponent c : this.components)
			{
				c.propagate();
				if (!c.outputsValid()){key++;}
			}
			if (key == 0){break;}
		}
	}
}
