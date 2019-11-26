package lab5;
import java.util.Scanner;

public class checkpoint1 
{
	public static void main(String[] args)
	{
		System.out.println(initials("Cher"));
		System.out.println(initials("Edna del Humboldt von der Schooch"));
		
		System.out.println(firstVowel("aeiouAEIOU"));
		System.out.println(firstVowel("HI"));
		System.out.println(firstVowel("Rythms"));
	}
	
	public static String initials(String name)
	{
		Scanner in = new Scanner(name);
		String initials = "";
		
		while (in.hasNext())
		{
			initials += in.next().charAt(0);
		}
		in.close();
		
		return initials;
	}
	
	public static int firstVowel(String s)
	{
		int first = s.length();
		s = s.toLowerCase();
		String vowels = "aeiou";
		
		for (int i = 0; i < s.length(); i++)
		{
			if (vowels.indexOf(s.charAt(i)) >= 0 && s.indexOf(s.charAt(i)) < first)
			{first = s.indexOf(s.charAt(i));}
		}
		
		if (first == s.length()){return -1;}
		else{return first;}
	}
}
