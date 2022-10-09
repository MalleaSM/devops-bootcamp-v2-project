import Interfaces.ITeacherCommand;
import models.Student;

public class enterStudentScoreCommand implements ITeacherCommand{

    Student student;

    public enterStudentScoreCommand(Student student){
        this.student = student;
    }

    @Override
    public void enterStudentScore(String score, String subjectName) {
     student.setScore(score, subjectName);  
    }
    
}
