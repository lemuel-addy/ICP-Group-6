import java.util.*;
import java.util.Arrays;
public class Building_Canvas {
protected void createAccount
protected boolean login
protected void updateProfileprotected String viewProfile
    protected boolean isAdmin    int count=0;
    String [][] accounts = new String[100][7]; //data_type[][] array_name = new data_type[x][y];
{
        Scanner input = new Scanner(System.in);
        String userEmail, userPass;

        System.out.print("To create your account, enter your email: ");
        //userEmail = input.nextLine();
        accounts[count][0]=userEmail;

        System.out.print("Please enter your password: ");
        userPass = input.nextln();
        accounts[count][1]=userPass;

        if (count<100){
            count++;
        }
    }

    {
        Scanner input= new Scanner(System.in);
        String logEm, logPass;
        System.out.print("Enter email: ");
        logEm = input.nextln();

        System.out.print("Enter password: ");
        logPass=input.nextln();

        for (String [] acc: accounts){
            //compare the data
            if (logEm.equals(acc[0])) {
                if (logPass.equals(acc[1])) {
                    return true;
                }
            }
        }
        return false;
    }
{
        Scanner input = new Scanner(System.in);
        String logEm,logPass,logFname,logLname,logYgrp,logGPA,logDOB;

        System.out.print("Enter email: ");
        logEm = input.nextln();
        System.out.print("Enter password: ");
        logPass=input.nextln();

        for (String [] acc: accounts){
            //compare the data
            if (logEm.equals(acc[0])) {
                if (logPass.equals(acc[1])) {
                    System.out.print("To update account, enter first name: ");
                    logFname=input.nextln();
                    accounts[count][2]=logFname;

                    System.out.print("Enter last name: ");
                    logLname=input.nextln();
                    accounts[count][3]=logLname;

                    System.out.print("Enter year group: ");
                    logYgrp=input.nextln();
                    accounts[count][4]=logYgrp;

                    System.out.print("Enter current GPA: ");
                    logGPA=input.nextln();
                    accounts[count][5]=logGPA;

                    System.out.print("Enter date of birth: ");
                    logDOB=input.nextln();
                    accounts[count][6]=logDOB;
                }
            }
        }
    }

{
        Scanner input= new Scanner(System.in);
        String logEm, logPass;
        System.out.print("Enter email: ");
        logEm = input.nextln();

        System.out.print("Enter password: ");
        logPass=input.nextln();

        for (String [] acc: accounts){
            //compare the data
            if (logEm.equals(acc[0])) {
                if (logPass.equals(acc[1])) {
                    System.out.print("Your information: " + Arrays.toString(acc));
                }
            }
        }
    }

    {
        count = 0
        String adminEm;
        String[] adminAccnts;
        Scanner admin = new Scanner(System.in);
        System.out.print("Admin Login, please enter email: ");
        adminEm = input.nextln();
        adminAccnts[count] = adminEm;
        for (String[] acc : adminAccnts) {
            if (adminEm.equals(adminAccnts[acc]))
                count++;
            return true;
            else{
                return false;
            }
        }

        protected void makeFaculty {
        counter = 0
        String facEm;
        String[] facAccnts;
        Scanner admin = new Scanner(System.in);
        System.out.print("Faculty Signup, please enter email: ");
        facEm = input.nextln();
        facAccnts[count] = facEm;
        counter++;
    }

        protected boolean isFaculty {
        Scanner faculty = new Scanner(System.in);
        System.out.print("Faculty sign in. Please enter email: ");

        for (String[] acc : facAccnts) {
            if (facEm.equals(facAccnts[acc]))
                counter++;
            return true;
            else{
                return false;
            }
        }
    }

        protected void createCourse {
        String[][] courseArray = new String[100][3];
        Scanner input = new Scanner(System.in);
        String userEmail, courseCode, courseName;

        System.out.print("To create your course, enter your email: ");
        userEmail = input.nextLine();
        courseArray[count][0] = userEmail

        System.out.print("Please enter your course code: ");
        courseCode = input.nextln();
        courseArray[count][1] = courseCode;

        System.out.print("Please enter your course name: ")
        courseName = input.nextln();
        courseArray[course][2] = courseName;

        if (count < 100) {
            count++;
        }
    }

        protected String viewCourses {
        for (String[] acc : courseArray) {
            System.out.println("Course information" + Arrays.toString(acc));
        }
    }

        protected void registerCourses {
        Scanner input = new Scanner(System.in);
        String logEm, logPass, userEm, courseCode;
        System.out.print("Enter email: ");
        logEm = input.nextln();

        System.out.print("Enter password: ");
        logPass = input.nextln();
        for (String[] acc : accounts) {
            //compare the data
            if (logEm.equals(acc[0])) {
                if (logPass.equals(acc[1])) {
                    Scanner input = new Scanner(System.in);
                    System.out.println("Enter your email: ");
                    userEm = input.nextln();

                    System.out.println("Enter your course code: ");
                    courseCode = input.nextln();

                    courseArray[count][0] = userEmail

                    if (count < 100) {
                        count++;
                    }
                }
            }
        }

    }
        protected String viewCourseByCode{
        String courseCode;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter course code: ");
        courseCode=input.nextln();
        for (String[] acc : courseArray) {
            if (courseCode.equals(acc)){
            System.out.println("Course information" + Arrays.toString(acc));
    }

    protected String viewCoursesByEmail {
                String courseEmail;
                Scanner input = new Scanner(System.in);
                System.out.print("Enter your email: ");
                courseEmail = input.nextln();
                for (String[] acc : courseArray) {
                    if (courseEmail.equals(acc)) {
                        System.out.println("Course information" + Arrays.toString(acc));
                    }
                }
            }

    protected void addAssignment {
                String userEmail, assgnCode, assgnEmail, assgnName, assgnDesc, assgnDD, assgnType;
                Scanner faculty = new Scanner(System.in);
                System.out.print("Faculty permision needed. Please enter email: ");
                userEmail = input.nextln();
                for (String[] acc : facAccnts) {
                    if (userEmail.equals(facAccnts[acc])) {
                        Scanner input = new Scanner(System.in);
                        System.out.print("Enter email: ");
                        assgnEmail = input.nextln();

                        Scanner input1 = new Scanner(System.in);
                        System.out.print("enter course code: ");
                        assgnCode = input.nextln();

                        Scanner input2 = new Scanner(System.in);
                        System.out.print("Enter assignment name: ");
                        assgnName = input.nextln();

                        Scanner input3 = new Scanner(System.in);
                        System.out.print("Enter assignment description: ");
                        assgnDesc = input.nextln();

                        Scanner input4 = new Scanner(System.in);
                        System.out.print("Enter assignment due date: ");
                        assgnDD = input.nextln();

                        Scanner input5 = new Scanner(System.in);
                        System.out.print("Enter assignment type: ");
                        assgnType = input.nextln();
                    }
                }
            }

    public static void main (String[]args){
                
            }

