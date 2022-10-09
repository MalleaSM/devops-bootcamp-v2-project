import java.util.List;
import Interfaces.IMenuCommand;
import models.Display;
import models.Student;
import models.Subject;

public class DisplayCommand implements IMenuCommand{
    Display display;
    public DisplayCommand(Display display){
        this.display = display;
    }
    @Override
    public void studentScoreDisplay(List<Subject> subjects) {
        display.showStudentScores(subjects);
    }
    @Override
    public void studentByGradeDisplay(List<Student> students, String grade) {
        display.showStudentByGrade(students, grade);
    }
}
