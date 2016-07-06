/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcard;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chengi
 */
public class ReportCard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Student> Students = new ArrayList<>();
        
        // Set Information for Student One
        Student Student_One = new Student("Oscar", "Saborio");
        
        CourseReportCard Chemistry= new CourseReportCard("Chemistry", "Laura Vasquez", "F9-10", "M 7-9 am");
        Chemistry.setGrade(80);
        
        CourseReportCard Spanish= new CourseReportCard("Spanish", "William Fallas", "B2-02", "T,W 1-3 pm");
        Spanish.setGrade(80);
        
        CourseReportCard Physics= new CourseReportCard("Physics", "Carolina Vargas", "B1-09", "F 10-12 am");
        Physics.setGrade(80);
        
        CourseReportCard Math= new CourseReportCard("Math", "Laura Vasquez", "F9-10", "M 4-6 pm");
        Math.setGrade(80);
        
        Student_One.addCourse(Chemistry);
        Student_One.addCourse(Spanish);
        Student_One.addCourse(Physics);
        Student_One.addCourse(Math);
        
        Students.add(Student_One);
        
        // Set Information for Student Two
        Student Student_Two = new Student("Gia", "Chen");

        Chemistry.setGrade(85);
        Spanish.setGrade(70);
        Physics.setGrade(95);
        Math.setGrade(90);
        
        Student_Two.addCourse(Chemistry);
        Student_Two.addCourse(Spanish);
        Student_Two.addCourse(Physics);
        Student_Two.addCourse(Math);
        
        Students.add(Student_Two);
        
        /**
         * Print Report Card of all the students
         */
        for (int i =0; i < Students.size(); i ++){
            System.out.println(Students.get(i).toString());
        }       
    }
}
