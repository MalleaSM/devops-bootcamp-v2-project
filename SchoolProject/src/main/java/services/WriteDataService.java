package services;

import models.Student;
import models.Teacher;
import repositories.StudentRepository;
import repositories.TeacherRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WriteDataService {
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    public WriteDataService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public WriteDataService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void writeStudentsDataToRepository(List<Student> students) {
        students.forEach(student -> this.studentRepository.addStudent(student));
    }
    public void writeTeacherDataToRepository(List<Teacher> teachers) {
        teachers.forEach(teacher -> this.teacherRepository.addTeacher(teacher));
    }

    public void updateJson(List<Student> students){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            
            Writer writer = new FileWriter("SchoolProject/src/main/resources/students.json");
            gson.toJson(students, writer);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
