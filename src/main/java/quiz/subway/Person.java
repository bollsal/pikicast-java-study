package quiz.subway;

/**
 * Created by bollsal on 2016. 12. 6..
 */
public class Person {

    String subwayRoute;
    int destinationPosition;

    String currentRoute;
    int currentPosition;

    public void setDestinationInfo(String subwayRoute, int destinationPosition) {
        this.subwayRoute = subwayRoute;
        this.destinationPosition = destinationPosition;
    }

    public void setCurrentInfo(String currentRoute, int currentPosition) {
        this.currentRoute = currentRoute;
        this.currentPosition = currentPosition;
    }

    public String getDestinationRoute() {
        return subwayRoute;
    }

    public int getDestinationPosition() {
        return destinationPosition;
    }

    public String getCurrentRoute() {
        return currentRoute;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
