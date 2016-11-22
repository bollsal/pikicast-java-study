package sis.report;

import sis.studentInfo.Student;

import java.util.List;

/**
 * Created by bollsal on 2016. 11. 22..
 */
public class RosterReporter {
    static final String SEPARATOR = System.getProperty("line.separator");
    static final String ROSTER_REPORT_HEADER = "학생명단 ==============" + SEPARATOR;
    static final String ROSTER_REPORT_FOOTER = "등록한 학생수 : ";

    List<Student> students;

    public RosterReporter(List<Student> students) {
        this.students = students;
    }

    public String getRosterReport() {
        StringBuilder builder = new StringBuilder();
        writeHeader(builder);
        writeBody(builder);
        writeFooter(builder);
        return builder.toString();
    }

    private void writeFooter(StringBuilder builder) {
        builder.append(ROSTER_REPORT_FOOTER);
        builder.append(students.size() + SEPARATOR);
    }

    private void writeBody(StringBuilder builder) {
        for (Student student : students) {
            builder.append(student.getName() + SEPARATOR);
        }
    }

    private void writeHeader(StringBuilder builder) {
        builder.append(ROSTER_REPORT_HEADER);
    }
}
