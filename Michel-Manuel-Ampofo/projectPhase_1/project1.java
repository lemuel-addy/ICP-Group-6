package projectPhase_1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;




public class project1 {

    // courses student register for  :   email  and course name
    static HashMap<String, String> courseRegistrationNames = new HashMap<>();

    // courses student register for  : course code and name
    static HashMap<String, String> registeredCoursesStudentsName = new HashMap<>();

    // course creator : course code and email
    static HashMap<String, String> courseCreatorEmail = new HashMap<>();

    // all courses created- course code and course name
    static HashMap<String, String> TotalCourseInfo = new HashMap<>();

    //course creator: course code and name
    static HashMap<String, String> courseCreator = new HashMap<>();

    // courses student register for  :   email  and course code
    static HashMap<String, String> courseRegistration = new HashMap<>();




    // courses storage array

    private static boolean True;
    private static boolean False;
    static boolean result; static String output;

    //  logins storage array
    static  ArrayList<String> studentEmail = new ArrayList<>();
    static ArrayList<String> studentPassword = new ArrayList<>();

    static  ArrayList<String> facultyEmail = new ArrayList<>();
    static ArrayList<String> facultyPassword = new ArrayList<>();

    static ArrayList<String> adminEmail = new ArrayList<>();
    static ArrayList<String> adminPassword = new ArrayList<>();


    // updating profile
    static int UpdateAccountDetails = 100;
    static String[][] UpdateAccount = new String[ UpdateAccountDetails][7];

    // view courses by email - email, course name and course code
    static int studentMail = 100;
    static String[][]  allregisteredCoursenames  = new String [studentMail][3];

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




    // add assignment
    static String [][] Addassignment  = new String[studentMail][5];
    // submit assignment
    static String [][] submitAss  = new String[studentMail][5];


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






    private  static void  updateProfile() {

        /* This is done for admin access only*/

        System.out.print("\n");
        System.out.print("To update user profile, login first:\n");

        Scanner email_l = new Scanner(System.in);
        System.out.print("Enter your admin email: " );

       // String AdminEmail = email_l.nextLine();


        Scanner password1 = new Scanner(System.in);
        System.out.print("Enter your admin password: " );







        // read email
        String AdminEmail = email_l.nextLine();
        Scanner  password = new Scanner(System.in);
        System.out.print("Enter your admin password: " );

        // read password
        String Admin_Password  = password1.nextLine();
        String login= adminLogin(AdminEmail,Admin_Password);


        Scanner updates = new Scanner(System.in);
        if (isAdmin(AdminEmail).equals("True") & login.equals("True")){
            System.out.print("Enter the name of the user you want to update the details : ");
            String mail = updates.nextLine();

            if ( studentEmail.contains(mail)){

                System.out.print("Enter new Email");
                String Email = updates.nextLine();

                System.out.print("Enter First Name: ");
                String firstName = updates.nextLine();

                System.out.print("Enter Last Name: ");
                String lastName = updates.nextLine();

                System.out.print("Enter Year group: ");
                String yearGroup = updates.nextLine();

                System.out.print("Enter GPA(current): ");
                String Gpa = updates.nextLine();

                System.out.print("Enter Date of birth e.g 01/02/2000: ");
                String DOB = updates.nextLine();

                for (int a = 0; a < UpdateAccount.length; a++) {

                    UpdateAccount[a][0] = Email;
                    UpdateAccount[a][2] = firstName;
                    UpdateAccount[a][3] = lastName;
                    UpdateAccount[a][4] = yearGroup;
                    UpdateAccount[a][5] = Gpa;
                    UpdateAccount[a][6] = DOB;

                }
                System.out.println(" student details updated successfully");
            }

            else{
                System.out.println("user doesnt exist ");
            }


        }

        else if(isAdmin(AdminEmail).equals("True") &&
                adminLogin(AdminEmail, Admin_Password).equals("False")){

            System.out.println("Incorrect Password");
        }

        else {
            System.out.println("Incorrect username or permission denied to update your details");
        }

    }


    private  static  void viewProfile() {
        /* admins  and students should be able to view student details*/
        System.out.print("\n");
        System.out.print("To view  user  profile, Please login: \n");

        Scanner e_mail = new Scanner(System.in);
        System.out.print("Enter your email: ");

        // read email
        String Email = e_mail.nextLine();

        Scanner password = new Scanner(System.in);
        System.out.print("Enter your  password: ");

        // read password
        String Password = password.nextLine();

        Scanner updates = new Scanner(System.in);
        if (isAdmin(Email).equals("True") && adminLogin(Email,
                Password).equals("True") || isStudent(Email).equals("True") &&
                studentLogin(Email,Password).equals("True")) {

            System.out.print("Enter person's username: ");
            String mail = updates.nextLine();

            for (int i = 0; i < UpdateAccount.length; i++ ) {
                String checkEmail = UpdateAccount[i][0];

                if (checkEmail.equals(mail)) {

                    System.out.print("Email: " + UpdateAccount[i][0] + "\n");

                    if ((UpdateAccount[i][2])==null){
                        System.out.print("First Name: NA \n");
                    }
                    else {System.out.print("First Name: " +
                            UpdateAccount[i][2]);}

                    if ((UpdateAccount[i][3])==null){
                        System.out.print("Last Name: NA \n");
                    }
                    else {System.out.print("Last Name: " + UpdateAccount[i][3]);}

                    if ((UpdateAccount[i][4])==null){System.out.print("Year Group: NA \n");
                    }
                    else {System.out.print("Year Group: " + UpdateAccount[i][4]);}

                    if ((UpdateAccount[i][5])==null){
                        System.out.print("GPA: NA \n");
                    }
                    else {
                        System.out.print("GPA: " +UpdateAccount[i][5]);
                    }

                    if ((UpdateAccount[i][6])==null){
                        System.out.print("D.O.B: NA \n");
                    }
                    else {  System.out.print("D.O.B: " +
                            UpdateAccount[i][6]);}

                }
                else {
                    System.out.println("Unable to view details");
                }
            }
        }
    }





    private  static void   createAccount(String Email, String password) {

        /* only Admins can create accounts for students and faculty.  */

        Scanner roles= new Scanner(System.in);
        System.out.print("Role being assigned to account: " );
        String role  = roles.nextLine();

        String role_lower = role.toLowerCase();
        switch (role_lower) {
            case "student" -> {
                String Student= makeStudent(Email);
                if (Student.equals("True")){
                    studentPassword.add(password);
                    System.out.println(" Student account created ");
                }
                else{
                    System.out.println("Cannot create account for student. Contact your administrator");
                }

            }
            case "faculty" -> {
                String Faculty = makeFaculty(Email);
                if (Faculty.equals("True")){
                    facultyPassword.add(password);
                    System.out.println("Faculty account created successfully ");
                }
                else{
                    System.out.println("Cannot create account for faculty. Contact your administrator ");
                }
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



    // set notification preference. notification value for assignment , courses, score can be either yes or no

    private static void setNotificationPreferences(String Email, String password,  String Assignment4courseNotify ,  String score4AssignmentNotify, String register4CourseNotify ){
        String StudentLogin = studentLogin(Email, password);
        if (StudentLogin.equals("True")) {

            switch (Assignment4courseNotify.toLowerCase()){
                case "yes":
                    System.out.println(" You will be notified via email when an assignment is posted");
                    break;

                case "no":
                    System.out.println(" You can change your notification settings later ");
                    break;
            }


            switch (score4AssignmentNotify.toLowerCase()){
                case "yes":
                    System.out.println(" You will be notified via email  when a score for an  assignment is posted");
                    break;

                case "no":
                    System.out.println(" You can change your notification settings later ");
                    break;
            }

            switch (register4CourseNotify.toLowerCase()){
                case "yes":
                    System.out.println(" You will be notified via email when you register for a course ");
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




    private static  String  makeFaculty(String Email) {

        Scanner email = new Scanner(System.in);
        System.out.print("Enter your admin email: " );

        // read email
        String AdminEmail = email.nextLine();

        Scanner  password = new Scanner(System.in);
        System.out.print("Enter your admin password: " );

        // read password
        String AdminPassword  = password.nextLine();


        String login= adminLogin(AdminEmail,AdminPassword);

        if (isAdmin(AdminEmail).equals("True") & login.equals("True")){

            facultyEmail.add(Email);
            System.out.println("User faculty successfully made");
        }

        else  if(isAdmin(AdminEmail).equals("True") &&
                adminLogin(AdminEmail, AdminPassword).equals("False")){

            System.out.println("Please login first.");
        }

        else {
            System.out.println("Please contact admin to make these changes. Your account does not have admin privileges");
        }
        return login;
    }




    // display all created courses
    private static void viewCourse() {

        for (String s : TotalCourseInfo.keySet() ){
            System.out.println("Course Name: "+ s);
            System.out.println("courseInstructor Name: "+ courseCreator.get(s));
            System.out.println("courseInstructor Email: "+ courseCreatorEmail.get(s));

            for (String i : TotalCourseInfo.values() ){
                System.out.println("Course Name: "+ i);


            }
        }


    }
    // email is the email of the faculty .
// Hashmap is used so that each course is identified by its unique  code and no 2 courses can have the same  course code
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




    // grade assignment
    private static String gradeScore( double  score ){
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






    private static String  makeStudent(String Email) {

        Scanner em_ail = new Scanner(System.in);
        System.out.print("Enter your admin email: " );

        // read email
        String minEmail = em_ail.nextLine();

        Scanner  Password = new Scanner(System.in);
        System.out.print("Enter your admin password: " );

        // read password
        String AdminPassword  = Password.nextLine();
        String login= adminLogin(minEmail,AdminPassword);

        if (isAdmin(minEmail).equals("True") & login.equals("True")){

            studentEmail.add(Email);
            System.out.println("Student account successfully made");
        }

        else  if(isAdmin(minEmail).equals("True") && adminLogin(minEmail,
                AdminPassword).equals("False")){

            System.out.println("Login required.");
        }

        else {
            System.out.println("Please contact admin to make these changes. Your account does not have admin privileges");
        }

        return login;
    }

    private static String studentLogin(String Email, String Password) {

        for (int i = 0; i < studentEmail.size(); i++) {


            output = (studentEmail.contains(Email) &&
                    studentPassword.contains(Password)) ? "True" : "False";

        }

        return output;

    }






    private static  String  adminLogin(String Email, String Password) {

        for (int i = 0; i < adminEmail.size(); i++) {


            output = (adminEmail.contains(Email) && adminPassword.contains(Password)) ? "True" : "False";

        }
        System.out.println("login is "+ output);
        return output;

    }

    private  static String  isStudent(String Email){
        output=studentEmail.contains(Email)  ? "True": "False";
        System.out.println(output);
        return output;
    }

    private  static String  isFaculty(String Email){
        output=facultyEmail.contains(Email)  ? "True": "False";
        System.out.println(output);
        return output;
    }


    private  static String  isAdmin(String Email){
        output=adminEmail.contains(Email)  ? "True": "False";
        System.out.println(output);
        return output;
    }


    private static void addAdmin(String email, String password){
        adminEmail.add(email);
        adminPassword.add(password);
        System.out.println("Admin account added successfully");
    }



    public static void main(String[] args) {
        //testing addAdmin

        addAdmin( "michel.manuel@gmail.com", "asdf.1234");


        //testing adminLogin
        adminLogin("michel.manuel@gmail.com", "asdf.1234");


        // testing isAdmin
        isAdmin("michel.manuel@gmail.com");

        //testing makeFaculty
        // makeFaculty("kofi@gmail.com");

        // testing makeStudent
        makeStudent("michel.manuel@gmail.com");

        // testing is student
        isStudent("michel.manuel@gmail.com");

        //testing createAccount
        createAccount("maame@gmail.com", "ama");

        // testing student login
        studentLogin("maame@gmail.com", "ama");


        // testing update details
        updateProfile();

        //testing view profile
        viewProfile();




    }

}


