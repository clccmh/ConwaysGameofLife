//package net.carterhay.life;

/**
 * @Author Carter Hay 
 * 
 */
public class LifeTest {
  public static void main (String[] args) {
    boolean[][] test = {
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, true, false, true, false, false, false, false},
    {false, false, false, false, true, true, false, false, false, false},
    {false, false, false, false, true, false, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false}};

    System.out.println(test[4][4]);

    boolean[][] correct = {
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, false, false, true, false, false, false, false},
    {false, false, false, true, false, true, false, false, false, false},
    {false, false, false, false, true, true, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false},
    {false, false, false, false, false, false, false, false, false, false}};

    LifeBoard board = new LifeBoard(10, 10, test);
    printBoard(board);
    System.out.println("--------------------------------------------");
    board.update();
    printBoard(board);
    System.out.println("----------------Expected--------------------");
    printBoard(new LifeBoard(10, 10, correct));

  }

  static void printBoard(LifeBoard board) {
    for (int y = 0; y < 10; y++) {
      for (int x = 0; x < 10; x++) {
          if (board.getBoard()[y][x]) {
            System.out.print("x");
          } else {
            System.out.print(".");
          }
        }
      System.out.println();
    }
  }
}
