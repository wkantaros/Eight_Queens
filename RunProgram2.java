/*
* Recursive step:
* BRANCHING
* either do or don't place it on the next square
* Base case:
* if the board is filled, return the board
* if the board is filled and has 8 queens add it to the ArrayList<Board>
* Sort through the boards and if anything equals anything else remove it from the arrayList
*/

import java.util.ArrayList;

// to save to a file
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class RunProgram2
{
  private static ArrayList<Board> solutions = new ArrayList<Board>();

  public void run(boolean nextUp)
  {
    // Recursion Step
    if (!isFull())

    // Base
  }


  public boolean removeDuplicates()
  {
    int i = 0;
    int j = 0;
    while(j < solutions.size() - 1){
      i = j + 1;
      while(i < solutions.size())
      {
        if (solutions.get(j).equals(solutions.get(i)))
          solutions.remove(i);
        else i++;
      }
      j++;
    }
    return true;
  }

  public void printSolutions()
  {
    int counter = 1;
    for (Board board : solutions)
    {
      System.out.println(counter + ":");
      System.out.println(board);
      counter++;
    }
  }

  public static void main(String[] args) throws FileNotFoundException {

    // // Saves to a file rather than to the terminal
    // File file = new File("Solutions.txt");
    // FileOutputStream fos = new FileOutputStream(file);
    // PrintStream ps = new PrintStream(fos);
    // System.setOut(ps);

    RunProgram2 solve = new RunProgram2();
    solve.run();
  }
}
