package quiz.chess.pieces;

/**
 * Created by bollsal on 2016. 12. 14..
 */
public class Queen extends Piece {
    public static final String BLACK_NAME = "Q";
    public static final String WHITE_NAME = "q";

    Queen(Color color) {
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
