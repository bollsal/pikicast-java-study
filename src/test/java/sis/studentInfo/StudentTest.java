package sis.studentInfo;

import org.junit.Before;
import org.junit.Test;
import sis.studentInfo.Student;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Created by bollsal on 2016. 11. 16..
 */
public class StudentTest {

    private static final float GRADE_TOLERANCE = 0.5f;
    private Student student;
    private String studentName;

    @Before
    public void setUp() {
        studentName = "케케티";
        student = StudentFactory.create(studentName);
    }

    @Test
    public void create() {
        assertThat(student.getName(), is(studentName));
    }

    @Test
    public void credits() {
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
        assertThat(student.isInState(), is(false));

        student.setState(Student.IN_STATE);
        assertThat(student.isInState(), is(true));

        student.setState("김해");
        assertThat(student.isInState(), is(false));
    }

    @Test
    public void calculateGpa() {
        assertThat(student.getGpa(), is(0.0));

        student.addGrade(Student.Grade.A);
        assertGpa(student.getGpa(), 4.0);

        student.addGrade(Student.Grade.B);
        assertGpa(student.getGpa(), 3.5);

        student.addGrade(Student.Grade.C);
        assertGpa(student.getGpa(), 3.0);

        student.addGrade(Student.Grade.D);
        assertGpa(student.getGpa(), 2.5);

        student.addGrade(Student.Grade.F);
        assertGpa(student.getGpa(), 2.0);
    }

    private void assertGpa(double origGpa, double expectedGpa) {
        assertThat(origGpa, is(closeTo(expectedGpa, GRADE_TOLERANCE)));
    }

}
