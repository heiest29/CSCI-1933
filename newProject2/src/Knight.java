public class Knight {
    private int row;
    private int col;
    private boolean isBlack;

    public Knight(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        // the first case for the knight is that the move is a legal knight move (see knight move function in board)
        // within this case the target square will be checked for an ally or enemy piece using verifySourceAndDestination
        if (board.verifySourceAndDestination(this.row,this.col,endRow,endCol,this.isBlack)) {
            // case 1: determines if a given move is a legal knight move or not
            if (board.verifyKnightMove(this.row, this.col, endRow, endCol)) {
                return true;
            }
            // case 2 is that the move is not a legal knight move and therefore returns false
            else {
                return false;
            }
        }
        // if verifySourceAndDestination does not resolve to true, then it is an illegal move
        else {
            return false;
        }
    }
}
