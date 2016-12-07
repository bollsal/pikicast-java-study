package quiz.mcdonalds.customer;

import org.junit.Test;
import quiz.mcdonalds.Mcdonalds;
import quiz.mcdonalds.menu.Hamburger;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by bollsal on 2016. 12. 7..
 */
public class CustomerTest {

    @Test
    public void 주문항목_제대로_저장되는지() {
        String menuName = Hamburger.NAME;
        int money = Hamburger.PRICE;

        Customer customer = new Customer();
        customer.setOrderMenu(menuName);
        customer.setHaveMoney(money);

        assertThat(customer.getOrderMenuName(), is(menuName));
        assertThat(customer.getHaveMoney(), is(money));
    }
}
