package aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Chessposition;

public class programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		while (true) {
			try {
			UI.clearScreen();
			UI.printMatch(chessMatch);
			System.out.println();
			System.out.println("source:");
			Chessposition source = UI.readChessposition(sc);
			
			boolean [][]possibleMoves = chessMatch.possibleMoves(source); 
			UI.clearScreen();
			UI.printBoard(chessMatch.getPieces(),possibleMoves);
             
			System.out.println();
			System.out.println("target: ");
			Chessposition target = UI.readChessposition(sc);

			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}

	}

}
