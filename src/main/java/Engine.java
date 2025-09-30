package CSC305;

import java.util.List;

/**
 * Implements move selection for the computer player.
 *
 * @author javiergs
 * @version 1.0
 */
public class Engine {
	
	private final Board board;
	
	public Engine(Board board) {
		this.board = board;
	}
	
	public int move() {
		if (board.gameOver()) return -1;
		int pos = chooseMove();
		board.place(pos, Board.COMPUTER_MARK);
		return pos;
	}
	
	private int chooseMove() {
		Integer win   = findFinishingMove(Board.COMPUTER_MARK);
		if (win != null) return win;
		Integer block = findFinishingMove(Board.HUMAN_MARK);
		if (block != null) return block;
		if (board.isEmpty(5)) return 5;
		for (int c : new int[]{1,3,7,9}) if (board.isEmpty(c)) return c;
		for (int s : new int[]{2,4,6,8}) if (board.isEmpty(s)) return s;
		List<Integer> moves = board.getAvailableMoves();
		return moves.isEmpty() ? 5 : moves.get(0);
	}
	
	private Integer findFinishingMove(char mark) {
		for (int pos : board.getAvailableMoves()) {
			if (wouldBeWin(mark, pos)) return pos;
		}
		return null;
	}
	
	private boolean wouldBeWin(char mark, int pos1to9) {
		int[][] lines = {
			{1,2,3},{4,5,6},{7,8,9},
			{1,4,7},{2,5,8},{3,6,9},
			{1,5,9},{3,5,7}
		};
		for (int[] L : lines) {
			char a = (L[0]==pos1to9)?mark:board.get(L[0]);
			char b = (L[1]==pos1to9)?mark:board.get(L[1]);
			char c = (L[2]==pos1to9)?mark:board.get(L[2]);
			if (a==mark && b==mark && c==mark) return true;
		}
		return false;
	}

}

