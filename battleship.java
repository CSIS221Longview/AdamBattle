package battleship;


public class battleship {
	public static void main(String[] args) {
	actiongame action = new actiongame(); // creating a new object of actiongame.java
	
	gameboard.getLogo(); // get the gameboard logo
	action.startGame(); // call actiongame.java and start the game
	action.playGame(); // call actiongame.java and play the game
	}
	
}



