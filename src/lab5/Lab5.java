/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab5;

import Backend.StudentDataBase;
import Controller.Controller;


public class Lab5 {
    
    private static Controller control ;

    public static void main(String[] args) {
      StudentDataBase Data  = new StudentDataBase();
      
      control = new Controller(Data);
       
    }
    
    public static Controller getController(){
        return control;
    }
}
