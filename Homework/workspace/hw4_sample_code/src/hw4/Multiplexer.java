package hw4;

public class Multiplexer extends AbstractComponent
{
	/**
	 * Inital k input from constructor
	 */
	private int kin;
	
	/**
	 * Constructor to implement a Multiplexer logic gate.
	 */
	public Multiplexer(int k)
	{
		super(((int) Math.pow(2, k) + k),1);	
		this.kin = k;
	}
	
	public void propagate()
	{
		if (inputsValid())
		{
			String inputs = "";
			for (int i = 0; i < this.kin; i++)
			{
				inputs += inputs()[i].getValue();
			}
			int index = Integer.parseInt(inputs, 2);
			
			outputs()[0].set(inputs()[inputs().length-index-1].getValue());
		}
	}
}
