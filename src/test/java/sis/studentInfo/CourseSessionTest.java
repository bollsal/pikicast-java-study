package sis.studentInfo;

import org.junit.Before;
import org.junit.Test;
import sis.studentInfo.CourseSession;
import sis.studentInfo.Student;
import sis.util.DateUtil;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bollsal on 2016. 11. 16..
 */
public class CourseSessionTest {

    private CourseSession courseSession;
    String department = "이산수학";
    String number = "10";
    private Date startDate;

    @Before
    public void setUp() {
        courseSession = CourseSession.create(department, number, startDate);
    }

    @Test
    public void create() {
        assertThat(courseSession.getDepartment(), is(department));
        assertThat(courseSession.getNumber(), is(number));
    }

    @Test
    public void enroll() {
        Student student1 = new Student("학생1");
        courseSession.enroll(student1);
        assertThat(courseSession.getStudent(0), is(student1));
        assertThat(courseSession.getStudentCount(), is(1));
        assertThat(student1.getCredits(), is(courseSession.getCredits()));

        Student student2 = new Student("학생2");
        courseSession.enroll(student2);
        assertThat(courseSession.getStudent(1), is(student2));
        assertThat(courseSession.getStudentCount(), is(2));
        assertThat(student2.getCredits(), is(courseSession.getCredits()));
    }

    @Test
    public void studentStatus() {
        Student student = new Student("학생1");
        CourseSession session1 = CourseSession.create(department, number, startDate);
        CourseSession session2 = CourseSession.create(department, number, startDate);
        CourseSession session3 = CourseSession.create(department, number, startDate);
        CourseSession session4 = CourseSession.create(department, number, startDate);

        assertThat(student.isFullTime(), is(false));

        session1.enroll(student);
        session2.enroll(student);
        session3.enroll(student);
        session4.enroll(student);

        assertThat(student.isFullTime(), is(true));
    }

    @Test
    public void count() {
        CourseSession.clearSessionCount();
        assertThat(CourseSession.getCourseSessionCount(), is(0));

        CourseSession.create(department, number, startDate);
        assertThat(CourseSession.getCourseSessionCount(), is(1));
    }
}
