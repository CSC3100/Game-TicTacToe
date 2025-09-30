package CSC305;

/**
 * Orchestrates the game flow for a console-based Tic-Tac-Toe game.
 * Initializes the board, engine, and player, and manages turns until the game concludes.
 *
 * @author javiergs
 * @version 1.0
 */
public class Main {
	
	public static void main(String[] args) {
	
		View view = new View();
		
		Board board   = new Board  ();
		Engine engine = new Engine (board);
		Player player = new Player (board);
		
		view.showMessage("=== Tic-Tac-Toe ===");
		
		while (!board.gameOver()) {
			// 1. Human turn
			while (!player.move (view)) {
				view.showMessage("Invalid move, try again.");
			}
			// 2. Computer turn
			int pos = engine.move ();
			// 3. Show board and results
			view.showMessage("Computer placed an O in position " + pos);
			view.showBoard(board);
			if (board.hasWinner(Board.HUMAN_MARK))
				view.showMessage("You win! 🎉");
			else if (board.hasWinner(Board.COMPUTER_MARK))
				view.showMessage("Computer wins!");
			else if (board.isFull())
				view.showMessage("It's a draw!");
		}
		
		view.showMessage("Thanks for playing!");
	}
	
}

