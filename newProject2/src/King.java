public class King {
    private int row;
    private int col;
    private boolean isBlack;

    public King(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    // for the king, the only cases are a legal adjacent move, or a non-legal adjacent move which would be illegal
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        // for the king, he can only move to adjacent squares, so the steps are to verifySourceAndDestination,
        // and then to check if the move is a legal adjacent move
        if (board.verifySourceAndDestination(this.row,this.col,endRow,endCol,this.isBlack)) {
            //case 1 checks for legal adjacent move
            if (board.verifyAdjacent(this.row, this.col, endRow, endCol)) {
                return true;
            }
            // case 2 handles any move other than an adjacent move
            else {
                return false;
            }
        }
        // if source and destination does not resolve to true, then it is within reason that the move is illegal
        else {
            return false;
        }
    }
}
