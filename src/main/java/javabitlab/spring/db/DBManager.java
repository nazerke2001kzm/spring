package javabitlab.spring.db;

import javabitlab.spring.models.Student;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    public static List<Student> students = new ArrayList<>();
    private static Long id = 5L;
    static {
        students.add(new Student(1L,"Nazerke","Sapargali",49,"F"));
        students.add(new Student(2L,"Nazerke","Sapargali",40,"F"));
        students.add(new Student(3L,"Nazerke","Sapargali",90,"A"));
        students.add(Student.builder().id(4L).name("Nazerke").surname("Sapargali").exam(77).mark("B").build());
    }
    public static List<Student> getStudents(){
        return students;
    }
    public static Student getStudentsById(Long id){
        for(Student student:students){
            if(student.getId()==id){
                return student;
            }
        }
        return null;
    }
    public static void addStudent(Student student){
        student.setId(id);
        students.add(student);
        id++;
    }
}
