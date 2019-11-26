package hw1;

/**
 * Model of a Radio
 * @author Nic Fox G
 *
 */
public class Radio 
{
	public static final double VOLUME_INCREMENT = .16; // Static volume increment
	
	private double minFrequency; // Minimum frequency the Radio will go
	private double frequency; // Current frequency of Radio
	private double frequencyIncrement; // Increment the frequency changes between stations
	
	private double volume; // Current volume of Radio
	private int station; // Current station of Radio
	private int numStations; // Total number of stations in Radio
	
	/**
	 * Constructs a Radio object with the given Minimum frequency, Maximum frequency, and Number of stations
	 * @param givenMinFrequency - Minimum range of frequency
	 * @param givenMaxFrequency - Maximum range of frequency
	 * @param givenNumStations
	 * 		Number of stations in frequency range
	 */
	public Radio(double givenMinFrequency, double givenMaxFrequency, int givenNumStations)
	{
		this.volume = 0;
		this.station = 0;
		this.numStations = givenNumStations;
		
		this.frequencyIncrement = (givenMaxFrequency - givenMinFrequency)/givenNumStations;
		this.minFrequency = givenMinFrequency + (this.frequencyIncrement/2);
		this.frequency = this.minFrequency;
	}
	
	/**
	 * Returns the current frequency of the Radio
	 * @return - frequency of Radio
	 */
	public double getFrequency() {return this.frequency;}
	
	/**
	 * Returns the current station number of the Radio
	 * @return - station number of Radio
	 */
	public int getStationNumber() {return this.station;}
	
	/**
	 * Returns the current volume of the Radio
	 * @return - volume of Radio
	 */
	public double getVolume() {return this.volume;}
	
	/**
	 * Sets the station number of the Radio to the given station number (or closest if given station doesn't exist) 
	 * @param stationNumber - requested station number
	 */
	public void setStationNumber(int stationNumber)
	{
		this.station = Math.max(0, stationNumber); 
		this.station = Math.min(this.numStations-1, this.station);
		
		this.frequency = this.minFrequency + (this.frequencyIncrement*this.station);
	}
	
	/**
	 * Sets the station number based on closest frequency to the frequency given
	 * @param frequency - requested frequency to get closest station
	 */
	public void setStationFromFrequency(double frequency)
	{
		this.station = (int) Math.round((frequency-this.minFrequency)/this.frequencyIncrement);
		this.station = Math.min(this.numStations-1, this.station);
		this.station = Math.max(0, this.station);
		
		this.frequency = this.minFrequency + (this.frequencyIncrement*this.station);
	}
	
	/**
	 * Increases volume of the Radio (wraps to bottom station)
	 */
	public void stationUp()
	{
		this.station++;
		this.station = this.station%this.numStations;
		
		this.frequency = this.minFrequency + (this.frequencyIncrement*this.station);
	}
	
	/**
	 * Decreases station of the Radio (wraps to top station)
	 */
	public void stationDown()
	{
		this.station += this.numStations - 1;
		this.station = this.station%this.numStations;
		
		this.frequency = this.minFrequency + (this.frequencyIncrement*this.station);
	}
	
	/**
	 * Increases volume of the Radio
	 */
	public void volumeUp() {this.volume = Math.round(Math.min(1, this.volume + this.VOLUME_INCREMENT)*100.0)/100.0;}
	
	/**
	 * Decreases volume of the Radio
	 */
	public void volumeDown() {this.volume = Math.round(Math.max(0, this.volume - this.VOLUME_INCREMENT)*100.0)/100.0;}
}
















