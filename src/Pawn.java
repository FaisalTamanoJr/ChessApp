public class Pawn extends ChessPiece {

	/** Constructor for the Pawn class */
	public Pawn(int initialRow, int initialCol, int pieceColor)
	{
		this.row = initialRow;
		this.col = initialCol;
		this.color = pieceColor;
	}	

	/** Method that returns a boolean indicating whether or not the pawn can legally move
	 *  to the specified location (you need to fill this one in).
	 */
	public boolean canMoveTo(int nextRow, int nextCol, ChessBoard board)
	{
		// Fill this in with your own code.
		return automagicPawnCanMoveTo(nextRow, nextCol, board);	// Eventually this line should not be here
	}

	/** Implementation of getType() method for the Pawn class. Provides a way to identify
	 *  the Pawn-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.PAWN;
	}
	
}
