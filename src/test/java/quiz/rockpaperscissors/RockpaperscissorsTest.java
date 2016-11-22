package quiz.rockpaperscissors;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bollsal on 2016. 11. 15..
 */
public class RockpaperscissorsTest {
    Rockpaperscissors rockpaperscissors;

    @BeforeClass
    public static void beforeClass() {

    }

    @Before
    public void setUp() {
        rockpaperscissors = new Rockpaperscissors();
    }

    @Test
    public void 이기는_경우() {
        rockpaperscissors.computerValue = Common.VALUE.NUM_PAPERS;
        rockpaperscissors.setUserInput(Common.VALUE.SCISSOR);
        assertThat(rockpaperscissors.getResult(), is(Common.RESULT.WIN));

        rockpaperscissors.computerValue = Common.VALUE.NUM_SCISSOR;
        rockpaperscissors.setUserInput(Common.VALUE.ROCK);
        assertThat(rockpaperscissors.getResult(), is(Common.RESULT.WIN));

        rockpaperscissors.computerValue = Common.VALUE.NUM_ROCK;
        rockpaperscissors.setUserInput(Common.VALUE.PAPERS);
        assertThat(rockpaperscissors.getResult(), is(Common.RESULT.WIN));
    }

    @Test
    public void 비기는_경우() {
        rockpaperscissors.computerValue = Common.VALUE.NUM_SCISSOR;
        rockpaperscissors.setUserInput(Common.VALUE.SCISSOR);
        assertThat(rockpaperscissors.getResult(), is(Common.RESULT.DRAW));
    }

    @Test
    public void 지는_경우() {
        rockpaperscissors.computerValue = Common.VALUE.NUM_ROCK;
        rockpaperscissors.setUserInput(Common.VALUE.SCISSOR);
        assertThat(rockpaperscissors.getResult(), is(Common.RESULT.LOSE));
    }

    /**
     * 단위테스트가 용이하도록 기능을 분류.
     */
    @Test
    public void 묵찌빠_각각의_케이스() {
        Scissor scissor = new Scissor();
        // 이기는 경우
        assertThat(scissor.getMukjjuppaResult(scissor.getValue()), is(Common.RESULT.WIN_MUKJJIPPA));
        // 이겨서 공격권 이어가는 경우
        assertThat(scissor.getMukjjuppaResult(new Papers().getValue()), is(Common.RESULT.WIN_CONTINUE_GAME));
        // 져서 공격권 뺏기는 경우
        assertThat(scissor.getMukjjuppaResult(new Rock().getValue()), is(Common.RESULT.LOSE_CONTINUE_GAME));
    }

    @Test
    public void 가위바위보의_결과값을_먼저정하고_결과가_잘나오는지_체크() {
        String firstGame = Common.RESULT.WIN;
        String secondGame = Common.RESULT.WIN_MUKJJIPPA;

        Rock rock = new Rock();
        assertThat(rock.getResult(new Scissor().getValue()), is(firstGame));
        assertThat(rock.getMukjjuppaResult(new Rock().getValue()), is(secondGame));
    }

    @After
    public void tearDown() {
        rockpaperscissors = null;
    }

    @AfterClass
    public static void afterClass() {

    }
}
