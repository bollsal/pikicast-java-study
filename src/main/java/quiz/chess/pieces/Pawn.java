package quiz.chess.pieces;

/**
 * Created by bollsal on 2016. 11. 15..
 */
public class Pawn {

    public final static String WHITE = "white";
    public final static String BLACK = "black";
    public final static String EMPTY = "empty";

    public static final String WHITE_PAWN = "p";
    public static final String BLACK_PAWN = "P";
    public static final String EMPTY_PAWN = ".";

    String color;
    String mark;

    public Pawn(String color) {
        this.color = color;
        setMark();
    }

    public void create(String color) {
        this.color = color;
    }

    public void setMark() {
        switch (color) {
            case WHITE:
                mark = WHITE_PAWN;
                break;
            case BLACK:
                mark = BLACK_PAWN;
                break;
            default:
                mark = EMPTY_PAWN;
                break;
        }
    }

    public String getColor() {
        return color;
    }

    public String getMark() {
        return mark;
    }
}
