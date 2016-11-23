package battleship;

import java.security.SecureRandom;
import java.util.Arrays;

public class gameboard {
    int BOARD_SIZE;
	
	char [][] board;
	char [][] ships;
	

public void setboard() {
	// setting the array size depending on the game difficulty
	board = new char[BOARD_SIZE][BOARD_SIZE];
	ships = new char[BOARD_SIZE][BOARD_SIZE];
	fillboard();
}
	
private void fillboard() {
	// initializing both the board and ship array to ~
	for(int i = 0; i < this.BOARD_SIZE; i++) {
		for (int j = 0; j < this.BOARD_SIZE; j++) {
			board[i][j] = '~';
		}
	}
}



public void printboard() {
	setboard();
	System.out.printf("%nBoard size is: %dx%d%n", this.BOARD_SIZE, this.BOARD_SIZE);
	// for printing the top column of the game board going to the right with some extra space
	System.out.print("\n  ");
	for (int i = 0; i < this.BOARD_SIZE; i++) {
		System.out.printf("%3d", i+1);	
	}
	// start of main loop for printing the rows for the rest of the board
	// for printing the numbers (converted to letters) going down
	for (int i = 0; i < this.BOARD_SIZE; i++) {
		System.out.print("\n");
		System.out.printf("%3c", getLetter(i+1));
		for (int j = 0; j < this.BOARD_SIZE; j++) {
			System.out.printf("%2c", board[i][j]);
			System.out.print("|");
            }
            
    }
}


// converting the initial column for printing to letters
public char getLetter(int i){
  return (char) (i + 64);
}


}
