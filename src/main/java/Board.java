package CSC305;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Tic-Tac-Toe board and provides methods to manipulate and query its state.
 *
 * @author javiergs
 * @version 1.0
 */
public class Board {
	
	public static final char HUMAN_MARK = 'X';
	public static final char COMPUTER_MARK = 'O';
	public static final char EMPTY = ' ';
	
	private final char[] cells = new char[9];
	
	
	public Board() {
		for (int i = 0; i < 9; i++) cells[i] = EMPTY;
	}
	
	public boolean isEmpty(int pos1to9) {
		int i = pos1to9 - 1;
		return i >= 0 && i < 9 && cells[i] == EMPTY;
	}
	
	public boolean place(int pos1to9, char mark) {
		int i = pos1to9 - 1;
		if (i < 0 || i >= 9 || cells[i] != EMPTY) return false;
		cells[i] = mark;
		return true;
	}
	
	public char get(int pos1to9) {
		return cells[pos1to9 - 1];
	}
	
	public boolean isFull() {
		for (char c : cells) if (c == EMPTY) return false;
		return true;
	}
	
	public boolean hasWinner(char mark) {
		int[][] lines = {
			{1,2,3},{4,5,6},{7,8,9},
			{1,4,7},{2,5,8},{3,6,9},
			{1,5,9},{3,5,7}
		};
		for (int[] L : lines) {
			if (get(L[0]) == mark && get(L[1]) == mark && get(L[2]) == mark) return true;
		}
		return false;
	}
	
	public List<Integer> getAvailableMoves() {
		List<Integer> moves = new ArrayList<>();
		for (int i = 0; i < 9; i++) if (cells[i] == EMPTY) moves.add(i + 1);
		return moves;
	}
	
	public boolean gameOver() { return isFull(); }

}

