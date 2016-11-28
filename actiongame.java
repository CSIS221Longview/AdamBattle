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
}
