package sis.studentInfo;

import sis.util.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bollsal on 2016. 11. 16..
 */
public class CourseSession {
    private final String department;
    private final String number;
    private Date startDate;
    private List<Student> students;
    private Date endDate;

    public CourseSession(String department, String number, Date date) {
        this.department = department;
        this.number = number;
        this.students = new ArrayList<>();
        this.startDate = date;
    }

    String getDepartment() {
        return department;
    }

    String getNumber() {
        return number;
    }

    public void enroll(Student student) {
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
}
