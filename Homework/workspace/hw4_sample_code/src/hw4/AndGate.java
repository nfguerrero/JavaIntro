package hw4;

/**
 * Implementation of the IComponent interface as an AND-Gate with two inputs and one output.
 * @author Nic Fox G
 */
public class AndGate extends AbstractComponent
{	
	/**
	 * Constructor to make an AND-Gate
	 */
	public AndGate()
	{
		super(2, 1);
	}
	
	/**
	 * Sets outputs to the logic of an AND-Gate based on inputs.
	 */
	public void propagate()
	{
		if (inputsValid())
		{
			int newValue = 0;
			if (inputs()[0].getValue() == 1 && inputs()[1].getValue() == 1)
			{newValue = 1;}
			outputs()[0].set(newValue);
		}
	}
}
