package hw2;

/**
 * Models an exit machine that returns if you can exit based on the given ticket
 * 
 * @author Nic Fox G
 */
public class ExitMachine 
{
	private SimpleClock clock; //The clock object to find the current time
	private int exits; //The number of successfull exits
	
	/**
	 * Constructs an Exit Machine based on the given simple clock object
	 * @param givenClock - a SimpleClock to check current time with
	 */
	public ExitMachine(SimpleClock givenClock)
	{
		this.clock = givenClock;
		this.exits = 0;
	}
	
	/**
	 * Returns whether or not the given ticket's payment time is within the exit time limit
	 * @param givenTicket - Ticket to check the payment time
	 * @return boolean, if given ticket's payment time is within exit time limit
	 */
	public boolean insertTicket(Ticket givenTicket)
	{
		int time = Math.abs(givenTicket.getPaymentTime()-clock.getTime());
		if (time <= ParkingRateUtil.EXIT_TIME_LIMIT && givenTicket.getPaymentTime() > 0)
		{
			this.exits++;
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the amount of successful exits
	 * 
	 * @return	Number of successful exits
	 */
	public int getExitCount(){return this.exits;}
}
