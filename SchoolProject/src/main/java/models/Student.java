package models;

import java.util.List;

import javax.swing.JOptionPane;

public class Student {
    private String code;
    private String name;
    private String age;
    private String grade;
    private List<Subject> subjects;

    public Student(String code, String name, String age, String grade, List<Subject> subjects) {
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

    public String getAge(){
        return age;
    }

    public List<Subject> getSubjects(){
        return subjects;
    }

    public void setScore(String Score, String subjectName){
        boolean found = false;
        for (Subject subject : subjects) {
            if(subject.getName().equalsIgnoreCase(subjectName)){
                subject.setScore(Score);
                found = true;
            }
        }
        if(!found){
            JOptionPane.showMessageDialog(null, "This student does not have your subject!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}
