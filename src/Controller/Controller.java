/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Backend.Student;
import Backend.StudentDataBase;
import java.util.List;

public class Controller {

    private StudentDataBase Data;

    public Controller(StudentDataBase Data) {
        this.Data = Data;
    }

    public List<Student> getAllStudents() {
        return Data.loadStudentsFromFile();
    }

    public Student searchById(int id) {
        return Dara.getById(id);
    }

    public Student searchByName(String name) {
        return Data.getByName(name);
    }

    public void addStudent(String name, int age, String gender, String department, double gpa) {
        int id = Data.generateId();
        Student s = new Student(id, name, age, gender, name, gpa);
    }

    public boolean updateStudent(int id, String name, int age, String gender, String department, double gpa) {
        Student S = Data.getById(id);
        if (S == null) {
            return false;
        }
        S.setName(name);
        S.setAge(age);
        S.setGender(gender);
        S.setDP(department);
        S.setGpa(gpa);
        Data.updateStudent(S);
        return true;
    }
    
     public boolean deleteStudent(int id) {
        return Data.deleteStudent(id);
    }
}
