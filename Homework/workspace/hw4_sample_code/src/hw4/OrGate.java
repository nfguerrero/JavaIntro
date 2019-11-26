package hw4;

/**
 * Implementation of the IComponent interface as an OR-Gate with two inputs and one output.
 * @author Nic Fox G
 */
public class OrGate extends AbstractComponent
{
	/**
	 * Constructor to make an OR-Gate
	 */
	public OrGate()
	{
		super(2, 1);
	}
	
	/**
	 * Sets outputs to logic of an OR-Gate based on inputs.
	 */
	public void propagate()
	{
		if (inputsValid())
		{
			int newValue = 0;
			if (inputs()[0].getValue() == 1 || inputs()[1].getValue() == 1)
			{newValue = 1;}
			outputs()[0].set(newValue);
		}
	}
}
