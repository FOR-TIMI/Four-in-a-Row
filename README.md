# 4 in a Row Game -console game
This 4 in a Row game is built using Java and runs in the console. It is a classic game where players can win left diagonally, right diagonally, horizontally, and vertically by connecting four of their tokens in a row.

## Classes
The app consists of four classes: Game class, Board class, Main class, and Player class.

-  **Game Class**:  The Game class handles the overall game play and implements the rules of the game. It prompts the players to enter the number of players that are playing, which can be between 2 and 4 players. It also allows the players to enter the number of rows and columns for the board, which can be between 4 and 10 for both rows and columns.

- **Board Class**: The Board class handles the creation and display of the game board. It also keeps track of the players' moves and determines if a player has won the game.

- **Main Class**: The Main class is the entry point of the game. It initializes the Game class and starts the game.

- **Player Class**: The Player class represents each player in the game. It generates player numbers automatically and keeps track of each player's moves.

## How to Play
- Run the Main class to start the game.
- Enter the number of players that will be playing, between 2 and 4 players.
- Enter the number of rows and columns for the board, which can be between 4 and 10 for both rows and columns.
- Players will take turns dropping their tokens into the columns until one player connects four of their tokens in a row. The first player to connect four tokens in a row wins the game.

## Win conditions
Players can win if they connect their `playerNumbers` 4 times in the following manners;
- Horizontally
- Vertically
- Diagonally


## Note
The game uses player numbers instead of token colors. Player numbers are generated automatically for each player.

## Contribution
Made with ❤️ by Timi
