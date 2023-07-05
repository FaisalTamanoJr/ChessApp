public class Queen extends ChessPiece {

	/** Constructor for the Queen class */
	public Queen(int initialRow, int initialCol, int pieceColor)
	{
		this.row = initialRow;
		this.col = initialCol;
		this.color = pieceColor;
	}	
	
	/** Method that returns a boolean indicating whether or not the queen can legally move
	 *  to the specified location (you need to fill this one in).
	 */
	public boolean canMoveTo(int nextRow, int nextCol, ChessBoard board)
	{
		int rowDif = nextRow-row;
		int colDif = nextCol-col;
		if (((nextRow != row) & (nextCol != col)) && !(Math.abs(rowDif) == Math.abs(colDif))){
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

		if ((nextRow == row) || (nextCol == col)){
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
		} else {
			if ((rowDif >= row) && (colDif >= col)) {
				int j = col + 1;
				for (int i = row + 1; i < nextRow; i++) {
					if (board.pieceAt(i, j) != null) {
						return false;
					}
					j++;
				}
			} else if ((rowDif >= row) && (colDif <= col)) {
				int j = col - 1;
				for (int i = row + 1; i < nextRow; i++) {
					if (board.pieceAt(i, j) != null) {
						return false;
					}
					j--;
				}
			} else if ((rowDif <= row) && (colDif >= col)) {
				int j = col + 1;
				for (int i = row - 1; i > nextRow; i--) {
					if (board.pieceAt(i, j) != null) {
						return false;
					}
					j++;
				}
			} else if ((rowDif <= row) && (colDif <= col)) {
				int j = col - 1;
				for (int i = row - 1; i > nextRow; i--) {
					if (board.pieceAt(i, j) != null) {
						return false;
					}
					j--;
				}
			} else {
				return true;    // Eventually this line should not be here
			}
		}
		return true;
	}

	/** Implementation of getType() method for the Pawn class. Provides a way to identify
	 *  the Pawn-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.QUEEN;
	}
	
}
