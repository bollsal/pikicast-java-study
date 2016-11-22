package sis;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sis.report.RosterReporterTest;
import sis.studentInfo.CourseSessionTest;
import sis.studentInfo.StudentTest;
import sis.util.DateUtilTest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by bollsal on 2016. 11. 22..
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RosterReporterTest.class,
        CourseSessionTest.class,
        StudentTest.class,
        DateUtilTest.class
})
public class StudentInformationSystemTest {


}
