/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcard;

/**
 *
 * @author chengi
 */
public class CourseReportCard extends EnrolledCourse{
    
    // Attributes
    private int Grade;

    public CourseReportCard(){
        super();
        Grade = 0;        
    }
    
    public CourseReportCard(String Name, String Teacher, String Classroom, 
            String Schedule){
        super(Name, Teacher, Classroom, Schedule);
        Grade = 0;        
    }
    
    /**
     * @return the Grade
     */
    public int getGrade() {
        return Grade;
    }

    /**
     * @param Grade the Grade to set
     */
    public void setGrade(int Grade) {
        this.Grade = Grade;
    }
    /**
     * Print  Course Report Card Information
     * @return outResult
     */
    @Override
    public String toString(){
        String outResult = "";
        
        outResult = outResult + super.toString();
        outResult = outResult +"    Course's Grade: " + getGrade() + "\n"; 
        outResult = outResult + "\n";
        
        return outResult;
    }
    
}
