package battleship;
import java.util.Scanner;

public class actiongame {

	gameboard gameboard = new gameboard(); // create new object of gameboard.java
	Scanner kb = new Scanner(System.in);
	
	public void startGame() {
		gameboard.setDiff(); // call the setDiff() method from gameboard.java
		gameboard.placeShips(); // call placeShips() method from gameboard.java
		gameboard.printBoard(); // call the printBoard() method from gameboard.java
	}
	
	public void playGame() {
		boolean gameOver; // create a boolean for determing gameover
		
			// the following code will execute over and over until gameOver is set to true (when the game ends)
		do {
			// initializing gameOver to false
		gameOver = false; 
		System.out.print("\n\nWhat row do you want to attack? (example: A or b): ");
		
		char input = kb.next().charAt(0); // takes the character input from the player 
		input = Character.toUpperCase(input); // capatalizes the character input for easier conversion to integer
		// this is merely a test for uppercase System.out.printf("%nYou have entered %c as your char input", input);
		
		
		int row = getNumber(input); // passes the character input to getNumber() to convert the letter to a number for the board[][] array
		System.out.print("What column do you want to attack? (example: 1 or 5): ");
		int col = kb.nextInt() - 1; // subtract 1 so we don't go out of bounds on the board[][] array
		
		// pass the converted row and column to fire method to attack the board
		fire(row, col); 
		gameboard.useMissiles();
		// call printBoard() from the gameboard.java to re-print the board for another attack
		gameboard.printBoard();
		// once the int sunk value hits 0, all ships have been sunk, the player wins, call gameOverWin() from gameboard.java
		if (gameboard.shipsAlive == 0) {
			gameboard.gameOverWin();
			gameOver = true;
		}
		// or if they have used all their missiles, the player loses, call gameOverLoss() from gameboard.java
		else if (gameboard.getMissiles() == 0) {
			gameboard.gameOverLoss();
			gameOver = true;
		}
		} while(!gameOver); // the do, while loop will end when gameOver is true
	}
	
	
	// The following code will determine what the player hit with their choice of attack
	// the row and col values were passed inside the playGame() method
	public void fire(int row, int col) {
		// if the players attack landed on a -3 value, they hit the AIRCRAFT_CARRIER
		if (gameboard.board[row][col] == -3){
			// Create an int for ship sinking call sunk. Each time the players attack lands on a -3 value, subtract 1 from the ships size
			// once the size hits 1, the ship is sunk
			int sunk = gameboard.ships[0].size--;
			System.out.printf("%nYou have hit the %s", gameboard.ships[0].name);
			// change the value where the player attacked to a 1, meaning a HIT
			gameboard.board[row][col] = 1;
			if (sunk == 1) {
				System.out.printf("%n You have sunk the %s Aircraft Carrier.", gameboard.ships[0].name);
				gameboard.shipsAlive--;
			}
		}
		// if the players attack landed on a -4 value, they hit the BATTLESHIP
		else if (gameboard.board[row][col] == -4) {
			int sunk = gameboard.ships[1].size--;
			System.out.printf("%nYou have hit the %s", gameboard.ships[1].name);
			gameboard.board[row][col] = 1;
			if (sunk == 1) {
				System.out.printf("%n You have sunk the %s Battleship.", gameboard.ships[1].name);
				gameboard.shipsAlive--;
			}
		}
		// if the players attack landed on a -5 value, they hit the DESTROYER
		else if (gameboard.board[row][col] == -5) {
			int sunk = gameboard.ships[2].size--;
			System.out.printf("%nYou have hit the %s", gameboard.ships[2].name);
			gameboard.board[row][col] = 1;
			if (sunk == 1) {
				System.out.printf("%nYou have sunk the %s Destroyer.", gameboard.ships[2].name);
				gameboard.shipsAlive--;
			}
		}
		// if the players attack landed on a -6 value, they hit the SUBMARINE
		else if (gameboard.board[row][col] == -6) {
			int sunk = gameboard.ships[3].size--;
			System.out.printf("%nYou have hit the %s", gameboard.ships[3].name);
			gameboard.board[row][col] = 1;
			if (sunk == 1) {
				System.out.printf("%n You have sunk the %s Submarine.", gameboard.ships[3].name);
				gameboard.shipsAlive--;
			}
		}
		// if the players attack landed on a -7 value, they hit the PATROL_BOAT
		else if (gameboard.board[row][col] == -7) {
			int sunk = gameboard.ships[4].size--;
			System.out.printf("%nYou have hit the %s", gameboard.ships[4].name);
			gameboard.board[row][col] = 1;
			if (sunk == 1) {
				System.out.printf("%n You have sunk the %s Patrol Boat.", gameboard.ships[4].name);
				gameboard.shipsAlive--;
			}
		}
		
		// if the players attack hit anything other than the values indicated above, then they missed hitting a ship
		else {
			System.out.print("You hit NOTHING! TRY AGAIN");
			// assign the value of the board where the player attacked to 0, meaning a miss
			gameboard.board[row][col] = 0;
		}
		
		
		
	
	}
	
	
	
	
	
	// change the character input for first user attack prompt to a number for the board[][] array
	private int getNumber(char input) {
		int row = 0;
		
		switch(input){
		case 'A':
			row = 0;
			break;
		case 'B':
			row = 1;
			break;
		case 'C':
			row = 2;
			break;
		case 'D':
			row = 3;
			break;
		case 'E':
			row = 4;
			break;
		case 'F':
			row = 5;
			break;
		case 'G':
			row = 6;
			break;
		case 'H':
			row = 7;
			break;
		case 'I':
			row = 8;
			break;
		case 'J':
			row = 9;
			break;
		case 'K':
			row = 10;
			break;
		case 'L':
			row = 11;
			break;
		
		}
		
		
		return row;
	}
}
