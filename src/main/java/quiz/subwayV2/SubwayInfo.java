package quiz.subwayV2;

/**
 * Created by bollsal on 2016. 12. 14..
 */
public class SubwayInfo {
    String name;
    boolean transfer;

    SubwayInfo(String name, boolean transfer) {
        this.name = name;
        this.transfer = transfer;
    }

    public String getName() {
        return name;
    }

    public boolean isTransfer() {
        return transfer;
    }

    @Override
    public String toString() {
        return "SubwayInfo{" +
                "name='" + name + '\'' +
                ", transfer=" + transfer +
                '}';
    }
}
