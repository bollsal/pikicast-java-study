package day02.quiz.rockpaperscissors;

/**
 * Created by bollsal on 2016. 11. 15..
 */
public abstract class Common {

    interface VALUE {
        String SCISSOR = "가위";
        String ROCK = "바위";
        String PAPERS = "보";

        int NUM_SCISSOR = 0;
        int NUM_ROCK = 1;
        int NUM_PAPERS = 2;
    }

    interface RESULT {
        String WIN = "이겼습니다.";
        String DRAW = "비겼습니다.";
        String LOSE = "졌습니다.";
        String UNKNOWN = "???";
    }

    abstract String getResult(int computerValue);
}
