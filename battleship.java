package battleship;

import java.util.Scanner;

public class battleship {
	static gameboard board = new gameboard();
	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int gamediff = 0;
		
		 		
		gameLogo();
		gameRules();
				
		System.out.print("Select your board size by entering the number 1, 2, or 3:  ");
		gamediff = input.nextInt();
		
		while (gamediff != 1 && gamediff != 2 && gamediff != 3) {
			System.out.println("\nYou have entered an invalid difficulty entry\n");
			System.out.print("Select your board size by entering the number 1, 2, or 3:  ");
			gamediff = input.nextInt();			
		}
		switch (gamediff) {
		case 1: System.out.println("\nYou have chosen beginner. You must be scared.");
				board.BOARD_SIZE=6;
				break;
		case 2: System.out.println("\nYou have chosen Standard. Just average eh?");
				board.BOARD_SIZE=9;
				break;
		case 3: System.out.println("\nYou have chosen Advanced. You must be confident!");
				board.BOARD_SIZE=12;
		 		break;	
		}
		
		boolean gameover = false;
		do {
			board.printboard();
		} while (!gameover);
	
		input.close();

		
	}

	


	private static void gameLogo() {
	System.out.println("-----------------------------------------------------------------------------");
	System.out.println("| @@@@@@@@                                     @@@@@@@  @                   |");
	System.out.println("| @@    @@                                    @         @                   |");
	System.out.println("| @@    @@               @      @   @        @          @       @           |");
	System.out.println("| @@    @@               @      @   @       @           @                   |");
	System.out.println("| @@@@@@@@               @      @   @        @          @                   |");
	System.out.println("| @@@@@@@@@              @      @   @          @        @                   |");
	System.out.println("| @@     @@  @@@@@@@@  @@@@@  @@@@@ @ @@@@@     @@@     @@@@@@  @  @@@@@@@  |");
	System.out.println("| @@     @@  @      @    @      @   @ @             @   @    @  @  @     @  |");
	System.out.println("| @@     @@  @      @    @      @   @ @@@@           @  @    @  @  @     @  |");
	System.out.println("| @@     @@  @      @    @      @   @ @               @ @    @  @  @     @  |");
	System.out.println("| @@     @@  @      @    @      @   @ @              @  @    @  @  @     @  |");
	System.out.println("| @@@@@@@@@  @@@@@@@@@   @      @   @ @@@@@    @@@@@@   @    @  @  @@@@@@@  |");
	System.out.println("|                                                                  @        |");
	System.out.println("|                                                                  @        |");
	System.out.println("|                                                                  @        |");
	System.out.println("|                                                                  @        |");
	System.out.println("-----------------------------------------------------------------------------");	
	}
	
	private static void gameRules() {
	System.out.println("You have three difficulties to choose from");
	System.out.println("   LEVEL        BOARD SIZE        MISSLES");
	System.out.println("1. Beginner        6x6               30   ");
	System.out.println("2. Standard        9x9               50   ");
	System.out.println("3. Advanced       12x12              75   ");
		
	}
	


	
}




