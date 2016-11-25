package battleship;

import java.util.Random;

public class gameboard {
    int BOARD_SIZE;
    int missilesleft;
    static int size;
    private int shipsalive = 5;
    private static final int AIRCRAFT_CARRIER = 5;
    private static final int BATTLESHIP = 4;
    private static final int DESTROYER = 3;
    private static final int SUBMARINE = 3;
    private static final int PATROL = 2;
    static char water = '~';
    static char miss = '*';
    static char hit = 'X';
	
	int [][] board;
	int [] ships = new int[5];
	

public void setboard() {
	// setting the array size depending on the game difficulty
	board = new int[BOARD_SIZE][BOARD_SIZE];
	fillboard();
	ships[0] = AIRCRAFT_CARRIER;
	ships[1] = BATTLESHIP;
	ships[2] = DESTROYER;
	ships[3] = SUBMARINE;
	ships[4] = PATROL;
}

	
private void fillboard() {
	// initializing both the board and ship array to ~
	for(int i = 0; i < this.BOARD_SIZE; i++) {
		for (int j = 0; j < this.BOARD_SIZE; j++) {
			board[i][j] = -1;
		}
	}
	setShips();
}



public void printboard() {
	// printout for each turn indicating missiles left, ships still floating
	System.out.println("--------------------------------------------");
	System.out.printf("Board size is: %dx%d%n", this.BOARD_SIZE, this.BOARD_SIZE);
	System.out.println("Missiles Left: " + this.missilesleft);
	System.out.println("Ships Floating: " + this.shipsalive);
	
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
			if (board[i][j] == -1)
				System.out.printf("%2c", water);
			else if (board[i][j] == 0) 
				System.out.printf("%2c", miss);
			else if (board[i][j] == 1)
				System.out.printf("%2c", hit);
			System.out.print("|");
            }
            
    }
}

public void setShips() {
	for (int ship = 0; ship < ships.length; ship++) {
		Random rand = new Random();
		int direction = rand.nextInt(2)+1;
		int coordX;
		int coordY;
		coordX = rand.nextInt(this.BOARD_SIZE);
		coordY= rand.nextInt(this.BOARD_SIZE);
		int shiplength = ships[ship];
		
		if (board[coordX][coordY] != -1)
			continue;
		
			// Horizontal placement if direction = 1
		if (direction == 1) {
			if (shiplength + coordX > this.BOARD_SIZE)
				continue;
			for (int i = 0; i < shiplength; i++) {
				board[coordX + i][coordY] = -3;
				}
			}
					
			// Vertical placement if direction = 2
		else if (direction == 2) {
			if (shiplength + coordY > this.BOARD_SIZE)
				continue;
			for (int i = 0; i < shiplength; i++) {
				board[coordX][coordY + i] = -3;
				}	
			}
	}
}

// converting the initial column for printing to letters
public char getLetter(int i){
  return (char) (i + 64);
}


	
}





