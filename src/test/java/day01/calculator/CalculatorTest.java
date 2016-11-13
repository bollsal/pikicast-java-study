package day01.calculator;

import day01.quiz.calculator.Calculator;
import org.junit.*;
import util.Logger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bollsal on 2016. 11. 9..
 */
public class CalculatorTest {
    private static Logger logger;

    private Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        logger = new Logger();
    }

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void 더하기로_int범위넘겨봄() {
        assertThat(calculator.plus(Integer.MAX_VALUE, 2147483647), is(20));
    }

    @Test
    public void 더하기_long() {
        assertThat(calculator.plusLong(2147483647, 2147483647), is(4294967294L));
    }

    @Test
    public void 백_나누기_영은_에러다() {
        assertThat(calculator.division(100, 0), is(1));
    }

    @Test(expected = ArithmeticException.class)
    public void 백_나누기_영은_에러_EXPECTED() {
        assertThat(calculator.division(100, 0), is(1));
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @AfterClass
    public static void afterClass() {
        logger = null;
    }
}
