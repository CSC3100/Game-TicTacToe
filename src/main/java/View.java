package CSC305;

import java.util.Scanner;

/**
 * Handles all user interactions: displays the board, messages, and prompts for moves.
 *
 * @author javiergs
 * @version 1.0
 */
public class View {

	private final Scanner in = new Scanner(System.in);
	
	public void showBoard(Board b) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 9; i++) {
			char c = b.get(i);
			sb.append(c == Board.EMPTY ? (char)('0' + i) : c);
			if (i % 3 != 0) sb.append(" | ");
			if (i % 3 == 0 && i < 9) sb.append("\n---------\n");
		}
		System.out.println("\n" + sb + "\n");
	}
	
	public void showMessage (String text) {
		System.out.println(text);
	}
	
	public int askForNextMove(char mark) {
		while (true) {
			System.out.print("CSC305.Player (" + mark + "), enter a move [1-9]: ");
			String s = in.nextLine().trim();
			try {
				int pos = Integer.parseInt(s);
				return pos;
			} catch (NumberFormatException ignored) {
				System.out.println("Please type a number from 1 to 9.");
			}
		}
	}
	
}

