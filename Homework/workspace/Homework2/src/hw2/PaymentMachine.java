package hw2;

public class PaymentMachine 
{
	private double total; //Total amount inserted since object is constructed
	private SimpleClock clock; //Clock object to find current time
	private Ticket currentTicket; //Current ticket in Payment Machine
	
	/**
	 * Constructs a new Payment Machine with a given SimpleClock object
	 * 
	 * @param givenClock	SimpleClock object for retrieving time passed
	 */
	public PaymentMachine(SimpleClock givenClock)
	{
		this.total = 0.0;
		this.clock = givenClock;
	}
	
	/**
	 * Simulates inserting the given ticket into this machine
	 * 
	 * @param t		
	 */
	public void insertTicket(Ticket t){if(!this.inProgress()){this.currentTicket = t;}}
	
	/**
	 * Returns a reference to the current ticket in the Payment Machine (null if no ticket)
	 * 
	 * @return		The reference to the ticket currently in the Machine
	 */
	public Ticket getCurrentTicket(){return this.currentTicket;}
	
	/**
	 * Returns if there is a ticket in the machine
	 * 
	 * @return		true or false if a ticket is in the machine
	 */
	public boolean inProgress(){return (this.currentTicket != null);}
	
	/**
	 * Returns the amount due based on how long the car was parked
	 * 
	 * @return		dollar amount due based on time parked
	 */
	public double getPaymentDue()
	{
		if(this.inProgress())
		{
			double start = ParkingRateUtil.calculateCost(this.clock.getTime()-this.currentTicket.getStartTime());
			double payed = ParkingRateUtil.calculateCost(this.currentTicket.getPaymentTime()-this.currentTicket.getStartTime());
			if(this.currentTicket.getPaymentTime() != 0)
			{
				if (this.clock.getTime()-this.currentTicket.getPaymentTime()>ParkingRateUtil.EXIT_TIME_LIMIT)
				{return start-payed;}
				return payed;
			}
			return start;
		}
		return 0.0;
	}
	
	/**
	 * If a transaction is in progress, the ticket's payment time is updated to the current time
	 */
	public void makePayment()
	{
		if(this.inProgress())
		{
			this.total += this.getPaymentDue();
			this.currentTicket.setPaymentTime(this.clock.getTime());
		}		
	}
	
	/**
	 * Simulates ejecting the current ticket if there is a transaction in progress
	 */
	public void ejectTicket(){if(this.inProgress()){this.currentTicket=null;}}
	
	/**
	 * Returns the total payments that have been made at this machine.
	 * 
	 * @return		The total payments made at this machine
	 */
	public double getTotalPayments(){return this.total;}
}
