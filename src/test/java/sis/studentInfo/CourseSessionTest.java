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

        Student student2 = new Student("학생2");
        courseSession.enroll(student2);
        assertThat(courseSession.getStudent(1), is(student2));
        assertThat(courseSession.getStudentCount(), is(2));
    }

    @Test
    public void count() {
        CourseSession.clearSessionCount();
        assertThat(CourseSession.getCourseSessionCount(), is(0));

        CourseSession.create(department, number, startDate);
        assertThat(CourseSession.getCourseSessionCount(), is(1));
    }
}
