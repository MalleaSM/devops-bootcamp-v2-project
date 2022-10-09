package Interfaces;

import java.util.List;

import models.Student;
import models.Subject;


public interface IMenuCommand {
    public void studentScoreDisplay(List<Subject> subjects); 
    public void studentByGradeDisplay(List<Student> students,String grade);
}
