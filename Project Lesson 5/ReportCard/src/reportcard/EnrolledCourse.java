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
public class EnrolledCourse {
    
    private String Name;
    private String Teacher;
    private String Classroom;
    private String Schedule;

    // Contructor function
    public EnrolledCourse(){
        this.Name = "Undefined Name";
        this.Teacher =  "Undefined Teacher";
        this.Classroom = "Undefined Classroom";
        this.Schedule = "Undefined Schedule";
    }
    
    // Contructor function
    public EnrolledCourse(String Name, String Teacher, String Classroom, 
            String Schedule){
        this.Name = Name;
        this.Teacher =  Teacher;
        this.Classroom = Classroom;
        this.Schedule = Schedule;
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
     * @return the Teacher
     */
    public String getTeacher() {
        return Teacher;
    }

    /**
     * @param Teacher the Teacher to set
     */
    public void setTeacher(String Teacher) {
        this.Teacher = Teacher;
    }

    /**
     * @return the Classroom
     */
    public String getClassroom() {
        return Classroom;
    }

    /**
     * @param Classroom the Classroom to set
     */
    public void setClassroom(String Classroom) {
        this.Classroom = Classroom;
    }

    /**
     * @return the Schedule
     */
    public String getSchedule() {
        return Schedule;
    }

    /**
     * @param Schedule the Schedule to set
     */
    public void setSchedule(String Schedule) {
        this.Schedule = Schedule;
    }
    
    /**
     * Print  Course Report Card Information
     * @return outResult
     */
    @Override
    public String toString(){
        String outResult = "";
        
        outResult = outResult + "    Course's Name: " + getName() + "\n";
        outResult = outResult + "    Course's Teacher: " + getTeacher() + "\n";
        outResult = outResult + "    Course's Classroom: " + getClassroom() + "\n";
        outResult = outResult + "    Course's Schedule: " + getSchedule() + "\n";
        
        return outResult;
    }
}
