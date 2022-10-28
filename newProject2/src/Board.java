import java.lang.Math;

public class Board {
    private Piece[][] board;

    // Set the new two-dimensional piece array to be of length and width 8 as described by a regular chess board
    public Board() {
        board = new Piece[8][8];
    }

    // Accessor Methods
    // Return the Piece object stored at a given row and column
    // They key here was to ensure that a given square was not null before attempting to access a piece there
    // If it happened to be null, there would be a null pointer if there didn't exist a piece at a location
    public Piece getPiece(int row, int col) {
        if ((row < 0) || (row > 7) || (col < 0) || (col > 7)) {
            return null;
        }
        else if (board[row][col] != null) {
            return board[row][col];
        }
        else {
            return null;
        }
    }
    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }
    // Game functionality methods
    // Checks if there is a piece and start row and start col, as well as if the desired move is legal, then moves the piece if that is the case
    // returns true if the move is made, and false otherwise
    // Move piece also ensures that the pieces location is updated after it moves... otherwise its position attributes will remain at its starting position
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        if (this.getPiece(startRow, startCol) != null && this.getPiece(startRow, startCol).isMoveLegal(this, endRow, endCol)) {
            this.setPiece(endRow, endCol, board[startRow][startCol]);
            this.getPiece(endRow, endCol).setPosition(endRow, endCol);
            board[startRow][startCol] = null;

            return true;
        } else {
            return false;
        }
    }
    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    // use getCharacter for this im the future
    // This was implemented by iterating through each square in the board and checking to see if the piece at that square is either null, or
    // of the same character representation of a white or black king
    public boolean isGameOver() {
        int kingCount = 0;
        for (int i=0; i<8; i++) {
            for (int j = 0; j<8; j++) {
                if (board[i][j] == null){
                    kingCount+=0;
                } else if(((board[i][j].getCharacter()=='\u2654')||(board[i][j].getCharacter()=='\u265a'))){
                    kingCount++;
                }
            }
        }
        if(kingCount<2){
            return true;
        } else {
            return false;
        }
    }

    // Construct a String that represents the Board object's 2D array. Return
    // the fully constructed String.
    // the toString method sets the board to be a bunch of pipes delimited by the \u2001 whitespace character
    public String toString() {
        String longAf = " \u2001 0\u20011\u20012\u20013\u20014\u20015\u20016\u20017\u2001\n";
        for (int i=0; i<8; i++) {
            longAf += i+"\u2001";
            for (int j=0; j<8; j++) {
                if (board[i][j] == null) {
                    longAf += "|\u2001";
                } else {
                    longAf += "|" + board[i][j].getCharacter();
                }
            }
            longAf += "|\n";
        }
        return longAf;
    }

    // Sets every cell of the array to null. For debugging and grading purposes.
    // goes through each of the squares in the board and sets the board at that location to null
    public void clear() {
        for (int i=0; i<8; i++) {
            for (int j = 0; j<8; j++) {
                board[i][j] = null;
            }
        }
    }

    // Movement helper functions
    // Ensure that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - 'start' contains a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - 'end' contains either no Piece or a Piece of the opposite color.
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        if (getPiece(startRow,startCol) == null){
            return false;
        } else if ((startRow>7) || (endRow>7) || (startCol>7) || (endCol>7) || (startRow<0) || (endRow<0) || (startCol<0) || (endCol<0)) {
            return false;
        } else if ((getPiece(startRow,startCol)!=null) && ((board[endRow][endCol]==null)||(board[endRow][endCol]!=null && board[endRow][endCol].getIsBlack()!=isBlack))) {
            // please note that the number of parenthesis in this conditional is extremely important to the success of the method
            // the use of the || can result in permanently true conditionals if care is not taken
            // accidentally made every move legal because I hadn't grouped the || statements correctly
            return true;
        } else {
            return false;
        }
    }

    // Ensures that a given move that a knight makes is a legal move
    // The knight does not need to worry about the piece in between it and its destination square.
    // therefore, all the function will compute is whether the destination square is of legal distance from the origin
    // I implemented this method on my own to make the Knight class easier to check isMoveLegal
    public boolean verifyKnightMove(int startRow, int startCol, int endRow, int endCol) {
        if (Math.abs(startRow-endRow)==1 && Math.abs(startCol-endCol)==2) {
            return true;
        }
        else if (Math.abs(startCol-endCol)==1 && Math.abs(startRow-endRow)==2) {
            return true;
        }
        else {
            return false;
        }
    }

    // Check whether the 'start' position and 'end' position are adjacent to each other
    // I do understand that his method could have been more efficiently broken up into sub conditional statements, but I wrote all possible king moves in one conditional
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        if ((endRow==startRow && endCol==startCol+1)||(endRow==startRow && endCol==startCol-1) ||(endRow==startRow-1 && endCol==startCol)||(endRow==startRow-1 && endCol==startCol-1)||(endRow==startRow-1 && endCol==startCol+1)||(endRow==startRow+1 && endCol==startCol-1)||(endRow==startRow+1 && endCol==startCol)||(endRow==startRow+1 && endCol==startCol+1)) {
            return true;
        } else {
            return false;
        }
    }

    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    // I could have used Math methods in this method, but I got carried away and just checked to see if startCol > endCol and vise versa
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        if (startRow==endRow) {
            if (startCol > endCol) {
                for (int i=endCol+1; i<startCol; i++){
                    if (board[startRow][i]!=null) {
                        return false;
                    }
                }
                return true;
            }
            else if (startCol < endCol) {
                for (int i=startCol+1; i<endCol; i++){
                    if (board[startRow][i]!=null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    // similarly to the above method, I just used startRow > endRow instead of math class methods
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        if (startCol==endCol){
            if (startRow > endRow) {
                for (int i=endRow+1; i<startRow; i++){
                    if (board[i][startCol]!=null) {
                        return false;
                    }
                }
                return true;
            }
            else if (startRow < endRow) {
                for (int i=startRow+1; i<endRow; i++){
                    if (board[i][startCol]!=null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        // The verifyDiagonal method can be broken down into a total of 5 cases: bottom left diagonal, bottom right, upper left, and upper right
        // all of these are checked based off of the difference between the start and end columns and rows.
        // 4 if statements represent the 4 possible diagonal directions
        // Additionally, there is an if statement that that checks if the absolute value of the difference of each row and column is the same
        // if it is not, it is not a legal diagonal and therefore the verifyDiagonal method would return false
        if (Math.abs(startRow-endRow)!=Math.abs(startCol-endCol)){
            return false;
            // this statement ^ just ensures that the absolute value of the change in row by the change in col was equal
            // if this weren't the case, it will automatically not be a legal diagonal
        } else if (endRow>startRow && endCol>startCol) {
            for(int i=startRow+1;i<endRow;i++){
                for(int j=startCol+1;j<endCol;j++){
                    if(this.board[i][j]!=null){
                        return false;
                    }
                }
            }
            return true;
        } else if (endRow>startRow && endCol<startCol) {
            for(int i=startRow+1;i<endRow;i++){
                for(int j=startCol-1;j<endCol;j--){
                    if(this.board[i][j]!=null){
                        return false;
                    }
                }
            }
            return true;
        } else if (endRow<startRow && endCol>startCol) {
            for(int i=startRow-1;i<endRow;i--){
                for(int j=startCol+1;j<endCol;j++){
                    if(this.board[i][j]!=null){
                        return false;
                    }
                }
            }
            return true;
        } else if (endRow<startRow && endCol<startCol) {
            for(int i=startRow-1;i<endRow;i--){
                for(int j=startCol-1;j<endCol;j--){
                    if(this.board[i][j]!=null){
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
