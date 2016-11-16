package sis;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by bollsal on 2016. 11. 16..
 */
public class StudentTest {

    @Test
    public void create() {
        Student student = new Student();
        assertThat(student, is(notNullValue()));
    }
}
