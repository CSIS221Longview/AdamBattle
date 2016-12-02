package battleship;

import java.util.Random;
import java.util.Scanner;

public class gameboard {
	Scanner kb = new Scanner(System.in);
	Random r = new Random();
	
	int board[][]; // creating a 2d int array for printing of the game board
	shipInfo[] ships = new shipInfo[5]; // creating an array of 5 for the 5 ships
	protected int BOARD_SIZE;
	protected int missiles;
	protected int shipsAlive = 5;
	protected int difficulty;

	
	// getting difficulty settings from the player
	protected void setDiff() {
		
		System.out.println("You have three difficulties to choose from");
		System.out.println("   LEVEL        BOARD SIZE        MISSLES");
		System.out.println("1. Beginner        6x6               30   ");
		System.out.println("2. Standard        9x9               50   ");
		System.out.println("3. Advanced       12x12              75   ");
		
		System.out.print("Select your board size by entering the number 1, 2, or 3:  ");
		// this will determine if the user entered anything other than an integer number
		while (!kb.hasNextInt()) {
			System.out.println("\nMake sure you are entering a NUMBER!\n");
			System.out.print("Select your board size by entering the number 1, 2, or 3:  ");
			kb.next();
		}
		difficulty = kb.nextInt();
		// if they entered a value other than 1, 2, or 3 for the game difficulty, execute the while loop
		while(difficulty != 1 && difficulty != 2 && difficulty != 3) {
			System.out.println("\nYou have entered an invalid difficulty entry\n");
			System.out.print("Select your board size by entering the number 1, 2, or 3:  ");
			difficulty = kb.nextInt();	
		}
		
		// If they chose 1 = BEGINNER difficulty
		if (difficulty == 1) {
			System.out.print("\nYou have chosen beginner. What a scrub!");
			BOARD_SIZE = 6; // board size will be 6x6
			missiles = 30; // they get 30 missiles
		}
		// If they chose 2 = STANDARD difficulty
		else if (difficulty == 2) {
			System.out.print("\nYou have chosen standard. Just a mediocre life.");
			BOARD_SIZE = 9; // board size will be 9x9
			missiles = 50; // they get 50 missiles
		}
		// If they chose 3 = ADVANCED DIFFICULTY	
		else if (difficulty == 3) {
			System.out.print("\nYou have chosen advanced. You must be confident!");
			BOARD_SIZE = 12; // board size will be 12x12
			missiles = 75; // they get 75 missiles
		}
		setBoardSize(); // call setBoardSize() method below to create the 2d int array based on the difficulty the player chose
		fillBoard(); // call fillBoard() method below to initialize the 2d array
		System.out.printf("%nGameboard is set to %dx%d%n", getBoardSize(), getBoardSize());
	}
	
	// return the size of the board
	protected int getBoardSize() {
		return BOARD_SIZE;
	}
	
	protected int getMissiles() {
		return missiles;
	}
	
	protected int useMissiles() {
		return missiles--;
	}
	
	protected int getDifficulty() {
		return difficulty;
	}

	// setting the board size to what the player wanted, 6, 9 or 12
	private void setBoardSize() {
		board = new int[BOARD_SIZE][BOARD_SIZE];
	}
	
	// initializing the whole board to -1
	private void fillBoard() {
		// initializing the board array to -1
		// -1 will equal empty space, aka water on the battleship board
		for(int i = 0; i < getBoardSize(); i++) {
			for (int j = 0; j < getBoardSize(); j++) {
				board[i][j] = -1;
			}
		}
	}
	
	// printing of the board
	protected void printBoard() {
		final char water = '~'; // This will allow all -1 values (water) to output as ~
		final char miss = '*'; // This will allow all 0 values (miss) to output as *
		final char hit = 'X';	// This will allow all 1 values (hit) to output as X
		
		
		
		System.out.println("\n----------------------------------------");

		System.out.printf("You have %d missiles left%n", getMissiles());
		System.out.printf("There are %d ship(s) still alive%n", shipsAlive);

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
				//
				
				System.out.print("|");
			}
		}
	}
	
	
	protected class shipInfo {
		public String name = "";
		public String icon = "";
		public int size = 0;
	}
	
	protected void createShips() {
		ships[0] = new shipInfo();
		ships[1] = new shipInfo();
		ships[2] = new shipInfo();
		ships[3] = new shipInfo();
		ships[4] = new shipInfo();
		
		ships[0].name = "USS Enterprise";
		ships[1].name = "USS Iowa";
		ships[2].name = "USS Arlington";
		ships[3].name = "USS Alexandria";
		ships[4].name = "USS Flagstaff";
		
		ships[0].size = 5; // Aircraft Carrier is 5 spaces long
		ships[1].size = 4; // Battleship is 4 spaces long
		ships[2].size = 4; // Destroyer is 4 spaces long
		ships[3].size = 3; // Submarine is 3 spaces long
		ships[4].size = 2; // Patrol Boat is 2 spaces long
		
		// THE FOLLOWING WILL BE COMMENTED OUT FOR FINAL GAME
		// Uncomment the ships[].icon if you want to see the icons print with the board game (for cheating)
		ships[0].icon = "A"; // A for Aircraft Carrier
		ships[1].icon = "B"; // B for Battleship
		ships[2].icon = "D"; // D for Destroyer
		ships[3].icon = "S"; // S for Submarine
		ships[4].icon = "P"; // P for Patrol Boat

	}
	
	protected void placeShips() {
		createShips(); // when placeShip() is called in actiongame.java, createShips() will execute and create the ships for the board
		int size = getBoardSize();	 // assigning the board size to an int value for easier output
		int shipIcon = -3; // initializing a value to -3 for placement of ships. A counter for -- is at the end of the placeShips() method which will subtract a number
		
		// The for loop will execute 5 times, the ships[] array is 5 elements long
		for (int i = 0; i < ships.length; i++) {
			// initialize a boolean value to false for determing if the ship is placed on the board
			boolean shipPlaced = false;
		// since the boolean value is set to false, the following code will execute UNTIL the ship is placed on the board, then it will move to the next iteration of the for loop
		while (!shipPlaced) {
			// create a boolean value for determining directional placement of the ship and randomize between true and false
			// TRUE WILL BE HORIZONTAL
			// FALSE WILL BE VERTICAL
			boolean placeHorizontal = r.nextBoolean();
			// create and randomize two int values based on the size of the gameboard (6, 9 or 12), these two values will be passed to the board[][] array
			// to determine the starting point of the ship placement
			int row = r.nextInt(size);
			int col = r.nextInt(size);
			
			// if the randomized values land on anything BUT -1 (empty space, water), restart the while (!shipPlaced) loop
			if (board[row][col] != -1)
				continue;

			// if the boolean value randomized to true, execute the next code
			if (placeHorizontal) { // HORIZONTAL PLACEMENT
				// if the randomized value for row PLUS the ships size is greater than the length of the board
				// continue to the back of the while loop and start again
				if (row + ships[i].size > size) {
					continue;
				}
				// if there is enough space to place the ship on the board and not go OFF, the next code will execute
				else {
					// initialize spaceFree boolean to true, spaceFree will determine if there is another ship in the way of placement
					// if there is another ship in the way, the code will restart at the top of the while loop and try again
					boolean spaceFree = true;
					// for loop will run for the length of the ship (example 5 times for the aircraft carrier)
					for (int j = 0; j < ships[i].size; j++) {
						// testing if each randomized row + 1 and col are equal to -1 (empty space, water)
						if (board[row+j][col] != -1) {
							spaceFree = false;
						}
					}
					

			    if (!spaceFree)
			      continue; // if the previous for loop determined there is a ship in the way, restart the while loop and try again
			    
			 // The code will only get to this point if the ship will not go off the board AND there is not another ship in the way of current ship
			 // The following code places the ship on the board
			    for (int j = 0; j < ships[i].size; j++) {
			    	// shipIcon was initialized to -3 (aircraft carrier), and a -- counter will subtract to -4 then -5 and so on to change the value of that
			    	// position to match that of the ship
					board[row + j][col] = shipIcon;
				}
			    // since the ship passed all tests and was finally placed, change shipPlaced to true so the code moves to the next iteration of the for loop to place the next ship
			    shipPlaced = true;
			  } 
			}
			
			// if the boolean value for placeHorizontal is anything but true (false) then the following block of code will execute
			else { // VERTICALLY	   
				// code executes the exact same as the placeHorizontal, except it tests for vertical values instead of horizontal ones
				if (col + ships[i].size > size) {
					continue;
				}

				else {
					boolean spaceFree = true;

			    for (int j = 0; j < ships[i].size; j++) {
			      if (board[row][col+j] != -1)
			      spaceFree = false;
			    }

			    if (!spaceFree)
			      continue; 


				for (int j = 0; j < ships[i].size; j++) {	
					board[row][col + j] = shipIcon;
				}
			  
			    shipPlaced = true;
				}
			  }
			}
		// shipIcon starts at -3, assigns the number to that specific board[row][column] per ship, then subtracts to -4 for the next
		// iteration of the for loop
		// -3 = AIRCRAFT_CARRIER
		// -4 = BATTLESHIP
		// -5 = DESTROYER
		// -6 = SUBMARINE
		// -7 = PATROL BOAT
		shipIcon--;
		}	
	
	}
		
	protected void gameOverWin() {
		System.out.println("\n\n");
		System.out.println("Congratulations! You have sunk all the enemy ships.");
		System.out.println("----------------------------------------------------");
		System.out.println("|                                                  |");
		System.out.println("|                   YOU WIN!!                      |");
		System.out.println("|                                                  |");
		System.out.println("----------------------------------------------------");
		
	}
	
	protected void gameOverLoss() {
		System.out.println("\n\n");

		System.out.println("----------------------------------------------------");
		System.out.println("|                                                  |");
		System.out.println("|                   YOU LOSE!!                     |");
		System.out.println("|                     HA HA                        |");
		System.out.println("----------------------------------------------------");
	}
	
		
	// converts the numbers to letters (for the first column going down)
	private char getLetter(int i){
		  return (char) (i + 64);
		}
	
	protected static void getLogo() {
		System.out.println("----------------------------------------------------");
		System.out.println("|                                                  |");
		System.out.println("|             WELCOME TO BATTLESHIP                |");
		System.out.println("|                   WITH JAVA!                     |");
		System.out.println("|                                                  |");
		System.out.println("----------------------------------------------------");
	
		
	}
	
	
}





