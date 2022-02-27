package projectPhase_2;

import java.util.Arrays;
import java.util.HashMap;


public class Faculty extends Admin {


    static int studentMail = 100;
    static String [][] submitAss  = new String[studentMail][5];

    static boolean True;
    static boolean False;
    //static boolean result;
    static String output;

    // all courses created- course code and course name
    static HashMap<String, String> TotalCourseInfo = new HashMap<>();

    //course creator: course code and name
    static HashMap<String, String> courseCreator = new HashMap<>();

    // course creator : course code and email
    static HashMap<String, String> courseCreatorEmail = new HashMap<>();

    // courses student register for  :   email  and course code
    static HashMap<String, String> courseRegistration = new HashMap<>();

    // courses student register for  : course code and name
    static HashMap<String, String> registeredCoursesStudentsName = new HashMap<>();
    // add assignment
    static String [][] Addassignment  = new String[studentMail][5];

   // static String [][] submitAss  = new String[studentMail][5];

    static String[][]  allregisteredCoursenames  = new String [studentMail][3];

    // grade assignment
    public static String gradeScore( double  score ){
        if (score >= 85 && score  <= 100 ){
            System.out.println("A+");
            return "A+" ;
        }
        else if (score >=80 && score <= 84 ){
            System.out.println("A");
            return "A" ;
        }
        else if (score >=75 && score <= 79 ){
            System.out.println("B+");
            return "B+" ;
        }
        else if (score >=70 && score <= 74 ){
            System.out.println("B");
            return "B" ;
        }
        else if (score >=65 && score <= 69 ){
            System.out.println("C+");
            return "C+" ;
        }
        else if (score >=60 && score <= 64 ){
            System.out.println("C");
            return "C" ;
        }
        else if (score >=55 && score <= 59 ){
            System.out.println("D+");
            return "D+" ;
        }
        else if (score >=50 && score <= 54 ){
            System.out.println("D");
            return "D" ;
        }
        else if (score <= 49 ){
            System.out.println("E");
            return "E" ;
        }

        else {  System.out.println("no score "); return "no score";}
    }

    private  static String  isFaculty(String Email){
        output=facultyEmail.contains(Email)  ? "True": "False";
        System.out.println(output);
        return output;
    }


    // view all  assignment grade
    private  static void  viewAssignmentGrades (String email, String password, String courseCode, String AssignmentName){
        boolean Fa_culty = isFaculty(email).equals("True");
        boolean creatorOfCourse = isCourseCreator(email,courseCode)==True;
        boolean login = facultyLogin(email,password).equals("True");

        if( Fa_culty &&  creatorOfCourse && login) {

            for (int i = 0; i < allregisteredCoursenames.length; i++) {
                for (int s = 0; s < submitAss.length; s++) {

                    // those who have submitted assignment
                    if ( submitAss[s][1].equals(courseCode) && submitAss[s][0].equals(AssignmentName) && submitAss[s][4] !=null ) {
                        try {
                            System.out.println("--------- students with scored assignment  are ------------ ");
                            System.out.println(" Student email is " + submitAss[s][3]);
                            System.out.println(" Student score is " + submitAss[s][4]);
                            System.out.println("Assignment Grade " + gradeScore(Double.parseDouble(submitAss[s][4])));
                            System.out.println(" --------------------------");

                        } catch (Exception e) {
                            System.out.println("Sorry try again");
                        }
                    }
                    // students with no scores yet
                    else if (submitAss[s][1].equals(courseCode) && submitAss[s][0].equals(AssignmentName) && submitAss[s][4] ==null) {
                        System.out.println("--------- students with no score for  submitted  assignments  ------------ ");
                        System.out.println(" Student email is " + submitAss[s][0]);
                        System.out.println(" Student score pending");
                        System.out.println(" --------------------------");

                    }
                }
            }
        }

        else {
            System.out.println("Sorry check whether you've logged in or you are the course creator");

        }

    }

    // display all created courses
    private static void viewCourse() {

        for (String s : TotalCourseInfo.keySet() ){
            System.out.println("Course Code: "+ s);
            System.out.println("courseInstructor Name: "+ courseCreator.get(s));
            System.out.println("courseInstructor Email: "+ courseCreatorEmail.get(s));

            for (String i : TotalCourseInfo.values() ){
                System.out.println("Course Name: "+ i);


            }
        }


    }


    // view submissions
    private  static void  viewSubmissions (String email, String password, String courseCode, String AssignmentName, String stdemail){
        boolean Faculty = isFaculty(email).equals("True");
        boolean creatorOfCourse = isCourseCreator(email,courseCode)==True;
        boolean login = facultyLogin(email,password).equals("True");

        if( Faculty &&  creatorOfCourse && login) {

            for (int i = 0; i < allregisteredCoursenames.length; i++) {
                for (int s = 0; s < submitAss.length; s++) {

                    // those who have submitted assignment
                    if ( submitAss[s][1].equals(courseCode) && submitAss[s][0].equals(AssignmentName)  ) {
                        try {
                            System.out.println("--------- students who have submitted their assignments are ------------ ");
                            System.out.println(" Student email is " + submitAss[s][3]);

                        } catch (Exception e) {
                            System.out.println("Sorry try again");
                        }
                    }
                    // those who have not  submitted assignment
                    else if (allregisteredCoursenames[i][0].equals(stdemail) &&  Arrays.asList(submitAss).contains(stdemail)== False) {
                        System.out.println("--------- students who have not  submitted their assignments are ------------ ");
                        System.out.println(" Student with  email " + allregisteredCoursenames[i][0] + " No submission ");

                    }
                }
            }
        }

        else {
            System.out.println("Sorry check whether you've logged in or you are the course creator");

        }

    }


    // add assignment
    private  static void  addAssignment (String email, String password, String courseCode, String AssignmentName,  String AssigmentDescription,String dueDate, String AssinmentType){
        boolean isFaculty = isFaculty(email).equals("True");
        boolean iscreatorOfCourse = isCourseCreator(email,courseCode)==True;
        boolean Flogin = facultyLogin(email,password).equals("True");

        if( isFaculty &&  iscreatorOfCourse && Flogin){

            for ( int i = 0; i< Addassignment.length; i++ ){
                try{
                    Addassignment [i][0] = courseCode;
                    Addassignment [i][1] =AssignmentName;
                    Addassignment [i][2] = AssigmentDescription;
                    Addassignment [i][3] = dueDate;
                    Addassignment [i][4] = AssinmentType;

                    System.out.println("Assignment added to course successfully");

                }

                catch (Exception e){
                    System.out.println("Sorry, please try again");

                }

            }

        }

        else {
            System.out.println("Sorry check whether you have logged in or you are the course creator");

        }

    }

    // is course creator
    private static boolean isCourseCreator(String email , String courseCode) {
        for (String c : courseCreatorEmail.keySet()) {
            if (courseCreatorEmail.get(c).equals(courseCode) && c.equals(email)) {
                try {
                    System.out.println(" is the course creator ");
                    return True;

                } catch (Exception e) {
                    System.out.println("Sorry cannot verify the creator of the course. Try again ");
                    return False;
                }

            } else {
                System.out.println(" Not a creator of the course ");

            }
        }
        return False;
    }


    // view course by email
    private static void viewCourseByEmail(String email){

        for (int i = 0; i <  allregisteredCoursenames.length; i++) {
            if (email.equals(allregisteredCoursenames [i][0])) {
                try {
                    System.out.println("Registered course code is " + allregisteredCoursenames[i][1]);
                    System.out.println("Registered course name  is " + allregisteredCoursenames[i][2]);
                } catch (Exception e) {
                    System.out.println("Sorry could not retrieve user course info. Try again ");

                }
            } else {
                System.out.println("Course details do not exist for the user");
            }

        }

    }
    private static String facultyLogin(String Email, String Password) {

        for (int i = 0; i < facultyEmail.size(); i++) {
            output = (facultyEmail.contains(Email) && facultyPassword.contains(Password)) ? "True" : "False";

        }
        //System.out.println("login is "+ output);
        return output;

    }


    private static void createCourse(String email, String password,String courseCode, String courseName, String Instructorname) {
        if (isFaculty(email).equals("True") && facultyLogin(email, password).equals("True")) {
            if (!(TotalCourseInfo.containsKey(courseCode))){
                TotalCourseInfo.put(courseCode,courseName);
                courseCreator.put(courseCode,Instructorname);
                courseCreatorEmail.put(courseCode,email);

                System.out.println("Course created successfully");

            }

            else{
                System.out.println("Course creation failed");
            }

        }
        else {
            System.out.println("Sorry dont have the permission to create a course");

        }

    }
    // view assignment scores
    private  static void  viewAssignmentScores (String email, String password, String courseCode, String AssignmentName){
        boolean Fa_culty = isFaculty(email).equals("True");
        boolean creatorOfCourse = isCourseCreator(email,courseCode)==True;
        boolean login = facultyLogin(email,password).equals("True");

        if( Fa_culty &&  creatorOfCourse && login) {

            for (int i = 0; i < allregisteredCoursenames.length; i++) {
                for (int s = 0; s < submitAss.length; s++) {

                    // those who have submitted assignment
                    if ( submitAss[s][1].equals(courseCode) && submitAss[s][0].equals(AssignmentName) && submitAss[s][4] !=null ) {
                        try {
                            System.out.println("--------- students with scored assignment  are ------------ ");
                            System.out.println(" Student email is " + submitAss[s][3]);
                            System.out.println(" Student score is " + submitAss[s][4]);
                            System.out.println(" --------------------------");

                        } catch (Exception e) {
                            System.out.println("Sorry try again");
                        }
                    }
                    // students with no scores yet
                    else if (submitAss[s][1].equals(courseCode) && submitAss[s][0].equals(AssignmentName) && submitAss[s][4] ==null) {
                        System.out.println("--------- students with no score for  submitted  assignments  ------------ ");
                        System.out.println(" Student email is " + submitAss[s][0]);
                        System.out.println(" Student score pending");
                        System.out.println(" --------------------------");

                    }
                }
            }
        }

        else {
            System.out.println("Sorry check whether you've not  login or you are the course creator");

        }

    }
    // view course by code .
    private static void viewCourseByCode(String courseCode) {

        for (String  i:  courseRegistration.keySet()) {
            viewCourse();// additional course details
            if (courseRegistration.get(i).equals(courseCode))
                System.out.println("All  registered students emails: " + i);

            for (String c : registeredCoursesStudentsName.keySet()) {
                if (registeredCoursesStudentsName.get(c).equals(courseCode))
                    System.out.println("All  registered students Names : " + c);


            }

        }

    }

    // score assignment
    private  static void  scoreAssignment (String email, String password, String courseCode, String AssignmentName, String stdemail, double  score) {
        boolean Faculty = isFaculty(email).equals("True");
        boolean creatorOfCourse = isCourseCreator(email, courseCode) == True;
        boolean login = facultyLogin(email, password).equals("True");

        if (Faculty && creatorOfCourse && login) {
            for (int s = 0; s < submitAss.length; s++) {
                if (submitAss[s][3].equals(stdemail)) {
                    try {
                        submitAss[s][4] = (String.valueOf(score));
                        System.out.println("assignment scored successfully");
                    } catch (Exception e) {
                        System.out.println("try again");
                    }
                } else {
                    System.out.println(" Student did not  submit assignment");
                }

            }
        } else {
            System.out.println(" Please login or check if you are the course creator ");
        }

    }


}
