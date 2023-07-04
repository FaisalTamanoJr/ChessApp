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

	/** Object used to tell which player's turn is it*/
	int chessTurn;

	boolean firstClick;

	ChessPiece selectedPiece;

	/** Method called before run responsible for initializing the ChessDisplay and 
	 *  ChessBoard objects */
	public void init()
	{
		display = ChessDisplay.getInstance(this);			// This line is required, don't change it
		board = new ChessBoard();

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
		startGame(); // Arrange to match the starting configuration
		this.chessTurn = ChessPiece.WHITE; // Player white is the first player
		this.firstClick = true;
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

	public void mousePressed(MouseEvent e){
		/* Translate mouse click location to chess board location  */
		int[] clickedLocation = display.getLocation(e.getX(), e.getY());
		ChessPiece clickedPiece = board.pieceAt(clickedLocation[0],clickedLocation[1]);
		if (firstClick){

			/* If(they click on a piece of their own color) */
			if (clickedPiece.getColor() == chessTurn){

				// Highlight spot where the player clicked with selectSquare
				display.selectSquare(clickedPiece.getRow(),
						clickedPiece.getCol(), Color.GREEN);

				// Store the piece at the location the user clicked so you
				// can move it on the next click
				selectedPiece = clickedPiece;
				this.firstClick = false;
				display.draw(board);
			}
		}else{
			/*
			 * Check to see if the piece selected on the previous click
			 * can move to the spot selected on this click with the
			 * canMoveTo method.
           	 */
			boolean allowedMove = selectedPiece.canMoveTo(clickedLocation[0],clickedLocation[1],board);

			/*
			 * If(the chosen piece can move to the selected spot AND the
			 * selected spot is not the spot the piece already occupies)
			 */
			if ((allowedMove) & ((clickedPiece.getRow() != selectedPiece.getRow()) & (clickedPiece.getCol() !=
					selectedPiece.getCol()))){

				// Remove the piece from the board
				board.removePiece(clickedPiece.getRow(),clickedPiece.getCol());

				// Update the ChessPiece’s location
				selectedPiece.moveTo(clickedPiece.getRow(), selectedPiece.getCol());

				// Add the updated ChessPiece back to the board addPiece
				board.addPiece(selectedPiece);

				// Clear all highlighted squares
				display.unselectAll();

				display.draw(board);

				// Check for Checkmates or Stalemates with isInCheckmate
				// or isinStalemate and print appropriate message
				if (isInCheck(board, chessTurn)){
					if (chessTurn == ChessPiece.WHITE){
						print("Black is in check");
					}else{
						print("White is in check");
					}
				}else if (isInStalemate(board, chessTurn)){
					print("Stalemate. Game Over");
				}

				// Advance to next player’s turn
				if (chessTurn == ChessPiece.WHITE){
					this.chessTurn = ChessPiece.BLACK;
				}else{
					this.chessTurn = ChessPiece.WHITE;
				}
			}else{
				// Clear all highlighted squares
				display.unselectAll();
				display.draw(board);
			}
			this.firstClick = true;
		}
	}
}
