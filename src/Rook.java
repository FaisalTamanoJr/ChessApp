public class Rook extends ChessPiece {

	/** Constructor for the Rook class */
	public Rook(int initialRow, int initialCol, int pieceColor)
	{
		this.row = initialRow;
		this.col = initialCol;
		this.color = pieceColor;
	}	

	/** Method that returns a boolean indicating whether or not the bishop can legally move
	 *  to the specified location (you need to fill this one in).
	 */
	public boolean canMoveTo(int nextRow, int nextCol, ChessBoard board)
	{
		// Fill this in with your own code.
		return automagicRookCanMoveTo(nextRow, nextCol, board);	// Eventually this line should not be here
	}

	/** Implementation of getType() method for the Rook class. Provides a way to identify
	 *  the Rook-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.ROOK;
	}

}
