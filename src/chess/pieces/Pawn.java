package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public abstract class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);

	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);
		
		if (getColor() == Color.WHITE) {
			
			p.setValues(((Position) position).getRow() - 1, ((Position) position).getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;

			}
			p.setValues(((Position) position).getRow() - 2, ((Position) position).getColumn());
			Position p2 = new Position(getRow()-1,((Position) position).getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p2)&& !getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)&& getMoveCount()==0) {
				mat[p.getRow()][p.getColumn()] = true;
				
			}
			p.setValues(((Position) position).getRow() - 1, ((Position) position).getColumn()-1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;

			}
			p.setValues(((Position) position).getRow() - 1, ((Position) position).getColumn()+1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;

			}

		}
		else {
			p.setValues(((Position) position).getRow() + 1, ((Position) position).getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;

			}
			p.setValues(((Position) position).getRow() + 1, ((Position) position).getColumn());
			Position p2 = new Position(getRow()+1,((Position) position).getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p2)&& !getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)&& getMoveCount()==0) {
				mat[p.getRow()][p.getColumn()] = true;
				
			}
			p.setValues(((Position) position).getRow()+1, ((Position) position).getColumn()-1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;

			}
			p.setValues(((Position) position).getRow() + 1, ((Position) position).getColumn()+1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;

			}
		}

		return null;
	}

	private int getRow() {
		
		return "p";
	}

}
