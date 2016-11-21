package day02.quiz.rockpaperscissors;

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

    @After
    public void tearDown() {
        rockpaperscissors = null;
    }

    @AfterClass
    public static void afterClass() {

    }
}
