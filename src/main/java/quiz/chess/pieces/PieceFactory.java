package quiz.chess.pieces;

/**
 * Created by bollsal on 2016. 12. 14..
 */
public class PieceFactory {
    public static Piece create(Piece.Color color, String name) {
        return new Piece(color, name);
    }

    public static Piece createRook(Piece.Color color, String name) {
        return new Rook(color, name);
    }
    public static Piece createBishop(Piece.Color color, String name) {
        return new Bishop(color, name);
    }
    public static Piece createKnight(Piece.Color color, String name) {
        return new Knight(color, name);
    }
    public static Piece createKing(Piece.Color color, String name) {
        return new King(color, name);
    }
    public static Piece createQueen(Piece.Color color, String name) {
        return new Queen(color, name);
    }
}
