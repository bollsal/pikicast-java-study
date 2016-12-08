package quiz.subway;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by bollsal on 2016. 12. 6..
 */
public class PersonTest {

    @Test
    public void 목적지설정() {
        Person person = new Person();
        person.setDestinationInfo(Subway.SUBWAY_01, 3);
        assertThat(person.getDestinationRoute(), is(Subway.SUBWAY_01));
        assertThat(person.getDestinationPosition(), is(3));
    }
}
