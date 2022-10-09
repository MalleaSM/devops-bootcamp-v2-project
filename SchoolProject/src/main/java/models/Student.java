package models;

import java.util.List;

public class Student {
    private String code;
    private String name;
    private int age;
    private String grade;
    private List<Subject> subjects;

    public Student(String code, String name, int age, String grade, List<Subject> subjects) {
        // this.code = "ST-" + (int)(Math.random() * 100 + 1) +"-" +name;
        this.code = code;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.subjects = subjects;
    }

    public String getCode() {
        return code;
    }

    
    public String getName() {
        return name;
    }
    
    public String getGrade() {
        return grade;
    }

    public int getAge(){
        return age;
    }

    public List<Subject> getSubjects(){
        return subjects;
    }

    public void setScore(String Score, String subjectName){
            
        System.out.println("=============================");
        System.out.println("LISTA ANTES");
        System.out.println("=============================");
        showStudentScores();

        for (Subject subject : subjects) {
            if(subject.getName().equalsIgnoreCase(subjectName)){
                subject.setScore(Score);
            }
        }

        System.out.println("=============================");
        System.out.println("LISTA DESPUES");
        System.out.println("=============================");
        showStudentScores();
    }
    public void showStudentScores(){
        System.out.println("=============================");
        System.out.println("SCORE REPORT\t");
        System.out.println("=============================");
        System.out.println("Subject          |           Score");
        for (Subject subject : subjects) {
            System.out.println(subject.getName()+"\t\t\t"+subject.getScore());
        }
    }
}
