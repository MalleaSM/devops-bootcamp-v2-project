package services;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import models.Student;
import models.Subject;
import models.Teacher;

import com.google.gson.JsonArray;

import java.io.File;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;

public class ReadDataService {
    public ReadDataService() {}

    public List<Teacher> getTeachersJsonData() {
        List<Teacher> teachers = new ArrayList<>();
        File data = new File("SchoolProject/src/main/resources/teachers.json"); 
                
        try {
            JsonElement jsonData = JsonParser.parseReader(new FileReader(data));
            JsonArray jsonObject = jsonData.getAsJsonArray();

            for (JsonElement jsonElement : jsonObject) {

                JsonObject teacherData = jsonElement.getAsJsonObject();
                String code = teacherData.get("code").getAsString();
                String name = teacherData.get("name").getAsString();
                String subject =  teacherData.get("subject").getAsString();
                Teacher teacher = new Teacher(code, name, subject);
                teachers.add(teacher);
            }

        }
        catch (Exception e) {
            System.err.println("Error reading teachers json file");
        }

        return teachers;
    }

    public List<Student> getStudentJsonData(){
        File data = new File("SchoolProject/src/main/resources/students.json"); 
        List<Student> students = new ArrayList<>();
        try {
            JsonElement jsonData = JsonParser.parseReader(new FileReader(data));
            JsonArray jsonObject = jsonData.getAsJsonArray();
            
            for (JsonElement jsonElement : jsonObject) {

                JsonObject studentData = jsonElement.getAsJsonObject();
                String code = studentData.get("code").getAsString();
                String name = studentData.get("name").getAsString();
                String grade =  studentData.get("grade").getAsString();
                int age = studentData.get("age").getAsInt();
    
                JsonArray subjectArray = studentData.get("subjects").getAsJsonArray();
                List<Subject> subjects = new ArrayList<>()  ;
                for(JsonElement subelement: subjectArray){
                    
                    JsonObject subdata = subelement.getAsJsonObject();
                    String subname = subdata.get("subject").getAsString();
                    String score = subdata.get("score").getAsString();

                    Subject subject =  new Subject(subname,score);
                    subjects.add(subject);
                }
                Student student = new Student(code,name,age,grade,subjects);
                students.add(student);
            }

        } catch (Exception e) {   
            System.err.println("Error reading student json file");
        }
        return students;
    }
}
