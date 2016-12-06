package quiz.subway;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by bollsal on 2016. 12. 6..
 */
public class SubwayTest {


    private Subway subway;

    @Before
    public void setUp() {
        subway = new Subway(Subway.SUBWAY_01);
    }

    @Test
    public void 한칸씩이동() {
        subway.tick();

        assertThat(subway.getCurrentPosition(), is(1));

        subway.tick();
        assertThat(subway.getCurrentPosition(), is(2));
    }

    @Test
    public void 몇호선인지_셋팅잘되는지() {
        assertThat(subway.getSubwayRoute(), is(Subway.SUBWAY_01));
        assertThat(new Subway(Subway.SUBWAY_02).getSubwayRoute(), is(Subway.SUBWAY_02));
    }
}
