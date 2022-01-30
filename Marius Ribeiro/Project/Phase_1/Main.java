package com.company;

import java.util.*;


public class Main {
    /* Array (Map/HashMap) */
    static Map<String, String> studentLogin = new HashMap<>();
    static Map <String, List> profile = new HashMap<>(); //Email-profile Mapping
    static Map <String, List> courseInfo = new HashMap<>();

    //For Course Codes
    static Map <String, List> courseCodeUserInfo = new HashMap<>();
    static Map <String, List> courseCodeCourseInfo = new HashMap<>();

    //Registered users
    static Map <String, List> registeredUsers = new HashMap<>();

    //Assignment pairing
    static Map <String, List> assignmentByCourse = new HashMap<>();
    static Map <String, List> assignmentByEmail = new HashMap<>();


    /* list containing details via ArrayLists */
    static List<String> profileList = new ArrayList<>();

    static List<String> adminList = new ArrayList<>(); //Admins

    static List<String> facultyList = new ArrayList<>(); //Faculty

    static List<String> courseList = new ArrayList<>(); // Courses

    static List<String> classList = new ArrayList<>(Arrays.asList(null));

    //Registered users courses
    static List<String> userCourses = new ArrayList<>();

    //Assignment list
    static List<String> assignment = new ArrayList<>();




    /* Email & Password Entry Variables */
    public static String emailInput = null, passwordInput = null, generalInput = null;


    public static void main(String[] args) {
	

    }
   
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
    
    
    
    public static void createAccount(){
    System.out.println("Welcome to the Create Account Page");

    //email input
    emailEntry();

    //password input
    passwordEntry();

    //verificarion input
    System.out.println("Was this your password?: " + passwordInput + "\nYes or No");
    Scanner passVerification = new Scanner(System.in);
    String passwordVerification = passVerification.nextLine();

    //int verificationFlag = 0;

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

    System.out.println("Welcome to the Login Page.\nPlease enter your email address:");

    //successful login flag
    boolean response = false;
    

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

          

            //main job
            if(profile.get(emailInput )== null){
                profile.put(emailInput, profileList);
            }

            else
                profile.replace(emailInput, profileList, profileList);

            System.out.println(profile.get(emailInput));

        }

     
    }
    
    public static void viewProfile(){
    System.out.println("\nWelcome to the View Profile page!");
        if (login()){
                if(profile.isEmpty() || profile.get(emailInput).isEmpty()){
                    System.out.println("N/A");
                }

            System.out.println("Your Profile is as follows:\n" + profile.get(emailInput));

        }
}
    
    // #6
public static boolean isAdmin() {
    boolean state = false;

    if (adminList.contains(emailInput))
        state = true;


    return state;
}


// #7
public static void makeFaculty(){
    System.out.println("Make faculty Page\n");
        if (login() && isAdmin()){    //Login requirement
        
            System.out.println("To add to faculty: ");
            emailEntry();

            //Adds to faculty list
            facultyList.add(emailInput);
            System.out.println("Operation was Successful");


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
            courseList = new ArrayList<>(Arrays.asList("Email: " + emailInput, "Course Code: " +courseCode, courseName));

            //Stores all courses as pairs with their creator's emails
            courseInfo.put(emailInput, courseList);


            //Course Code Stuff

            courseCodeUserInfo.put(courseCode, classList); //Pairs Registered students as a List with course code
            courseCodeCourseInfo.put(courseCode, courseList); //Stores courses in a pair with the course code
        }


}

// #10
public static void viewCourses(){

        System.out.println("Courses:\n" + courseInfo.values());
}


// #11
public static void registerCourse() {
    System.out.println("Course Registraion\n");
    if (login()) {
        System.out.print("Available ");
        viewCourses();

        System.out.println("Please enter your course code");
        generalEntry();

        if (courseCodeUserInfo.containsKey(generalInput)) {
            courseCodeUserInfo.get(generalInput).add("Email: " + emailInput + "Username: "
                    + profileList.get(2) + " " + profileList.get(3));//Retrieves first and last name

            //Adds course to the email of the person registering
            if (registeredUsers.containsKey(emailInput)) {
                registeredUsers.get(emailInput).add("Course code: " + generalInput +
                        " Course: " + courseCodeCourseInfo.get(generalInput).get(-1));
            }

            else {
                //creates new email-registered courses map
                userCourses.add("Course code: " + generalInput +
                        " Course: " + courseCodeCourseInfo.get(generalInput));
                registeredUsers.put(emailInput, userCourses);

                userCourses = null;


            }
            System.out.println("NA");
        }


    }
}



// #12
    public static void viewCourseByCode() {
        System.out.println("\nView Course By Code");

        //Takes Course code
        System.out.println("\nPlease enter Course Code:");
        generalEntry();

        if (courseCodeCourseInfo.containsKey(generalInput)) {
            System.out.println("\nCourse Information:");
            courseCodeCourseInfo.get(generalInput);

            System.out.println("\nClass Participants:");
            courseCodeUserInfo.get(generalInput); //prints the list of students under the C code

        } else {
            System.out.println("NA");
        }


    }




// #13
public static void viewCoursesByEmail(){
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

            assignment = new ArrayList<>(Arrays.asList("Creator: " + emailInput +
                    "  Course Code: " + courseCode + "  Assignment Name: " + assignmentName +
                    "\nDescription: " + assignmentDescription + "\n" + "Due Date: " +
                    dueDate + " Assignment Type: " + assignmentType));

            //Pairing Course (Code) to Assignments
            if (courseCodeCourseInfo.containsKey(courseCode)) { //Making sure it is official
                assignmentByCourse.put(courseCode, assignment);

                //pairing with Email
                assignmentByEmail.put(emailInput, assignment);
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
    System.out.println("\nAssignments by Course");
    System.out.println("Enter Course Code:");
    generalEntry();

    if(assignmentByCourse.containsKey(generalInput)){
        System.out.println("\nResult:");
        System.out.println(assignmentByCourse.get(generalInput));
    }

    else
        System.out.println("NA");
}

}

