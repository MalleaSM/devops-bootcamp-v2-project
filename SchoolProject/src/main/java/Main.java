import models.School;
import repositories.StudentRepository;
import services.AccessValidator;
import services.ReadDataService;
import services.WriteDataService;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        StudentRepository studentRepository = new StudentRepository();

        ReadDataService readDataService = new ReadDataService();
       
        var students = readDataService.readStudentsDataFromJson();

        WriteDataService writeDataService = new WriteDataService(studentRepository);
        writeDataService.writeStudentsDataToRepository(students);

        Scanner scanner = new Scanner(System.in);
        var school = new School("American School");

        System.out.println("=============================");
        System.out.println("Welcome to " + school.getName());
        System.out.println("=============================");

        System.out.println("Select your role please: ");
        System.out.println("1. Teacher");
        System.out.println("2. Student");

        String option = scanner.nextLine();
        boolean access = false;

        while (!access) {
            System.out.println("Please enter your code");
            AccessValidator accessValidator = new AccessValidator(studentRepository);

            String code = scanner.nextLine();

            switch (option) {
                case "1":
                    var teacher = accessValidator.verifyTeacherAccess(code);
                    if (teacher != null) {
                        access = true;
                        break;
                    }
                case "2":
                    var student = accessValidator.verifyStudentAccess(code);
                    if (student != null) {
                        access = true;
                        break;
                    }
            }
        }
    }
}
