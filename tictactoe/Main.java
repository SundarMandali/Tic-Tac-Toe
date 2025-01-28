package tictactoe;

public class Main {

	public static void main(String[] args) {
		System.out.println("*** Welcome to TIC-TOE GAME ***");
		TicTacToeGame ticTacToeGame=new TicTacToeGame();
		ticTacToeGame.initialize();
		
		System.out.println("And the winner is "+ticTacToeGame.start());
	}

}
