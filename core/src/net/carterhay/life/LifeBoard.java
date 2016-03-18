package net.carterhay.life;

/**
 * @Author Carter Hay 
 * 
 */
public class LifeBoard {

  private final int width, height;
  private boolean[][] board;
  private boolean[][] old;

  public LifeBoard(int width, int height){
    this.width = width;
    this.height = height;
    this.board = new boolean[this.height][this.width];
    this.old = new boolean[this.height][this.width];
  }

  public LifeBoard(int width, int height, boolean[][] board) {
    this.width = width;
    this.height = height;
    this.board = board;
    this.old = new boolean[this.height][this.width];
  }

  public void update() {
    //copy board to old
    for (int y = 0; y < this.height; y++) {
      for (int x = 0; x < this.width; x++) {
        this.old[y][x] = this.board[y][x];
      }
    }
    for (int y = 0; y < this.height; y++) {
      for (int x = 0; x < this.width; x++) {
        int neighbors = 0;
        //Check below
        if (y > 0) {
          if (old[y-1][x]) neighbors++;
        }
        //Check up
        if (y < this.height-1) {
          if (old[y+1][x]) neighbors++;
        }
        //Check left
        if (x > 0) {
          if (old[y][x-1]) neighbors++;
        }
        //Check right
        if (x < this.width-1) {
          if (old[y][x+1]) neighbors++;
        }
        //Check down left diag
        if (y > 0 && x > 0) {
          if (old[y-1][x-1]) neighbors++;
        }
        //Check down right diag
        if (y > 0 && x < this.width-1) {
          if (old[y-1][x+1]) neighbors++;
        }
        //Check up left diag
        if (y < this.height-1 && x > 0) {
          if (old[y+1][x-1]) neighbors++;
        }
        //Check up right diag
        if (y < this.height-1 && x < this.width-1) {
          if (old[y+1][x+1]) neighbors++;
        }

        if (neighbors < 2 || neighbors > 3) {
          board[y][x] = false;
        } else if (neighbors == 3) {
          board[y][x] = true;
        }
      }
    }
  }

  /**
   * Sets the current board to newBoard
   *
   * @param newBoard The board to be set
   */
  public void setBoard(boolean[][] newBoard) {
    this.board = newBoard;
  }

  /**
   * Returns the board
   *
   * @return this.board
   */
  public boolean[][] getBoard() {
    return this.board;
  }

  /**
   * Turns a cell on
   *
   * @param x The x value of the cell
   * @param y The y value of the cell
   */
  public void setOn(int x, int y) {
    this.board[x][y] = true;
  }
  
}
