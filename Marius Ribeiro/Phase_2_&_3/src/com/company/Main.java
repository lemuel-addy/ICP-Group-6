package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        adminList.add("marius@gmail.com");
    }



    ///////////////////////////////////////
    static Map<String, String> studentLogin = new HashMap<>();
    static Map <String, List> profile = new HashMap<>(); //Email-profile Mapping
    static Map <String, List> courseInfo = new HashMap<>();

    //For Course Codes
    static Map <String, List> courseCodeUserInfo = new HashMap<>();
    static Map <String, List> courseCodeCourseInfo = new HashMap<>();

    //Registered users
    static Map <String, List> registeredUsers = new HashMap<>();
    static Map <String, List> registeredCourses = new HashMap<>(); // for course code to user email

    //Assignment pairing
    static Map <String, List> assignmentByCourse = new HashMap<>();
    static Map <String, List> assignmentByCourseList = new HashMap<>();

    static Map <String, List> assignmentByEmail = new HashMap<>();
    static Map <String, List> assignmentByEmailList = new HashMap<>();

    //static Map <Map, String> willWork = new HashMap<>();


    /* list containing details via ArrayLists */
    static List<String> profileList = new ArrayList<>();

    static List<String> adminList = new ArrayList<>(); //Admins

    static List<String> facultyList = new ArrayList<>(); //Faculty

    static List<String> courseList = new ArrayList<>(); // Courses

    static List<String> classList = new ArrayList<>(Arrays.asList());

    //Registered users courses
    static List<String> userCourses = new ArrayList<>();

    ///
    static List<String> emailInputList = new ArrayList<>();// for storing email inputs in registerCourse function

    //Assignment list
    static List<String> assignment = new ArrayList<>();

    static List<String> assignmentList = new ArrayList<>();



    /*Actual Arrays*/
    //static int[] rows;

    static String[][] assSubmissionArray;


    //Column allocation
    static int emailColumn = 0, codeColumn =1, assNameColumn =2, submissionColumn = 3, scoreColumn = 3;
    static int newEntryRow = 0;
    private static int newEntryRowScore = 0;


    static String[][] assScoreArray;

    static String[][] permissionsArray;

    static int[] position;


    /* Email & Password Entry Variables */
    public static String emailInput = null, passwordInput = null, generalInput = null;


    //recurrent methods

    public static void emailEntry(){
        System.out.println("Enter your email address:");
        Scanner emInput = new Scanner(System.in);
        emailInput = emInput.nextLine();
    }

    public static void passwordEntry(){
        System.out.println("Enter your password:");
        Scanner passInput = new Scanner(System.in);
        passwordInput = passInput.nextLine();
    }


    public static void generalEntry(){
        Scanner genInput = new Scanner(System.in);
        generalInput = genInput.nextLine();
    }



    //1
    public static void createAccount(){
        System.out.println("Welcome to the Create Account Page");


        //email input
        emailEntry();

        //password input
        passwordEntry();

        Person student = new Person(emailInput, passwordInput);

        System.out.println("Was this your password?: " + passwordInput + "\nYes or No");
        Scanner passVerification = new Scanner(System.in);
        String passwordVerification = passVerification.nextLine();



        while (passwordVerification.toLowerCase().equals("no")) {
            passwordEntry();

            System.out.println("Was this your password?: " + passwordInput + "\nYes or No");
            passVerification = new Scanner(System.in);
            passwordVerification = passVerification.nextLine();
        }

        studentLogin.put(emailInput, passwordInput);

    }

    //2
    public static boolean login() {

        System.out.println("Welcome to the Login Page.");

        //successful login flag
        boolean response = false;
        //boolean fail = false;
        //boolean exitCall = false;

        //check if array is empty
        if (studentLogin.isEmpty()){
            System.out.println("Sorry, there are no registered accounts" +
                    "\nYou will be redirected to create an account ");

            createAccount();
        }




        //email section
        emailEntry();

        //password section
        passwordEntry();


        if (studentLogin.containsKey(emailInput)) {
            response = passwordInput.equals(studentLogin.get(emailInput));

        }

        return response;



    }

    public static void updateProfile(){
        System.out.println("Welcome to the Profile Update page\n");

        if (login()){
            System.out.println("Login was successful!\n");

            //First name
            System.out.println("Please enter your first name:");
            Scanner fnameInput = new Scanner(System.in);
            String firstName = "First name: " + fnameInput.nextLine();

            //last name
            System.out.println("\nPlease enter your last name:");
            Scanner lnameInput = new Scanner(System.in);
            String lastName = "Last name: " + lnameInput.nextLine();

            //year group
            System.out.println("\nPlease enter your Year Group:");
            Scanner yearInput = new Scanner(System.in);
            String yearGroupStr =  yearInput.nextLine();
            //int yearGroup = Integer.parseInt(yearGroupStr);

            //current GPA
            System.out.println("\nPlease enter your current GPA:");
            Scanner gpaInput = new Scanner(System.in);
            String gpaStr = gpaInput.nextLine();
            //int currentGpa = Integer.parseInt(gpaStr);

            //Date of Birth
            System.out.println("\nPlease enter your Date of Birth:");
            Scanner birthInput = new Scanner(System.in);
            String birthday = "Date of Birth: " +birthInput.nextLine();

            //list containing details via ArrayLists
            profileList = new ArrayList<>(Arrays.asList("Email: " + emailInput, firstName, lastName,
                    "Year group: " + yearGroupStr, "GPA: " + gpaStr, birthday));

            // Map <String, List> profile = new HashMap<>();

            //main job
            if(profile.get(emailInput )== null){
                profile.put(emailInput, profileList);
            }

            else
                profile.replace(emailInput, profileList, profileList);

            //System.out.println(profile.get(emailInput));

        }

       /* else
            login();*/
    }



    public static void viewProfile(){


        System.out.println("\nWelcome to the View Profile page!");
        if (login()){
            if(profile.isEmpty() || profile.get(emailInput).isEmpty()){
                System.out.println("N/A");
            }

            System.out.println("Your Profile is as follows:\n" + profile.get(emailInput));

            //
            //System.out.println("Testing...\n" + profile.values());
        }
    }



    // #6
    public static boolean isAdmin() {
        boolean state = false;
    /*System.out.println("To know if you are an admin,");
    emailEntry();*/

        if (adminList.contains(emailInput))
            state = true;


        return state;
    }

    // #7
    public static void makeFaculty(){
        System.out.println("\nMake faculty Page\n");
        if (login() && isAdmin()){    //Login requirement
            //if(isAdmin()){
            System.out.println("Enter new faculty Email address: ");
            emailEntry();

            //Adds to faculty list
            facultyList.add(emailInput);
            System.out.println("Email added successfully");


        }


        else{
            System.out.println("Feature is inaccessible");
        }
    }
    // #8
    public static boolean isFaculty(){
        boolean state = false;

        if (facultyList.contains(emailInput))
            state = true;

        return state;
    }




    // #9
    public static void createCourse(){
        System.out.println("\nCreate course page \nPlease log in as Faculty!");
        if (login() && isFaculty()){
            System.out.println("Login was successful!\n");

            //Course code
            System.out.println("Please enter Course Code:");
            Scanner courseCodeInput = new Scanner(System.in);
            String courseCode = courseCodeInput.nextLine();

            //Course name
            System.out.println("\nPlease enter Course name:");
            Scanner courseNameInput = new Scanner(System.in);
            String courseName = "Course name: " + courseNameInput.nextLine();


            //list containing details via ArrayLists
            courseList = new ArrayList<>(Arrays.asList("Creator Email: " + emailInput, "Course Code: " +courseCode, courseName));

            //Stores all courses as pairs with their creator's emails
            courseInfo.put(emailInput, courseList);


            //Course Code Stuff

            courseCodeUserInfo.put(courseCode, classList); //Pairs Registered students as a List with course code
            courseCodeCourseInfo.put(courseCode, courseList); //Stores courses in a pair with the course code
        }


    }

    // #10
    public static void viewCourses(){
        System.out.println("View Courses Page");
        System.out.println("Courses:\n" + courseInfo.values());
    }

    // #11
    public static void registerCourse() {
        System.out.println("Course Registration\n");
        if (login()) {
            System.out.print("Available ");
            viewCourses();

            System.out.println("Please enter your course code");
            generalEntry();

            if (courseCodeUserInfo.containsKey(generalInput)) {
                String code = generalInput;
                courseCodeUserInfo.get(generalInput).add("Email: " + emailInput + "Username: "
                        + profileList.get(2) + " " + profileList.get(3));//Retrieves first and last name

                //Adds course to the email of the person registering
                if (registeredUsers.containsKey(emailInput)) {
                    registeredUsers.get(emailInput).add("Course code: " + generalInput +
                            " Course: " + courseCodeCourseInfo.get(generalInput).get(-1));

                    //for course-email of users
                    registeredCourses.get(code).add(emailInput);
                }

                else {
                    //creates new email-registered courses map
                    userCourses.add("Course code: " + generalInput +
                            " Course: " + courseCodeCourseInfo.get(generalInput));
                    registeredUsers.put(emailInput, userCourses);


                    emailInputList.add(emailInput);
                    registeredCourses.put(code, emailInputList);

                    userCourses = null;


                }
                System.out.println("NA");
            }


        }
    }
    // #12
    public static void viewCourseByCode() {
        System.out.println("\nView Course By Code\n");

        //Takes Course code
        System.out.println("\nPlease enter Course Code:");
        generalEntry();

        if (courseCodeCourseInfo.containsKey(generalInput)) {
            System.out.println("\nCourse Information:");
            courseCodeCourseInfo.get(generalInput);

            System.out.println("\nClass Participants:" +courseCodeUserInfo.get(generalInput));//prints the list of students under the C code


        } else {
            System.out.println("NA");
        }


    }

    // #13
    public static void viewCoursesByEmail(){
        System.out.println("\nView Course By Email Page\n");
        System.out.println("View course by email\n");
        emailEntry();
        if(registeredUsers.containsKey(emailInput)){   //If email has registered for a course,
            System.out.println(registeredUsers.get(emailInput));  //prints out the key as a List
        }

        else{
            System.out.println("NA");
        }
    }

    //#14
    public static void addAssignment(){
        System.out.println("\nAdd Assignment Page\n");
        if(login() && isFaculty() && courseInfo.containsKey(emailInput)) {

            //The asks
            //Course code
            System.out.println("\nCourse code");
            generalEntry();

            String courseCode = generalInput;

            //Assignment Name
            System.out.println("\nAssignment Name:");
            generalEntry();
            String assignmentName = generalInput;

            //Description
            System.out.println("Assignment description:\n");
            generalEntry();
            String assignmentDescription = generalInput;

            //Due Date
            System.out.println("\nDue date:");
            generalEntry();
            String dueDate = generalInput;

            //Assignment Type
            System.out.println("What type of assignment is this?\n" +
                    "QUIZ  / HOMEWORK  / PROJECT  / EXAM");
            generalEntry();
            String assignmentType = generalInput.toUpperCase();

            assignment.add("\nCreator: " + emailInput +
                    "  Course Code: " + courseCode + "  Assignment Name: " + assignmentName +
                    "\nDescription: " + assignmentDescription + "\n" + "Due Date: " +
                    dueDate + " Assignment Type: " + assignmentType);
            /*
            assignment = new ArrayList<>(Arrays.asList("Creator: " + emailInput +
                    "  Course Code: " + courseCode + "  Assignment Name: " + assignmentName +
                    "\nDescription: " + assignmentDescription + "\n" + "Due Date: " +
                    dueDate + " Assignment Type: " + assignmentType));*/



            assignmentList = new ArrayList<>(Arrays.asList("Creator: " + emailInput,
                    "  Course Code: " + courseCode, "  Assignment Name: " + assignmentName,
                    "\nDescription: " + assignmentDescription, "\n" + "Due Date: " +
                            dueDate, " Assignment Type: " + assignmentType));


            //Pairing Course (Code) to Assignments
            if (courseCodeCourseInfo.containsKey(courseCode)) { //Making sure it is official

                assignmentByCourse.put(courseCode, assignment);//for view functions

                assignmentByCourseList.put(courseCode, assignmentList);


                //pairing with Email
                assignmentByEmail.put(emailInput, assignment); //for view functions

                assignmentByEmailList.put(emailInput, assignmentList);
            }

            //In case of a wrong course code/ non-existing course
            else {
                System.out.println("Course Code input is not available.\n" +
                        "Could not save assignment");
            }
        }

        else{
            System.out.println("NA");
        }

    }


    //#15
    public static void viewAssignmentsByCourse(){
        System.out.println("\nView Assignments By Course Page");
        System.out.println("\nAssignments by Course");
        System.out.println("Enter Course Code:");
        generalEntry();

        if(assignmentByCourse.containsKey(generalInput)){ //Checks for validity of course code input
            System.out.println("\nResult:");
            System.out.println(assignmentByCourse.get(generalInput));
        }

        else
            System.out.println("NA");
    }

    // #16
    public  static void viewAssignmentsByEmail(){
        System.out.println("View assignments by Email");
        emailEntry();

   /* if (

    )*/

    }

    // #17
    public static void submitAssignment(){
        System.out.println("\nSubmit Assignment Page\nUse Student Email");
        if (login()){
            System.out.println("Input your course code:");
            generalEntry();
            String Code = generalInput;
            if (assignmentByCourse.containsKey(Code)){//Checks course code
                System.out.println("Input Assignment name:");
                generalEntry();
                String assignment = generalInput;
                if (assignmentByCourseList.get(Code).contains("  Assignment Name: "+ assignment)){//Checks assignment name
                    //Assignment Input
                    System.out.println("\nPlease enter your assignment:\n");
                    generalEntry();


                    //Size
                    int size = registeredCourses.get(Code).size();


                    assSubmissionArray = new String[size][10];


                    //Entry
                    assSubmissionArray[newEntryRow][emailColumn] = emailInput;
                    assSubmissionArray[newEntryRow][codeColumn] = Code;
                    assSubmissionArray[newEntryRow][assNameColumn] = assignment;
                    assSubmissionArray[newEntryRow][submissionColumn] =generalInput;

                    //New entry increment
                    newEntryRow += 1;

                }

                else{
                    System.out.println("NA");
                }

            }
            else {
                System.out.println("NA");
            }
        }
        else {
            System.out.println("NA");
        }
    }

    //2D array Search
    static boolean arraySearch(String[][] arr, String target) {
        boolean res = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    res = true;
                    //position = ( i, j);
                }

            }
        }
        return res;
    }

    //2D array Row finder
    // to use: int ans[] = arrayRowSearch(arr, 14, 19 );
    //Arrays.toString(ans))
    static int[] arrayRowSearch(String[][] arr, String target, String targetTwo) {
        boolean res = false;
        boolean resTwo = false;
        int rowInd = 0;
        int[] rows =new int[arr[0].length];


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == target) {
                    res = true;
                }
                if (arr[i][j] == targetTwo) {
                    resTwo = true;
                }

            }
            if (res == true && resTwo == true){
                rows[rowInd] = i;
                rowInd += 1;
            }


            res = false;
            resTwo = false;
        }
        return rows;
    }

    // #18
    public static void viewSubmissions(){
        System.out.println("\nView Submissions Page\n");
        if(login() && isFaculty() && courseInfo.containsKey(emailInput)){
            if (assSubmissionArray != null){
                System.out.println("\nEnter Course Code:");
                generalEntry();
                String code = generalInput;

                System.out.println("\nEnter Assignment Name:");
                generalEntry();
                String assignmentName = generalInput;

                if (arraySearch(assSubmissionArray, assignmentName) && arraySearch(assSubmissionArray, code)){ //Validation
                    int ros[] = arrayRowSearch(assSubmissionArray, code, assignmentName);
                    for (int i = 0; i < ros.length; i++) {

                        int r = ros[i];
                        System.out.println("Email:"+ assSubmissionArray[r][0] + "\nSubmission:\n"+ assSubmissionArray[r][3]);
                        if(assSubmissionArray[r][3]==null){
                            System.out.println("No Submission");
                        }
                    }
                    //System.out.println("");
                }
            }
            else
                System.out.println("NA");
        }
        else
            System.out.println("NA");
    }

    // #19
    public static void scoreAssignment(){
        System.out.println("\nScore Assignment Page\n");
        if(login() && isFaculty() && courseInfo.containsKey(emailInput)){
            if (login()){
                System.out.println("Input your course code:");
                generalEntry();
                String Code = generalInput;
                if (assignmentByCourse.containsKey(Code)){//Checks course code
                    System.out.println("Input Assignment name:");
                    generalEntry();
                    String assignment = generalInput;
                    if (assignmentByCourse.get(Code).contains(assignment)){//Checks assignment name
                        //Assignment Input
                        System.out.println("\nPlease enter Student Email:\n");
                        generalEntry();
                        String studentEmail = generalInput;

                        System.out.println("Input Score");
                        generalEntry();
                        String score = generalInput;
                        float scoreFloat = Float.parseFloat(score);
                        while (scoreFloat > 100 || scoreFloat < 0){
                            System.out.println("Input a score from 0 to 100");
                            generalEntry();
                            score = generalInput;
                            scoreFloat = Float.parseFloat(score);
                        }




                        //Size
                        //int size = courseCodeUserInfo.get(Code).size();

                        assScoreArray = new String[100][10];


                        //Entry
                        assScoreArray[newEntryRowScore][emailColumn] = studentEmail;
                        assScoreArray[newEntryRowScore][codeColumn] = Code;
                        assScoreArray[newEntryRowScore][assNameColumn] = assignment;
                        assSubmissionArray[newEntryRow][scoreColumn] =score;

                        //New entry increment
                        newEntryRowScore += 1;

                    }

                    else{
                        System.out.println("NA");
                    }

                }
                else {
                    System.out.println("NA");
                }
            }
            else {
                System.out.println("NA");
            }
        }


    }


    // #20
    public static void viewAssignmentScore(){
        System.out.println("\nView Assignment Score Page\n");
        if(login() ){
            if (assScoreArray != null){
                System.out.println("\nEnter Course Code:");
                generalEntry();
                String code = generalInput;

                System.out.println("\nEnter Assignment Name:");
                generalEntry();
                String assignmentName = generalInput;

                if (arraySearch(assScoreArray, assignmentName) && arraySearch(assScoreArray, emailInput)){ //Validation
                    int ros[] = arrayRowSearch(assScoreArray, emailInput, assignmentName);
                    for (int i = 0; i < ros.length; i++) {

                        int r = ros[i];
                        System.out.println("Email:"+ assScoreArray[r][0] + "Assignment" + assScoreArray[r][2]+ "\nScore: "+ assScoreArray[r][3]);
                        if(assScoreArray[r][3]==null){
                            System.out.println("No Score");
                        }
                    }

                }
                else
                    System.out.println("NA");
            }
            else
                System.out.println("NA");
        }
        else
            System.out.println("NA");
    }


    // #21
    public static void viewAssignmentScores(){
        if(login() && isFaculty() && courseInfo.containsKey(emailInput)){
            System.out.println("\nView Assignment Scores Page\n");
            if (assScoreArray != null){
                System.out.println("\nEnter Course Code:");
                generalEntry();
                String code = generalInput;

                System.out.println("\nEnter Assignment Name:");
                generalEntry();
                String assignmentName = generalInput;

                if (arraySearch(assScoreArray, assignmentName) && arraySearch(assScoreArray, code)){ //Validation
                    int ros[] = arrayRowSearch(assScoreArray, code, assignmentName);
                    for (int i = 0; i < ros.length; i++) {

                        int r = ros[i];
                        System.out.println("Student Email:"+ assScoreArray[r][0] + "\nScore: "+ assScoreArray[r][3]);
                        if(assScoreArray[r][3]==null){
                            System.out.println("No Score");
                        }
                    }

                }
                else
                    System.out.println("NA");
            }
            else
                System.out.println("NA");
        }
        else
            System.out.println("NA");
    }

    // #22
    public static void viewAllAssignmentScores() {
        System.out.println("\nView All Assignment Scores Page\n");
        if(login() ){
            if (assScoreArray != null){
                System.out.println("\nEnter Course Code:");
                generalEntry();
                String code = generalInput;

                System.out.println("\nEnter Assignment Name:");
                generalEntry();
                String assignmentName = generalInput;

                if (arraySearch(assScoreArray, code) && arraySearch(assScoreArray, emailInput)){ //Validation
                    int ros[] = arrayRowSearch(assScoreArray, emailInput, code);
                    for (int i = 0; i < ros.length; i++) {

                        int r = ros[i];
                        System.out.println("Assignment: " + assScoreArray[r][2]+ "   Score: "+ assScoreArray[r][3]);
                        if(assScoreArray[r][3]==null){
                            System.out.println("No Score");
                        }
                    }

                }
                else
                    System.out.println("NA");
            }
            else
                System.out.println("NA");
        }
        else
            System.out.println("NA");
    }

    //Grading function
    public static String letterGrades(String scoreValue) {
        String letterValue = null;
        if (scoreValue != null) {
            float floatValue = Float.parseFloat(scoreValue);
            letterValue = null;
            if (floatValue > 85)
                letterValue = "A+";
            else if (floatValue > 79 && floatValue < 85)
                letterValue = "A";
            else if (floatValue > 74 && floatValue < 80)
                letterValue = "B+";
            else if (floatValue > 69 && floatValue < 75)
                letterValue = "B";
            else if (floatValue > 64 && floatValue < 70)
                letterValue = "C+";
            else if (floatValue > 59 && floatValue < 65)
                letterValue = "C";
            else if (floatValue > 54 && floatValue < 60)
                letterValue = "D+";
            else if (floatValue > 49 && floatValue < 55)
                letterValue = "D";
            else if (floatValue < 50)
                letterValue = "E";
            else if (floatValue == 0)
                letterValue = "Incomplete";

        } else
            System.out.println("NA");

        return letterValue;
    }



    // #23
    public static void viewAssignmentGrade(){
        if(login() ){
            System.out.println("\nView Assignment Grade\n");
            if (assScoreArray != null){
                System.out.println("\nEnter Course Code:");
                generalEntry();
                String code = generalInput;

                System.out.println("\nEnter Assignment Name:");
                generalEntry();
                String assignmentName = generalInput;

                if (arraySearch(assScoreArray, assignmentName) && arraySearch(assScoreArray, emailInput)){ //Validation
                    int ros[] = arrayRowSearch(assScoreArray, emailInput, assignmentName);
                    for (int i = 0; i < ros.length; i++) {

                        int r = ros[i];
                        System.out.println("Email:"+ assScoreArray[r][0] + "   Assignment: " + assScoreArray[r][2]+
                                "   Score: "+ assScoreArray[r][3] +
                                "Letter Grade: "+ letterGrades(assScoreArray[r][3]));
                        if(assScoreArray[r][3]==null){
                            System.out.println("No Score");
                        }
                    }

                }
                else
                    System.out.println("NA");
            }
            else
                System.out.println("NA");
        }
        else
            System.out.println("NA");
    }

    // #24
    public static void viewAssignmentGrades(){
        System.out.println("\nView Assignment Grades\n");
        if(login() && isFaculty() && courseInfo.containsKey(emailInput)){
            if (assScoreArray != null){
                System.out.println("\nEnter Course Code:");
                generalEntry();
                String code = generalInput;

                System.out.println("\nEnter Assignment Name:");
                generalEntry();
                String assignmentName = generalInput;

                if (arraySearch(assScoreArray, assignmentName) && arraySearch(assScoreArray, code)){ //Validation
                    int ros[] = arrayRowSearch(assScoreArray, code, assignmentName);
                    for (int i = 0; i < ros.length; i++) {

                        int r = ros[i];
                        System.out.println("Student Email:"+ assScoreArray[r][0] + "   Assignment: " +
                                assScoreArray[r][2]+ "Score: " + assScoreArray[r][3]+
                                "   Letter Grade: "+ letterGrades(assScoreArray[r][3])) ;
                        if(assScoreArray[r][3]==null){
                            System.out.println("No Score");
                        }
                    }

                }
                else
                    System.out.println("NA");
            }
            else
                System.out.println("NA");
        }
        else
            System.out.println("NA");
    }

    // #25
    public static void viewAllAssignmentGrades(){
        System.out.println("\nView All Assignment Grades\n");
        if(login() ){
            if (assScoreArray != null){
                System.out.println("\nEnter Course Code:");
                generalEntry();
                String code = generalInput;

                System.out.println("\nEnter Assignment Name:");
                generalEntry();
                String assignmentName = generalInput;

                if (arraySearch(assScoreArray, code) && arraySearch(assScoreArray, emailInput)){ //Validation
                    int ros[] = arrayRowSearch(assScoreArray, emailInput, code);
                    for (int i = 0; i < ros.length; i++) {

                        int r = ros[i];
                        System.out.println("Assignment: " + assScoreArray[r][2]+ "   Score: "
                                + assScoreArray[r][3]+ "Letter Grade: "+ letterGrades(assScoreArray[r][3]));
                        if(assScoreArray[r][3]==null){
                            System.out.println("No Score");
                        }
                    }

                }
                else
                    System.out.println("NA");
            }
            else
                System.out.println("NA");
        }
        else
            System.out.println("NA");
    }

    // #26
    public static void setNotificationPreferences(){
        if(login()){
            System.out.println("\nAnswer 'Yes' or 'No'");

            //notify assignment being posted
            System.out.println("\nWould you like to be notified when assignments are posted?");
            generalEntry();
            String postNotification = generalInput.toLowerCase();

            //notify when an assignment is graded
            System.out.println("\nWould you like to be notified when assignments are Scored?");
            generalEntry();
            String scoreNotification = generalInput.toLowerCase();

            //notify when user registers for course
            System.out.println("Would you like to be notified when you register for a course?");
            generalEntry();
            String registrationNotification = generalInput.toLowerCase();

            //Array
            assScoreArray = new String[100][10];
            int rowPerm = 0;


            //Entry
            permissionsArray[rowPerm][emailColumn] = emailInput;
            permissionsArray[rowPerm][1] = postNotification;
            permissionsArray[rowPerm][2] = scoreNotification;
            permissionsArray[rowPerm][3] =registrationNotification;

            //New entry increment
            rowPerm += 1;

        }
    }

}

