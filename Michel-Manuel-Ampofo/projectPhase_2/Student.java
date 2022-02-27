package projectPhase_2;

import java.util.HashMap;

public class Student extends Faculty {





    // courses student register for  :   email  and course code
    static HashMap<String, String> courseRegistration = new HashMap<>();

    // courses student register for  :   email  and course name
    static HashMap<String, String> courseRegistrationNames = new HashMap<>();
    // courses student register for  : course code and name
    static HashMap<String, String> registeredCoursesStudentsName = new HashMap<>();

    static String[][]  allregisteredCoursenames  = new String [studentMail][3];

    // add assignment
    static String [][] Addassignment  = new String[studentMail][5];
    // submit assignment
   // static String [][] submitAss  = new String[studentMail][5];



    // set notification preference. notification value for assignment , courses, score can be either yes or no

    private static void setNotificationPreferences(String Email, String password,  String Assignment4courseNotify ,  String score4AssignmentNotify, String register4CourseNotify ){
        String StudentLogin = studentLogin(Email, password);
        if (StudentLogin.equals("True")) {

            switch (Assignment4courseNotify.toLowerCase()){
                case "yes":
                    System.out.println("You will be notified through email when an assignment is posted");
                    break;

                case "no":
                    System.out.println(" You can change your notification settings later ");
                    break;
            }


            switch (score4AssignmentNotify.toLowerCase()){
                case "yes":
                    System.out.println(" You will be notified through email  when a score for an  assignment is posted");
                    break;

                case "no":
                    System.out.println(" You can change your notification settings later ");
                    break;
            }

            switch (register4CourseNotify.toLowerCase()){
                case "yes":
                    System.out.println(" You will be notified through email when you register for a course ");
                    break;

                case "no":
                    System.out.println(" You can change your notification settings later ");
                    break;
            }

        }

        else{
            System.out.println(" Please login");
        }




    }



    // view all assignments grade
    private static void viewAllAssignmentGrade( String email , String Coursecode, String password ) {
        String StudentLogin = studentLogin(email, password);
        if (StudentLogin.equals("True")) {
            for (int i = 0; i < submitAss.length; i++) {
                if (email.equals(submitAss[i][3]) && submitAss[i][1].equals(Coursecode)) {
                    try {
                        System.out.println("Course code  " + submitAss[i][1]);
                        System.out.println("Assignment name " + submitAss[i][0]);
                        System.out.println("Assignment score " + submitAss[i][4]);
                        System.out.println("Assignment Grade " + gradeScore(Double.parseDouble(submitAss[i][4])));

                    } catch (Exception e) {
                        System.out.println("Sorry could retrieve assignment grade. Try again ");

                    }
                }

            }

        } else {
            System.out.println("Please login ");
        }
    }


    // view assignment grade
    private static void viewAssignmentGrade( String email , String Coursecode, String  assign_mentName, String password ) {

        String StudLogin = studentLogin(email, password);
        if (StudLogin.equals("True")) {
            for (int i = 0; i < submitAss.length; i++) {
                if (email.equals(submitAss[i][3]) && submitAss[i][1].equals(Coursecode) && submitAss[i][0].equals(assign_mentName)) {
                    try {

                        System.out.println("Course code  " + submitAss[i][1]);
                        System.out.println("Assignment name " + submitAss[i][0]);
                        System.out.println("Assignment score " + submitAss[i][4]);
                        System.out.println("Assignment Grade " + gradeScore(Double.parseDouble(submitAss[i][4])));


                    } catch (Exception e) {
                        System.out.println("Sorry could retrieve assignment grade. Try again ");

                    }
                }

            }

        } else {
            System.out.println("Please login ");
        }
    }

    // view all assignments score
    private static void viewAllAssignmentScore( String email , String Coursecode, String password ) {

        String StudentLogin = studentLogin(email, password);
        if (StudentLogin.equals("True")) {
            for (int i = 0; i < submitAss.length; i++) {
                if (email.equals(submitAss[i][3]) && submitAss[i][1].equals(Coursecode)) {
                    try {
                        System.out.println("Course code  " + submitAss[i][1]);
                        System.out.println("Assignment name " + submitAss[i][0]);
                        System.out.println("Assignment score " + submitAss[i][4]);

                    } catch (Exception e) {
                        System.out.println("Sorry could retrieve  assignment score . Try again ");

                    }
                }

            }

        } else {
            System.out.println("Please login ");
        }
    }

    // submit assignment
    private static void submitAssignment( String email , String Coursecode, String  assign_mentName, String password, String FileSubmit ) {

        String StudLogin = studentLogin(email, password);
        if (StudLogin.equals("True")) {
            for (int i = 0; i < allregisteredCoursenames.length; i++) {
                if (email.equals(allregisteredCoursenames[i][0]) && hasAssignment(Coursecode) && Addassignment[i][1].equals(assign_mentName)) {
                    try {
                        submitAss[i][0]= assign_mentName;
                        submitAss[i][1]= Coursecode;
                        submitAss[i][2] = FileSubmit;
                        submitAss[i][3] = email;
                        System.out.println("Assignment submitted successfully");

                    } catch (Exception e) {
                        System.out.println("Sorry could not submit assignment. Try again ");

                    }
                }

            }

        } else {
            System.out.println("Please login ");
        }
    }

    // view assignments by email
    private static void viewAssignmentByEmail(String email, String CourseCode){

        for (int i = 0; i <  allregisteredCoursenames.length; i++) {
            if (email.equals(allregisteredCoursenames[i][0]) &&  hasAssignment(CourseCode)) {
                try {
                    System.out.println("Assignment name  " + Addassignment[i][1]);
                    System.out.println("Assignment description  " + Addassignment[i][2]);
                    System.out.println("Assignment due date  " + Addassignment[i][3]);
                    System.out.println("Assignment type " + Addassignment[i][4]);
                } catch (Exception e) {
                    System.out.println("Sorry could not retrieve assignment info. Try again ");

                }
            } else {
                System.out.println("sorry no  details");
            }

        }

    }

    // check if a course has an assignment
    private static boolean hasAssignment(String courseCode){

        for( int i = 0; i< Addassignment.length; i++){
            if( courseCode.equals(Addassignment[i][1])){

                try {
                    System.out.println("Assignment is created for the course");
                    return True;

                }
                catch (Exception e){
                    System.out.println("Try checking again");
                    return False;
                }

            }
            else {
                System.out.println("Assignment creation failed");
            }
        }
        return False;
    }

    // view assignments by course
    private static void viewAssignmentByCourse(String courseCode){

        for (int i = 0; i <  Addassignment.length; i++) {
            if (courseCode.equals(Addassignment[i][0])) {
                try {
                    System.out.println("Assignment name is " + Addassignment[i][1]);
                    System.out.println("Assignment description is " + Addassignment[i][2]);
                    System.out.println("Assignment due date  is " + Addassignment[i][3]);
                    System.out.println("Assignment type  is " + Addassignment[i][4]);
                } catch (Exception e) {
                    System.out.println("Sorry could not retrieve assignment info. Try again ");

                }
            } else {
                System.out.println("sorry cannot view the details");
            }

        }

    }


    private static String studentLogin(String Email, String Password) {

        for (int i = 0; i < studentEmail.size(); i++) {


            output = (studentEmail.contains(Email) &&
                    studentPassword.contains(Password)) ? "True" : "False";

        }

        return output;

    }

    public static String isStudent(String Email) {
        output=studentEmail.contains(Email)  ? "True": "False";
        System.out.println(output);
        return output;
    }

    // register course : email is student email
    private static void registerCourse(String email, String password, String userName, String courseCode, String CourseName){
        if(isStudent(email).equals("True") && studentLogin(email,password).equals("True")){
            for (String s : TotalCourseInfo.keySet() ){
                if ( s.equals(courseCode)){
                    // course was created by faculty add student
                    courseRegistration.put(email,courseCode);
                    registeredCoursesStudentsName.put(userName,courseCode);
                    courseRegistrationNames.put(CourseName,email);

                    for (int i = 0; i < allregisteredCoursenames.length; i++){
                        allregisteredCoursenames[i][0]= email;
                        allregisteredCoursenames[i][1]= courseCode;
                        allregisteredCoursenames[i][2]= CourseName;
                    }

                    System.out.println("course registration successful");

                }

                else {
                    System.out.println("Course doesnt exist ");
                }

            }

        }
        else {
            System.out.println("Sorry, Course registration failed");
        }

    }



    // view assignment score
    private static void viewAssignmentScore( String email , String Coursecode, String  assign_mentName, String password ) {

        String StudLogin = studentLogin(email, password);
        if (StudLogin.equals("True")) {
            for (int i = 0; i < submitAss.length; i++) {
                if (email.equals(submitAss[i][3]) && submitAss[i][1].equals(Coursecode) && submitAss[i][0].equals(assign_mentName)) {
                    try {
                        System.out.println("Course code  " + submitAss[i][1]);
                        System.out.println("Assignment name " + submitAss[i][0]);
                        System.out.println("Assignment score " + submitAss[i][4]);

                    } catch (Exception e) {
                        System.out.println("Sorry could retrieve  assignment score . Try again ");

                    }
                }

            }

        } else {
            System.out.println("Please login ");
        }
    }






}
