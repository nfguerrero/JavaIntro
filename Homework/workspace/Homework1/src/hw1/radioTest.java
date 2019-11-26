package hw1;

public class radioTest 
{
	public static void main(String[] args)
	{
		Radio r = new Radio(100, 200, 5);
		
		System.out.println(r.getVolume()); // expected 0.0
		 r.volumeUp();
		 r.volumeUp();
		 System.out.println(r.getVolume()); // expected 0.32
		 r.volumeDown();
		 r.volumeDown();
		 r.volumeDown();
		 System.out.println(r.getVolume()); // expected 0.0
		 // setting stations
		 System.out.println(r.getStationNumber()); // expected 0
		 r.setStationNumber(4);
		 System.out.println(r.getStationNumber()); // expected 4
		 r.stationUp();
		 r.stationUp();
		 System.out.println(r.getStationNumber()); // expected 1
		 r.stationDown();
		 System.out.println(r.getStationNumber()); // expected 0
		 // frequency calculations
		 System.out.println(r.getFrequency()); // expected 110.0
		 r.setStationFromFrequency(162.0);
		 System.out.println(r.getStationNumber()); // expected 3
		 System.out.println(r.getFrequency()); // expected 170.0
		 // further station testing
		 r.stationDown();
		 r.stationDown();
		 r.stationDown();
		 r.stationDown();
		 System.out.println(r.getStationNumber()); // expected 4
		 r.setStationNumber(-2);
		 System.out.println(r.getStationNumber()); // expected 0
		 r.setStationNumber(3);
		 System.out.println(r.getStationNumber()); // expected 3
		 // further frequency testing
		 System.out.println(r.getFrequency()); // expected 190.0
		 r.setStationFromFrequency(140);
		 System.out.println(r.getFrequency()); // expected 150.0
		 r.setStationFromFrequency(0); 
		 System.out.println(r.getFrequency());// expected 110.0
		 System.out.println(r.getStationNumber()); //expected 0
		 r.setStationFromFrequency(90); 
		 System.out.println(r.getFrequency()); // expected 110.0
		 r.setStationFromFrequency(210);
		 System.out.println(r.getFrequency()); // expected 190.0
		 r.setStationFromFrequency(300);
		 System.out.println(r.getFrequency()); // expected 190.0
		 System.out.println(r.getStationNumber()); // expected 4
		 // further volume testing
		 r.volumeUp();
		 r.volumeUp();
		 r.volumeUp();
		 r.volumeUp();
		 r.volumeUp();
		 r.volumeUp(); 
		 System.out.println(r.getVolume()); // expected .96
		 r.volumeUp();
		 System.out.println(r.getVolume()); // expected 1.0
	}
}
