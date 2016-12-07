package quiz.mcdonalds;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import quiz.mcdonalds.menu.MenuTest;
import quiz.mcdonalds.customer.CustomerTest;

/**
 * Created by bollsal on 2016. 12. 7..
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CustomerTest.class,
        McdonaldsTest.class,
        MenuTest.class
})
public class TotalTest {
}
