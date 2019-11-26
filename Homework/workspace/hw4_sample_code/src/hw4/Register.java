package hw4;

import api.Endpoint;
import api.IStatefulComponent;

public class Register extends AbstractComponent implements IStatefulComponent
{
	/**
	 * whether the Register is enabled or not.
	 */
	private boolean enabled;
	
	private Endpoint[] last;
	
	/**
	 * Constructor to initialize the Register
	 * 
	 * @param n		number of bits
	 */
	public Register(int n)
	{
		super(n,n);
		this.enabled = false;
		this.last = new Endpoint[n];
	}
	
	public void tick()
	{
		if (this.enabled)
		{
			for (int i = 0; i < inputs().length; i++)
			{
				inputs()[i] = this.last[i];
			}
		}
	}

	public void setEnabled(boolean enable)
	{
		this.enabled = enable;
	}
	
	public void clear()
	{
		
	}
	
	public void propagate()
	{
		if (this.enabled)
		{
			for (int i = 0; i < outputs().length; i++)
			{
				outputs()[i] = inputs()[i];
			}
		}
		else
		{
			this.last = inputs();
		}
	}
}
