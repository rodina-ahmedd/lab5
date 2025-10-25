
package Backend;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class StudentDataBase {
     
    
    private final int id;
    private String name;
    private int age;
    private final String gender;
    private String DP; 
    private double gpa;
 
    
    public StudentDataBase (int id, String name, int age, String gender, String DP, double gpa) {
        
        
        
        if (String.valueOf(id).length() != 4) {
            throw new IllegalArgumentException("ID must be 4 digits.");
        }
        if (!name.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("Name must be alphabet only.");
        }
        if (age < 17 || age > 25) {
            throw new IllegalArgumentException("Age must be between 17-25.");
        }
        if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
            throw new IllegalArgumentException("Gender must be Male or Female.");
        }
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0-4.0.");
        }
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
    
    public String toTableFormat() {
        return String.format("%-5d %-20s %-3d %-7s %-15s %.2f", 
                           id,name, age, gender, DP, gpa);
    }
    
    public void setName(String name){
        
        if (!name.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("Name must be alphabet only.");
        }
        
        this.name = name;
    }
    
    public void setAge(int age) {
       
        if (age < 17 || age > 25) {
            throw new IllegalArgumentException("Age must be between 17-25.");
        }

        this.age = age;
    }
    
   
    public void setDepartment(String DP) {
        this.DP = DP;
    }
    
    public void setGPA(double gpa) {
        
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0-4.0.");
        }
        
        this.gpa = gpa;
    }
}


