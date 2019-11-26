package hw4;

import api.IComponent;
import api.Endpoint;

public abstract class AbstractComponent implements IComponent
{
	/**
	 * Inputs for this component.
	 */
	private Endpoint[] inputs;
	
	/**
	 * Outputs for this component.
	 */
	private Endpoint[] outputs;
	
	/**
	 * Constructs the Abstract Component with the given amount of inputs and outputs for the specific logic gate
	 * 
	 * @param in	Number of inputs of logic gate.
	 * @param out	Number of outputs of logic gate.
	 */
	public AbstractComponent (int in, int out)
	{
		this.inputs = new Endpoint[in];
		for (int i = 0; i < in; i++)
			{this.inputs[i] = new Endpoint(this);}
		this.outputs = new Endpoint[out];
		for (int o = 0; o < out; o++)
			{this.outputs[o] = new Endpoint(this);}
	}
	
	/**
	 * Invalidates all inputs of this component.
	 */
	@Override
	public void invalidateInputs()
	{
		for (Endpoint e : this.inputs) {e.invalidate();}
	}
	
	/**
	 * Invalidates all outputs of this component.
	 */
	@Override
	public void invalidateOutputs()
	{
		for (Endpoint e : this.outputs) {e.invalidate();}
	}
	
	/**
	 * Checks whether all the inputs are valid or not.
	 * 
	 * @return boolean	whether inputs are valid or not.
	 */
	@Override
	public boolean inputsValid()
	{
		for (Endpoint e : this.inputs)
		{
			if (!e.isValid()) {return false;}
		}
		return true;
	}
	
	/**
	 * Checks whether all the outputs are valid or not.
	 * 
	 * @return boolean	whether outputs are valid or not.
	 */
	@Override
	public boolean outputsValid()
	{
		for (Endpoint e : this.outputs)
		{
			if (!e.isValid()) {return false;}
		}
		return true;
	}
	
	/**
	 * Returns the inputs of the component as an array of Endpoints
	 * 
	 * @return Endpoint[]	The inputs of the component.
	 */
	@Override
	public Endpoint[] inputs()
	{
		return this.inputs;
	}
	
	/**
	 * Returns the outputs of the component as an array of Endpoints
	 * 
	 * @return Endpoint[]	The outputs of the component.
	 */
	@Override
	public Endpoint[] outputs()
	{
		return this.outputs;
	}
	
	/**
	 * Method for specific component to calculate outputs given the inputs
	 */
	@Override
	public abstract void propagate();
}
