package day01;

/**
 * Created by bollsal on 2016. 11. 7..
 */

import org.junit.*;
import util.Logger;

/**
 * junit : lifeCycle도 가지고 있다.
 */
public class Learning {
    private static Logger logger;

    @BeforeClass
    public static void beforeClass() {
        logger = new Logger();
    }

    @Before
    public void setUp() {
        logger = new Logger();
    }

    @Test
    public void 일_더하기_일은_이() {
        logger.p("test1 >> ");
    }

    @Test
    public void 일_더하기_사는_오다() {
        logger.p("test2 >> ");
    }

    @After
    public void tearDown() {

    }

    @AfterClass
    public static void afterClass() {
        logger = null;
    }
}
