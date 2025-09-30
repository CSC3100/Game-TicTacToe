package CSC305;

/**
 * CSC305.Player class for a Tic-Tac-Toe game.
 * Handles human player moves and input validation.
 *
 * @author javiergs
 * @version 1.0
 */
public class Player {

	private final Board board;
	
	public Player(Board board) {
		this.board = board;
	}
	
	public boolean move(View view) {
		int pos = view.askForNextMove(Board.HUMAN_MARK);
		return moveTo(pos);
	}
	
	private boolean moveTo (int pos1to9) {
		if (pos1to9 < 1 || pos1to9 > 9)
			return false;
		if (!board.isEmpty(pos1to9))
			return false;
		board.place(pos1to9, Board.HUMAN_MARK);
		return true;
	}
	
}

