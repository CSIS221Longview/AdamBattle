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
   
	
	int [][] board;
	int [] ships = new int[5];
	

public void setboard() {
	// setting the array size depending on the game difficulty
	board = new int[BOARD_SIZE][BOARD_SIZE];	
	ships[0] = AIRCRAFT_CARRIER;
	ships[1] = BATTLESHIP;
	ships[2] = DESTROYER;
	ships[3] = SUBMARINE;
	ships[4] = PATROL;
	fillboard();
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
	 char water = '~';
	 char miss = '*';
	 char hit = 'X';
	 char air_carrier = 'A';
	 char battleship = 'B';
	 char destroyer = 'D';
	 char sub = 'S';
	 char patrol = 'P';
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
			// the rest are just for testing purposes only, will remove once the program is done
			else if (board[i][j] == -3)
				System.out.printf("%2c", air_carrier);
			else if (board[i][j] == -4)
				System.out.printf("%2c", battleship);
			else if (board[i][j] == -5)
				System.out.printf("%2c", destroyer);
			else if (board[i][j] == -6)
				System.out.printf("%2c", sub);
			else if (board[i][j] == -7)
				System.out.printf("%2c", patrol);
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
		int shipChar = ship;
	
		if (board[coordX][coordY] != -1)
			continue;
		if (shiplength + coordX > this.BOARD_SIZE - 1)
			continue;
			// Horizontal placement if direction = 1
		if (direction == 1) {
			for (int i = 0; i < shiplength; i++) {
				// if else statement for setting the value of the ship for printing
				// -3 = aircraft carrier
				// -4 = battleship
				// -5 = destroyer
				// -6 = submarine
				// -7 = patrol boat
				if (shipChar == 0) 
					board[coordX + i][coordY] = -3;
				else if (shipChar == 1)
					board[coordX + i][coordY] = -4;
				else if (shipChar == 2)
					board[coordX + i][coordY] = -5;
				else if (shipChar == 3)
					board[coordX + i][coordY] = -6;
				else if (shipChar == 4)
					board[coordX + i][coordY] = -7;
				
			}
		}
			
		if (shiplength + coordY > this.BOARD_SIZE - 1)
			continue;
			// Vertical placement if direction = 2
		else if (direction == 2) {
			for (int i = 0; i < shiplength; i++) {
				// if else statement for setting the value of the ship for printing
				// -3 = aircraft carrier
				// -4 = battleship
				// -5 = destroyer
				// -6 = submarine
				// -7 = patrol boat
				if (shipChar == 0) 
					board[coordX][coordY + i] = -3;
				else if (shipChar == 1)
					board[coordX][coordY + i] = -4;
				else if (shipChar == 2)
					board[coordX][coordY + i] = -5;
				else if (shipChar == 3)
					board[coordX][coordY + i] = -6;
				else if (shipChar == 4)
					board[coordX][coordY + i] = -7;
				}
				}	
			}
		
	}


// converting the initial column for printing to letters
public char getLetter(int i){
  return (char) (i + 64);
}


	
}





