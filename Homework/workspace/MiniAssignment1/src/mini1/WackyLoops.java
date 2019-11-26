package mini1;
import java.util.Scanner;

public class WackyLoops 
{
	public WackyLoops(){}
	
	public static int countMatches(String s, String t)
	{
		int length = Math.min(s.length(),  t.length());
		int same = 0;
		
		for (int i = 0; i < length; i++)
		{
			if (s.charAt(i) == t.charAt(i)){same++;}
		}
		return same;
	}
	
	public static String doubleConsonants(String s)
	{
		String vowels = "aeiouAEIOU";
		String word = "";
		
		for (int i = 0; i < s.length(); i++)
		{
			word += s.charAt(i);
			
			if (!vowels.contains(s.charAt(i)+""))
			{
				word += s.charAt(i);
				if (i < s.length()-1 && s.charAt(i) == s.charAt(i+1))
				{i++;}
			}
		}
		
		return word;
	}
	
	public static int findEscapeCount(double x, double y, int maxIterations)
	{
		double a = 0, b = 0, newA = 0, newB = 0;
		
		for (int i = 1; i <= maxIterations; i++)
		{
			newA = (a * a) - (b * b) + x;
			newB = (2 * a * b) + y;
			a = newA;
			b = newB;
			
			if ((a * a + b * b) > 4){return i;}
		}
		
		return maxIterations;
	}
	
	public static int findSecondLargest(String nums)
	{
		Scanner scan = new Scanner(nums);
		int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
		
		while (scan.hasNextInt())
		{
			int num = scan.nextInt();
			if (num > second)
			{
				if (num > first){second = first; first = num;}
				else {second = num;}					
			}
		}
		
		scan.close();
		return second;
	}
	
	public static boolean isPermutation(String s, String t)
	{
		if (s.length() == t.length())
		{
			String temp = s + "";
			for (int i = 0; i < s.length(); i++)
			{
				String letter = t.charAt(i)+"";
				if (temp.contains(letter))
				{
					temp = temp.replaceFirst(letter, "");
				}
				else {return false;}
			}
			if (temp.length() == 0){return true;}
		}
		return false;
	}
	
	public static boolean substringWithGaps(String source, String target)
	{
		if (target.equals("")){return true;}
		String temp = "";
		int targetI = 0;
		for (int i = 0; i < source.length(); i++)
		{
			if (source.charAt(i) == target.charAt(targetI))
			{
				temp += source.charAt(i);
				targetI++;
				if (targetI == target.length()){i = source.length();}
			}
		}
		if (temp.equals(target)){return true;}
		return false;
	}
}
