package projectPhase_1;

import java.util.ArrayList;
import java.util.Scanner;

public class project1 {

    //try
    int trail ;

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


    private  static void  updateProfile() {

        /*  This is done for admin access only, to prevent changing of critical info like gpa by students.*/

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

            System.out.println("incorrect Password");
        }

        else {
            System.out.println("incorrest Username or permission denied to update your details");
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

            System.out.print("Enter the username of the person you want to view  : ");
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
            System.out.println(" Successfully made user  faculty");
        }

        else  if(isAdmin(AdminEmail).equals("True") &&
                adminLogin(AdminEmail, AdminPassword).equals("False")){

            System.out.println("Please login first.");
        }

        else {
            System.out.println("Please contact admin to make these changes. Your account does not have admin priviledges");
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
            System.out.println("Student account succesfully made");
        }

        else  if(isAdmin(minEmail).equals("True") && adminLogin(minEmail,
                AdminPassword).equals("False")){

            System.out.println("Login required.");
        }

        else {
            System.out.println("Please contact admin to make these changes. Your account does not have admin priviledges");
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


