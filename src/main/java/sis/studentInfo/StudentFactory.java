package sis.studentInfo;

/**
 * Created by bollsal on 2016. 12. 12..
 */
public class StudentFactory {
    public static Student create(String name) {
        return new Student(name);
    }

    public static Student createNationalMerit(String name) {
        Student student = new Student(name);
        student.setNationalMerit(true);
        student.setGradeStrategy(new NationalMeritGradesStartegy());
        return student;
    }

    public static Student createDischagred(String name) {
        Student student = new Student(name);
        student.setDischarged(true);
        student.setGradeStrategy(new DischargedGradeStrategy());
        return student;
    }
}
