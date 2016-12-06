package quiz.elevator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by bollsal on 2016. 11. 28..
 */
public class Elevator {

    private ArrayList<Person> persons;

    interface DIRECTION {
        int UP = 1;
        int DOWN = 0;
    }

    static final int MAX_FLOOR = 10;
    static final int MIN_FLOOR = 0;

    int currentFloor = MIN_FLOOR;
    int currentDirection = DIRECTION.UP;

    public Elevator() {
        persons = new ArrayList<>();
    }

    void enterElevator(Person person) {
        persons.add(person);
    }

    public int getPersonCount() {
        return persons.size();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void prepareElevator() {
        int destFloor = -1;

        for (Person person : persons) {
            int floor = person.getDestFloor();
            if (currentDirection == DIRECTION.UP) {
                if (floor > currentFloor &&
                        (destFloor == -1 || destFloor > floor)) {
                    destFloor = floor;
                }
            } else {
                if (floor < currentFloor &&
                        (destFloor == -1 || destFloor < floor)) {
                    destFloor = floor;
                }
            }
        }

        destFloor -= currentFloor;
        setCurrentDirection(destFloor > 0 ? DIRECTION.UP : DIRECTION.DOWN);

        System.out.println("destFloor : " + destFloor + "__direction : " + currentDirection);
    }

    public void tick() {
        if (currentDirection == DIRECTION.UP) {
            currentFloor++;
        } else {
            currentFloor--;
        }
    }

    public void arrivalElevator() {
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getDestFloor() == currentFloor) {
                iterator.remove();
            }
        }
    }
}
