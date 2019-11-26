package hw3;

import java.util.Arrays;
import java.util.Random;

public class Testing 
{
	public static void main(String[] args)
	{
		boolTest();
	}
	
	public static void forTest()
	{
		int[] grid = {3, 5, 0, 0, 6, 0, 1, 2, 0, 4, 0, 7, 0};
		for (int i = grid.length-1; i >= 0; i--) {
			if (grid[i] == 0) {
				for (int j = i-1; j >= 0; j--) {
					if (grid[j] != 0)
					{
						grid [i] = grid[j];
						grid[j] = 0;
						j = -1;
					}
				}
			}
		}
		System.out.println(Arrays.toString(grid));
	}
	
	public static void boolTest()
	{
		boolean test = true;
		int loop=0;
		if (test){loop=1;}
		System.out.println(13+loop);
	}
}
