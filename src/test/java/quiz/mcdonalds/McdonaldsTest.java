package quiz.mcdonalds;

import org.junit.Before;
import org.junit.Test;
import quiz.mcdonalds.customer.Customer;
import quiz.mcdonalds.menu.Frenchfry;
import quiz.mcdonalds.menu.Hamburger;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by bollsal on 2016. 12. 7..
 */
public class McdonaldsTest {

    private Mcdonalds mcdonalds;
    private Customer customer;

    @Before
    public void setUp() {
        mcdonalds = Mcdonalds.create(false);
        customer = new Customer();
    }

    @Test
    public void 판매할_메뉴들_셋팅되어있는지_체크() {
        Mcdonalds mcdonalds = Mcdonalds.create(true);
        assertThat(mcdonalds.getMenus().size(), is(0));

        Hamburger hamburger1 = new Hamburger();
        Hamburger hamburger2 = new Hamburger();
        mcdonalds.addMenu(hamburger1);
        mcdonalds.addMenu(hamburger2);

        assertThat(mcdonalds.getMenus().size(), is(2));
        assertThat(mcdonalds.getMenus(), hasItem(hamburger1));
        assertThat(mcdonalds.getMenus(), hasItem(hamburger2));
    }

    @Test
    public void 정상적으로_주문하고_메뉴를_받는경우() {
        customer.setHaveMoney(3000);
        customer.setOrderMenu(Hamburger.NAME);

        mcdonalds.enterCustomer(customer);
        PurchaseResult result = mcdonalds.takeAnOrder();
        customer.setPurchaseResult(result);

        assertThat(customer.getPurchaseResult().getMessage(), is(PurchaseResult.PURCHASE_STATE.SUCCESS));
    }

    @Test
    public void 준비안된_메뉴를_주문하는경우() {
        customer.setHaveMoney(3000);
        customer.setOrderMenu(Frenchfry.NAME);

        mcdonalds.enterCustomer(customer);
        PurchaseResult result = mcdonalds.takeAnOrder();
        customer.setPurchaseResult(result);

        assertThat(customer.getPurchaseResult().getMessage(), is(PurchaseResult.PURCHASE_STATE.FAIL_SOLDOUT));
    }

    @Test
    public void 메뉴가격보다_모자란_돈으로_주문하는경우() {
        customer.setHaveMoney(100);
        customer.setOrderMenu(Hamburger.NAME);

        mcdonalds.enterCustomer(customer);
        PurchaseResult result = mcdonalds.takeAnOrder();
        customer.setPurchaseResult(result);

        assertThat(customer.getPurchaseResult().getMessage(), is(PurchaseResult.PURCHASE_STATE.FAIL_MONEY));
    }
}
