package chess;

import boardgame.Board;
import boardgame.Piece;
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
	
	public ChessPiece performChessMove(Chessposition sourcePosition, Chessposition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target  = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturePiece = makeMove(source,target);
		return (ChessPiece) capturePiece;
	
				}
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
		
	}
	private void validateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new ChessException(" Thre is not piece on source position");
		}
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
