public class King extends ChessPiece {
	
	/** Constructor for the King class */
	public King(int initialRow, int initialCol, int pieceColor)
	{
		this.row = initialRow;
		this.col = initialCol;
		this.color = pieceColor;
	}	
	
	/** Method that returns a boolean indicating whether or not the king can legally move
	 *  to the specified location (you need to fill this one in).
	 */
	public boolean canMoveTo(int nextRow, int nextCol, ChessBoard board)
	{
		if (moveWouldCauseCheck(nextRow, nextCol, board)){
			return false;
		}
		else {
			if (board.pieceAt(nextRow,nextCol) != null){
				if (board.pieceAt(nextRow,nextCol).getColor() == board.pieceAt(row,col).getColor()){
					return false;
				}
			}
			else
			{
				if ((nextRow == row+1) || (nextRow == row-1) || (nextRow == row)){
					return ((nextCol == col + 1) || (nextCol == col - 1) || (nextCol == col));
				}
			}
		}

		return false;
	}
	
	/** Implementation of getType() method for the King class. Provides a way to identify
	 *  the King-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.KING;
	}
	
}
