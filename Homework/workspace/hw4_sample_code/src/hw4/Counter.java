package hw4;

import api.IStatefulComponent;

public class Counter extends AbstractComponent implements IStatefulComponent
{
	private int counter;
	private boolean enabled;
	
	public Counter(int out)
	{
		super(0,out);
		int counter = 0;
		this.enabled = false;
	}
	
	public void clear()
	{
		this.counter = 0;
	}
	
	public void setEnabled(boolean enable)
	{
		this.enabled = enable;
	}
	
	public void tick()
	{
		
	}
	
	public void propagate()
	{
		
	}
}
