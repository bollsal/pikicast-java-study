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

    @Before
    public void setUp() {
        Date startDate = DateUtil.createDate(2016, 1, 4);
        courseSession = new CourseSession(department, number, startDate);
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
}
