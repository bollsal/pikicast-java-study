package quiz.elevator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by bollsal on 2016. 12. 21..
 *
 *  같은층층으로 이동하지 않아야함.
 *
 *  서로 경쟁하지 않고 효율적으로 이동되도록.
 *
 */
public class BuildingTest {

    Building building;
    Elevator elevator1;
    Elevator elevator2;

    @Before
    public void setUp() {
        building = new Building();
        elevator1 = building.getElevators().get(0);
        elevator2 = building.getElevators().get(1);
    }

    @Test
    public void 두대의_엘르베이터를_셋팅() {
        assertThat(building.getElevatorCount(), is(2));
    }

    @Test
    public void 같은층에있는_엘르베이터를_호출() {
        elevator1.setCurrentFloor(0);
        elevator2.setCurrentFloor(0);

        building.elevatorCall(5);

        assertThat(elevator1.getCurrentFloor(), is(5));
        assertThat(elevator2.getCurrentFloor(), is(0));
    }

    @Test
    public void 다른층에있는_엘르베이터를_호출() {
        elevator1.setCurrentFloor(8);
        elevator2.setCurrentFloor(4);

        Elevator selectedElevator = building.elevatorCall(0);
        assertThat(selectedElevator, is(elevator2));

        assertThat(elevator1.getCurrentFloor(), is(8));
        assertThat(elevator2.getCurrentFloor(), is(0));
    }
}
