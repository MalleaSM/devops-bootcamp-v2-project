import models.Display;
import models.School;
import repositories.StudentRepository;
import repositories.TeacherRepository;
import services.AccessValidator;
import services.ReadDataService;
import services.WriteDataService;
import javax.swing.JOptionPane;

import helpers.Grade;
import helpers.Score;

public class Main {
    public static void main(String args[]) {
        TeacherRepository teacherRepository = new TeacherRepository();
        StudentRepository studentRepository = new StudentRepository();

        ReadDataService readDataService = new ReadDataService();
        
        WriteDataService writeDataService = new WriteDataService(studentRepository);
        WriteDataService teacherData = new WriteDataService(teacherRepository);

        var students = readDataService.getStudentJsonData();
        var teachers = readDataService.getTeachersJsonData();

        
        writeDataService.writeStudentsDataToRepository(students);
        teacherData.writeTeacherDataToRepository(teachers);

        var school = new School("American School");

        MenuManager menuOption = new MenuManager();
        TeacherMenuManager teacherOption = new TeacherMenuManager();

        Display display = new Display();
        String[] options = {"Teacher", "Student", "Exit"};
        int selection1 = JOptionPane.showOptionDialog(null, "Welcome to "+ school.getName() +"\n please select one option", "Welcome", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        boolean access = false;
        boolean access2 = false;
        while (!access){
            AccessValidator accessValidator = new AccessValidator(studentRepository,teacherRepository);
            switch (selection1) {
                case 0:
                    String teacherCode = JOptionPane.showInputDialog(null, "Please enter your code");
                    var teacher = accessValidator.verifyTeacherAccess(teacherCode);
                    if (teacher != null){
                        String[] teacherOptions = {"List of Students by grade", "Enter a score for a student", "Exit"};
                        int teacherSelection = JOptionPane.showOptionDialog(null, "Welcome "+ teacher.getName() +"\n please select one option", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, teacherOptions, teacherOptions[0]);                   
                        System.out.println(teacherSelection);
                        switch(teacherSelection){
                            case 0:
                                String[] gradesOPtions = {
                                        Grade.ELEMENTARY_SCHOOL.toString(),
                                        Grade.MIDDLE_SCHOOL.toString(),
                                        Grade.HIGH_SCHOOL.toString()
                                    };
                                String gradeselect = (String) JOptionPane.showInputDialog(null, "Select grade to display list", "Grade selection", JOptionPane.DEFAULT_OPTION, null, gradesOPtions, gradesOPtions[0]);
                                var sbg = studentRepository.getStudentsByGrade(gradeselect);
                                menuOption.setCommand(new DisplayCommand(display));
                                menuOption.showStudentByGrade(sbg,gradeselect);
                                break;
                            case 1:
                                while (!access2){
                                    String studentTeacherCode = JOptionPane.showInputDialog(null, "Please enter the student code");
                                    var studentToScore = accessValidator.verifyStudentAccess(studentTeacherCode);
                                    if (studentToScore != null){
                                        String[] scoreOPtions = {
                                            Score.A.toString(),
                                            Score.B.toString(),
                                            Score.C.toString(),
                                            Score.D.toString(),
                                            Score.E.toString(),
                                            Score.F.toString(),
                                        };
                                        String scoreSelect = (String) JOptionPane.showInputDialog(null, "Select score to register", "Enter score", JOptionPane.DEFAULT_OPTION, null, scoreOPtions, scoreOPtions[0]);
                                        teacherOption.setCommand(new enterStudentScoreCommand(studentToScore));
                                        teacherOption.enterStudentScore(scoreSelect, teacher.getSubject());
                                        int save = JOptionPane.showConfirmDialog(null, "Score entered, save changes?", "Alerta!", JOptionPane.YES_NO_OPTION);
                                        if(save == 0){
                                            writeDataService.updateJson(students);
                                        }
                                        access2 = true;
                                        break;
                                    }
                                    else{
                                        int notFound = JOptionPane.showConfirmDialog(null, "Student not found try again?", "Alerta!", JOptionPane.YES_NO_OPTION);
                                        if(notFound != 0){
                                            access2=true;
                                            break;
                                        }
                                    }
                                }
                                break;
                            default:
                                access= true;
                                break;
                        }
                        access = true;
                        break;      
                    }
                    break;
                case 1:
                    String studentCode = JOptionPane.showInputDialog(null, "Please enter your student code");
                    var student = accessValidator.verifyStudentAccess(studentCode);
                    if(student != null){
                        String[] studentOptions = {"List of your scores", "Exit"};
                        int studentSelection = JOptionPane.showOptionDialog(null, "Welcome "+ student.getName() +"\n please select one option", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, studentOptions, studentOptions[0]);                   
                        switch(studentSelection){
                            case 0:
                                menuOption.setCommand(new DisplayCommand(display));
                                menuOption.showScoreSelected(student.getSubjects());
                                break;
                        }
                        access = true;
                        break;
                    }
                default:
                    access = true;
                    break;
            }
        }   
     }
}
