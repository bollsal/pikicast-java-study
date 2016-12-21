package quiz.elevator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bollsal on 2016. 12. 21..
 */
public class Building {
    private List<Elevator> elevators = new ArrayList<>();

    public Building() {
        elevators.add(new Elevator());
        elevators.add(new Elevator());
    }

    public List<Elevator> getElevators() {
        return elevators;
    }

    public int getElevatorCount() {
        return elevators.size();
    }

    public Elevator elevatorCall(int dstFloor) {
        Elevator selectedElevator = null;

        int minValue = Integer.MAX_VALUE;
        for (Elevator elevator : elevators) {
            int floor = Math.abs(dstFloor - elevator.getCurrentFloor());
            if (floor < minValue) {
                selectedElevator = elevator;
                minValue = floor;
            }
        }
        if (selectedElevator != null)
            selectedElevator.call(dstFloor);

        return selectedElevator;
    }
}
