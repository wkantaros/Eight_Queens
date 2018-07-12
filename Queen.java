public class Queen
{
  private int rank, file;

  public Queen(int num)
  {
    num--;
    file = num / 8;
    rank = num % 8;
  }

  public String toString()
  {
    String converter = "ABCDEFGH";
    return "\u2655 " + converter.charAt(file) + "" + (rank + 1);
  }

  public int getFile()
  {
    return file;
  }

  public int getRank()
  {
    return rank;
  }
}
