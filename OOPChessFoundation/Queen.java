public class Queen
{
  private int rank, file;

  public Queen(int num)
  {
    num--;
    file = num / 8;
    rank = num % 8;
  }

  public Queen(int file, int rank)
  {
    this.file = file;
    this.rank = rank;
  }

  // ----------------------------------------------------------------------

  public Queen(String file, int rank)
  {
    String converter = "ABCDEFGH";
    this.rank = rank - 1;
    this.file = converter.indexOf(file);
  }

  public String toString()
  {
    String converter = "ABCDEFGH";
    return "\u2655 " + converter.charAt(file) + "" + (rank + 1);
  }

  public void move(String file, int rank)
  {
    String converter = "ABCDEFGH";
    this.rank = rank - 1;
    this.file = converter.indexOf(file);
  }

  public void move(int file, int rank)
  {
    this.file = file;
    this.rank = rank;
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
