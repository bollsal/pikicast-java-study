package quiz.baseball;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by bollsal on 2016. 12. 13..
 */
public class BaseBallGame {

    interface ERROR_MSG {
        String OVERLAP_NUMBER = "중복되는 숫자가 있습니다.";
        String OVER_LIMIT = LIMIT + "미만의 숫자를 입력해주세요.";
    }

    interface RESULT {
        String OUT = " out입니다.";
        String GAME_OVER = "3 out GameOver";
        String GAME_CLEAR = "3 strike GameClear";
    }

    public static final int LIMIT = 10;

    private List<Integer> answerNumbers = new ArrayList<>();
    private List<Integer> userInputNumbers = new ArrayList<>();

    private int outCount = 0;
    private int strikeCount = 0;
    private int ballCount = 0;

    public void initAnserNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < LIMIT; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        answerNumbers.clear();
        for (int i = 0; i < 3; i++) {
            answerNumbers.add(numbers.get(i));
        }
    }

    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }

    public List<Integer> getUserInputNumbers() {
        return userInputNumbers;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void userInput(int num1, int num2, int num3) {
        userInputNumbers.clear();
        userInputNumbers.add(num1);
        userInputNumbers.add(num2);
        userInputNumbers.add(num3);
    }

    public String startGame() {
        if (overlapCheck()) {
            return ERROR_MSG.OVERLAP_NUMBER;
        }
        if (overLimitCheck()) {
            return ERROR_MSG.OVER_LIMIT;
        }
        return result();
    }

    private boolean overlapCheck() {
        for (int i = 0; i < userInputNumbers.size(); i++) {
            int num = userInputNumbers.get(i);
            for (int j = i + 1; j < userInputNumbers.size(); j++) {
                if (num == userInputNumbers.get(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean overLimitCheck() {
        for (int userInputNumber : userInputNumbers) {
            if (userInputNumber >= LIMIT) {
                return true;
            }
        }
        return false;
    }

    private String result() {
        if (out()) {
            if (outCount == 3) {
                return RESULT.GAME_OVER;
            }
            return outCount + RESULT.OUT;
        }

        if (ballAndStrikeCheck()) {
            return RESULT.GAME_CLEAR;
        } else {
            return strikeCount + "S " + ballCount + "B";
        }
    }

    private boolean out() {
        for (int userInputNumber : userInputNumbers) {
            if (answerNumbers.contains(userInputNumber)) {
                return false;
            }
        }

        outCount++;
        return true;
    }

    private boolean ballAndStrikeCheck() {
        strikeCount = 0;
        ballCount = 0;

        for (int i = 0; i < answerNumbers.size(); i++) {
            for (int j = 0; j < userInputNumbers.size(); j++) {
                if (answerNumbers.get(i) == userInputNumbers.get(j)) {
                    if(i == j) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
            }
        }
        return strikeCount == 3 ? true : false;
    }
}
