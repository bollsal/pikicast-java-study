package quiz.mcdonalds.menu;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by bollsal on 2016. 12. 7..
 */
public class MenuTest {

    @Test
    public void 메뉴이름_가격_제대로설정되있는지체크() {
        Menu hamburger = new Hamburger();
        assertThat(hamburger.getName(), is(Hamburger.NAME));
        assertThat(hamburger.getPrice(), is(Hamburger.PRICE));

        Menu frenchfry = new Frenchfry();
        assertThat(frenchfry.getName(), is(Frenchfry.NAME));
        assertThat(frenchfry.getPrice(), is(Frenchfry.PRICE));
    }
}
