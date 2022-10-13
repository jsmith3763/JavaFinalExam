/*
 * class Student provides constructor for creating a Student object
 * inherits from super class person
 * */
public class Student extends Person {

    //constructor for  Student
    public Student(String name, String id) {

        super(name, id);

    }


     // toString method to print all of a student information in desired format
    public String toString() {
        return "S " + super.toString();
    }

}
