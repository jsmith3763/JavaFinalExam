/*
 * class Courses provides constructor for creating a course object
 *
 * */
public class Course  {
    String course;
    String courseTitle;
    String professorID;

    //constructor to create a course
    public Course(String course, String courseTitle, String professorID) {
        this.course = course;
        this.courseTitle = courseTitle;
        this.professorID = professorID;
    }


    // toString method to print all of a course information in desired format
    public String toString() {
        return course + " " + courseTitle + " " + professorID;
    }

}
