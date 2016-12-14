package quiz.chess.pieces;

/**
 * Created by bollsal on 2016. 12. 14..
 */
public class Knight extends Piece {
    public static final String BLACK_NAME = "N";
    public static final String WHITE_NAME = "n";

    Knight(Color color, String name) {
        super(color, name);
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
