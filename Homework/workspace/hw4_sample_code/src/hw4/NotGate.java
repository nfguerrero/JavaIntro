package hw4;

/**
 * Implementation of the IComponent interface as a NOT-Gate with one input and one output.
 * @author Nic Fox G
 */
public class NotGate extends AbstractComponent
{
	/**
	 * Constructor to make an OR-Gate
	 */
	public NotGate()
	{
		super(1, 1);
	}
	
	/**
	 * Sets outputs to logic of a NOT-Gate based on inputs.
	 */
	public void propagate()
	{
		if (inputsValid())
		{
			int newValue = 0;
			if (inputs()[0].getValue() == 0)
			{newValue = 1;}
			outputs()[0].set(newValue);
		}
	}
}
