package sis.report;

import org.junit.Before;
import org.junit.Test;
import sis.studentInfo.Student;
import sis.studentInfo.StudentFactory;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static sis.report.RosterReporter.SEPARATOR;

/**
 * Created by bollsal on 2016. 11. 22..
 */
public class RosterReporterTest {

    @Test
    public void rosterReport() {
        String rosterReport = new RosterReporter(Arrays.asList(StudentFactory.create("A"), StudentFactory.create("B"))).getRosterReport();
        assertThat(rosterReport, is(
                RosterReporter.ROSTER_REPORT_HEADER +
                        "A" + SEPARATOR +
                        "B" + SEPARATOR +
                        RosterReporter.ROSTER_REPORT_FOOTER + "2" + SEPARATOR)
        );
    }
}
