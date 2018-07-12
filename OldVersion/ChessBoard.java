import java.util.ArrayList;

// to save to a file
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ChessBoard
{
  private ArrayList<Queen> queens = new ArrayList<Queen>();
  private char[][] board =
    {
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
    };

  public void printBoard()
  {
		System.out.println();
    System.out.println("     A    B    C    D    E    F    G    H");
    System.out.println("  -----------------------------------------");
		int q = 3;
		for(int i = 0; i < 8; i++){
			for(int a = 0; a < 9; a++){
        System.out.print("  | ");
        if (a != 8)
				  System.out.print(board[i][a]);
        if (a == 8)
          System.out.print(i + 1);
			}
			System.out.println();
			if(i != 8)
				System.out.println("  -----------------------------------------");
		}
		System.out.println();
	}

  public void clearBoard()
  {
    for(int i = 0; i < 8; i++)
      for(int j = 0; j < 8; j++)
        board[j][i] = ' ';
    queens.clear();
  }

  public void addPiece(Queen piece)
  {
    board[piece.getRank()][piece.getFile()] = '\u2655';
    queens.add(piece);
  }

  public void addPiece(String file, int rank)
  {
    addPiece(new Queen(file, rank));
  }

  public void addPiece(int file, int rank)
  {
    addPiece(new Queen(file, rank));
  }

  public void checkLegalSquares()
  {
    for (Queen q : queens)
    {
      for(int i = 0; i < 8; i++)
        if (board[q.getRank()][i] == ' ')
          board[q.getRank()][i] = 'X';
      for(int i = 0; i < 8; i++)
        if (board[i][q.getFile()] == ' ')
          board[i][q.getFile()] = 'X';
      for(int i = -1; i + q.getFile() >= 0 && i + q.getRank() >= 0; i--)
        board[q.getRank() + i][q.getFile() + i] = 'X';
      for(int i = 1; i + q.getFile() <= 7 && i + q.getRank() <= 7; i++)
        board[q.getRank() + i][q.getFile() + i] = 'X';
      for(int i = 1; q.getFile() - i >= 0 && q.getRank() + i <= 7; i++)
        board[q.getRank() + i][q.getFile() - i] = 'X';
      for(int i = 1; q.getFile() + i <= 7 && q.getRank() - i >= 0; i++)
        board[q.getRank() - i][q.getFile() + i] = 'X';
    }
  }

  public void cleanUp()
  {
    for(int i = 0; i < 8; i++)
      for(int j = 0; j < 8; j++)
        if(board[j][i] == 'X')
          board[j][i] = ' ';
  }

  public void fillHoles()
  {
    for(int i = 0; i < 8; i++)
    {
      for(int j = 0; j < 8; j++)
      {
        if (board[j][i] == ' ')
        {
          Queen q = new Queen(i, j);
          addPiece(q);
          checkLegalSquares();
        }
      }
    }
  }

  public void run()
  {
    int counter = 0;
    for(int adder1 = 1; adder1 < 8; adder1++){
      for(int adder2 = 1; adder2 < 8; adder2++){
        for(int file = 0; file < 8; file++)
        {
          for(int rank = 1; rank < 8; rank++)
          {
            clearBoard();
            addPiece(file, rank);
            checkLegalSquares();
            for(int i = 0; i < 8; i += adder1)
            {
              for(int j = 0; j < 8; j += adder2)
              {
                if (board[j][i] == ' ')
                {
                  Queen q = new Queen(i, j);
                  addPiece(q);
                  checkLegalSquares();
                }
              }
            }
            fillHoles();
            if(queens.size() == 8)
            {
              cleanUp();
              printBoard();
              counter++;
            }
          }
        }
      }
    }
    System.out.println(counter);
  }

  public static void main(String[] args) throws FileNotFoundException {
    // Saves to a file rather than to the terminal
    // File file = new File("Solutions.txt");
    // FileOutputStream fos = new FileOutputStream(file);
    // PrintStream ps = new PrintStream(fos);
    // System.setOut(ps);
    ChessBoard test = new ChessBoard();
    test.run();
  }
}
