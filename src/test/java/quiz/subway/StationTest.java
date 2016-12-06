package quiz.subway;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by bollsal on 2016. 12. 6..
 */
public class StationTest {

    private Station station;

    @Before
    public void setUp() {
        station = new Station();
    }

    @Test
    public void 운행하는열차체크_1호선_2호선() {
        assertThat(station.getSubway(Subway.SUBWAY_01), notNullValue());
        assertThat(station.getSubway(Subway.SUBWAY_02), notNullValue());
    }

    @Test
    public void 환승없이_목적지를정함() {
        String route = Subway.SUBWAY_01;
        int position = 3;

        Person person = new Person();
        station.enterPerson(person);

        person.setCurrentInfo(Subway.SUBWAY_01, 0);
        person.setDestinationInfo(route, position);

        station.tick();
        station.tick();
        station.tick();

        // 목적지
        assertThat(station.getPerson().getCurrentRoute(), is(route));
        assertThat(station.getPerson().getCurrentPosition(), is(position));
    }

    @Test
    public void 환승하도록_목적지를정함() {
        String route = Subway.SUBWAY_02;
        int position = 3;

        Person person = new Person();
        station.setTransferPosition(2);
        station.enterPerson(person);

        person.setCurrentInfo(Subway.SUBWAY_01, 0);
        person.setDestinationInfo(route, position);

        // 시작위치 확인
        assertThat(station.getPerson().getCurrentRoute(), is(Subway.SUBWAY_01));
        assertThat(station.getPerson().getCurrentPosition(), is(0));

        station.tick();
        station.tick();

        // 환승 구간
        assertThat(station.getPerson().getCurrentRoute(), is(Subway.SUBWAY_02));
        assertThat(station.getPerson().getCurrentPosition(), is(0));

        station.tick();
        station.tick();
        station.tick();

        // 목적지
        assertThat(station.getPerson().getCurrentRoute(), is(route));
        assertThat(station.getPerson().getCurrentPosition(), is(position));
    }
}
