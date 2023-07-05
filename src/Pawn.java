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
		if (moveWouldCauseCheck(nextRow, nextCol, board)){
			return false;
		}

		if (board.pieceAt(nextRow,nextCol) != null){
			if (board.pieceAt(nextRow,nextCol).getColor() == board.pieceAt(row,col).getColor()){
				return false;
			}
		}

		if (board.pieceAt(row,col).getColor() == ChessPiece.WHITE){
			if ((nextRow == row-1) && (nextCol == col)){
				return true;
			}

			if (row == 6)
			{
				if ((nextRow == row-2) && (nextCol == col)){
					return true;
				}
				if ((nextRow == row-1) && (nextCol == col)){
					return true;
				}
			}

			if ((nextRow == row-1)){
				if ((nextCol == col-1) || (nextCol == col+1)){
					if (board.pieceAt(nextRow,nextCol) != null){
						if (board.pieceAt(nextRow,nextCol).getColor() == ChessPiece.BLACK){
							return true;
						}
					}
				}
			}
		}else{
			if ((nextRow == row+1) && (nextCol == col)){
				return true;
			}

			if (row == 1)
			{
				if ((nextRow == row+2) && (nextCol == col)){
					return true;
				}
				if ((nextRow == row+1) && (nextCol == col)){
					return true;
				}
			}

			if ((nextRow == row+1)){
				if ((nextCol == col-1) || (nextCol == col+1)){
					if (board.pieceAt(nextRow,nextCol) != null){
						if (board.pieceAt(nextRow,nextCol).getColor() == ChessPiece.WHITE){
							return true;
						}
					}
				}
			}

		}
		return false;
	}

	/** Implementation of getType() method for the Pawn class. Provides a way to identify
	 *  the Pawn-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.PAWN;
	}
	
}
