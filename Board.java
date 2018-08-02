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

  public void plotQueens(int a, int b, int c, int d, int e, int f, int g, int h)
  {
    ArrayList<Queen> qVar = new ArrayList<Queen>();
    qVar.add(new Queen(a));
    qVar.add(new Queen(b));
    qVar.add(new Queen(c));
    qVar.add(new Queen(d));
    qVar.add(new Queen(e));
    qVar.add(new Queen(f));
    qVar.add(new Queen(g));
    qVar.add(new Queen(h));

    for (Queen queen : qVar){
      addPiece(queen);
    }
  }

  public void addPiece(Queen piece)
  {
    board[piece.getRank()][piece.getFile()] = '\u2655';
    queens.add(piece);
  }

  public boolean checkDiagonals()
  {
    for (Queen q : queens)
    {
      for(int i = -1; i + q.getFile() >= 0 && i + q.getRank() >= 0; i--)
        if(board[q.getRank() + i][q.getFile() + i] == '\u2655') return false;
      for(int i = 1; i + q.getFile() <= 7 && i + q.getRank() <= 7; i++)
        if(board[q.getRank() + i][q.getFile() + i] == '\u2655') return false;
      for(int i = 1; q.getFile() - i >= 0 && q.getRank() + i <= 7; i++)
        if(board[q.getRank() + i][q.getFile() - i] == '\u2655') return false;
      for(int i = 1; q.getFile() + i <= 7 && q.getRank() - i >= 0; i++)
        if(board[q.getRank() - i][q.getFile() + i] == '\u2655') return false;
    }
    return true;
  }

  public String toString()
  {
    String boardContents = "";
    for(int i = 0; i < 8; i++){
      for(int a = 0; a < 9; a++){
        boardContents += "  | ";
        if (a != 8)
          boardContents += board[i][a];
        if (a == 8)
          boardContents += (i + 1);
      }
      boardContents += "\n";
      if(i != 8)
        boardContents += "  -----------------------------------------\n";
    }

    return  "\n" +
            "     A    B    C    D    E    F    G    H\n" +
            "  -----------------------------------------\n" +
            boardContents + "\n";
  }
}
