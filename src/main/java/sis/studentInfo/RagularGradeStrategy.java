package sis.studentInfo;

/**
 * Created by bollsal on 2016. 12. 12..
 */
public class RagularGradeStrategy implements GradeStrategy {
    @Override
    public double getScoreByGrade(Student.Grade grade) {
        if (grade == Student.Grade.A) return 4.0;
        if (grade == Student.Grade.B) return 3.0;
        if (grade == Student.Grade.C) return 2.0;
        if (grade == Student.Grade.D) return 1.0;
        return 0;
    }
}
