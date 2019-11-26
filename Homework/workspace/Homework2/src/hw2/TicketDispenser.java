package hw2;

/**
 * This class models a ticket dispenser that will give a ticket to
 * the user with the start time of the current time based on the clock
 * and a payment time of 0
 * 
 * @author Nic Fox G
 */
public class TicketDispenser 
{
	private SimpleClock clock; //The clock object to find the current time
	
	/**
	 * Constructs a Ticket Dispenser with the given clock
	 * @param givenClock - a SimpleClock to give the current time on returned tickets
	 */
	public TicketDispenser(SimpleClock givenClock)
	{
		this.clock = givenClock;
	}
	
	/**
	 * Returns the ticket with the current time 
	 * @return - The Ticket
	 */
	public Ticket takeTicket()
	{
		return new Ticket(this.clock.getTime());
	}
}
