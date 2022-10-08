package services;

import models.Student;
import models.Teacher;
import repositories.StudentRepository;
import repositories.TeacherRepository;

public class AccessValidator {
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    public AccessValidator(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = new TeacherRepository();
    }

    public Student verifyStudentAccess(String code) {
        System.out.println("size: " + this.studentRepository.getAllStudents().size());
        return this.studentRepository.getStudentByCode(code);
    }

    public Teacher verifyTeacherAccess(String code) {
        System.out.println("verify teacher");
        return this.teacherRepository.getTeacherByCode(code);
    }
}
