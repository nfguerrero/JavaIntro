
package hw3;

import java.util.ArrayList;

import javax.swing.Icon;

import api.Descriptor;
import api.Dot;
import api.Util;

/**
 * This class encapsulates the game logic for a video game called Dots.
 * The game consists of a 2D array or grid of colored icons, called dots, 
 * along with an ordered list that we will call the selection list.  Intuitively, 
 * the selection list represents a set of adjacent dots, all of the same color, 
 * that have been selected by the player.  When selection is complete (e.g. the 
 * mouse is released), the selected dots disappear from the grid, and the dots 
 * above shift down  to take their places.  Then new dots fill in each column from the top.
 * A point is scored for each dot that disappears from the grid.  There
 * is a special rule for the case that the selected dots form a loop;
 * then all dots in the grid of the same color disappear too.
 */
public class DotsGame
{
	private Dot[][] grid; //2D array of dots to be displayed
	private ArrayList<Descriptor> selectionList; //ArrayList of Descriptors that are currently selected
	private boolean loop; //whether or not the selected list contains a loop
	private int score; //score the player has
	private Generator gen; //generator to dictate what dots are made
	
  /**
   * Constructs a game with the given number of columns and rows that will use
   * the given Generator instance to create new icons.  The dots
   * in the initial grid are produced by the generator.
   * 
   * @param width
   *          number of columns
   * @param height
   *          number of rows
   * @param generator
   *          generator for new icons
   */
  public DotsGame(int width, int height, Generator generator)
  {
	  this.grid = new Dot[height][width];	  
	  this.selectionList = new ArrayList<Descriptor>();
	  this.loop = false;
	  this.score = 0;
	  this.gen = generator;
	  
	  for (int col = 0; col < this.grid[0].length; col++)
	  	{this.fillColumn(col);}
  }

  /**
   * Constructs a game based on the given string array according to
   * the conventions of Util.createGridFromString. The given Generator 
   * instance is used to create new dpts.  
   * 
   * @param data
   *          string indicating initial configuration of grid
   * @param generator
   *          generator for new icons
   */
  public DotsGame(String[] data, Generator generator)
  {
	  this.grid = Util.createGridFromString(data);
	  this.selectionList = new ArrayList<Descriptor>();
	  this.loop = false;
	  this.score = 0;
	  this.gen = generator;
  } 
  
  /**
   * Returns the Dot object at the given row and column.
   * @param row
   *   row within the grid
   * @param col
   *   column within the grid
   * @return
   *   Dot object at the given row and column
   */
  public Dot getDot(int row, int col)
  {
    return this.grid[row][col];
  }

  /**
   * Sets the Dot object at the given row and column.
   * @param row
   *   row of the grid to be modified
   * @param col
   *   column of the grid to be modified
   * @param dot
   *   the given Dot object to set
   */
  public void setDot(int row, int col, Dot dot)
  {
	  this.grid[row][col] = dot;
  }

  /**
   * Returns the number of columns in this game.
   * @return
   *   number of columns
   */
  public int getWidth()
  {
    return grid[0].length;
  }

  /**
   * Returns the number of rows in this game.
   * @return
   *   number of rows
   */
  public int getHeight()
  {
    return grid.length;
  }

  /**
   * Returns the current score for this game.
   * @return
   *   score for this game
   */
  public int getScore()
  {
    return this.score;
  }

  /**
   * Attempts to select the dot at given position. A descriptor for the dot is
   * added to the selection list provided that a) the given position is
   * adjacent to the last one added to the selection list, and b) its type matches
   * the type of those already in the selection list, and c) the given position
   * is not already in the selection list OR it completes a loop.
   * Completing a loop means that the given position matches the first one in
   * the selection list, the list has length at least 3, and the given position does
   * not already occur twice in the list.
   * @param row
   *   row of the dot to be selected
   * @param col
   *   column of the dot to be selected
   */
  public void select(int row, int col)
  {
	  if (this.selectionList.size() > 0)
	  {
		  Descriptor last = this.selectionList.get(this.selectionList.size()-1);
		  Dot dot = this.grid[row][col];
		  Descriptor compare = new Descriptor(row, col, dot);
		  
		  boolean sameType = last.getDot().getType() == dot.getType();
		  boolean inBound = (row >= last.row() -1 && row <= last.row()+1 && col == last.col()) || (col >= last.col()-1 && col <= last.col()+1 && row == last.row());
		  boolean notInList = true;
		  for (Descriptor des : this.selectionList)
		  	{if (des.equals(compare)){notInList = false;}}
		  boolean loopSize = this.selectionList.size() >= 4;
		  
		  if (sameType && inBound)
		  {
			  if (notInList)
			  	{this.selectionList.add(compare);}
			  else if (loopSize && this.selectionList.get(0).equals(compare) && !this.loop)
			  	{this.loop = true; this.selectionList.add(compare);}
		  }
	  }
	  else {this.selectionList.add(new Descriptor(row, col, this.grid[row][col]));}
  }
  
  /**
   * Returns a list of descriptors for currently selected dots.
   * @return
   *   the selection list
   */
  public ArrayList<Descriptor> getSelectionList()
  {
    return this.selectionList;
  }
    
  /**
   * If the selection list has at least two elements, replaces all selected positions 
   * with null, clears the selection list, and updates the score.  If the selection 
   * list does not contain at least two elements, no positions are nulled but the
   * selection list is still cleared.  If the selection list includes a completed loop,
   * then all dots of matching type are also nulled and the score is updated accordingly.  
   * The method returns a list containing all nulled positions.  (The list is in
   * no particular order but should not contain duplicates.)
   * @return
   *   list of descriptors for cells that are nulled as a result of this operation
   */
  public ArrayList<Descriptor> release()
  {
	  ArrayList<Descriptor> dots = new ArrayList<Descriptor>();
	  
	  if (this.selectionList.size() >= 2)
	  	{for (int i = 0; i < this.selectionList.size(); i++)
		  {
	  		  Descriptor dot = this.selectionList.get(i);
	  		  if (!dots.contains(dot))
	  		  {
				  this.grid[dot.row()][dot.col()] = null;
				  dots.add(dot);
				  this.score++;
	  		  }
		  }
		  if (this.loop)
		  	{for (int row = 0; row < this.grid.length; row++)
			  	{for (int col = 0; col < this.grid[0].length; col++)
			  	 {
			  		Dot dot = this.grid[row][col];	
			  		if (dot != null && dot.getType() == this.selectionList.get(0).getDot().getType())
			  			{
			  				this.grid[row][col] = null; 
			  				this.loop = false;
			  				dots.add(new Descriptor(row, col, dot));
			  				this.score++;
			  			}
			  	 }
			 }
		  }
	  }
	  this.selectionList.clear();
	  
	  return dots;
  }

  
  /**
   * Collapses the dots in the given column of the current game grid such 
   * that all null dots, if any, are at the top of the column 
   * and non-null dots are shifted toward the bottom (i.e., as if by gravity).  
   * The returned list contains Descriptors representing dots that were moved (if any)
   * with their new row and column; moreover, each Descriptor's <code>getPreviousRow</code>
   * method returns the original row of the dot.  The returned list is 
   * in no particular order.
   * @param col
   *   column to be collapsed
   * @return
   *   list of descriptors for moved dots
   */
  public ArrayList<Descriptor> collapseColumn(int col)
  {
	  ArrayList<Descriptor> shifted = new ArrayList<Descriptor>();
	  
	  for (int row = this.grid.length-1; row >= 0; row--) {
		  if (this.grid[row][col] == null) {
			  for (int i = row-1; i >= 0; i--) {
				  if (this.grid[i][col] != null)
				  {
					  this.grid[row][col] = this.grid[i][col];
					  this.grid[i][col] = null;
					  
					  Descriptor dot = new Descriptor(row, col, this.grid[row][col]);
					  dot.setPreviousRow(i);
					  shifted.add(dot);
					  
					  i = -1;
				  }
			  }
		  }
	  }
	  return shifted;
  }

  
  /**
   * Fills the null grid positions (if any) at the top of the given column in the
   * current game grid.  The returned list contains Descriptors representing new
   * dots added to the column with their new row and column. The previous row
   * for all descriptors is set to -1. The new dots are
   * produced by the generator's <code>generate</code> method. The list is 
   * in no particular order.
   * 
   * @param col
   *   column to be filled
   * @return
   *   list of new descriptors for dots added to the column
   */
  public ArrayList<Descriptor> fillColumn(int col)
  {
	  ArrayList<Descriptor> filled = new ArrayList<Descriptor>();
	  
	  for (int row = 0; row < this.grid.length && this.grid[row][col] == null; row++)
	  {
		  Dot dot = this.gen.generate();
		  this.grid[row][col] = dot;
		  Descriptor fill = new Descriptor(row, col, dot);
		  fill.setPreviousRow(-1);
		  filled.add(fill);
	  }
	  
	  return filled;
  }


}
