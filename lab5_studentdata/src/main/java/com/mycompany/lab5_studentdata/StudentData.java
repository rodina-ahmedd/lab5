/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab5_studentdata;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/**
 *
 * @author YOUSSEF FATHY
 */

public class StudentData {
    
    
    private int id;
    private String name;
    private int age;
    private String gender;
    private String DP; 
    private double gpa;
 
    
    public StudentData(int id, String name, int age, String gender, String DP, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.DP = DP;
        this.gpa = gpa;
    }


    public int getID() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getDepartment() { return DP; }
    public double getGPA() { return gpa; }

    
    public String Save() {
        return id + "," + name + "," + age + "," + gender + "," + DP + "," + gpa  ;
    }
}


