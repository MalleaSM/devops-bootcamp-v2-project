package models;

import java.util.List;

public class Display {
       
    public void showStudentScores(List<Subject> subjects){
        System.out.println("=============================");
        System.out.println("SCORE REPORT\t");
        System.out.println("=============================");
        System.out.println("Subject          |           Score");
        for (Subject subject : subjects) {
            System.out.println(subject.getName()+"\t\t\t"+subject.getScore());
        }
    }

    public void showStudentByGrade(List<Student> students, String grade){
        System.out.println("=============================");
        System.out.println("LIST OF STUDENTS IN:\t"+grade);
        System.out.println("=============================");
        System.out.println("Name                |           Age          |      Code");
        for (Student student : students) {
            System.out.println(student.getName()+"\t\t\t"+student.getAge()+"\t\t\t"+student.getCode());
        }
    }
}
