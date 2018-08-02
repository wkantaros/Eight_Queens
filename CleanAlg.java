import java.util.ArrayList;

// to save to a file
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class CleanAlg{

  private static ArrayList<Board> solutions = new ArrayList<Board>();

  // takes ~ .1 seconds to run
  public static void run(){
    for(int a = 0; a <= 7; a++){
      for(int b = 8; b <= 15; b++){
        if (b % 8 == a) continue;
        for(int c = 16; c <= 23; c++){
          if (c % 8 == b % 8 || c % 8 == a) continue;
          for(int d = 24; d <= 31; d++){
            if (d % 8 == c % 8 || d % 8 == b % 8 || d % 8 == a) continue;
            for(int e = 32; e <= 39; e++){
              if (e % 8 == d % 8 || e % 8 == c % 8 || e % 8 == b % 8 || e % 8 == a) continue;
              for(int f = 40; f <= 47; f++){
                if (f % 8 == e % 8 || f % 8 == d % 8 || f % 8 == c % 8 || f % 8 == b % 8 || f % 8 == a) continue;
                for(int g = 48; g <= 55; g++){
                  if (g % 8 == f % 8 || g % 8 == e % 8 || g % 8 == d % 8 || g % 8 == c % 8 || g % 8 == b % 8 || g % 8 == a) continue;
                  for(int h = 56; h <= 63; h++){
                    if (h % 8 == g % 8 || h % 8 == f % 8 || h % 8 == e % 8 || h % 8 == d % 8 || h % 8 == c % 8 || h % 8 == b % 8 || h % 8 == a) continue;
                    Board instanceBoard = new Board();
                    instanceBoard.plotQueens(a, b, c, d, e, f, g, h);
                    if (instanceBoard.checkDiagonals()) solutions.add(instanceBoard);
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
    
    // Saves to a file rather than to the terminal, comment out if you don't want
    File file = new File("Solutions.txt");
    FileOutputStream fos = new FileOutputStream(file);
    PrintStream ps = new PrintStream(fos);
    System.setOut(ps);

    run();

    System.out.println(solutions.size());
    for(Board board : solutions) System.out.println(board);
  }
}
