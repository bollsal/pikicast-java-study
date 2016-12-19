package quiz.chess.pieces;

/**
 * Created by bollsal on 2016. 11. 15..
 */
public class Piece {

    enum Color {
        WHITE, BLACK, EMPTY
    }

    public static final String WHITE_PAWN = "p";
    public static final String BLACK_PAWN = "P";
    public static final String EMPTY_PAWN = ".";

    Color color;

    Piece(Color color) {
        this.color = color;
    }

    public void create(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        if (isWhite()) {
            return WHITE_PAWN;
        } else if(isBlack()) {
            return BLACK_PAWN;
        } else {
            return EMPTY_PAWN;
        }
    }

    public boolean isWhite() {
        return (color != null && color.equals(Color.WHITE));
    }

    public boolean isBlack() {
        return (color != null && color.equals(Color.BLACK));
    }
}
