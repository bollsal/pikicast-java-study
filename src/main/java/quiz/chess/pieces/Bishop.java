package quiz.chess.pieces;

/**
 * Created by bollsal on 2016. 12. 14..
 */
public class Bishop extends Piece {
    public static final String BLACK_NAME = "B";
    public static final String WHITE_NAME = "b";

    Bishop(Color color) {
        super(color);
    }

    @Override
    public String getName() {
        if (isWhite()) {
            return WHITE_NAME;
        } else {
            return BLACK_NAME;
        }
    }
}
