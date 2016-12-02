package sis.studentInfo;

import org.junit.Test;
import sis.studentInfo.Student;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by bollsal on 2016. 11. 16..
 */
public class StudentTest {

    @Test
    public void create() {
        String studentName = "케케티";
        Student student = new Student(studentName);
        assertThat(student.getName(), is(studentName));
    }

    @Test
    public void credits() {
        Student student = new Student("케케티");

        assertThat(student.getCredits(), is(0));
        assertThat(student.isFullTime(), is(false));

        student.addCredits(3);
        assertThat(student.getCredits(), is(3));
        assertThat(student.isFullTime(), is(false));

        student.addCredits(4);
        assertThat(student.getCredits(), is(7));
        assertThat(student.isFullTime(), is(false));

        student.addCredits(5);
        assertThat(student.getCredits(), is(12));
        assertThat(student.isFullTime(), is(true));
    }

    @Test
    public void inState() {
        Student student = new Student("케케티");
        assertThat(student.isInState(), is(false));

        student.setState(Student.IN_STATE);
        assertThat(student.isInState(), is(true));

        student.setState("김해");
        assertThat(student.isInState(), is(false));
    }
}
