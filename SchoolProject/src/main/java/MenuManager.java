import java.util.List;
import Interfaces.IMenuCommand;
import models.Student;
import models.Subject;

public class MenuManager {
    IMenuCommand menuCommand;
    public MenuManager(){};

    public void setCommand(IMenuCommand menuCommand){
        this.menuCommand = menuCommand;
    }
    
    public void showScoreSelected(List<Subject> subjects){
        this.menuCommand.studentScoreDisplay(subjects);
    }

    public void showStudentByGrade(List<Student> students, String grade){
        this.menuCommand.studentByGradeDisplay(students, grade);
    }

}
