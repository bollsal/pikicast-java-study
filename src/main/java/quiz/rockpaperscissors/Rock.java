package quiz.rockpaperscissors;

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

    @Override
    String getMukjjuppaResult(int computerValue) {
        switch (computerValue) {
            case VALUE.NUM_SCISSOR:
                return RESULT.WIN_CONTINUE_GAME;
            case VALUE.NUM_ROCK:
                return RESULT.WIN_MUKJJIPPA;
            case VALUE.NUM_PAPERS:
                return RESULT.LOSE_CONTINUE_GAME;
            default:
                return RESULT.UNKNOWN;
        }
    }

    @Override
    int getValue() {
        return VALUE.NUM_ROCK;
    }
}
