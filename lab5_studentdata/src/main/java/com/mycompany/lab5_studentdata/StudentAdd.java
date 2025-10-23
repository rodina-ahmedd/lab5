/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_studentdata;

/**
 *
 * @author YOUSSEF FATHY
 */




import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class StudentAdd {
        private static final String FILENAME = "student.txt";

    public static void addStudent(StudentData student) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
            writer.write(student.Save());
            writer.newLine();
        } 
    }
    public static ArrayList<StudentData> loadStudentsFromFile() throws IOException {
        ArrayList<StudentData> students = new ArrayList<>();
         try (FileReader fileReader = new FileReader(FILENAME);
        BufferedReader bufferedReader = new BufferedReader(fileReader)){
        
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split(",");
            
            if (parts.length == 6) {
                
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String gender = parts[3];
                String DP = parts[4];
                double gpa = Double.parseDouble(parts[5]);
                
                
                students.add(new StudentData(id, name, age, gender, DP, gpa));
            }
        }
        
    }
       
        
        
        return students;
    }
    
}
