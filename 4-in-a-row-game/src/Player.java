import java.util.Scanner;

public class Player {
	private String name;
	private String playerNumber;
	private static Scanner scanner = new Scanner(System.in);
	
	public Player(String name, String playerNumber) {
		this.name = name;
		this.playerNumber = playerNumber;
	}

	public String getName() {
		return name;
	}

	public String getPlayerNumber() {
		return playerNumber;
	}
	
	public int MakeMove() {
		System.out.println("Make a move(choose a column to place a token in): ");
		return scanner.nextInt();
	}
	
	public String toString() {
		return "Player "+playerNumber+ " is " + name;
	}

}
