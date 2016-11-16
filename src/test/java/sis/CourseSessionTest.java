package sis;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by bollsal on 2016. 11. 16..
 */
public class CourseSessionTest {

    private CourseSession courseSession;
    String department = "이산수학";
    String number = "10";

    @Before
    public void setUp() {
        courseSession = new CourseSession(department, number);
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
    public void startData() {
        CourseSession courseSession = new CourseSession(department, number, createDate(2016, 1, 4));
        assertThat(courseSession.getEndDate(), is(createDate(2016, 4, 22)));
    }

    Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }
}
