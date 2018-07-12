import java.util.ArrayList;

public class CleanAlg{

  /*TODO:
    * Make Queen() contructor that only takes one int value
    * Make plotQueens method(Queen[] queens) in Board.java
    * Make a correct() method  in Board.java
    * Clean Up files for accessability
  */

  private static ArrayList<Board> solutions = new ArrayList<Board>();

  public void run(){
    for(int a = 0; a <= 57; a++){
      for(int b = a+1; b <= 58; b++){
        for(int c = b+1; c <= 59; c++){
          for(int d = c+1; d <= 60; d++){
            for(int e = d+1; e <= 61; e++){
              for(int f = e+1; f <= 62; f++){
                for(int g = f+1; g <= 63; g++){
                  for(int h = g+1; h <= 64; h++){
                    // Board instanceBoard = new Board();
                    Queen[] queens = new Queen[8]; // faster than arrayList
                    // instanceBoard.plotQueens(a, b, c, d, e, f, g, h)
                    // if (instanceBoard.correct()) solutions.add(instanceBoard)
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}
