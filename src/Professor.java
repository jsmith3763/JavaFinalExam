/*
* class Professor provides constructor for creating a Professor object
* inherits from super class person
* */
public class Professor extends Person {
    String highestEd;

    //constructor for professor
    public Professor(String name, String id, String educationLevel) {
        super(name, id);
        this.highestEd = educationLevel;
    }


   // toString to print all of a Professor's information in desired format
    public String toString() {
        return "P " + super.toString() +" "+ highestEd;
    }

}
