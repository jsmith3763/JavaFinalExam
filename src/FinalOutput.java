/*
* FinalOutput is the class where we implement all information and classes/methods found in the final exam project
* */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.io.FileReader;

import java.util.ArrayList;


public class FinalOutput {

    //create lists for various objects we will be creating and storing
    static ArrayList<Student> studentList = new ArrayList<Student>();
    static ArrayList<Professor> professorList = new ArrayList<>();
    static ArrayList<Course> courseList = new ArrayList<>();
    static ArrayList<Schedule> scheduleList = new ArrayList<>();


    public static void main(String[] args) {

        ArrayList<String> lines = new ArrayList<String>();


        try {
            //creates our files we will be reading from and user can input data

            /*PrintWriter fRoster = new PrintWriter("FinalRoster.txt");
            PrintWriter fStudentClassList = new PrintWriter("FinalStudentClassList.txt");
            PrintWriter fClass = new PrintWriter("FinalClassList.txt");*/

            //allows us to read from FinalRoster.txt
            FileReader finalRoster = new FileReader("FinalRoster.txt");
            Scanner fr = new Scanner(finalRoster);
            fr.useDelimiter(",");

            //reads through entire FinalRoster.txt and assigns values to Strings to make an object
            while (fr.hasNext()) {

                String line = fr.nextLine();
                lines.add(line);
                String[] strings = line.split(",");


                String name = strings[1];
                String id = strings[2];

                //creates and determines if a object is a professor or student and puts object in correct list
                if (strings.length == 4) {
                    String edu = strings[3];
                    professorList.add(new Professor(name, id, edu));

                } else studentList.add(new Student(name, id));

            }
        //throws exception error if file we are trying to read is not found
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }


        try {
            //allows us to read from FinalClassList.txt
            FileReader finalClassList = new FileReader("FinalClassList.txt");
            Scanner fcl = new Scanner(finalClassList);
            fcl.useDelimiter(",");
            //reads through entire FinalClassList.txt and assigns values to Strings to make an object
            while (fcl.hasNext()) {

                String line = fcl.nextLine();
                lines.add(line);
                String[] strings = line.split(",");

                String course = strings[0];
                String courseTitle = strings[1];
                String professorID = strings[2];
                //creates and adds courses to our courseList
                courseList.add(new Course(course, courseTitle, professorID));


            }
            //throws exception error if file we are trying to read is not found
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }


        try {
            //allows us to read from FinalStudentClassList.txt
            FileReader finalStudentCL = new FileReader("FinalStudentClassList.txt");
            Scanner fscl = new Scanner(finalStudentCL);
            fscl.useDelimiter(",");
            //reads through entire FinalStudentClassList.txt and assigns values to Strings to make a schedule object
            while (fscl.hasNext()) {

                String line = fscl.nextLine();
                lines.add(line);
                String[] strings = line.split(",");

                String studentID = strings[0];
                String course = strings[1];

                //creates and adds schedules to our scheduleList
                scheduleList.add(new Schedule(studentID, course));


            }
            //throws exception error if file we are trying to read is not found
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        try {
            //creates and allows us to write to FinalOutput.txt
            //FinalOutput.txt includes a students info and class schedule along with which professor teaches the class
            //also the professor's education level
            PrintWriter fOutput = new PrintWriter("FinalOutput.txt");

            //we compare arrayLists of objects and add info to FinalOutput.txt from those arrayLists
            for(int i= 0; i < studentList.size(); i++) {

                fOutput.printf("%s - %s %n", studentList.get(i).name, studentList.get(i).id);
                System.out.println(studentList.get(i).name + " - " + studentList.get(i).id);

                    for (int j = 0; j < scheduleList.size(); j++) {
                        if (scheduleList.get(j).studentID.equals(studentList.get(i).id)) {
                            fOutput.printf("%s ", scheduleList.get(j).course);
                            System.out.print(scheduleList.get(j).course + " ");


                            for (int x = 0; x < courseList.size(); x++) {
                                if (courseList.get(x).course.equals(scheduleList.get(j).course)) {
                                    fOutput.printf("%s ", courseList.get(x).courseTitle);
                                    System.out.print(courseList.get(x).courseTitle + " ");

                                    for (int y = 0; y < professorList.size(); y++) {
                                        if (professorList.get(y).id.equals(courseList.get(x).professorID)) {
                                            fOutput.printf("%s %s %n", professorList.get(y).name, professorList.get(y).highestEd);
                                            System.out.print(professorList.get(y).name + " " + professorList.get(y).highestEd + "\n");
                                        }
                                    }
                                }
                            }
                        }
                    }
                    fOutput.printf("%n");
                    System.out.print("\n");

                }
            System.out.println("Students at bottom with no classes still need to enroll");
            fOutput.printf("Students at bottom with no classes still need to enroll");




            fOutput.close();
                //throws exception error if we did not create file successfully
        } catch (FileNotFoundException e) {
            System.out.println("File not created!" + e.getMessage());
            e.printStackTrace();


        }

    }
}




