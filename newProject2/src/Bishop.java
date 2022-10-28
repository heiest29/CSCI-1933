public class Bishop {
    private int row;
    private int col;
    private boolean isBlack;

    public Bishop(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        // there are two cases for the bishop: a legal diagonal move or a non-legal move
        // source and destination determines if there are valid pieces on the start and end rows and columns
        if (board.verifySourceAndDestination(this.row,this.col,endRow,endCol,this.isBlack)) {
            // checks to see if legal diagonal move or not returns true if it is
            if (board.verifyDiagonal(this.row, this.col, endRow, endCol)) {
                return true;
            }
            // if it is not a legal diagonal move, then it is an illegal move
            else {
                return false;
            }
        }
        // if source and destination do not resolve to true, then it is automatically an illegal move
        else {
            return false;
        }
    }
}
