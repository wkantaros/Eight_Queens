import java.util.ArrayList;

// to save to a file
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class RunProgram
{
  private static ArrayList<Board> solutions = new ArrayList<Board>();

  public void run()
  {
    int counter = 0;
    for(int adder1 = 1; adder1 < 8; adder1++)
    {
      for(int adder2 = 1; adder2 < 8; adder2++)
      {
        for(int file = 0; file < 8; file++)
        {
          for(int rank = 1; rank < 8; rank++)
          {
            Board testBoard = new Board();
            testBoard.addPiece(file, rank);
            testBoard.checkLegalSquares();
            for(int i = 0; i < 8; i += adder1)
            {
              for(int j = 0; j < 8; j += adder2)
              {
                if (testBoard.getBoard()[j][i] == ' ')
                {
                  Queen q = new Queen(i, j);
                  testBoard.addPiece(q);
                  testBoard.checkLegalSquares();
                }
              }
            }
            testBoard.fillHoles();
            if(testBoard.getQueens().size() == 8)
            {
              testBoard.removeLegalSquares();
              solutions.add(testBoard);
              counter++;
            }
          }
        }
      }
    }
    removeDuplicates();
    printSolutions();
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

    RunProgram solve = new RunProgram();
    solve.run();
  }
}
