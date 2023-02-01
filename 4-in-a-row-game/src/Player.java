
import java.util.Scanner;

public class Player {	
	//initial variables
	private String playerName;
	private String playerNumber;
	private static Scanner scanner = new Scanner(System.in);
	
	//constructor need playerName and playerNumber
	public Player(String playerName, String playerNumber) {
		this.playerName = playerName;
		this.playerNumber = playerNumber;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public String getPlayerNumber() {
		return this.playerNumber;
	}
	
	public int makeMove() {
		System.out.println("What column would you like to place your token?");
		return scanner.nextInt();
	}
	
	public String toString(){
		return "Player " +playerNumber+ " is " + playerName;
	}		
}
