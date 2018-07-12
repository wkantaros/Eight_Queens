import java.util.ArrayList;

// to save to a file
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class CleanAlg{

  private static ArrayList<Board> solutions = new ArrayList<Board>();

  public void run(){
    for(int a = 1; a <= 8; a++){
      for(int b = 9; b <= 16; b++){
        for(int c = 17; c <= 24; c++){
          for(int d = 25; d <= 32; d++){
            for(int e = 33; e <= 40; e++){
              for(int f = 41; f <= 48; f++){
                for(int g = 49; g <= 56; g++){
                  for(int h = 57; h <= 64; h++){
                    Board instanceBoard = new Board();
                    instanceBoard.plotQueens(a, b, c, d, e, f, g, h);
                    if (instanceBoard.isCorrect()) solutions.add(instanceBoard);
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  public static void main(String[] args) throws FileNotFoundException {

    // Saves to a file rather than to the terminal
    File file = new File("Solutions.txt");
    FileOutputStream fos = new FileOutputStream(file);
    PrintStream ps = new PrintStream(fos);
    System.setOut(ps);

    CleanAlg ca = new CleanAlg();
    ca.run();

    System.out.println(solutions.size());
    for(Board board : solutions) System.out.println(board);
  }
}
