/*
* super class Person
* */
public class Person {
    String id;
    String name;

    //constructor for a Person
    public Person(String name, String id){
        this.id = id;
        this.name = name;
    }

    //toString method for printing out a person's information in desired format
    public String toString() {
        return name +" " + id;
    }
}
