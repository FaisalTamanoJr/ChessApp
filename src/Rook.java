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
		if ((nextRow != row) & (nextCol != col)){
			return false;
		}
		else if (moveWouldCauseCheck(nextRow, nextCol, board)){
			return false;
		}

		if (board.pieceAt(nextRow,nextCol) != null){
			if (board.pieceAt(nextRow,nextCol).getColor() == board.pieceAt(row,col).getColor()){
				return false;
			}
		}


		if (nextRow > row) {
			for (int i = row+1; i < nextRow; i++) {
				if (board.pieceAt(i, nextCol) != null) {
					return false;
				}
			}
		}
		else{
			for (int i = row-1; i > nextRow; i--) {
				if (board.pieceAt(i, nextCol) != null) {
					return false;
				}
			}
		}
		if (nextCol > col) {
			for (int i = col+1; i < nextCol; i++) {
				if (board.pieceAt(nextRow, i) != null) {
					return false;
				}
			}
		}
		else{
			for (int i = col-1; i > nextCol; i--) {
				if (board.pieceAt(nextRow, i) != null) {
					return false;
				}
			}
		}

		return true;
	}

	/** Implementation of getType() method for the Rook class. Provides a way to identify
	 *  the Rook-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.ROOK;
	}

}
