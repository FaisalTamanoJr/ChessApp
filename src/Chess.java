/*
 * Name: Faisal Tamano Jr.
 * Section: EQ3
 * File: Chess.java
 * ------------------
 * This program plays the game Chess.
 */

import java.awt.Color;
import java.awt.event.*;

/** The main class responsible for managing the chess game */
public class Chess extends GraphicsProgram{

	/** Object responsible for handling the graphical display on the screen */
	ChessDisplay display;
	
	/** Object that keeps track of the locations of all pieces */
	ChessBoard board;

	/** Method called before run responsible for initializing the ChessDisplay and 
	 *  ChessBoard objects */
	public void init()
	{
		display = ChessDisplay.getInstance(this);			// This line is required, don't change it
		board = new ChessBoard();
		startGame();

		display.useRealChessLabels(false);			// Use this method to change how the board is labeled
															// on the screen. Passing in true will label the board
															// like an official chessboard; passing in false will
															// label the board like it is indexed in an array and
															// in ChessDisplay.
	}
	
	/** The main method that runs the program */
	public void run()
	{
		// You fill this in.
		display.draw(board);
	}

	/** The method that arranges the piece to the starting positions*/
	private void startGame(){
		// Add the black pieces
		Rook blackRookL = new Rook(0, 0, ChessPiece.BLACK);
		Knight blackKnightL = new Knight(0, 1, ChessPiece.BLACK);
		Bishop blackBishopL = new Bishop(0, 2, ChessPiece.BLACK);
		Queen blackQueen = new Queen(0, 3, ChessPiece.BLACK);
		King blackKing = new King(0, 4, ChessPiece.BLACK);
		Bishop blackBishopR = new Bishop(0, 5, ChessPiece.BLACK);
		Knight blackKnightR = new Knight(0, 6, ChessPiece.BLACK);
		Rook blackRookR = new Rook(0, 7, ChessPiece.BLACK);
		board.addPiece(blackRookL);
		board.addPiece(blackKnightL);
		board.addPiece(blackBishopL);
		board.addPiece(blackKing);
		board.addPiece(blackQueen);
		board.addPiece(blackBishopR);
		board.addPiece(blackKnightR);
		board.addPiece(blackRookR);
		board.addPiece(new Pawn(1,0,ChessPiece.BLACK));
		board.addPiece(new Pawn(1,1,ChessPiece.BLACK));
		board.addPiece(new Pawn(1,2,ChessPiece.BLACK));
		board.addPiece(new Pawn(1,3,ChessPiece.BLACK));
		board.addPiece(new Pawn(1,4,ChessPiece.BLACK));
		board.addPiece(new Pawn(1,5,ChessPiece.BLACK));
		board.addPiece(new Pawn(1,6,ChessPiece.BLACK));
		board.addPiece(new Pawn(1,7,ChessPiece.BLACK));

		// Add the white pieces
		Rook whiteRookL = new Rook(7, 0, ChessPiece.WHITE);
		Knight whiteKnightL = new Knight(7, 1, ChessPiece.WHITE);
		Bishop whiteBishopL = new Bishop(7, 2, ChessPiece.WHITE);
		Queen whiteQueen = new Queen(7, 3, ChessPiece.WHITE);
		King whiteKing = new King(7, 4, ChessPiece.WHITE);
		Bishop whiteBishopR = new Bishop(7, 5, ChessPiece.WHITE);
		Knight whiteKnightR = new Knight(7, 6, ChessPiece.WHITE);
		Rook whiteRookR = new Rook(7, 7, ChessPiece.WHITE);
		board.addPiece(whiteRookL);
		board.addPiece(whiteKnightL);
		board.addPiece(whiteBishopL);
		board.addPiece(whiteKing);
		board.addPiece(whiteQueen);
		board.addPiece(whiteBishopR);
		board.addPiece(whiteKnightR);
		board.addPiece(whiteRookR);
		board.addPiece(new Pawn(6,0,ChessPiece.WHITE));
		board.addPiece(new Pawn(6,1,ChessPiece.WHITE));
		board.addPiece(new Pawn(6,2,ChessPiece.WHITE));
		board.addPiece(new Pawn(6,3,ChessPiece.WHITE));
		board.addPiece(new Pawn(6,4,ChessPiece.WHITE));
		board.addPiece(new Pawn(6,5,ChessPiece.WHITE));
		board.addPiece(new Pawn(6,6,ChessPiece.WHITE));
		board.addPiece(new Pawn(6,7,ChessPiece.WHITE));
	}
}

