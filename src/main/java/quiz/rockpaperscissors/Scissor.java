package quiz.rockpaperscissors;

/**
 * Created by bollsal on 2016. 11. 15..
 */
public class Scissor extends Common {

    @Override
    String getResult(int computerValue) {
        switch (computerValue) {
            case VALUE.NUM_SCISSOR:
                return RESULT.DRAW;
            case VALUE.NUM_ROCK:
            case VALUE.NUM_SPOCK:
                return RESULT.LOSE;
            case VALUE.NUM_PAPERS:
            case VALUE.NUM_LIZARD:
                return RESULT.WIN;
            default:
                return RESULT.UNKNOWN;
        }
    }

    @Override
    String getMukjjuppaResult(int computerValue) {
        switch (computerValue) {
            case VALUE.NUM_SCISSOR:
                return RESULT.WIN_MUKJJIPPA;
            case VALUE.NUM_ROCK:
            case VALUE.NUM_SPOCK:
                return RESULT.LOSE_CONTINUE_GAME;
            case VALUE.NUM_PAPERS:
            case VALUE.NUM_LIZARD:
                return RESULT.WIN_CONTINUE_GAME;
            default:
                return RESULT.UNKNOWN;
        }
    }

    @Override
    int getValue() {
        return VALUE.NUM_SCISSOR;
    }
}
