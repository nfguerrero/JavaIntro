package hw2;

public class ATester 
{
	public static void main(String[] args)
	{
		SimpleClock c = new SimpleClock();
		c.timePasses(10);
		Ticket t = new Ticket(c.getTime());
		PaymentMachine pm = new PaymentMachine(c);		
		t.setPaymentTime(41);
		c.timePasses(250);
		pm.insertTicket(t);
		System.out.println(pm.getPaymentDue());
	}
	
	private static void ticketDispenserTest()
	{
		SimpleClock c = new SimpleClock();
		TicketDispenser td = new TicketDispenser(c);
		c.timePasses(10);
		Ticket t = td.takeTicket();
		System.out.println(t.getStartTime()); //expected 10
		System.out.println(t.getPaymentTime()); // expected 0
	}
	
	private static void exitMachineTest()
	{
		SimpleClock c = new SimpleClock();
		ExitMachine em = new ExitMachine(c);
		Ticket t = new Ticket(c.getTime());
		c.timePasses(10);
		boolean canExit = em.insertTicket(t);
		System.out.println(canExit); // expected true
		Ticket t2 = new Ticket(c.getTime());
		c.timePasses(30);
		canExit = em.insertTicket(t2);
		System.out.println(canExit); // expected false
		System.out.println(em.getExitCount()); // expected 1
	}
}
