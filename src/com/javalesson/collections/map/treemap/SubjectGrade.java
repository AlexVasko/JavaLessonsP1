package com.javalesson.collections.map.treemap;

import java.io.Serializable;

public class SubjectGrade implements Serializable{
    private final String subject;
    private final int grade;

    public SubjectGrade(String subject, int grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectGrade grade1 = (SubjectGrade) o;

        if (grade != grade1.grade) return false;
        return subject != null ? subject.equals(grade1.subject) : grade1.subject == null;
    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + grade;
        return result;
    }

    @Override
    public String toString() {
        return "Grade: "+subject+" Grade:"+grade;
    }
}
