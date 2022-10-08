package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Student;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadDataService {
    public ReadDataService() {}

    public List<Student> readStudentsDataFromJson() {
        List<Student> students = null;
                
        try {
            Gson gson = new Gson();
            // var path = (Paths.get("students.json"));
            // System.out.println(path);
            Reader reader = Files.newBufferedReader(Paths.get("SchoolProject/src/main/resources/students.json"));

            students = gson.fromJson(reader, new TypeToken<List<Student>>() {}.getType());
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }
}
