package models;

import java.util.List;

import javax.swing.JOptionPane;

public class Display {
       
    public void showStudentScores(List<Subject> subjects){
        String message = ("Score                          Subject\n");
        for (Subject subject : subjects) {
            message += subject.getScore()+"                          "+subject.getName()+"\n";
        }
        JOptionPane.showMessageDialog(null, message, "STUDENT SCORES:", JOptionPane.DEFAULT_OPTION, null); 
    }

    public void showStudentByGrade(List<Student> students, String grade){ 
        String message = ("Code                             Name                    Age\n");
        for (Student student : students) {
            message += student.getCode()+"                  "+student.getName()+"                   "+student.getAge()+"\n";
        }
        JOptionPane.showMessageDialog(null, message, "STUDENTS IN: \t"+ grade, JOptionPane.DEFAULT_OPTION, null);
    }
}
