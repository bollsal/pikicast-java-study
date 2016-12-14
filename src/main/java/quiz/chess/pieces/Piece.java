package quiz.chess.pieces;

/**
 * Created by bollsal on 2016. 11. 15..
 */
public class Piece {

    public enum Color {
        WHITE, BLACK, EMPTY;
    }

    public static final String WHITE_PAWN = "p";
    public static final String BLACK_PAWN = "P";
    public static final String EMPTY_PAWN = ".";

    Color color;
    String name;

    Piece(Color color, String name) {
        this.color = color;
        this.name = name;
    }

    public void create(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public boolean isWhite() {
        return (color != null && color.equals(Color.WHITE));
    }

    public boolean isBlack() {
        return (color != null && color.equals(Color.BLACK));
    }
}
