package sis.report;

import sis.studentInfo.CourseSession;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by bollsal on 2016. 12. 8..
 */
public class CourseReport {
    private List<CourseSession> sessions = new ArrayList<>();

    public void add(CourseSession session) {
        sessions.add(session);
    }

    public String text() {
        Collections.sort(sessions);
        StringBuilder builder = new StringBuilder();
        for (CourseSession session : sessions) {
            builder.append(session.getDepartment());
            builder.append(ReportConstant.SPACE);
            builder.append(session.getNumber());
            builder.append(ReportConstant.NEWLINE);
        }
        return builder.toString();
    }
}
