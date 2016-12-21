package quiz.rockpaperscissors;

/**
 * Created by bollsal on 2016. 11. 15..
 */
public abstract class Common {

    interface VALUE {
        String SCISSOR = "가위";
        String ROCK = "바위";
        String PAPERS = "보";
        String SPOCK = "스폭";
        String LIZARD = "도마뱀";

        int NUM_SCISSOR = 0;
        int NUM_ROCK = 1;
        int NUM_PAPERS = 2;
        int NUM_SPOCK = 3;
        int NUM_LIZARD = 4;
    }

    interface RESULT {
        String WIN = "이겼습니다.";
        String DRAW = "비겼습니다.";
        String LOSE = "졌습니다.";

        String WIN_CONTINUE_GAME = "공격권을 이어갑니다.";
        String WIN_MUKJJIPPA = WIN;
        String LOSE_CONTINUE_GAME = "져서 공격권을 뺏깁니다.";
        String UNKNOWN = "???";
    }

    abstract String getResult(int computerValue);
    abstract String getMukjjuppaResult(int computerValue);
    abstract int getValue();
}
