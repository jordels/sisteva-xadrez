package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();

	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);

			}
		}
		return mat;
	}

	private void placenewPiece(char column, int row, ChessPiece piece) {

		board.placePiece(piece, new Chessposition(column, row).toPosition());

	}

	private void initialSetup() {
		placenewPiece('c', 1, new Rook(board, Color.WHITE));
		placenewPiece('c', 2, new Rook(board, Color.WHITE));
		placenewPiece('d', 2, new Rook(board, Color.WHITE));
		placenewPiece('e', 2, new Rook(board, Color.WHITE));
		placenewPiece('e', 1, new Rook(board, Color.WHITE));
		placenewPiece('d', 1, new King(board, Color.WHITE));

		placenewPiece('c', 7, new Rook(board, Color.BLACK));
		placenewPiece('c', 8, new Rook(board, Color.BLACK));
		placenewPiece('d', 7, new Rook(board, Color.BLACK));
		placenewPiece('e', 7, new Rook(board, Color.BLACK));
		placenewPiece('e', 8, new Rook(board, Color.BLACK));
		placenewPiece('d', 8, new King(board, Color.BLACK));
	}
}
