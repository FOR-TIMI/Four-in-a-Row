import java.util.Scanner;

public class Board {
  private String[][] board;
  private int rows;
  private int columns;

  public Board() {
    boardSetUp();
  }

  public void boardSetUp() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number of rows: ");
    rows = input.nextInt();
    System.out.print("Enter number of columns: ");
    columns = input.nextInt();
    board = new String[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        board[i][j] = "-";
      }
    }
  }

  public void printBoard() {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public boolean columnFull(int column) {
    return !board[0][column].equals("-");
  }

  public boolean boardFull() {
    for (int i = 0; i < columns; i++) {
      if (!columnFull(i)) {
        return false;
      }
    }
    return true;
  }

  public void addToken(int column, String player) throws Exception {
    if (columnFull(column)) {
      throw new Exception("Column is full.");
    }
    if (column < 0 || column >= columns) {
      throw new Exception("Invalid column number.");
    }
    for (int i = rows - 1; i >= 0; i--) {
      if (board[i][column].equals("-")) {
        board[i][column] = player;
        break;
      }
    }
  }

  public boolean checkIfPlayerIsTheWinner(String player) {
    return checkVertical(player) || checkHorizontal(player) || checkRightDiagonal(player) || checkLeftDiagonal(player);
  }

  private boolean checkVertical(String player) {
    for (int i = 0; i < columns; i++) {
      for (int j = 0; j < rows - 3; j++) {
        if (board[j][i].equals(player) && board[j + 1][i].equals(player) && board[j + 2][i].equals(player) && board[j + 3][i].equals(player)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean checkHorizontal(String player) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns - 3; j++) {
        if (board[i][j].equals(player) && board[i][j + 1].equals(player) && board[i][j + 2].equals(player) && board[i][j + 3].equals(player)) {
          return true;
        }
      }
     }
      return false;
    }

  private boolean checkRightDiagonal(String player) {
    for (int i = 0; i < rows - 3; i++) {
      for (int j = 0; j < columns - 3; j++) {
        if (board[i][j].equals(player) && board[i + 1][j + 1].equals(player) && board[i + 2][j + 2].equals(player) && board[i + 3][j + 3].equals(player)) {
        return true;
        }
       }
      }
        return false;
    }

  private boolean checkLeftDiagonal(String player) {
    for (int i = 0; i < rows - 3; i++) {
      for (int j = columns - 1; j >= 3; j--) {
       if (board[i][j].equals(player) && board[i + 1][j - 1].equals(player) && board[i + 2][j - 2].equals(player) && board[i + 3][j - 3].equals(player)) {
        return true;
        }
       }
      }
        return false;
     }
    }