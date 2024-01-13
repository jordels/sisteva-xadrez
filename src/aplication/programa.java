package aplication;


import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.Chessposition;
public class programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		while (true) {
		UI.printBoard(chessMatch.getPieces());
		System.out.println();
		System.out.println("source:");
		Chessposition source = UI.readChessposition(sc);
		
		System.out.println();
		System.out.println("target: ");
		Chessposition target = UI.readChessposition(sc);
		
		ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
		
		
		
		}
		

	}

}
