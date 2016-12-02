package sis.studentInfo;

/**
 * Created by bollsal on 2016. 11. 16..
 */
public class Student {

    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static final String IN_STATE = "서울시";

    private String name;
    private int credits;
    private String state;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isFullTime() {
        return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    public int getCredits() {
        return credits;
    }

    public void addCredits(int credit) {
        this.credits += credit;
    }

    public boolean isInState() {
        return IN_STATE.equals(state);
    }

    public void setState(String state) {
        this.state = state;
    }
}
