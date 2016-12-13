package sis.studentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bollsal on 2016. 11. 16..
 */
public class Student {

    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static final String IN_STATE = "서울시";

    enum Grade {
        A, B, C, D, F
    }

    private List<Grade> grades = new ArrayList<>();
    private GradeStrategy gradeStrategy = new RagularGradeStrategy();
    private String name;
    private int credits;
    private String state;
    private boolean nationalMerit;
    private boolean discharged;

    Student(String name) {
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

    public void setNationalMerit(boolean nationalMerit) {
        this.nationalMerit = nationalMerit;
    }

    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }

    public void setGradeStrategy(GradeStrategy gradeStrategy) {
        this.gradeStrategy = gradeStrategy;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public double getGpa() {
        if (grades.size() == 0) {
            return 0;
        }

        double result = 0;
        for (Grade grade : grades) {
            result += gradeStrategy.getScoreByGrade(grade);
        }
        result /= grades.size();

        return result;
    }
}
