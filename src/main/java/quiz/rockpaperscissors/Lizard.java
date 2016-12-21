package quiz.rockpaperscissors;

/**
 * Created by bollsal on 2016. 12. 21..
 */
public class Lizard extends Common {
    @Override
    String getResult(int computerValue) {
        switch (computerValue) {
            case VALUE.NUM_PAPERS:
            case VALUE.NUM_SPOCK:
                return RESULT.WIN;
            case VALUE.NUM_LIZARD:
                return RESULT.DRAW;
            case VALUE.NUM_ROCK:
            case VALUE.NUM_SCISSOR:
                return RESULT.LOSE;
            default:
                return RESULT.UNKNOWN;
        }
    }

    @Override
    String getMukjjuppaResult(int computerValue) {
        switch (computerValue) {
            case VALUE.NUM_PAPERS:
            case VALUE.NUM_SPOCK:
                return RESULT.WIN;
            case VALUE.NUM_LIZARD:
                return RESULT.DRAW;
            case VALUE.NUM_ROCK:
            case VALUE.NUM_SCISSOR:
                return RESULT.LOSE;
            default:
                return RESULT.UNKNOWN;
        }
    }

    @Override
    int getValue() {
        return VALUE.NUM_LIZARD;
    }
}
