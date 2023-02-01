import java.util.Scanner;


public class Board {
	private String[][] board;
	private Scanner scanner = new Scanner(System.in);
	private int rows;
	private int columns;
	
	
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public void boardSetUp() {
		System.out.println("How many rows would you like to add?(4-10)");
		rows = scanner.nextInt();
		
		//choose how many rows (between four and ten)
		while (rows < 4 || rows > 10) {
		    System.out.println("Invalid input. Please enter a number between 4 and 10.");
		    rows = scanner.nextInt();
		}

		
		System.out.println("How many columns would you like to add?(4-10)");
		columns = scanner.nextInt();
		
		//choose how many columns (between four and ten)
		while (columns < 4 || columns > 10) {
		    System.out.println("Invalid input. Please enter a number between 4 and 10.");
		    columns = scanner.nextInt();
		}

		
		
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
	
	
    public boolean columnFull(int columnNumber){
        //return true if a column is full or else it'll return false
    	if(board[0][columnNumber].equals("-")) {
    		return false;
  	   }
    	return true;
    }
    
	public boolean boardFull(){  
		//iterate through the columns 
		for(int i =0; i < columns; i++) {
			//check if that column is full
			if(!this.columnFull(i)) {
				return false;
			}
		}
		return true;	
	}
	
	public void addToken(int columnNumber, String playerNumber) {

        //iterate over the column and find the last open space;
        for(int i= rows - 1; i >= 0; i--){
            //if the element in that column is empty, addToken
            if(board[i][columnNumber].equals("-")){
                board[i][columnNumber] = playerNumber;
                break;
            }
        }
		
	}
	
	public boolean checkIfPlayerIsWinner(String playerNumber) {
		return  checkHorizontal(playerNumber)  
			 || checkVertical(playerNumber)  
			 || checkRightDiagonal(playerNumber)  
			 || checkLeftDiagonal(playerNumber);
	}
	
	/* Helper functions*/
	private boolean checkHorizontal(String playerNumber) {
        //iterate over each row 
        for(int i = rows - 1; i >= 0; i--){
             // iterates over all the columns in that row greater than 3 since it's 4 in a row;
             for(int j = 0; j < columns - 3; j++ ){
                 //check if the next 4 items are the player's Number
                if( this.board[i][j].equals(playerNumber)
                && board[i][j + 1].equals(playerNumber)
                && board[i][j + 2].equals(playerNumber)
                && board[i][j + 3].equals(playerNumber)
                ){
                	
                    return true;
                }
                
             }      

        }
       return false;
	 }
	
	private boolean checkVertical(String playerNumber){
	        //iterate over each column
	        for (int i = 0; i < columns; i++) {
	             // iterates over all the rows in that column greater than 3 since it's 4 in a row;
	             for (int j = 0; j < rows - 3; j++) {
	                 //check if the next 4 items are the player's Number
	                if( board[j][i].equals(playerNumber)
	                && board[j + 1][i].equals(playerNumber)
	                && board[j + 2][i].equals(playerNumber)
	                && board[j + 3][i].equals(playerNumber)
	                ){
	                    return true;
	                }
	             }      
	        }

	        return false;
	    }

	private boolean checkRightDiagonal(String playerNumber){
	        //iterate over the rows
	        for(int i=0; i < rows - 3; i++){
	            //iterate over the columns
	            for(int j=0; j< columns -3; j++){
	                if( board[i][j].equals(playerNumber)
	                 && board[i + 1][j + 1].equals(playerNumber)
	                 && board[i + 2][j + 2].equals(playerNumber)
	                 && board[i + 3][j + 3].equals(playerNumber)
	                ) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	
    private boolean checkLeftDiagonal(String playerNumber){
        //iterate over the rows
        for(int i=0; i < rows - 3; i++){
            //iterate over each column from the top
            for(int j=columns -1; j >= 3; j-- ){
                if(board[i][j].equals(playerNumber)
                && board[i + 1][j - 1].equals(playerNumber)
                && board[i + 2][j - 2].equals(playerNumber)
                && board[i + 3][j -3].equals(playerNumber)
                ){
                    return true;
                }
            }
        }
        return false;
    }

}
