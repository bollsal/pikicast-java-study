package quiz.subway;

/**
 * Created by bollsal on 2016. 12. 6..
 */
public class Subway {
    public static final String SUBWAY_01 = "1호선";
    public static final String SUBWAY_02 = "2호선";

    private String subwayRoute;
    private int currentPosition;
    private int transferPosition;

    public Subway(String subwayRoute) {
        this.subwayRoute = subwayRoute;
    }

    public void tick() {
        currentPosition++;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setTransferPosition(int transferPosition) {
        this.transferPosition = transferPosition;
    }

    public boolean isTransferPosition() {
        return currentPosition == transferPosition;
    }

    public String getSubwayRoute() {
        return subwayRoute;
    }
}
