package day02.quiz.chess.pieces;

/**
 * Created by bollsal on 2016. 11. 15..
 */
public class Pawn {

    public interface COLOR {
        String WHITE = "white";
        String BLACK = "black";
    }

    String color;

    public void create(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
