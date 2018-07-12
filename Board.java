import java.util.ArrayList;

public class Board
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

  public char[][] getBoard()
  {
    return board;
  }

  public ArrayList<Queen> getQueens()
  {
    return queens;
  }

  public boolean isFull()
  {
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[0].length; j++)
        if (board[i][j] == ' ') return false;
    return true;
  }

  public void nextLegalSquare()
  {
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[0].length; j++)
        if (board[i][j] == ' ') { addPiece(j, i); checkLegalSquares(); }
  }

  public String toString()
  {
    String theMeat = "";
    for(int i = 0; i < 8; i++){
      for(int a = 0; a < 9; a++){
        theMeat += "  | ";
        if (a != 8)
          theMeat += board[i][a];
        if (a == 8)
          theMeat += (i + 1);
      }
      theMeat += "\n";
      if(i != 8)
        theMeat += "  -----------------------------------------\n";
    }

    return  "\n" +
            "     A    B    C    D    E    F    G    H\n" +
            "  -----------------------------------------\n" +
            theMeat + "\n";
  }

  public boolean equals(Object o)
  {
    Board other = (Board)(o);
    for (int i = 0; i < 8; i++)
      for (int j = 0; j < 8; j++)
        if (this.board[j][i] != other.board[j][i])
          return false;
    return true;
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

  public void removeLegalSquares()
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
          addPiece(new Queen(i, j));
          checkLegalSquares();
        }
      }
    }
  }

  public void rotate90()
  {

  }

  public void emptyBoard()
  {
    for(int i = 0; i < 8; i++)
      for(int j = 0; j < 8; j++)
        board[j][i] = ' ';
    queens.clear();
  }
}
