package hw3;
import api.*;
import java.util.ArrayList;
import java.util.Random;

public class GameTest 
{
	public static void main(String[] args)
	{
		Generator gen = new Generator(7);
		String[] testgrid = {
				"0 0 1 2",
				"0 5 3 4",
				"1 5 5 3"};
		DotsGame game = new DotsGame(testgrid, gen);
		System.out.println(game.getWidth()); //expected 4
		System.out.println(game.getHeight()); //expected 3
		System.out.println(game.getDot(1,3)); //expected 4
		game.setDot(1,  3,  new Dot(8));
		System.out.println(game.getDot(1, 3)); // expected 8
		Util.printGrid(game);
		
		game.select(1, 1);
		System.out.println("\n"+game.getSelectionList());
		game.select(2,2);
		System.out.println(game.getSelectionList());
		game.select(2, 1);
		System.out.println(game.getSelectionList());
		game.select(2, 0);
		System.out.println(game.getSelectionList());
		
		//release() test
		game.release();
		System.out.println("\n" + game.getSelectionList());
		System.out.println(game.getDot(1, 1));
		System.out.println(game.getDot(2, 1));
		Util.printGrid(game);
		
		System.out.println("\n");
		
		//collapseColumn() test
		String[] cgrid = {
				"0 1 0",
				"0 * 0",
				"0 * 0",
				"0 2 0",
				"0 * 0"
		};
		DotsGame cg = new DotsGame(cgrid, gen);
		ArrayList<Descriptor> cresult = cg.collapseColumn(1);
		Util.printGrid(cg);
		System.out.println("\n" + cresult +"\n");
		
		//fillColumn() test
		String[] fgrid = {
				"0 * 0",
				"0 * 0",
				"0 * 0",
				"0 1 0",
				"0 2 0"
		};
		Generator fgen = new Generator(5, new Random());
		DotsGame fg = new DotsGame(fgrid, fgen);
		ArrayList<Descriptor> fresult = fg.fillColumn(1);
		Util.printGrid(fg);
		System.out.println("\n" + fresult);
	}
}
