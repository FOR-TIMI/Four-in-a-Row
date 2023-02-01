
import java.util.Arrays;
import java.util.Scanner;

public class Game {
	private Player[] players;
	private Board board;
	private int currentPlayerIndex;
	private int numOfPlayers;
	
	//Scanner
	private Scanner scanner = new Scanner(System.in);
	
	//Game constructor
	public Game(){
	    //create a new board;
	    this.board = new Board();
	    //setup game;
	    this.setupGame();
	    //start game;
	    this.play();
	}
	
	//To setup a game
	public void setupGame(){
		//To select the number of players allowed in the game
		System.out.println("How many players are included in this game? (2-4)");
		numOfPlayers = scanner.nextInt();
        
		//To make sure that the number of players are between 2 and 4
		while (numOfPlayers < 2 || numOfPlayers > 4) {
		    System.out.println("Invalid input. Please enter a number between 2 and 4.");
		    numOfPlayers = scanner.nextInt();
		}

		// To clear the next line and fix error
		scanner.nextLine();
		
		String[] playerNames = new String[numOfPlayers];
		
		//initialize with empty array of players
	    this.players = new Player[numOfPlayers];

		for (int i = 0; i < numOfPlayers; i++) {
		    System.out.println("Enter player " + (i + 1) + "'s name:");
		    String newPlayerName = scanner.nextLine();
		    
		  //To make sure players don't have the same name
		    while (Arrays.asList(playerNames).contains(newPlayerName)) {
		        System.out.println("Player names cannot be the same. Please enter different names.");
		        System.out.print("Enter player " + (i + 1) + "'s name: ");
		        newPlayerName = scanner.nextLine();
		    }
		    playerNames[i] = newPlayerName;
		    
		    //to add players to the players array
		    players[i] = new Player(newPlayerName, Integer.toString(i + 1));
		}

		
		
		
		//setup board
		this.board.boardSetUp();
		
		//set starting player to a random index
		this.currentPlayerIndex = (int) Math.floor(Math.random() * numOfPlayers);
		
	}
	
	//Print winner
	private void printWinner(Player player){
		System.out.println("------------------------------------------------");
		System.out.println("     | Player " +player.getPlayerNumber()+" which is "+player.getPlayerName() +" wins |     ");
		System.out.println("------------------------------------------------");
	}
	
	private void playerTurn(Player currentPlayer){
		try {
			System.out.println("\n---------Player " + currentPlayer.getPlayerNumber() +"'s turn -----\n");
			
			//To check the array. we assume that the user's input starts from 1
			// so to be within the bounds of the array.
			int move = currentPlayer.makeMove() - 1;
			
			//to check if the move is illegal 
			if(this.board.columnFull(move)) {
				throw new Exception("Column is full.");
			}
			
			//To make sure our column numbers are always valid
			if(move< 0 || move >= this.board.getColumns()){
				throw new Exception("Invalid column number.");
			}
			
			//update board to add token
			this.board.addToken(move, currentPlayer.getPlayerNumber());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

	}
	
    private void play() {	
    	while(!this.board.boardFull()){ 
    		Player currentPlayer = players[currentPlayerIndex];
    		
    		//print board
    		this.board.printBoard();
    		
    		//to make a move
    		try {
				this.playerTurn(currentPlayer);
			} catch (Exception e) {
				//catch block
				System.out.println("Something went wrong trying to add a token the playerTurn function: " + e);;
			}
    		
    		//if a player wins just print the current player
    		if(this.board.checkIfPlayerIsWinner(currentPlayer.getPlayerNumber())) {
    			this.board.printBoard(); //to print the board before declaring a winner
    			this.printWinner(currentPlayer);
    			return; // To end game when a player wins;
    		} 
    		
    		//alternate current player
            setPlayerIndex();
    	}
    	
    	System.out.println("Game ended because board is full!");
    }
    
    //to set current player Index
    private void setPlayerIndex() {
    	this.currentPlayerIndex = (this.currentPlayerIndex + 1) % numOfPlayers;
    }

}
