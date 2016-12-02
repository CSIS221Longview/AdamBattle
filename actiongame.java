package battleship;
import java.util.Scanner;


public class actiongame {
	 // create new object of gameboard.java
	gameboard gameboard = new gameboard();
	Scanner kb = new Scanner(System.in);
	private int hits = 0;
	private int turns = 0;
	
	
	public void startGame() {
		gameboard.setDiff(); // call the setDiff() method from gameboard.java
		gameboard.placeShips(); // call placeShips() method from gameboard.java
		gameboard.printBoard(); // call the printBoard() method from gameboard.java
	}
	
	public void playGame() {
		// create a boolean for determing gameover
		boolean gameOver; 
		
		// the following code will execute over and over until gameOver is set to true (when the game ends)
		do {
		turns++;	
		// initializing gameOver to false
		gameOver = false; 
		System.out.print("\n\nWhat row do you want to attack? (example: A or b): ");
		char input = kb.next().charAt(0);
		input = Character.toUpperCase(input); 
		// The while loop will validate that the player entered a valid character
		while (!Character.toString(input).matches("^[a-lA-L]") || Character.toString(input).length() >= 2)  {
			System.out.println("\nMake sure you are entering a valid single letter!");
			System.out.print("\nWhat row do you want to attack? (example: A or b): ");
			input = kb.next().charAt(0);
			input = Character.toUpperCase(input); 
		}
		// capatalizes the character input for easier conversion to integer	
		int row = getNumber(input); 
		// passes the character input to getNumber() to convert the letter to a number for the board[][] array
		System.out.print("What column do you want to attack? (example: 1 or 5): ");
		while (!kb.hasNextInt()) {
			System.out.println("\nMake sure you are entering a valid NUMBER!\n");
			System.out.print("What column do you want to attack? (example: 1 or 5): ");
			kb.next();
		}
		int col = kb.nextInt() - 1;
		// subtract 1 so we don't go out of bounds on the board[][] array
		// pass the converted row and column to fire method to attack the board
		fire(row, col); 
		gameboard.useMissiles();
		// 
		// System.out.printf("%nYou have hit %d ship(s) and had %d turn(s)", hits, turns);
		System.out.printf("%nYour hit accuracy is %.2f%%", getAccuracy(hits, turns));
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
		} while(!gameOver); 
	}
	
	
	// The following code will determine what the player hit with their choice of attack
	// the row and col values were passed inside the playGame() method
	public void fire(int row, int col) {
		// if the players attack landed on a -3 value, they hit the AIRCRAFT_CARRIER
		if (gameboard.board[row][col] == -3){
			// Create an int for ship sinking call sunk. Each time the players attack lands on a -3 value, subtract 1 from the ships size
			// once the size hits 1, the ship is sunk
			int sunk = gameboard.ships[0].size--;
			hits++;
			System.out.printf("%nYou have hit the %s", gameboard.ships[0].name);
			// change the value where the player attacked to a 1, meaning a HIT
			gameboard.board[row][col] = 1;
			if (sunk == 1) {
				System.out.printf("%n****** You have sunk the %s Aircraft Carrier.", gameboard.ships[0].name);
				gameboard.shipsAlive--;
			}
		}
		// if the players attack landed on a -4 value, they hit the BATTLESHIP
		else if (gameboard.board[row][col] == -4) {
			int sunk = gameboard.ships[1].size--;
			hits++;
			System.out.printf("%nYou have hit the %s", gameboard.ships[1].name);
			gameboard.board[row][col] = 1;
			if (sunk == 1) {
				System.out.printf("%n****** You have sunk the %s Battleship.", gameboard.ships[1].name);
				gameboard.shipsAlive--;
			}
		}
		// if the players attack landed on a -5 value, they hit the DESTROYER
		else if (gameboard.board[row][col] == -5) {
			int sunk = gameboard.ships[2].size--;
			hits++;
			System.out.printf("%nYou have hit the %s", gameboard.ships[2].name);
			gameboard.board[row][col] = 1;
			if (sunk == 1) {
				System.out.printf("%n****** You have sunk the %s Destroyer.", gameboard.ships[2].name);
				gameboard.shipsAlive--;
			}
		}
		// if the players attack landed on a -6 value, they hit the SUBMARINE
		else if (gameboard.board[row][col] == -6) {
			int sunk = gameboard.ships[3].size--;
			hits++;
			System.out.printf("%nYou have hit the %s", gameboard.ships[3].name);
			gameboard.board[row][col] = 1;
			if (sunk == 1) {
				System.out.printf("%n****** You have sunk the %s Submarine.", gameboard.ships[3].name);
				gameboard.shipsAlive--;
			}
		}
		// if the players attack landed on a -7 value, they hit the PATROL_BOAT
		else if (gameboard.board[row][col] == -7) {
			int sunk = gameboard.ships[4].size--;
			hits++;
			System.out.printf("%nYou have hit the %s", gameboard.ships[4].name);
			gameboard.board[row][col] = 1;
			if (sunk == 1) {
				System.out.printf("%n****** You have sunk the %s Patrol Boat.", gameboard.ships[4].name);
				gameboard.shipsAlive--;
			}
		}
		
		// if the players attack hit anything other than the values indicated above, then they missed hitting a ship
		else {
			System.out.print("You hit NOTHING! TRY AGAIN\n");
			// assign the value of the board where the player attacked to 0, meaning a miss
			gameboard.board[row][col] = 0;
		}
		
		
		
	
	}
	
	private double getAccuracy(double hits, double turns) {
		double accuracy = (hits / turns) * 100;
		return accuracy;
	}
	
	public static boolean validate(String s) {
		if (s.length() > 1 || s.length() == 0)
			return false;
		else
			return true;
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
