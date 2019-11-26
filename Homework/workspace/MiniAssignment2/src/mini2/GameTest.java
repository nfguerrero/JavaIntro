package mini2;

import java.util.ArrayList;

public class GameTest 
{
	public static void main(String[] args)
	{
		ArrayList<IntExpression> list = new ArrayList<IntExpression>();
		list.add(new IntExpression(1)); list.add(new IntExpression(2)); list.add(new IntExpression(3));
		ArrayList<String> results = new ArrayList<String>();
		
		NumberGame.findSolution(list, 6, results);
		
		ArrayList<String> noDups = new ArrayList<String>();
		for (String term : results)
		{
			boolean add = true;
			
			for (int i = 0; i < noDups.size(); i++)
			{
				if (term.equals(noDups.get(i)))
				{
					add = false; i = noDups.size();
				}
			}
			
			if (add) {noDups.add(term);}
		}
		
		System.out.println(results.toString());
		System.out.println(results.size());
	}
}
