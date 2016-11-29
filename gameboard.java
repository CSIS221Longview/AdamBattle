package battleship;

import java.util.Random;
import java.util.Scanner;

public class gameboard {
	Scanner kb = new Scanner(System.in);
	Random r = new Random();
	
	int board[][];
	shipInfo[] ships = new shipInfo[5];
	private int BOARD_SIZE;
	private int missiles;
	public int shipsAlive = 5;

	
	// getting difficulty settings from the player
	public void setDiff() {
		int difficulty;
		System.out.println("You have three difficulties to choose from");
		System.out.println("   LEVEL        BOARD SIZE        MISSLES");
		System.out.println("1. Beginner        6x6               30   ");
		System.out.println("2. Standard        9x9               50   ");
		System.out.println("3. Advanced       12x12              75   ");
		
		System.out.print("Select your board size by entering the number 1, 2, or 3:  ");
		difficulty = kb.nextInt();

		while(difficulty != 1 && difficulty != 2 && difficulty != 3) {
			System.out.println("\nYou have entered an invalid difficulty entry\n");
			System.out.print("Select your board size by entering the number 1, 2, or 3:  ");
			difficulty = kb.nextInt();	
		}
		
		if (difficulty == 1) {
			System.out.print("You have chosen beginner.");
			BOARD_SIZE = 6;
			missiles = 30; 
		}
		else if (difficulty == 2) {
			System.out.print("You have chosen standard.");
			BOARD_SIZE = 9;
			missiles = 50;
		}
			
		else if (difficulty == 3) {
			System.out.print("You have chosen advanced.");
			BOARD_SIZE = 12;
			missiles = 75;
		}
		setBoardSize();
		fillBoard();	
		
	}
	
	// return the size of the board
	private int getBoardSize() {
		return BOARD_SIZE;
	}
	
	private int getMissiles() {
		return missiles;
	}
	
	public int useMissiles() {
		return missiles--;
	}

	// setting the board size to what the player wanted, 6, 9 or 12
	private void setBoardSize() {
		board = new int[BOARD_SIZE][BOARD_SIZE];
	}
	
	// initializing the whole board to -1
	private void fillBoard() {
		// initializing both the board and ship array to -1
		for(int i = 0; i < getBoardSize(); i++) {
			for (int j = 0; j < getBoardSize(); j++) {
				board[i][j] = -1;
			}
		}
	}
	
	// printing of the board
	public void printBoard() {
		final char water = '~';
		final char miss = '*';
		final char hit = 'X';
		
		
		
		System.out.println("\n\n----------------------------------------");
		System.out.printf("Gameboard is set to %dx%d%n", getBoardSize(), getBoardSize());
		System.out.printf("You have %d missiles left%n", getMissiles());
		System.out.printf("You have %d ships still alive%n", shipsAlive);
		
		// print out empty space at top left of board
		System.out.print("\n  ");
		
		// print first column going right
		for (int i = 0; i < getBoardSize(); i++) {
			System.out.printf("%4d", i+1);	
		}
		
		// start of main loop for printing board
		for (int i = 0; i < getBoardSize(); i++) {
			System.out.print("\n");
			// printing of the letters for board legend
			System.out.printf("%3c", getLetter(i+1));
			
			for (int j = 0; j < getBoardSize(); j++) {
				if (board[i][j] == -1)
					System.out.printf("%3c", water);
				if (board[i][j] == 0)
					System.out.printf("%3c", miss);
				if (board[i][j] == 1)
					System.out.printf("%3c", hit);
					
				// 
				// FOR TEST PRINTING ONLY, WILL COMMENT OUT LATER
				//
				if (board[i][j] == -3)
					System.out.printf("%3s", ships[0].icon);
				if (board[i][j] == -4)
					System.out.printf("%3s", ships[1].icon);
				if (board[i][j] == -5)
					System.out.printf("%3s", ships[2].icon);
				if (board[i][j] == -6)
					System.out.printf("%3s", ships[3].icon);
				if (board[i][j] == -7)
					System.out.printf("%3s", ships[4].icon);

				
				System.out.print("|");
				getMissiles();
			}
		}
	}
	
	
	public class shipInfo {
		public String name = "";
		public String icon = "";
		public int size = 0;
		public int value = 0;
		
		public String getName() {
			return name;
		}
		
		public String getIcon() {
			return icon;
		}
		
		public int getSize() {
			return size;
		}
		
		public int getValue() {
			return value;
		}
	}
	
	public void createShips() {
		ships[0] = new shipInfo();
		ships[1] = new shipInfo();
		ships[2] = new shipInfo();
		ships[3] = new shipInfo();
		ships[4] = new shipInfo();
		
		ships[0].name = "USS Enterprise (Aircraft Carrier)";
		ships[1].name = "USS Iowa (Battleship)";
		ships[2].name = "USS Arlington (Destroyer)";
		ships[3].name = "USS Alexandria (Submarine)";
		ships[4].name = "USS Flagstaff (Patrol Boat)";
		
		ships[0].size = 5;
		ships[1].size = 4;
		ships[2].size = 4;
		ships[3].size = 3;
		ships[4].size = 2;
		
		ships[0].icon = "A";
		ships[1].icon = "B";
		ships[2].icon = "D";
		ships[3].icon = "S";
		ships[4].icon = "P";
		
		ships[0].value = -3;
		ships[1].value = -4;
		ships[2].value = -5;
		ships[3].value = -6;
		ships[4].value = -7;
	}
	
	public void placeShips() {
		createShips();
		int size = getBoardSize();	
		int shipIcon = -3;
		
		
		for (int i = 0; i < ships.length; i++) {	
			boolean shipPlaced = false;
		
		while (!shipPlaced) {
			boolean placeHorizontal = r.nextBoolean();
			int row = r.nextInt(size);
			int col = r.nextInt(size);
			
			if (board[row][col] != -1)
				continue;

			if (placeHorizontal) { // if ship was placed horizontal
				if (row + ships[i].size > size) {
					continue;
				}
				
				else {
					boolean spaceFree = true;
					for (int j = 0; j < ships[i].size; j++) {
						if (board[row+j][col] != -1) {
							spaceFree = false;
						}
					}
					

			    if (!spaceFree)
			      continue; // This will go to the next iteration of the while loop. (Generate a new position for the ship.)
			    
			 // Your code will only get to here if it can be placed here.
			 // place the ship at that location.
			    for (int j = 0; j < ships[i].size; j++) {
					board[row + j][col] = shipIcon;
				}
			    
			    shipPlaced = true;
			  } 
			}
			else { // If your ship was placed vertically.	    
				if (col + ships[i].size > size) {
					continue;
				}
				
				else {
					boolean spaceFree = true;
			    
			    for (int j = 0; j < ships[i].size; j++) {
			      if (board[row][col+j] != -1)
			      // if at any point there isn't free space then set spaceFree -> false
			      spaceFree = false;
			    }

			    if (!spaceFree)
			      continue; // This will go to the next iteration of your while loop. (Generate a new position for the ship.)

			    // The code will only get to here if the ship can be placed here.
				for (int j = 0; j < ships[i].size; j++) {	
					board[row][col + j] = shipIcon;
				}
			  
			    shipPlaced = true;
				}
			  }
			}
		// shipIcon starts at -3, assigns the number to that specific board[row][column] per ship
		// -3 = AIRCRAFT_CARRIER
		// -4 = BATTLESHIP
		// -5 = DESTROYER
		// -6 = SUBMARINE
		// -7 = PATROL BOAT
		shipIcon--;
		}	
	
	}
		
	
		
	// converts the numbers to letters (for the first column going down)
	public char getLetter(int i){
		  return (char) (i + 64);
		}
	
	
	
}





