public class Bishop extends ChessPiece {

	/** Constructor for the Bishop class */
	public Bishop(int initialRow, int initialCol, int pieceColor)
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
		if (moveWouldCauseCheck(nextRow, nextCol, board)){
			return false;
		}

		if (board.pieceAt(nextRow,nextCol) != null){
			if (board.pieceAt(nextRow,nextCol).getColor() == board.pieceAt(row,col).getColor()){
				return false;
			}
		}

		int rowDif = nextRow-row;
		int colDif = nextCol-col;
		if (!(Math.abs(rowDif) == Math.abs(colDif))){
			return false;
		}

		if ((rowDif >= row) && (colDif >= col)){
			int j = col+1;
			for (int i = row+1; i < nextRow; i++){
				if (board.pieceAt(i, j) != null) {
					return false;
				}
				j++;
			}
		} else if ((rowDif >= row) && (colDif <= col)){
			int j = col-1;
			for (int i = row+1; i < nextRow; i++){
				if (board.pieceAt(i,j) != null) {
					return false;
				}
				j--;
			}
		} else if ((rowDif <= row) && (colDif >= col)){
			int j = col+1;
			for (int i = row-1; i > nextRow; i--){
				if (board.pieceAt(i, j) != null) {
					return false;
				}
				j++;
			}
		} else if ((rowDif <= row) && (colDif <= col)){
			int j = col-1;
			for (int i = row-1; i > nextRow; i--){
				if (board.pieceAt(i, j) != null) {
					return false;
				}
				j--;
			}
		}

		return true;
	}
	
	/** Implementation of getType() method for the Bishop class. Provides a way to identify
	 *  the Bishop-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.BISHOP;
	}
}
