package quiz.SubwayV2;

import org.junit.Before;
import org.junit.Test;
import quiz.subwayV2.Subway;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by bollsal on 2016. 12. 14..
 */
public class SubwayTest {

    Subway subway;

    @Before
    public void setUp() throws Exception {
        subway = new Subway();
        subway.createLine();
    }

    @Test
    public void 같은라인에서_목표지설정() {
        subway.setCurrentPosition("A");
        subway.run("F", null);
        assertThat(subway.getCurrentPosition(), is("F"));
    }

    @Test
    public void 시작지점에서_목표지점까지_가는길이_여러개인_경우() {
        subway.setCurrentPosition("A");
        subway.run("K", Subway.TEST_PATH.LINE2);
        assertThat(subway.getCurrentPosition(), is("K"));

        subway.setCurrentPosition("A");
        subway.run("K", Subway.TEST_PATH.LINE3);
        assertThat(subway.getCurrentPosition(), is("K"));
    }
}
