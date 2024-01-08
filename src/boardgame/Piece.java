package boardgame;

import javax.swing.text.Position;

public class Piece {
	
	protected Position position;
	private Board board;
	public Piece(Board board) {
		this.board = board;
		position = null;
	}
	public Board getBoard() {
		return board;
	}
	

}
