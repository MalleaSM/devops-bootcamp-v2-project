import Interfaces.ITeacherCommand;

public class TeacherMenuManager {
    ITeacherCommand teacherCommand;
    public TeacherMenuManager (){};

    public void setCommand(ITeacherCommand teacherCommand){
        this.teacherCommand = teacherCommand;
    }

    public void enterStudentScore(String score, String subjectName){
        this.teacherCommand.enterStudentScore(score, subjectName);
    }
}
