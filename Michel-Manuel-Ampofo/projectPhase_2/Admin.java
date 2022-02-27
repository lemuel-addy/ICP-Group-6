package projectPhase_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    // instance variables
    private  static String facultyemail;
    private static String faculty_Password;


    private static   String Studentemail;
    private static  String Student_Password;

    private static boolean True;
    private static boolean False;
    private static boolean result;
    private static String output;



    // array for storage of logins
    static ArrayList<String> studentEmail = new ArrayList<>();
    static ArrayList<String> studentPassword = new ArrayList<>();

    static ArrayList<String> facultyEmail = new ArrayList<>();
    static ArrayList<String> facultyPassword = new ArrayList<>();

    static ArrayList<String> adminEmail = new ArrayList<>();
    static ArrayList<String> adminPassword = new ArrayList<>();

    // updating profile
    static int UpdateAccountDetails = 100;
    static String[][] UpdateAccount = new String[UpdateAccountDetails][7];

    private  static  void viewProfile(String mail) {
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
                Password).equals("True") ) {

            System.out.print("Enter person's username: ");
            //String mail = updates.nextLine();

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



    private  static void  updateProfile(String AdminEmail, String Admin_Password ) {

   /*  to prevent students from changing their gpa and including false data in the
    system only admins will be able to update student details.*/

        String login= adminLogin(AdminEmail,Admin_Password);

        Scanner updates = new Scanner(System.in);
        if (isAdmin(AdminEmail).equals("True") & login.equals("True")){
            System.out.print("Enter the name of the user you wish to update the details : ");
            String mail = updates.nextLine();

            if ( studentEmail.contains(mail)){

                System.out.print("Enter new Email ");
                String Email = updates.nextLine();

                System.out.print("Enter First Name: ");
                String firstName = updates.nextLine();

                System.out.print("Enter Last Name: ");
                String lastName = updates.nextLine();

                System.out.print("Enter Year group: ");
                String yearGroup = updates.nextLine();

                System.out.print("Enter current GPA: ");
                String Gpa = updates.nextLine();

                System.out.print("Enter Date of birth e.g 24/04/2020: ");
                String DOB = updates.nextLine();

                for (int k = 0; k < UpdateAccount.length; k++) {
                    //String checkEmail = UpdateAccount[k][0];
                    UpdateAccount[k][0] = Email;
                    UpdateAccount[k][2] = firstName;
                    UpdateAccount[k][3] = lastName;
                    UpdateAccount[k][4] = yearGroup;
                    UpdateAccount[k][5] = Gpa;
                    UpdateAccount[k][6] = DOB;

                }
                System.out.println(" student details updated successfully ");
            }

            else{
                System.out.println(" user doesnt exist ");
            }


        }

        else if(isAdmin(AdminEmail).equals("True") && adminLogin(AdminEmail, Admin_Password).equals("False")){

            System.out.println("INCORRECT Password");
        }

        else {
            System.out.println("INCORRECT Username or have no right to update your details");
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
            System.out.println("Please contact admin to make these changes. Your account does not have admin privi'leges");
        }

        return login;
    }

    private static  String  adminLogin(String Email, String Password) {

        for (int i = 0; i < adminEmail.size(); i++) {


            output = (adminEmail.contains(Email) && adminPassword.contains(Password)) ? "True" : "False";

        }
        System.out.println("login is "+ output);
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



}
