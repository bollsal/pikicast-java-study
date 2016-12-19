package quiz.chess.pieces;

/**
 * Created by bollsal on 2016. 12. 14..
 */
public class PieceFactory {
//    public static Piece create(Piece.Color color, String name) {
//        return new Piece(color, name);
//    }
//
//    public static Piece createRook(Piece.Color color, String name) {
//        return new Rook(color, name);
//    }
//    public static Piece createBishop(Piece.Color color, String name) {
//        return new Bishop(color, name);
//    }
//    public static Piece createKnight(Piece.Color color, String name) {
//        return new Knight(color, name);
//    }
//    public static Piece createKing(Piece.Color color, String name) {
//        return new King(color, name);
//    }
//    public static Piece createQueen(Piece.Color color, String name) {
//        return new Queen(color, name);
//    }

    public static Piece createWhitePawn() {
        return new Piece(Piece.Color.WHITE);
    }

    public static Piece createWhiteRook() {
        return new Rook(Piece.Color.WHITE);
    }
    public static Piece createWhiteBishop() {
        return new Bishop(Piece.Color.WHITE);
    }
    public static Piece createWhiteKnight() {
        return new Knight(Piece.Color.WHITE);
    }
    public static Piece createWhiteKing() {
        return new King(Piece.Color.WHITE);
    }
    public static Piece createWhiteQueen() {
        return new Queen(Piece.Color.WHITE);
    }

    public static Piece createBlackPawn() {
        return new Piece(Piece.Color.BLACK);
    }

    public static Piece createBlackRook() {
        return new Rook(Piece.Color.BLACK);
    }
    public static Piece createBlackBishop() {
        return new Bishop(Piece.Color.BLACK);
    }
    public static Piece createBlackKnight() {
        return new Knight(Piece.Color.BLACK);
    }
    public static Piece createBlackKing() {
        return new King(Piece.Color.BLACK);
    }
    public static Piece createBlackQueen() {
        return new Queen(Piece.Color.BLACK);
    }

    public static Piece createEmptyPawn() {
        return new Piece(Piece.Color.EMPTY);
    }
}
