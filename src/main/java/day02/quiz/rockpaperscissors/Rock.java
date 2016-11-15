package day02.quiz.rockpaperscissors;

/**
 * Created by bollsal on 2016. 11. 15..
 */
public class Rock extends Common {

    @Override
    String getResult(int computerValue) {
        switch (computerValue) {
            case VALUE.NUM_SCISSOR:
                return RESULT.WIN;
            case VALUE.NUM_ROCK:
                return RESULT.DRAW;
            case VALUE.NUM_PAPERS:
                return RESULT.LOSE;
            default:
                return RESULT.UNKNOWN;
        }
    }
}
