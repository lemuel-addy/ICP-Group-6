import java.util.*;
import java.util.Arrays;

public class Building_Canvas{
        int count; 
        int logGPA,logYrgroup,courseCode;
        
        String [][] accounts = new String[100][7]; //data_type[][] array_name = new data_type[x][y];
        String[] facAccnts;
        String[] adminAccnts;
        String[][] courseArray = new String[100][3];

        String logEmail, logPassword, userEmail, userPassword,courseName,logFname,logLname,logDOB;
        String courseEmail, adminEmail,adminAccounts,facEmail;
        String assgnCode, assgnEmail, assgnName, assgnDesc, assgnDD, assgnType;

    protected String createAccount(){
        count=0;
        Scanner input = new Scanner(System.in);
        System.out.print("To create your account, enter your email: ");
        userEmail = input.nextLine();
        accounts[count][0]=userEmail;
        System.out.print("Please enter your password: ");
        userPassword = input.next();
        accounts[count][1]=userPassword;
        if (count<100){
            count++;
        }
    }

    protected boolean login(){
        Scanner input= new Scanner(System.in);
        System.out.print("Enter email: ");
        logEmail = input.next();
        System.out.print("Enter password: ");
        logPassword = input.next();
        for (String [] acc: accounts){
            //compare the data
            if (logEmail.equals(acc[0])) {
                if (logPassword.equals(acc[1])) {
                    return true;
                }
            }
        }
        return false;
    }

    protected String updateProfileprotected(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter email: ");
        logEmail = input.next();
        System.out.print("Enter password: ");
        logPassword = input.next();
        for (String [] acc: accounts){
            //compare the data
            if (logEmail.equals(acc[0])) {
                if (logPassword.equals(acc[1])) {
                    System.out.print("To update account, enter first name: ");
                    logFname=input.next();
                    accounts[count][2]=logFname;

                    System.out.print("Enter last name: ");
                    logLname=input.next();
                    accounts[count][3]=logLname;

                    System.out.print("Enter year group: ");
                    logYrgroup=input.next();
                    accounts[count][4]=logYrgroup;

                    System.out.print("Enter current GPA: ");
                    logGPA=input.next();
                    accounts[count][5]=logGPA;

                    System.out.print("Enter date of birth: ");
                    logDOB=input.next();
                    accounts[count][6]=logDOB;
                }
            }
        }
    }


    String viewProfile(){
        Scanner input= new Scanner(System.in);
        System.out.print("Enter email: ");
        logEmail = input.next();
        System.out.print("Enter password: ");
        logPassword=input.next();
        for (String [] acc: accounts){
            //compare the data
            if (logEmail.equals(acc[0])) {
                if (logPassword.equals(acc[1])) {
                    System.out.print("Your information: " + Arrays.toString(acc));
                }
            }
        }
    }

    protected boolean isAdmin(){
        count = 0;
        Scanner admin = new Scanner(System.in);
        System.out.print("Admin Login, please enter email: ");
        adminEmail = input.nextln();
        adminAccnts[count] = adminEmail;
        for (String[] acc : adminAccnts) {
            if (adminEmail.equals(adminAccnts[acc])){
                count++;
            return true;
            }
            else{
                return false;
            }
        }
    }

    protected String makeFaculty(){
        count = 0;
        Scanner admin = new Scanner(System.in);
        System.out.print("Faculty Signup, please enter email: ");
        facEmail = input.nextln();
        facAccnts[count] = facEmail;
        count++;
    }

    protected boolean isFaculty(){
        Scanner faculty = new Scanner(System.in);
        System.out.print("Faculty sign in. Please enter email: ");
        for (String[] acc : facAccnts) {
            if (facEm.equals(facAccnts[acc])){
                counter++;
            return true;
            }
            else{
                return false;
            }
        }
    }

    protected String createCourse(){
        Scanner input = new Scanner(System.in);
        System.out.print("To create your course, enter your email: ");
        userEmail = input.nextLine();
        courseArray[count][0] = userEmail;

        System.out.print("Please enter your course code: ");
        courseCode = input.next();
        courseArray[count][1] = courseCode;

        System.out.print("Please enter your course name: ");
        courseName = input.next();
        courseArray[count][2] = courseName;

        if (count < 100){
            count++;
        }
    }

    protected String viewCourses(){
        for (String[] acc : courseArray) {
            System.out.println("Course information" + Arrays.toString(acc));
        }
    }

    protected void registerCourses(){
        count = 0;
        Scanner input0 = new Scanner(System.in);
        System.out.print("Enter email: ");
        logEmail = input.next();
        System.out.print("Enter password: ");
        logPassword = input.next();
        for (String[] acc : accounts) {
            //compare the data
            if (logEmail.equals(acc[0])) {
                if (logPassword.equals(acc[1])) {
                    Scanner input1 = new Scanner(System.in);
                    System.out.println("Enter your email: ");
                    userEmail = input.next();

                    System.out.println("Enter your course code: ");
                    courseCode = input.next();

                    courseArray[count][0] = userEmail;

                    if (count < 100) {
                        count++;
                    }
                }
            }
        }

    }
    
    protected String viewCourseByCode(){
        Scanner input0 = new Scanner(System.in);
        System.out.print("Enter course code: ");
        courseCode=input.next();
        for (String[] acc : courseArray){
            if (courseCode.equals(acc)){
            System.out.println("Course information" + Arrays.toString(acc));
            }
        }
    }        

    protected String viewCoursesByEmail(){
                String courseEmail;
                Scanner input1 = new Scanner(System.in);
                System.out.print("Enter your email: ");
                courseEmail = input.next();
                for (String[] acc : courseArray){
                    if (courseEmail.equals(acc)){
                        System.out.println("Course information" + Arrays.toString(acc));
                    }
                }
            }

    protected void addAssignment(){
                Scanner faculty = new Scanner(System.in);
                System.out.print("Faculty permision needed. Please enter email: ");
                userEmail = input.next();
                for (String[] acc : facAccnts) {
                    if (userEmail.equals(facAccnts[acc])) {
                        Scanner input0 = new Scanner(System.in);
                        System.out.print("Enter email: ");
                        assgnEmail = input.next();

                        Scanner input1 = new Scanner(System.in);
                        System.out.print("enter course code: ");
                        assgnCode = input.next();

                        Scanner input2 = new Scanner(System.in);
                        System.out.print("Enter assignment name: ");
                        assgnName = input.next();

                        Scanner input3 = new Scanner(System.in);
                        System.out.print("Enter assignment description: ");
                        assgnDesc = input.next();

                        Scanner input4 = new Scanner(System.in);
                        System.out.print("Enter assignment due date: ");
                        assgnDD = input.next();

                        Scanner input5 = new Scanner(System.in);
                        System.out.print("Enter assignment type: ");
                        assgnType = input.next();
                    }
                }
            }

    public static void main (String[]args){
                Building_Canvas bc = new Building_Canvas();
                bc.createAccount();
            }

        }