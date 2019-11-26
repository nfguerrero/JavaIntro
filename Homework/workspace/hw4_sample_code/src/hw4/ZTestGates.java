package hw4;

import api.Util;
import sample.SampleAndGate;
import api.ExternalValue;
import api.Probe;

public class ZTestGates 
{
	public static void main(String[] args)
	{
		andTest();
		orTest();
		notTest();
		halfTest();
		mpTest();
	}
	
	public static void andTest()
	{
		AndGate c = new AndGate();
		ExternalValue ex = new ExternalValue(2);
		Util.connect(ex, c);
		Util.addListener(c,  new Probe("Test AndGate"));
		ex.setValues("11");
		ex.propagate();
		c.propagate();
		ex.setValues("01");
		ex.propagate();
		c.propagate();
		ex.setValues("00");
		ex.propagate();
		c.propagate();
		c.invalidateOutputs();
		System.out.println("");
	}
	
	public static void orTest()
	{
		OrGate c = new OrGate();
		ExternalValue ex = new ExternalValue(2);
		Util.connect(ex, c);
		Util.addListener(c,  new Probe("Test OrGate"));
		ex.setValues("11");
		ex.propagate();
		c.propagate();
		ex.setValues("01");
		ex.propagate();
		c.propagate();
		ex.setValues("00");
		ex.propagate();
		c.propagate();
		c.invalidateOutputs();
		System.out.println("");
	}
	
	public static void notTest()
	{
		NotGate c = new NotGate();
		ExternalValue ex = new ExternalValue(1);
		Util.connect(ex, c);
		Util.addListener(c,  new Probe("Test NotGate"));
		ex.setValues("1");
		ex.propagate(); 
		c.propagate(); 
		ex.setValues("0");
		ex.propagate();
		c.propagate();
		c.invalidateOutputs();
		System.out.println("");
	}
	
	public static void halfTest()
	{
		HalfAdder c = new HalfAdder();
	    Util.setInputs(c, "11");
	    c.propagate();
	    System.out.println(Util.toString(c.outputs()));
	    c.invalidateOutputs();
	    c.invalidateInputs();
	    Util.setInputs(c, "01");
	    c.propagate();
	    System.out.println(Util.toString(c.outputs()));
	    c.invalidateOutputs();
	    c.invalidateInputs();
	    Util.setInputs(c, "00");
	    c.propagate();
	    System.out.println(Util.toString(c.outputs()));
	    c.invalidateOutputs();
	    c.invalidateInputs();
	    System.out.println("");
	}
	
	public static void mpTest()
	{
		Multiplexer mp = new Multiplexer(3);
		Util.setInputs(mp, "00000010011");
		mp.propagate();
		System.out.println(Util.toString(mp.outputs()));
	}
}
