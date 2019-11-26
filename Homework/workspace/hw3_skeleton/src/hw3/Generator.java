package hw3;
import java.util.Random;

import api.Dot;

/**
 * Class encapsulating a mechanism for producing new Dot objects
 * for a game.
 */
public class Generator
{
	private int dotType; //dotType to use for fixed, or range for random
	private Random gen; //Random generator used
	
  /**
   * Constructs a Generator whose generate() method always
   * returns a Dot of the given type.  (This method is intended
   * for testing.)
   * @param givenType
   *   type of Dot objects to be generated
   */
  public Generator(int givenType)
  {
	  this.dotType = givenType;	 
	  this.gen = null;
  }
 
  /**
   * Constructs a Generator that will create
   * random Dots with types 0 through numTypes - 1,
   * using the given Random instance.
   * @param numTypes
   *   number of types of dots
   * @param rand
   *   random number generator to use
   */
  public Generator(int numTypes, Random rand)
  {
	  this.dotType = numTypes;
	  this.gen = rand;
  }
  
  /**
   * Returns an instance of Dot according to this generator's rules
   * (Random or fixed value).
   * @return
   *   a new Dot object
   */
  public Dot generate()
  {
	  if (this.gen != null)
	  	{return new Dot(gen.nextInt(this.dotType));}
	  return new Dot(this.dotType);
  }

  /**
   * Initializes the given 2D array of Dot objects
   * with values produced by this generator.
   * @param grid
   *   a 2D array to be initialized
   */
  public void initialize(Dot[][] grid)
  { 
    for (int row = 0; row < grid.length; ++row)
    {
      for (int col = 0; col < grid[0].length; ++col)
      {
        grid[row][col] = generate();
      }
    }
  }

}