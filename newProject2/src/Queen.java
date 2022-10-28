public class Queen {
    private int row;
    private int col;
    private boolean isBlack;

    public Queen(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    // there are 4 total scenarios for the queen.  A legal vertical move, and legal horizontal move, a legal diagonal move, or an illegal move in general
    // we can cover these 4 scenarios using specific if statements
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifySourceAndDestination(this.row,this.col,endRow,endCol,this.isBlack)) {
            if (board.verifyDiagonal(this.row, this.col, endRow, endCol)) {
                return true;
            }
            else if (board.verifyHorizontal(this.row, this.col, endRow, endCol)) {
                return true;
            }
            else if (board.verifyVertical(this.row, this.col, endRow, endCol)) {
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
