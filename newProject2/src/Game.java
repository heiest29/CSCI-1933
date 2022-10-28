import java.util.Scanner;

public class Game {
    private static boolean BlacksMove = false;


    public static void main(String[] args) {
        // The main method functions around continuous ordered checking of four things.
        // 1: Has the game ended yet?
        // 2: Who's turn is it currently?
        // 3: Is the turn made by the current player legal (checks out of bounds, all the verify methods, etc.)
        // 4: Does either player have a pawn that they can promote
        // After a check successfully resolves and a move is made or a pawn is promoted, the board is reprinted.
        // After the board is printed, the users are informed of whose turn it currently is
        // When the game ends and the while loop breaks, the current player wins since they must have been the one to capture the opposing king
        Board newb = new Board();
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR",newb);
        Scanner scan = new Scanner(System.in);

        while(!newb.isGameOver()) {
            System.out.println(newb);

            if (BlacksMove){
                System.out.println("Black to Move: What is your play? (Enter in form:[startRow] [startCol] [endRow] [endCol])");
            } else {
                System.out.println("White to Move: What is your play? (Enter in form:[startRow] [startCol] [endRow] [endCol])");
            }

            String st = scan.nextLine();
            String[] moves = st.split(" ");


            if (newb.verifySourceAndDestination(Integer.parseInt(moves[0]), Integer.parseInt(moves[1]), Integer.parseInt(moves[2]), Integer.parseInt(moves[3]),BlacksMove)) {
                if (BlacksMove == newb.getPiece(Integer.parseInt(moves[0]), Integer.parseInt(moves[1])).getIsBlack()) {
                    if (newb.movePiece(Integer.parseInt(moves[0]), Integer.parseInt(moves[1]), Integer.parseInt(moves[2]), Integer.parseInt(moves[3]))) {
                        BlacksMove = !BlacksMove;
                    } else {
                        System.out.println("That was an illegal move, try again!!");
                    }
                } else {
                    System.out.println("That was the enemy piece you fool!");
                }
            } else {
                System.out.println("That move was out of bounds!");
            }

            System.out.println(newb);

            for (int i=0; i<8; i++) {
                if ((newb.getPiece(0,i)!=null && newb.getPiece(0,i).getCharacter() == '\u2659') || (newb.getPiece(0,i)!=null && newb.getPiece(0,i).getCharacter() == '\u265f')) {
                    System.out.println("White has a pawn to promote: Please enter lowercase q,r,k,b for queen, rook, knight, bishop respectively");
                    String c = scan.nextLine();
                    Piece tempPiece = newb.getPiece(0,i).promotePiece(c);
                    newb.setPiece(0,i,tempPiece);
                    System.out.println(newb);
                } else if ((newb.getPiece(7,i)!=null && newb.getPiece(7,i).getCharacter() == '\u265f') || (newb.getPiece(7,i)!=null && newb.getPiece(7,i).getCharacter() == '\u2659')) {
                    System.out.println("Black has a pawn to promote: Please enter lowercase q,r,k,b for queen, rook, knight, bishop respectively");
                    String c = scan.nextLine();
                    Piece tempPiece = newb.getPiece(7,i).promotePiece(c);
                    newb.setPiece(7,i,tempPiece);
                    System.out.println(newb);
                }
            }
        }
        System.out.println(newb);
        if (!BlacksMove){
            System.out.println("Black has captured the white king.  Congratulations!!");
        } else {
            System.out.println("White has captured the black king.  Congratulations!!");
        }
    }
}
