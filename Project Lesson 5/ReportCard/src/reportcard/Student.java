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
public class Student {
    
    // Student Attributes
    private String Name;
    private String LastName;
    private List<CourseReportCard> Courses;
    
    // Constructor Function
    public Student(){
        Name = "Undefined Name";
        LastName = "Undefined LastName";
        Courses = new ArrayList<>();
    }
    
     // Constructor Function
    public Student(String Name, String LastName){
        this.Name = Name;
        this.LastName = LastName;
        Courses = new ArrayList<>();
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * @return the Courses
     */
    public List<CourseReportCard> getCourses() {
        return Courses;
    }

    /**
     * @param Courses the Courses to set
     */
    public void setCourses(List<CourseReportCard> Courses) {
        this.Courses = Courses;
    }
    
    /**
     * Add course to the array
     * @param course 
     */
    public void addCourse(CourseReportCard course){
        this.Courses.add(course);
    }
    
    /**
     * Remove course in the array
     * @param course 
     */
    public void removeCourse(CourseReportCard course){
        this.Courses.add(course);
    }
    
    /**
     * toString function
     * @return outResult
     */
    @Override
    public String toString(){
        
        String outResult = "";
        outResult = outResult + "Student's Name: " + getName() + "\n";
        outResult = outResult + "Student's LastName: " + getLastName() + "\n";
        outResult = outResult +  "Student's Grades: " + "\n";
        
        for (int i =0; i < getCourses().size(); i++){
            outResult = outResult + getCourses().get(i).toString();
        }
        
        return outResult;
    }
}
