package hw2;

public class ParkingRateUtil
{
	public static final int EXIT_TIME_LIMIT = 15; //public constant for the time limit to exit since payment
	
	/**
	 * Constructs the Parking Rate Utility class
	 */
	private ParkingRateUtil(){}
	
	/**
	 * Returns the cost due based on how many minutes had passed
	 * 
	 * @param minutes	Amount of minutes to calculate the cost with
	 * @return	Fee due
	 */
	public static double calculateCost(int minutes)
	{
		double hours = minutes/60.0;
		double fee = 0.0;
		
		if (hours <= .5){fee = 1.00;}
		else
		{
			hours = Math.ceil(hours);
			fee = 2 + (hours-1)*1.25;
			
			if (hours > 7)
			{
				fee = (hours-7)*.75 + 9.50;
				if (hours > 9){fee = 11.50;}
				if (hours > 24)
				{
					hours -= 24;
					fee += calculateCost((int)hours*60);
				}
			}
		}
		
		return fee;
	}
}
