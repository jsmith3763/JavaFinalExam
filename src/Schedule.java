/*
 * class Schedule provides constructor for creating a Schedule object
 *
 * */
public class Schedule  {
    String studentID;
    String course;


    //constructor for Schedule
    public Schedule(String studentID, String course) {
        this.studentID = studentID;
        this.course = course;

    }


    // toString method to print a student's schedule in desired format
    public String toString() {
        return studentID + " " + course;
    }

}
