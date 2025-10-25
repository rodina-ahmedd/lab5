
package Backend;





import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class Student {
    
    private static final String FILENAME = "student.txt";
    private ArrayList<StudentDataBase> students;
    
    public Student() throws IOException
    {
      this.students=loadStudentsFromFile();
    }
    
    public  void addStudent(StudentDataBase student) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
            writer.write(student.Save());
            writer.newLine();
        } 
    }
    
    
    private  ArrayList<StudentDataBase> loadStudentsFromFile() throws IOException {
        ArrayList<StudentDataBase> students = new ArrayList<>();
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
                
                
                students.add(new StudentDataBase(id, name, age, gender, DP, gpa));
            }
        }
        
    }
         
        
       
        
        
        return students;
    }
    
  
}
