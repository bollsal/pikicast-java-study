package sis.studentInfo;

import sis.util.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bollsal on 2016. 11. 16..
 */
public class CourseSession {
    private static int courseSessionCount;

    private final String department;
    private final String number;
    private Date startDate;
    private List<Student> students;
    private Date endDate;
    private int credits;

    public CourseSession(String department, String number, Date date) {
        this.department = department;
        this.number = number;
        this.students = new ArrayList<>();
        this.startDate = date;
        this.credits = 3;
    }

    private static void incrementCourseSessionCount() {
        CourseSession.courseSessionCount++;
    }

    public static int getCourseSessionCount() {
        return CourseSession.courseSessionCount;
    }

    String getDepartment() {
        return department;
    }

    String getNumber() {
        return number;
    }

    public void enroll(Student student) {
        student.addCredits(credits);
        students.add(student);
    }

    int getStudentCount() {
        return students.size();
    }

    Student getStudent(int position) {
        return students.get(position);
    }

    public Date getEndDate() {
        return DateUtil.getEndDate(startDate);
    }

    public static void clearSessionCount() {
        CourseSession.courseSessionCount = 0;
    }

    /**
     *
     * 생성자에서 해야하는 일 외에 다른 기능들은 추상화하여 팩토리메소드로 추상화
     *
     */
    public static CourseSession create(String department, String number, Date startDate) {
        CourseSession.incrementCourseSessionCount();
        return new CourseSession(department, number, startDate);
    }

    public int getCredits() {
        return credits;
    }
}
