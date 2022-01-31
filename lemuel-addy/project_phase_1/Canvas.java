import java.util.Scanner;
import java.util.*;


public class Canvas{
    
    String email;
    String password;

    ArrayList<String> emails = new ArrayList<String>();
    ArrayList<String> passwords = new ArrayList<String>();
    ArrayList<String> firstName = new ArrayList<String>();
    ArrayList<String> lastName = new ArrayList<String>();
    ArrayList<String> yearGroup = new ArrayList<String>();
    ArrayList<String> currentGPA = new ArrayList<String>();
    ArrayList<String> dateBirth = new ArrayList<String>();
    ArrayList<String> admins = new ArrayList<String>();
    ArrayList<String> faculty = new ArrayList<String>();
    ArrayList<String> courseCodes = new ArrayList<String>();
    // ArrayList<String> courses = new ArrayList<String>();
    ArrayList<Course> courses = new ArrayList<Course>();
    // admins = {"daniel.nettey@ashesi.edu.gh","dennis.owusu@ashesi.edu.gh"};
    boolean accountUpdate;

    public Canvas(){
        admins.add("daniel.nettey@ashesi.edu.gh");
        admins.add("dennis.owusu@ashesi.edu.gh");
    }

    void createAccount(){
        Scanner init = new Scanner(System.in); 
        System.out.println("Welcome to Canvas/n To create an account, please enter your email: ");
        String entry = init.nextLine();
        if(entry.contains("@ashesi.edu.gh")){
            emails.add(entry);
            Scanner initp = new Scanner(System.in); 
            System.out.println("Please enter your new password: ");
            String pass = initp.nextLine();
            Scanner verip = new Scanner(System.in); 
            System.out.println("Please verify your new password: ");
            String passv = verip.nextLine();
            if (pass.equals(passv)){
                System.out.println("Account successfully created!");
                passwords.add(pass);
            }
            else{
                System.out.println("Password does not match. Try again");
            }

        }
        else{
            System.out.println("invalid email address. Try again");
        }; 
     
        
    }


     

    boolean login(){
        Scanner loge = new Scanner(System.in); 
        System.out.println("Welcome to Canvas\n To Log in, please enter your email: ");
        String entry = loge.nextLine();
        Scanner logp = new Scanner(System.in); 
        System.out.println("Enter your password: ");
        String pass = logp.nextLine();
        if(emails.contains(entry) && passwords.contains(pass)){
            return true;
        }
        else{
        return false;
        }
    }


    boolean updateProfile(){
        if (login()){
            Scanner loge = new Scanner(System.in); 
            System.out.println("To Update your profile\n Enter your email: ");
            String email = loge.nextLine();
            if (emails.contains(email)){
                
            }
            else{
                System.out.println("Login required! Try again");
            }
            Scanner logf = new Scanner(System.in); 
            System.out.println("Enter your first name: ");
            String first = logf.nextLine();
            firstName.add(first);
            Scanner logl = new Scanner(System.in); 
            System.out.println("Enter your last name: ");
            String last = logl.nextLine();
            lastName.add(last);
            Scanner logy = new Scanner(System.in); 
            System.out.println("Enter your year group: ");
            String year = logy.nextLine();
            yearGroup.add(year);
            Scanner logpa = new Scanner(System.in); 
            System.out.println("Enter your current GPA: ");
            String current = logpa.nextLine();
            currentGPA.add(current);
            Scanner logdob = new Scanner(System.in); 
            System.out.println("Enter your date of birth(dd/mm/yy): ");
            String dateofBirth = logdob.nextLine();
            dateBirth.add(dateofBirth);
            accountUpdate = true;
            return accountUpdate;
        }
        else{
            accountUpdate = false;
            return accountUpdate;
        }
    }

    void viewProfile(){
        Scanner log = new Scanner(System.in); 
        System.out.println("To view your profile, please enter you email: ");
        String entry = log.nextLine();
        if (emails.contains(entry)){
                
        }
        else{
            System.out.println("Login required! Try again");
        }
        if (accountUpdate == false){
            firstName.add(0,"NA");
            lastName.add(0,"NA");
            yearGroup.add(0,"NA");
            currentGPA.add(0,"NA");
            dateBirth.add(0,"NA");

        }
        System.out.println("User Profile\nEmail: " + entry + "\nFirst Name: "+firstName.get(0)+"\nLast Name: "+lastName.get(0)+"\nYear Group: "+yearGroup.get(0)+"\nCurrent GPA: "+currentGPA.get(0)+"\nDate of birth: "+dateBirth.get(0));
        
    }

    boolean isAdmin(){
        Scanner log = new Scanner(System.in); 
        System.out.println("Admin verification: ");
        String entry = log.nextLine();
        if(admins.contains(entry)){
            return true;
        }
        else{
            return false;
        }
        

    }

    void makeFaculty(){
        if (login()){
            if(isAdmin()){
            Scanner loge = new Scanner(System.in); 
            System.out.println("To assign Faculty, Enter your email: ");
            String email = loge.nextLine();
            
                if(admins.contains(email)){
                    faculty.add(email);
                    System.out.println("Assigned role of Faculty.");
                }
                else{
                    System.out.println("Sorry, you are not an admin. Action cannot be performed!");
                }
            }
        }

        }
        

    

    boolean isFaculty(){
        Scanner loge = new Scanner(System.in); 
        System.out.println("Enter your email to verify you are a faculty member: ");
        String email = loge.nextLine();
        if (faculty.contains(email)){
            return true;
        }
        else{
            return false;
        }
        

    }

    void createCourse(Course cc){
        if (login()){
            if(isFaculty()){
                Scanner logcc = new Scanner(System.in); 
                System.out.println("Enter the course code: ");
                String courseCode = logcc.nextLine();
                // courseCodes.add(courseCode);
                cc.setcourseCode(courseCode);
                Scanner logc = new Scanner(System.in); 
                System.out.println("Enter the course name: ");
                String courseName = logc.nextLine();
                // courses.add(courseName);
                cc.setcourseName(courseName);
                Scanner logn = new Scanner(System.in); 
                System.out.println("Enter creator's name: ");
                String creatorName = logn.nextLine();
                // courses.add(courseName);
                cc.setcreatorName(creatorName);
                Scanner logne = new Scanner(System.in); 
                System.out.println("Enter creator's email: ");
                String creatorEmail = logne.nextLine();
                // courses.add(courseName);
                cc.setcreatorEmail(creatorEmail);
                courses.add(cc);
            }
        }
    }

    void viewCourses(){
        for(int i = 0; i < courses.size(); i++)
        {
            System.out.println("Course: "+courses.get(i).getcourseName()+"\nCourse code: "+courses.get(i).getcourseCode()+"\nCourse creator's email: "+courses.get(i).getcreatorEmail()+"\nCourse creator's name: "+courses.get(i).getcreatorName());

        }
    }

    void registerCourse(Course cc){
        if(login()){
            Scanner logcc = new Scanner(System.in); 
            System.out.println("Enter the course code for registration: ");
            String courseCode = logcc.nextLine();
            for(int i = 0; i < courses.size(); i++)
            {
                if(courses.get(i).getcourseCode()==courseCode){
                    Scanner logc = new Scanner(System.in); 
                    System.out.println("Enter your email: ");
                    String email = logc.nextLine();
                    courses.get(i).addUsers(email);
                }
            }
            
            
        }
        
    }

    // void viewCourseByCode(String courseCode){

    // }

    // void viewCoursesByEmail(){

    // }

    // void addAssignment(String email, String courseCode, String assignmentName, String description, Date dueDate, String assignmentType){
        
    // }

    // void viewAssignmentsByCourse(String courseCode){

    // }

    // void viewAssignmentsByEmail(String email){

    // }

    // void submitAssignment(String email, String courseCode, String assignmentName, String submission){

    // }

    // void viewSubmissions(String email, String courseCode, String assignmentName){

    // }

    // void scoreAssignment(String email, String courseCode, String assignmentName, String submittersEmail, int score){

    // }
    
    // void viewAssignmentScore(String email, String courseCode, String assignmentName){

    // }

    // void viewAssignmentScores(String email, String courseCode, String assignmentName){

    // }

    // void viewAllAssignmentScores(String email, String courseCode){

    // }

    // void viewAssignmentGrade(String email, String courseCode, String assignmentName){

    // }

    // void viewAssignmentGrades(String email, String courseCode, String assignmentName){

    // }

    public class Course{
        String courseCode;
        String courseName;
        String creatorName;
        String creatorEmail;
        ArrayList<String> users = new ArrayList<String>();
    
        public String getcourseCode() { 
            return courseCode; 
         } 
        public void setcourseCode(String x) { 
            this.courseCode = x; 
         }
         public void addUsers(String x){
             users.add(x);
         }
         public void getUsers(){
            for(int i = 0; i < users.size(); i++)
            {
                System.out.println(users.get(i));
            }
         }
         public String getcourseName() { 
            return courseName; 
         } 
        public void setcourseName(String x) { 
            this.courseName = x; 
        }
        public String getcreatorName() { 
            return creatorName; 
         } 
        public void setcreatorName(String x) { 
            this.creatorName = x; 
    
        }
        public String getcreatorEmail() { 
            return creatorEmail; 
         } 
        public void setcreatorEmail(String x) { 
            this.creatorEmail = x; 
        }
    }
    public static void main(String[] args) {
        
        Canvas acc = new Canvas();
        acc.createAccount();
        acc.login();
        acc.updateProfile();
        acc.viewProfile();
        acc.isAdmin();
        acc.makeFaculty();
        Course cc = acc.new Course();
        acc.createCourse(cc);
        acc.viewCourses();
        acc.registerCourse(cc);
        
    }
}

 