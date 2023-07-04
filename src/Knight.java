public class Knight extends ChessPiece {

	/** Constructor for the Knight class */
	public Knight(int initialRow, int initialCol, int pieceColor)
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
		// If the space at (row,col) is two spaces in one direction and
		// one space in the other direction from (this.row, this.col)
		if ((nextRow == row+2) || (nextRow == row-2)){
			if ((nextCol == col+1) || (nextCol == col-1)){
				if (board.pieceAt(nextRow, nextCol) != null) {
					// If the space at (row,col) is occupied by a piece with the
					// same color as this.color
					if (board.pieceAt(nextRow, nextCol).getColor() == board.pieceAt(row, col).getColor()) {
						return false;
					}
				}
				// Check to see whether or not this move would cause the
				// player to move him/herself into check using
				// moveWouldCauseCheck
				if (moveWouldCauseCheck(nextRow, nextCol, board)){
					return false;
				}
				return true;
			}
			return false;
		}
		else if ((nextRow == row+1) || (nextRow == row-1)){
			if ((nextCol == col+2) || (nextCol == col-2)){
				if (board.pieceAt(nextRow, nextCol) != null) {
					// If the space at (row,col) is occupied by a piece with the
					// same color as this.color
					if (board.pieceAt(nextRow, nextCol).getColor() == board.pieceAt(row, col).getColor()) {
						return false;
					}
				}
				// Check to see whether or not this move would cause the
				// player to move him/herself into check using
				// moveWouldCauseCheck
				else if (moveWouldCauseCheck(nextRow, nextCol, board)){
					return false;
				}
				return true;
			}
			return false;
		}
		return false;
	}
	
	/** Implementation of getType() method for the Knight class. Provides a way to identify
	 *  the Knight-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.KNIGHT;
	}
	
}
