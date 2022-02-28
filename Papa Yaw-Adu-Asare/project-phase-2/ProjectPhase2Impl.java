import school.staff.Admin;
import school.SchoolManagementSystem;

import java.util.List;
import java.util.Scanner;

public class ProjectPhase2Impl {

    public static void main(String[] args){
        // scanner object
        Scanner myObj = new Scanner(System.in);

        // creating a new school management system to manage users, faculties, courses, and assignemnts
        SchoolManagementSystem ashesi = new SchoolManagementSystem();

        // Add all admins here
        ashesi.setAdmins(List.of(
                new Admin("Papa","Yaw","papayaw@gmail.com","papa"),
                new Admin("Lico","Smith","lico@gmail.com","lico")
        ));


        // Create Account Menu
        // 1. Faculty
        // 2. User

        // Using scanner object to add new user

        System.out.println("Welcome to Ashesi School Management System. Please create an account");
        System.out.println(
                "1. Faculty \n" +
                "2. User \n" +
                        "Choose an Account Type: ");

        String type = myObj.nextLine();  // Read firstName
        System.out.println("Enter FirstName: ");
        String firstName = myObj.nextLine();
        System.out.println("Enter lastName: ");
        String lastName = myObj.nextLine();
        System.out.println("Enter email: ");
        String email = myObj.nextLine();
        System.out.println("Enter password: ");
        String password = myObj.nextLine();

        ashesi.createAccount(firstName,lastName,email,password,type);
        System.out.println(ashesi.isFaculty(email));



    }
}
