package mini2;

import java.util.ArrayList;

/**
 * Implementation of a version of the "twenty-four" game.
 */
public class NumberGame
{

	/**
	 * Lists all ways to obtain the given target number using arithmetic operations
	 * on the values in the given IntExpression list.  Results in string form are added to the given list,
	 * where the string form of a value is obtained from the toString() of the Value object.
	 * Special rules are: 1) you are not required to use all given numbers, and 2) division 
	 * is integer division and is only allowed when remainder is zero.  For addition 
	 * and multiplication, a + b and b + a are considered to be distinct solutions, and
	 * likewise a * b and b * a are considered as different solutions.  See the
	 * pdf for detailed examples.
	 * @param list
	 *   the values to be used
	 * @param target
	 *   the target number to be obtained from the values in the list
	 * @param results
	 *   list of all results, as strings
	 */
	public static void findSolution(ArrayList<IntExpression> list, int target, ArrayList<String> results)
	{
		if (list.size() == 1 && list.get(0).getIntValue() == target)
	  		{results.add(list.get(0).toString());}
		else
		{
			for (int i = 0; i < list.size(); i++)
			{
				ArrayList<IntExpression> newList = new ArrayList<IntExpression>();
				newList.addAll(list);
				newList.remove(i);
				findSolution(newList, target, results);
			}
			
			for (int i = 0; i < list.size(); i++)
			{
				for (int j = 0; j < list.size(); j++)
				{
					if (i != j)
					{
						ArrayList<IntExpression> combos = Combos(list.get(i), list.get(j));
						
						for (IntExpression combo : combos)
						{
							ArrayList<IntExpression> newList = new ArrayList<IntExpression>();
							newList.addAll(list);
							
							if (i > j)
							{
								newList.remove(i); newList.remove(j);
								newList.add(combo);
							}
							else
							{
								newList.remove(j); newList.remove(i);
								newList.add(combo);
							}
							
							findSolution(newList, target, results);
						}
					}
				}
			}
		}
	} 
	
	public static ArrayList<IntExpression> Combos(IntExpression i, IntExpression j)
	{
		char[] ops = {'+', '-', '*', '/'};
		ArrayList<IntExpression> combos = new ArrayList<IntExpression>();
		
		for (char op : ops)
		{
			if (op != '/') {combos.add(new IntExpression(i, j, op)); combos.add(new IntExpression(j, i, op));}
			else if (i.getIntValue() % j.getIntValue() == 0) {combos.add(new IntExpression(i, j, op));}
			else if (j.getIntValue() % i.getIntValue() == 0) {combos.add(new IntExpression(j, i, op));}
		}
		
		return combos;
	}
}