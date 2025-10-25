
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
    
    public void updateStudent(int id , String name , int age , String DP , double gpa) throws IOException
    {
        StudentDataBase found = null ; 
        for (StudentDataBase std : students)
        {
            
         if(std.getID()==id){
             found = std ; 
             break ;
         }
         
        }
        
        if(found==null)
            System.out.print("NO STUDENT WITH SUCH ID IS FOUND");
        else {
            found.setName(name);
            found.setAge(age);
            found.setDepartment(DP);
            found.setGPA(gpa);
    
        saveStudentsToFile(FILENAME);
        System.out.print("Student updated successfully");
        }
        
    }
    
    public void DeleteStudent(int id) throws IOException
    {
        StudentDataBase found = null ;
         for (StudentDataBase std : students)
        {
            
         if(std.getID()==id){
             found = std ; 
             break ;
         }
        }
         
         if(found==null)
            System.out.print("NO STUDENT WITH SUCH ID IS FOUND");
        else {
            students.remove(found);
    
        saveStudentsToFile(FILENAME);
        System.out.print("Student removed successfully");
        }
         
    }
         
    
    public ArrayList<StudentDataBase> search(String key)
    {
     ArrayList<StudentDataBase> result = new ArrayList<>(); 
     
     for (StudentDataBase stu : students)
     {
         if(key==stu.getName()||Integer.parseInt(key)==stu.getID())
         {
             result.add(stu);
         }
     }
     
     return result ; 
    }
    
    public void DisplaySearchresults(String key)
    {
        ArrayList<StudentDataBase> result = search (key);
        if(result.isEmpty()){
            System.out.print("No found student with search key : "+ key);
            return;
                    }
        else {
             for (StudentDataBase student : result) {
            System.out.println(student.toTableFormat());
        }
        System.out.println("Found: " + result.size() + " students");
        
        }
        
        
    }
 
         
         
        
        
    
    
    private void saveStudentsToFile(String FILENAME) throws IOException
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME,true))){
            
           for(StudentDataBase st : students)
           {
               bw.write(st.Save());
               bw.newLine();
           }
            
        }
        
        catch(IOException e){
            System.out.print("ERROR IN SAVING FILES");
        }
         }
    
  
}
