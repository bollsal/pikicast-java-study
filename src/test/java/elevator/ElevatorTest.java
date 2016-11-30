package elevator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bollsal on 2016. 11. 28..
 *
 * 10층짜리 건물.
 *
 * tick()호출시 1층씩 이동 (위아래상관없음)
 *
 *
 * 1. 탑승객 인원 체크
 *
 * 2. 한사람만 타는 경우
 *      - 위로 올라가는 경우
 *      - 아래로 내려가는 경우
 *
 * 3. 두사람이 타는 경우
 *      - 같은 방향
 *      - 한사람이 내리고 반대로 가는 사람이 탄 경우
 *
 */
public class ElevatorTest {

    private Person person01;
    private Person person02;
    private Person person03;
    private Elevator elevator;
    private int destFloorPerson01;
    private int destFloorPerson02;
    private int destFloorPerson03;

    @Before
    public void setUp() {
        person01 = new Person();
        person02 = new Person();
        person03 = new Person();
        elevator = new Elevator();

        elevator.setCurrentFloor(0);
    }

    @Test
    public void 탑승객_인원체크() {
        assertThat(elevator.getPersonCount(), is(0));

        elevator.enterElevator(person01);
        assertThat(elevator.getPersonCount(), is(1));

        elevator.enterElevator(person01);
        assertThat(elevator.getPersonCount(), is(2));
    }

    @Test
    public void 한사람만타서_올라가는_경우() {
        elevator.enterElevator(person01);
        destFloorPerson01 = 5;
        person01.setDestFloor(destFloorPerson01);

        elevatorWorking(destFloorPerson01);

        assertThat(elevator.getPersonCount(), is(0));
        assertThat(elevator.getCurrentFloor(), is(destFloorPerson01));
    }

    @Test
    public void 같은층에서_두사람이타서_올라가는_경우() {
        sameDirectionTwoPerson();

        elevatorWorking(Math.abs(destFloorPerson02 - elevator.getCurrentFloor()));
        assertThat(elevator.getPersonCount(), is(0));
        assertThat(elevator.getCurrentFloor(), is(destFloorPerson02));
    }

    @Test
    public void 같은층에서_두사람이올라갈때_첫번째지점에서_한명더합류_같은방향() {
        sameDirectionTwoPerson();

        elevator.enterElevator(person03);
        destFloorPerson03 = 10;
        person03.setDestFloor(destFloorPerson03);
        assertThat(elevator.getPersonCount(), is(2));

        elevatorWorking(Math.abs(destFloorPerson02 - elevator.getCurrentFloor()));
        assertThat(elevator.getPersonCount(), is(1));
        assertThat(elevator.getCurrentFloor(), is(destFloorPerson02));

        elevatorWorking(Math.abs(destFloorPerson03 - elevator.getCurrentFloor()));
        assertThat(elevator.getPersonCount(), is(0));
        assertThat(elevator.getCurrentFloor(), is(destFloorPerson03));
    }

    @Test
    public void 같은층에서_두사람이_올라갈때_첫번째지점에서_한명더합류_다른반향() {
        sameDirectionTwoPerson();

        elevator.enterElevator(person03);
        destFloorPerson03 = 2;
        person03.setDestFloor(destFloorPerson03);
        assertThat(elevator.getPersonCount(), is(2));

        elevatorWorking(Math.abs(destFloorPerson02 - elevator.getCurrentFloor()));
        assertThat(elevator.getPersonCount(), is(1));
        assertThat(elevator.getCurrentFloor(), is(destFloorPerson02));

        elevatorWorking(Math.abs(destFloorPerson03 - elevator.getCurrentFloor()));
        assertThat(elevator.getPersonCount(), is(0));
        assertThat(elevator.getCurrentFloor(), is(destFloorPerson03));
    }

    private void sameDirectionTwoPerson() {
        elevator.enterElevator(person01);
        elevator.enterElevator(person02);

        destFloorPerson01 = 3;
        person01.setDestFloor(destFloorPerson01);
        destFloorPerson02 = 7;
        person02.setDestFloor(destFloorPerson02);

        elevatorWorking(destFloorPerson01);
        assertThat(elevator.getPersonCount(), is(1));
        assertThat(elevator.getCurrentFloor(), is(destFloorPerson01));

    }

    private void elevatorWorking(int destFloor) {
        elevator.prepareElevator();
        tickIterator(destFloor);
        elevator.arrivalElevator();
    }

    private void tickIterator(int tick) {
        for (int i = 0; i < tick; i++) {
            elevator.tick();
        }
    }
}
