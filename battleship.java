package battleship;


public class battleship {
	public static void main(String[] args) {
		// creating a new object of actiongame.java
	actiongame action = new actiongame(); 
	
	gameboard.getLogo(); // get the gameboard logo
	action.startGame(); // call actiongame.java and start the game
	action.playGame(); // call actiongame.java and play the game
	}
	
}



