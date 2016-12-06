package quiz.subway;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by bollsal on 2016. 12. 6..
 *
 * * 길 찾기 ex)지하철 노선도.
 *  - tick() 으로 이동
 *  - 1호선을 2호선을 갈아타는.
 *  - 환승역을 구분하고, 목표하는 역이 몇호선인지 확인.
 *  - 노선별로 일방향으로 가는 전철이니 주의해야함.
 *
 *  - 잘 풀리면 2번 환승하게 개발.
 *  - 상행선과 하행선 개념이 필요.
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PersonTest.class,
        StationTest.class,
        SubwayTest.class
})
public class SubwayStationTest {
}
