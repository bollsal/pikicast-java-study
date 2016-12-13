package quiz.baseball;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by bollsal on 2016. 12. 13..
 *
 * - 0~9 사이의 숫자 3개를 정합니다.
 *
 * - 숫자 3개를 입력 받습니다.
 *
 * - 입력 받은 숫자가 정해둔 숫자와 위치 및 수가 전혀 일치하지 않으면 **아웃**
 * - 수는 맞지만 위치가 다르면 **볼**
 * - 위치와 수가 일치하면 **스트라이크**
 *
 * - 3 아웃이 되기 전 숫자를 찾으면 플레이어 승리.
 * - 입력을 받은 후에 어떤 숫자가 스트라이크, 볼 인지는 알려주지 않고 몇 개의 볼과 스트라이크가 있는지 또는 아웃인지만 알려줍니다.
 *
 */
public class BaseBallGameTest {

    private BaseBallGame game;

    @Before
    public void setUp() {
        game = new BaseBallGame();
        setTestAnswerNumbers();
    }

    @Test
    public void 숫자3개를_정합니다() {
        game.initAnserNumbers();
        assertThat(game.getAnswerNumbers().size(), is(3));
    }

    @Test
    public void 숫자3개를_입력받습니다() {
        game.userInput(0, 1, 2);
        assertThat(game.getUserInputNumbers().size(), is(3));
    }

    @Test
    public void 중복되는_숫자를입력() {
        game.userInput(0, 2, 2);

        String result =  game.startGame();
        assertThat(result, is(BaseBallGame.ERROR_MSG.OVERLAP_NUMBER));
    }

    @Test
    public void 범위에_벗어나는_숫자를입력() {
        game.userInput(0, 2, 11);

        String result =  game.startGame();
        assertThat(result, is(BaseBallGame.ERROR_MSG.OVER_LIMIT));
    }

    @Test
    public void 아웃되는_케이스() {
        String result;

        game.userInput(4, 5, 6);
        result = game.startGame();
        assertThat(result, is(1 + BaseBallGame.RESULT.OUT));

        game.userInput(4, 5, 6);
        result = game.startGame();
        assertThat(result, is(2 + BaseBallGame.RESULT.OUT));

        game.userInput(4, 5, 6);
        result = game.startGame();
        assertThat(result, is(BaseBallGame.RESULT.GAME_OVER));
    }

    @Test
    public void 볼되는_케이스() {
        game.userInput(4, 2, 0);
        game.startGame();
        assertThat(game.getBallCount(), is(2));
    }

    @Test
    public void 스트라이크되는_케이스() {
        game.userInput(4, 1, 2);
        game.startGame();
        assertThat(game.getStrikeCount(), is(2));
    }

    @Test
    public void 유져가승리하는_케이스() {
        game.userInput(0, 1, 2);
        String result = game.startGame();
        assertThat(result, is(BaseBallGame.RESULT.GAME_CLEAR));
    }

    private void setTestAnswerNumbers() {
        game.getAnswerNumbers().add(0);
        game.getAnswerNumbers().add(1);
        game.getAnswerNumbers().add(2);
    }
}
