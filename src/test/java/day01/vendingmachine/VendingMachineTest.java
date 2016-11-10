package day01.vendingmachine;

import day01.quiz.vendingmachine.Cola;
import day01.quiz.vendingmachine.Juice;
import day01.quiz.vendingmachine.VendingMachine;
import org.hamcrest.CoreMatchers;
import org.junit.*;
import util.Logger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bollsal on 2016. 11. 10..
 */
public class VendingMachineTest {
    private static Logger logger;

    private VendingMachine vendingMachine;
    private Cola cola;
    private Juice juice;

    @BeforeClass
    public static void beforeClass() {
        logger = new Logger();
    }

    @Before
    public void setUp() {
        vendingMachine = new VendingMachine();
        cola = vendingMachine.getMenu().getCola();
        juice = vendingMachine.getMenu().getJuice();
    }

    @Test
    public void 테스트_1() {
        int insertMoney = 10000;
        vendingMachine.insertMoney(insertMoney);

        assertThat(vendingMachine.getInsertMoney(), is(insertMoney));
    }

    @Test
    public void 테스트_2() {
        assertThat(vendingMachine.getMenu().hasItem(), is(true));
    }

    @Test
    public void 테스트_3() {

        assertThat(vendingMachine.getMenu().hasCola(), is(true));
        assertThat(vendingMachine.getMenu().hasJuice(), is(true));
    }

    @Test
    public void 테스트_4() {
        int insertMoney = 90;
        vendingMachine.insertMoney(insertMoney);
        assertThat(vendingMachine.buyDrink(cola.getMenuName()), is(true));
    }

    @After
    public void tearDown() {
        vendingMachine = null;
    }

    @AfterClass
    public static void afterClass() {
        logger = null;
    }
}
