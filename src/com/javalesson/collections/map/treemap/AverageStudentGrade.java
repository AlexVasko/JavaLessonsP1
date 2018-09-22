package com.javalesson.collections.map.treemap;

public class AverageStudentGrade implements Comparable<AverageStudentGrade>{
    private final String name;
    private final float averageGrade;

    public AverageStudentGrade(String name, float averageGrade) {
        this.name = name;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public float getAverageGrade() {
        return averageGrade;
    }

    @Override
    public int compareTo(AverageStudentGrade that) {
        if(this.averageGrade<that.getAverageGrade()){
            return -1;
        }
        if(this.averageGrade>that.getAverageGrade()){
            return 1;
        }

        return name.compareTo(that.getName());
    }

    @Override
    public String toString() {
        return "Students name: "+name+"  Grade:"+averageGrade;
    }
}
