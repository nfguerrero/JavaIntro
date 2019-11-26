package mini1;
import mini1.WackyLoops;

public class WackyTest 
{
	public static void main(String[] args)
	{
		//countMatchesTest();
		doubleConsonantsTest();
		//findEscapeCountTest();
		//findSecondLargestTest();
		//isPermutationTest();
		//substringWithGapsTest();
	}
	
	public static void countMatchesTest()
	{
		System.out.println(WackyLoops.countMatches("yes", "yesir")+", Expected: 3");
		System.out.println(WackyLoops.countMatches("Hello World!", "Melting rat!")+", Expected: 4\n");
	}
	
	public static void doubleConsonantsTest()
	{
		System.out.println(WackyLoops.doubleConsonants("xyz"));
		//System.out.println(WackyLoops.doubleConsonants("Hello World!")+", Expected: \"HHellllo WWorrlldd!");
		//System.out.println(WackyLoops.doubleConsonants("rabbit")+", Expected: rrabbbbitt\n");
	}
	
	public static void findEscapeCountTest()
	{
		System.out.println(WackyLoops.findEscapeCount(.4, .2, 35)+", Expected: 31");
		System.out.println(WackyLoops.findEscapeCount(.4, .2, 30)+", Expected: 30\n");
	}
	
	public static void findSecondLargestTest()
	{
		System.out.println(WackyLoops.findSecondLargest("42 137 -7 42 66 55")+", Expected: 66");
		System.out.println(WackyLoops.findSecondLargest("-1 0")+", Expected: -1");
		System.out.println(WackyLoops.findSecondLargest("2 five")+", Expected: -2147483648\n");
	}
	
	public static void isPermutationTest()
	{
		System.out.println(WackyLoops.isPermutation("abcabc", "baaccb")+", Expected: true");
		System.out.println(WackyLoops.isPermutation("abc", "cbba")+", Expected: false");
		System.out.println(WackyLoops.isPermutation("Abc", "abc")+", Expected: false\n");
	}
	
	public static void substringWithGapsTest()
	{
		System.out.println(WackyLoops.substringWithGaps("hamburgers", "mug")+", Expected: true");
		System.out.println(WackyLoops.substringWithGaps("hamburgers", "gum")+", Expected: false");
		System.out.println(WackyLoops.substringWithGaps("hamburgers", "")+", Expected true");
	}
}
