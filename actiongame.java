package battleship;
import java.util.Scanner;

public class actiongame {

	gameboard gameboard = new gameboard();
	Scanner kb = new Scanner(System.in);
	
	public void startGame() {
		gameboard.setDiff();
		gameboard.placeShips();
		gameboard.printBoard();
	}
	
	public void playGame() {
		boolean gameOver;
		do {
		gameOver = false;
		System.out.print("\n\nWhat row do you want to attack? (A-F): ");
		char input = kb.next().charAt(0); // takes character input starting at position 0
		input = Character.toUpperCase(input); // capatalizes the character inputted for easier conversion to integer
		// test for uppercase System.out.printf("%nYou have entered %c as your char input", input);
		int row = getNumber(input); // passes the character input to getNumber() to convert the letter to a number for the board[][] array
		System.out.print("What column do you want to attack? (1-6): ");
		int col = kb.nextInt() - 1; // subtract 1 so we don't go out of bounds on the board[][] array
		fire(row, col); // pass the converted row and column to fire method to attack the board
	
		} while(!gameOver);
	}
	
	public void fire(int row, int col) {
		if (gameboard.board[row][col] == -3){
			int sunk = gameboard.ships[0].size--;
			System.out.printf("You have hit the %s", gameboard.ships[0].name);
			gameboard.board[row][col] = 1;
			if (sunk == 1) {
				System.out.printf("%n You have sunk the %s", gameboard.ships[0].name);
				gameboard.shipsAlive--;
			}
		}
		else if (gameboard.board[row][col] == -4) {
			System.out.printf("You have hit the %s", gameboard.ships[1].name);
			gameboard.board[row][col] = 1;
		}
		else if (gameboard.board[row][col] == -5) {
			System.out.printf("You have hit the %s", gameboard.ships[2].name);
			gameboard.board[row][col] = 1;
		}
		else if (gameboard.board[row][col] == -6) {
			System.out.printf("You have hit the %s", gameboard.ships[3].name);
			gameboard.board[row][col] = 1;
		}
		else if (gameboard.board[row][col] == -7) {
			System.out.printf("You have hit the %s", gameboard.ships[4].name);
			gameboard.board[row][col] = 1;
		}
		else {
			System.out.print("You hit NOTHING! TRY AGAIN");
			gameboard.board[row][col] = 0;
		}
		gameboard.useMissiles();		
		gameboard.printBoard();
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
