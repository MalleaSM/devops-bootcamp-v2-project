package services;

import models.Student;
import models.Teacher;
import repositories.StudentRepository;
import repositories.TeacherRepository;

public class AccessValidator {
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    public AccessValidator(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    public Student verifyStudentAccess(String code) {
        return this.studentRepository.getStudentByCode(code);
    }

    public Teacher verifyTeacherAccess(String code) {
        return this.teacherRepository.getTeacherByCode(code);
    }
}
