package quiz.subwayV2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bollsal on 2016. 12. 14..
 */
public class Subway {

    /**
     * A -- B -- C -- D -- E -- F
     *           |         |
     *           G         J
     *           |         |
     *           H -- I -- K
     *
     */

    List<SubwayInfo> linesNo1;
    List<SubwayInfo> linesNo2;
    List<SubwayInfo> linesNo3;

    private String currentPosition = "A";

    public enum TEST_PATH {
        LINE2, LINE3;
    }

    public void createLine() {
        linesNo1 = Arrays.asList(new SubwayInfo("A", false), new SubwayInfo("B", false), new SubwayInfo("C", true), new SubwayInfo("D", false), new SubwayInfo("E", true), new SubwayInfo("F", false));
        linesNo2 = Arrays.asList(new SubwayInfo("C", true), new SubwayInfo("G", false), new SubwayInfo("H", false), new SubwayInfo("I", false), new SubwayInfo("K", true), new SubwayInfo("J", false), new SubwayInfo("E", true), new SubwayInfo("D", false));
        linesNo3 = Arrays.asList(new SubwayInfo("E", true), new SubwayInfo("J", false), new SubwayInfo("K", false));
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void run(String destinationPos, TEST_PATH testPath) {
        runLineNo1(destinationPos, testPath);
    }

    private void runLineNo1(String destinationPos, TEST_PATH testPath) {
        StringBuilder builder = new StringBuilder();
        if (containsPositionInLine(linesNo1, currentPosition)) {
            boolean start = false;
            for (SubwayInfo subwayInfo : linesNo1) {
                if (!start && subwayInfo.getName().equals(currentPosition)) {
                    start = true;
                }
                if (start) {
                    builder.append(subwayInfo.getName());
                    builder.append(" - ");

                    if (subwayInfo.isTransfer()) {
                        if (testPath == TEST_PATH.LINE2) {
                            if (containsPositionInLine(linesNo2, destinationPos)) {
                                runLineNo2(destinationPos);
                                break;
                            }
                        }
                        if (testPath == TEST_PATH.LINE3) {
                            if (containsPositionInLine(linesNo3, destinationPos)) {
                                runLineNo3(destinationPos);
                                break;
                            }
                        }
                    } else if (subwayInfo.getName().equals(destinationPos)) {
                        System.out.println("도착");
                        break;
                    }
                    currentPosition = subwayInfo.getName();
                }
            }
        }
        System.out.println("경로1 : " + builder.toString());
    }

    private boolean containsPositionInLine(List<SubwayInfo> lines, String pos) {
        for (SubwayInfo subwayInfo : lines) {
            if (subwayInfo.getName().equals(pos)) {
                return true;
            }
        }
        return false;
    }

    private void runLineNo2(String destinationPos) {
        StringBuilder builder = new StringBuilder();
        for (SubwayInfo subwayInfo : linesNo2) {
            currentPosition = subwayInfo.getName();

            if (subwayInfo.getName().equals(destinationPos)) {
                builder.append(subwayInfo.getName());
                System.out.println("도착");
                break;
            }
            builder.append(subwayInfo.getName());
            builder.append(" - ");
        }
        System.out.println("경로2 : " + builder.toString());
    }

    private void runLineNo3(String destinationPos) {
        StringBuilder builder = new StringBuilder();
        for (SubwayInfo subwayInfo : linesNo3) {
            currentPosition = subwayInfo.getName();

            if (subwayInfo.getName().equals(destinationPos)) {
                builder.append(subwayInfo.getName());
                System.out.println("도착");
                break;
            }
            builder.append(subwayInfo.getName());
            builder.append(" - ");
        }
        System.out.println("경로3 : " + builder.toString());
    }
}
