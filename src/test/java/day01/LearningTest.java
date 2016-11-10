package day01;

/**
 * Created by bollsal on 2016. 11. 7..
 */

import org.junit.*;
import util.Logger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * junit : lifeCycle도 가지고 있다.
 *
 * hamcrest 좀더 영어문장처럼 가독성을 위해.
 */
public class LearningTest {
    private static Logger logger;

    private Learning learning;

    @BeforeClass
    public static void beforeClass() {
        logger = new Logger();
    }

    @Before
    public void setUp() {
        learning = new Learning();
    }

    @Test
    public void 일_더하기_일은_이() {
        assertThat(learning.plus(1, 1), is(2));
    }

    @Test
    public void 일_더하기_사는_오다() {
        assertThat(learning.plus(1, 4), is(5));
    }

    @After
    public void tearDown() {
        learning = null;
    }

    @AfterClass
    public static void afterClass() {
        logger = null;
    }
}
