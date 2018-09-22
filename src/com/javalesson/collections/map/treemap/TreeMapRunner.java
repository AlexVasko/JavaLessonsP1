package com.javalesson.collections.map.treemap;

import java.util.*;

public class TreeMapRunner {
    public static void main(String[] args) {
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades = createGrades();
        printGrades(grades, false);
        AverageStudentGrade border = grades.ceilingKey(new AverageStudentGrade("", 80));
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> scholarshipStudents = (NavigableMap<AverageStudentGrade, Set<SubjectGrade>>) grades.tailMap(border);
        System.out.println("==================================================");
        System.out.println("Scholarship students");
        printGrades(scholarshipStudents.descendingMap(), false);
        System.out.println("Contender student");
        AverageStudentGrade contender = grades.lowerKey(border);
        System.out.println(contender);
        System.out.println("Highest grade student");
        System.out.println(scholarshipStudents.descendingMap().firstEntry());

    }

    private static void printGrades(Map<AverageStudentGrade, Set<SubjectGrade>> grades, boolean printValue) {
        Set<AverageStudentGrade> averageGrades = grades.keySet();
        for (AverageStudentGrade gr : averageGrades) {
            System.out.println(gr);
            if (printValue) {
                System.out.println(grades.get(gr));
            }
        }
    }

    public static NavigableMap<AverageStudentGrade, Set<SubjectGrade>> createGrades(){
        Set<SubjectGrade> alexGrades = new HashSet<>();
        alexGrades.add(new SubjectGrade("Mathematics", 89));
        alexGrades.add(new SubjectGrade("Physics", 65));
        alexGrades.add(new SubjectGrade("History", 95));
        alexGrades.add(new SubjectGrade("Literature", 90));
        alexGrades.add(new SubjectGrade("Chemistry", 75));


        Set<SubjectGrade> jamesGrades = new HashSet<>();
        jamesGrades.add(new SubjectGrade("Mathematics", 75));
        jamesGrades.add(new SubjectGrade("Physics", 80));
        jamesGrades.add(new SubjectGrade("History", 55));
        jamesGrades.add(new SubjectGrade("Literature", 70));
        jamesGrades.add(new SubjectGrade("Chemistry", 80));


        Set<SubjectGrade> antonyGrades = new HashSet<>();
        antonyGrades.add(new SubjectGrade("Mathematics", 93));
        antonyGrades.add(new SubjectGrade("Physics", 91));
        antonyGrades.add(new SubjectGrade("History", 82));
        antonyGrades.add(new SubjectGrade("Literature", 78));
        antonyGrades.add(new SubjectGrade("Chemistry", 88));

        Set<SubjectGrade> victoriaGrades = new HashSet<>();
        victoriaGrades.add(new SubjectGrade("Mathematics", 73));
        victoriaGrades.add(new SubjectGrade("Physics", 65));
        victoriaGrades.add(new SubjectGrade("History", 75));
        victoriaGrades.add(new SubjectGrade("Literature", 66));
        victoriaGrades.add(new SubjectGrade("Chemistry", 50));


        Set<SubjectGrade> alinaGrades = new HashSet<>();
        alinaGrades.add(new SubjectGrade("Mathematics", 90));
        alinaGrades.add(new SubjectGrade("Physics", 70));
        alinaGrades.add(new SubjectGrade("History", 78));
        alinaGrades.add(new SubjectGrade("Literature", 88));
        alinaGrades.add(new SubjectGrade("Chemistry", 89));

        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> map =new TreeMap<>();
        map.put(new AverageStudentGrade("Alex",calcAverage(alexGrades)),alexGrades);
        map.put(new AverageStudentGrade("James",calcAverage(jamesGrades)),jamesGrades);
        map.put(new AverageStudentGrade("Antony",calcAverage(antonyGrades)),antonyGrades);
        map.put(new AverageStudentGrade("Victoria",calcAverage(victoriaGrades)),victoriaGrades);
        map.put(new AverageStudentGrade("Alina",calcAverage(alinaGrades)),alinaGrades);

        return map;
    }

    private static float calcAverage(Set<SubjectGrade> grades){
        float sum = 0f;
        for (SubjectGrade sg: grades){
            sum+=sg.getGrade();
        }
        return sum/grades.size();
    }


}
