public class Rook {
    private int row;
    private int col;
    private boolean isBlack;

    public Rook(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        // the rook has 3 cases: vertical move, horizontal move, or neither which is an illegal move
        // after checking the source and destination squares, it is as simple as verifying horizontal
        if (board.verifySourceAndDestination(this.row,this.col,endRow,endCol,this.isBlack)) {
            // case 1: verifies horizontal move
            if (board.verifyHorizontal(this.row, this.col, endRow, endCol)) {
                return true;
            }
            //case 2: verifies vertical move
            else if (board.verifyVertical(this.row, this.col, endRow, endCol)) {
                return true;
            }
            // case 3: neither one, therefore false
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
