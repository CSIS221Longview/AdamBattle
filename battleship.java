package battleship;


public class battleship {
	public static void main(String[] args) {
	actiongame action = new actiongame();
	
	getLogo();
	action.startGame();
	}
	
	
	
	
	
	
	
	public static void getLogo() {
		System.out.println("----------------------------------------------------");
		System.out.println("|                                                  |");
		System.out.println("|             WELCOME TO BATTLESHIP                |");
		System.out.println("|                   WITH JAVA!                     |");
		System.out.println("|                                                  |");
		System.out.println("----------------------------------------------------");
	
		
	}
	
	
}



