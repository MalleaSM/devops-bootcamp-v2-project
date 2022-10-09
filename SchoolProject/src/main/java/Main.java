import models.Display;
import models.School;
import repositories.StudentRepository;
import repositories.TeacherRepository;
import services.AccessValidator;
import services.ReadDataService;
import services.WriteDataService;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import helpers.Grade;

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

        Scanner scanner = new Scanner(System.in);
        var school = new School("American School");

       

        // StudentMenuManager studentOption = new StudentMenuManager();
        // MenuManager menuOption = new MenuManager();
        // Display display = new Display();
        // System.out.println("=============================");
        // System.out.println("Welcome to " + school.getName());
        // System.out.println("=============================");

        // System.out.println("Select your role please: ");
        // System.out.println("1. Teacher");
        // System.out.println("2. Student");

        // String option = scanner.nextLine();
        // boolean access = false;

        // while (!access) {
        //     System.out.println("Please enter your code");
        //     AccessValidator accessValidator = new AccessValidator(studentRepository,teacherRepository);

        //     String code = scanner.nextLine();

        //     switch (option) {
        //         case "1":
        //             var teacher = accessValidator.verifyTeacherAccess(code);
        //             if (teacher != null) {
        //                 System.out.println("=============================");
        //                 System.out.println("Welcome\t"+ teacher.getName());
        //                 System.out.println("=============================");

        //                 System.out.println("Select your option: ");
        //                 System.out.println("1. List of Students by grade");
        //                 System.out.println("2. Enter a score for a student");
        //                 System.out.println("3. Exit");

        //                 String option2 = scanner.nextLine();
        //                 switch(option2){
        //                     case "1":
        //                     var sbg = studentRepository.getStudentsByGrade(Grade.ELEMENTARY_SCHOOL.toString());
        //                     menuOption.setCommand(new DisplayCommand(display));
        //                     menuOption.showStudentByGrade(sbg,Grade.ELEMENTARY_SCHOOL.toString());
        //                     break;

        //                     case "2":
        //                     System.out.println("Please enter the student code");
        //                     String studentCode = scanner.nextLine();
        //                     var student = accessValidator.verifyStudentAccess(studentCode);
        //                     student.setScore("A", teacher.getSubject());
        //                     break;
        //                     }
        //                     access = true;
        //                     break;       
        //             }
        //         case "2":
        //             var student = accessValidator.verifyStudentAccess(code);
        //             if (student != null) {
                        
        //                 System.out.println("=============================");
        //                 System.out.println("Welcome\t"+ student.getName());
        //                 System.out.println("=============================");

        //                 System.out.println("Select your option: ");
        //                 System.out.println("1. Check Scores");
        //                 System.out.println("2. Exit");

        //                 String option2 = scanner.nextLine();

        //                 switch(option2){
        //                     case "1":
        //                     menuOption.setCommand(new DisplayCommand(display));
        //                     menuOption.showScoreSelected(student.getSubjects());
        //                     default:
        //                     break;
        //                 }
        //                 access = true;
        //                 break;
        //         }
        //     }
        // }
     }
}
