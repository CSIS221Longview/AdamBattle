package battleship;

import java.security.SecureRandom;

public class gameboard {
	int BOARD_SIZE;
	
	int [][] board;
	int [][] ships;
	

public void setboard() {
	// setting the array size depending on the game difficulty
	board = new int[BOARD_SIZE][BOARD_SIZE];
	ships = new int[BOARD_SIZE][BOARD_SIZE];
	fillboard();
}
	
private void fillboard() {
	// initializing both the board and ship array to -1
	for(int row = 0; row < this.BOARD_SIZE; row++) {
		for (int column = 0; column < this.BOARD_SIZE; column++) {
			ships[row][column] = -1;
			board[row][column] = -1;
		}
	}
}



public void printboard() {
	// for printing the top column of the game board going to the right
	System.out.print("\n   ");
	for (int column = 0; column < this.BOARD_SIZE; column++) {
		System.out.printf("%3d", column+1);	
	}
	// start of main loop for printing the rows for the rest of the board
	// for printing the numbers (converted to letters) going down
	for (int row = 0; row < this.BOARD_SIZE; row++) {
		System.out.print("\n");
		System.out.printf("%3c", getLetter(row+1));
		for (int column = 0; column < this.BOARD_SIZE; column++) {
		    if (board[row][column] == -1){
                System.out.print("  ~");
            }
		    else if(board[row][column] == 0){
                System.out.print("  *");
            }
		    else if(board[row][column] == 1){
                System.out.print("  X");
            }
            
        }
		
	}
}

// converting the initial column for printing to letters
public char getLetter(int i){
  return (char) (i + 64);
}


}
