package it.develhope.Servizi.Email1.student.service;

import it.develhope.Servizi.Email1.student.entity.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    List<Student> studentList = Arrays.asList(
            new Student("1","Emilio","Fagiani","rugdece85@gmail.com"),
            new Student("2","Ricki","Morty","rickmor@gmail.com"),
            new Student("3","Angelo","Verdi","AngVer@gmail.com"),
            new Student("4","Matteo","Marnalo","mama@gmail.com")
    );


    public Student getStudentById(String studentId){
        Optional<Student> students = studentList.stream().filter(student -> student.getId().equals(studentId)).findAny();
        if (students.isPresent()){
            return students.get();
        }else
            return null;
    }
}
