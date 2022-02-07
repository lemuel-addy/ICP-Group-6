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
        createAccount();
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

    void viewCourseByCode(){
        Scanner logcc = new Scanner(System.in); 
        System.out.println("Enter the course code for registration: ");
        String courseCode = logcc.nextLine();
        for(int i = 0; i < courses.size(); i++)
            {
                if(courses.get(i).getcourseCode()==courseCode){
                    System.out.println("Course: "+courses.get(i).getcourseName()+"\nCourse code: "+courses.get(i).getcourseCode()+"\nCourse creator's email: "+courses.get(i).getcreatorEmail()+"\nCourse creator's name: "+courses.get(i).getcreatorName());
                    System.out.println(courses.get(i).getUsers());
                }
            }
    }

    void viewCoursesByEmail(){
        Scanner logc = new Scanner(System.in); 
        System.out.println("Enter your email: ");
        String email = logc.nextLine();
        for(int i = 0; i < courses.size(); i++)
            {
                if(courses.get(i).getUsers().contains(email)){
                    System.out.println("Course: "+courses.get(i).getcourseName()+"\nCourse code: "+courses.get(i).getcourseCode());
                }
            }

    }

    void addAssignment(Course cc, Assignment ss){
        if(login()){
            if(isFaculty()){
                Scanner logc = new Scanner(System.in); 
                System.out.println("Enter your email: ");
                String email = logc.nextLine();
                if(cc.creatorEmail == email){
                    Scanner logcc = new Scanner(System.in); 
                    System.out.println("Enter the course code: ");
                    String courseCode = logcc.nextLine();
                    for(int i = 0; i < courses.size(); i++)
                        {
                            if(courses.get(i).getcourseCode()==courseCode){
                                ss.addUser(email);
                                Scanner logas = new Scanner(System.in); 
                                System.out.println("Enter the assignment name: ");
                                String assignmentName = logas.nextLine();
                                ss.setassignmentName(assignmentName);
                                Scanner logdes = new Scanner(System.in); 
                                System.out.println("Enter the assignment description: ");
                                String description = logdes.nextLine();
                                ss.setDescription(description);
                                Scanner logdate = new Scanner(System.in); 
                                System.out.println("Enter the due: ");
                                String dueDate = logdate.nextLine();
                                ss.setdueDate(dueDate);
                                Scanner logan = new Scanner(System.in); 
                                System.out.println("Enter the assignment type: ");
                                String assignmentType = logan.nextLine();
                                if(assignmentType == "Quiz"||assignmentType == "QUIZ"|| assignmentType == "quiz"){
                                    cc.addQuiz(ss);
                                }
                                System.out.println("Assignment Added Successfully");
                            }
                        }

        
                    
                    
                    
                }
            }
        }
        
    }

    void viewAssignmentsByCourse(){
        Scanner logc = new Scanner(System.in); 
        System.out.println("Enter the course code: ");
        String courseCode = logc.nextLine();
        for(int i = 0; i < courses.size(); i++)
            {
                if(courses.get(i).getcourseCode()==courseCode){
                    System.out.println("Quizzes: "+courses.get(i).getQuizzes()+"Homeworks: "+courses.get(i).getHomeworks()+"Projects: "+courses.get(i).getProjects()+"Exams: "+courses.get(i).getExams());
                }
            }
    }

    void viewAssignmentsByEmail(){
        Scanner log = new Scanner(System.in); 
        System.out.println("Enter your email: ");
        String email = log.nextLine();
        for(int i = 0; i < courses.size(); i++)
            {
                for(int j = 0; j < courses.get(i).getExams().size();j++){
                    if(courses.get(i).getExams().get(i).getUser().toString() == email){
                        System.out.println(courses.get(i).getExams().get(i));

                    }
                }
                for(int j = 0; j < courses.get(i).getQuizzes().size();j++){
                    if(courses.get(i).getQuizzes().get(i).getUser().toString() == email){
                        System.out.println(courses.get(i).getQuizzes().get(i));

                    }
                }
                for(int j = 0; j < courses.get(i).getHomeworks().size();j++){
                    if(courses.get(i).getHomeworks().get(i).getUser().toString() == email){
                        System.out.println(courses.get(i).getHomeworks().get(i));

                    }
                }
                for(int j = 0; j < courses.get(i).getProjects().size();j++){
                    if(courses.get(i).getProjects().get(i).getUser().toString() == email){
                        System.out.println(courses.get(i).getProjects().get(i));

                    }
                }
            }

    }

    void submitAssignment(Course cc, Assignment ss, Submit sb){
        if(login()){
            Scanner logc = new Scanner(System.in); 
            System.out.println("Enter your email: ");
            String email = logc.nextLine();
            Scanner logcc = new Scanner(System.in); 
            System.out.println("Enter the course code: ");
            String courseCode = logcc.nextLine();
            Scanner logas = new Scanner(System.in); 
            System.out.println("Enter the assignment name: ");
            String assignmentName = logas.nextLine();
            for(int i = 0; i < courses.size(); i++)
            {
                if(courses.get(i).getcourseCode()==courseCode){
                    for(int j = 0; j < courses.get(i).getExams().size();j++){
                        if(courses.get(i).getExams().get(i).getassignmentName().toString() == assignmentName){
                            Scanner logar = new Scanner(System.in); 
                            System.out.println("Input the submission ");
                            String subm = logar.nextLine();
                            sb.setSubmission(subm);
                            sb.setUser(email);
                            courses.get(i).getExams().get(i).addSubmissions(sb); 
                        }
                    }
                    for(int j = 0; j < courses.get(i).getQuizzes().size();j++){
                        if(courses.get(i).getQuizzes().get(i).getassignmentName().toString() == assignmentName){
                            Scanner logaq = new Scanner(System.in); 
                            System.out.println("Input the submission ");
                            String subm = logaq.nextLine();
                            sb.setSubmission(subm);
                            sb.setUser(email);
                            courses.get(i).getExams().get(i).addSubmissions(sb); 
    
                        }
                    }
                    for(int j = 0; j < courses.get(i).getHomeworks().size();j++){
                        if(courses.get(i).getHomeworks().get(i).getassignmentName().toString() == email){
                            Scanner logah= new Scanner(System.in); 
                            System.out.println("Input the submission ");
                            String subm = logah.nextLine();
                            sb.setSubmission(subm);
                            sb.setUser(email);
                            courses.get(i).getExams().get(i).addSubmissions(sb); 
    
                        }
                    }
                    for(int j = 0; j < courses.get(i).getProjects().size();j++){
                        if(courses.get(i).getProjects().get(i).getassignmentName().toString() == email){
                            Scanner logap = new Scanner(System.in); 
                            System.out.println("Input the submission ");
                            String subm = logap.nextLine();
                            sb.setSubmission(subm);
                            sb.setUser(email);
                            courses.get(i).getExams().get(i).addSubmissions(sb); 
    
                        }
                    }
                }
            
            }
        }
    }

    void viewSubmissions(Course cc, Assignment ss, Submit sb){
        if(login()){
            if(isFaculty()){
                Scanner logc = new Scanner(System.in); 
                System.out.println("Enter your email: ");
                String email = logc.nextLine();
                if(cc.creatorEmail == email){
                    Scanner logcc = new Scanner(System.in); 
                    System.out.println("Enter the course code: ");
                    String courseCode = logcc.nextLine();
                    for(int i = 0; i < courses.size(); i++)
                        {
                            if(courses.get(i).getcourseCode()==courseCode){
                                for(int j = 0; j < courses.get(i).getExams().size();j++){
                                        String us = courses.get(i).getExams().get(j).getSubmissions().get(j).getUser();
                                        String sus =  courses.get(i).getExams().get(j).getSubmissions().get(j).getSubmission();
                                        System.out.println("User: "+us+"Submission: "+sus);
                                
                                    }
                                    for(int j = 0; j < courses.get(i).getQuizzes().size();j++){
                                        String us = courses.get(i).getQuizzes().get(j).getSubmissions().get(j).getUser();
                                        String sus =  courses.get(i).getQuizzes().get(j).getSubmissions().get(j).getSubmission();
                                        System.out.println("User: "+us+"Submission: "+sus);
                                
                                    }
                                    for(int j = 0; j < courses.get(i).getHomeworks().size();j++){
                                        String us = courses.get(i).getHomeworks().get(j).getSubmissions().get(j).getUser();
                                        String sus =  courses.get(i).getHomeworks().get(j).getSubmissions().get(j).getSubmission();
                                        System.out.println("User: "+us+"Submission: "+sus);
                                
                                    }
                                    for(int j = 0; j < courses.get(i).getProjects().size();j++){
                                        String us = courses.get(i).getProjects().get(j).getSubmissions().get(j).getUser();
                                        String sus =  courses.get(i).getProjects().get(j).getSubmissions().get(j).getSubmission();
                                        System.out.println("User: "+us+"Submission: "+sus);
                                
                                    }
                                }     
                            }
                        }
                    }
                }
    }
    void scoreAssignment(Course cc, Assignment ss, Submit sb){
        if(login()){
            if(isFaculty()){
                Scanner logc = new Scanner(System.in); 
                System.out.println("Enter your email: ");
                String email = logc.nextLine();
                if(cc.creatorEmail == email){
                    Scanner log = new Scanner(System.in); 
                    System.out.println("Enter your email: ");
                    String emai = log.nextLine();
                    Scanner logcc = new Scanner(System.in); 
                    System.out.println("Enter the course code: ");
                    String courseCode = logcc.nextLine();
                    Scanner logas = new Scanner(System.in); 
                    System.out.println("Enter the assignment name: ");
                    String assignmentName = logas.nextLine();
                    for(int i = 0; i < courses.size(); i++)
                    {
                        if(courses.get(i).getcourseCode()==courseCode){
                            for(int j = 0; j < courses.get(i).getExams().size();j++){
                                if(courses.get(i).getExams().get(i).getassignmentName().toString() == assignmentName){
                                    for(int k = 0; k < courses.get(i).getExams().get(i).getUser().size();k++){
                                        if(courses.get(i).getExams().get(i).getUser().get(k)==email){
                                            Scanner logar = new Scanner(System.in); 
                                            System.out.println("Score the assignment: ");
                                            String subm = logar.nextLine();
                                            int scor = Integer.parseInt(subm);
                                            courses.get(i).getExams().get(i).getSubmissions().get(k).setScore(scor);
                                        }
                                    }
                                     
                                }
                            }
                            for(int j = 0; j < courses.get(i).getQuizzes().size();j++){
                                if(courses.get(i).getQuizzes().get(i).getassignmentName().toString() == assignmentName){
                                    for(int k = 0; k < courses.get(i).getQuizzes().get(i).getUser().size();k++){
                                        if(courses.get(i).getQuizzes().get(i).getUser().get(k)==email){
                                            Scanner logar = new Scanner(System.in); 
                                            System.out.println("Score the assignment: ");
                                            String subm = logar.nextLine();
                                            int scor = Integer.parseInt(subm);
                                            courses.get(i).getQuizzes().get(i).getSubmissions().get(k).setScore(scor);
                                        }
                                    }
                                     
                                }
                            }
                            for(int j = 0; j < courses.get(i).getProjects().size();j++){
                                if(courses.get(i).getProjects().get(i).getassignmentName().toString() == assignmentName){
                                    for(int k = 0; k < courses.get(i).getProjects().get(i).getUser().size();k++){
                                        if(courses.get(i).getProjects().get(i).getUser().get(k)==email){
                                            Scanner logar = new Scanner(System.in); 
                                            System.out.println("Score the assignment: ");
                                            String subm = logar.nextLine();
                                            int scor = Integer.parseInt(subm);
                                            courses.get(i).getProjects().get(i).getSubmissions().get(k).setScore(scor);
                                        }
                                    }
                                     
                                }
                            }
                            for(int j = 0; j < courses.get(i).getHomeworks().size();j++){
                                if(courses.get(i).getHomeworks().get(i).getassignmentName().toString() == assignmentName){
                                    for(int k = 0; k < courses.get(i).getHomeworks().get(i).getUser().size();k++){
                                        if(courses.get(i).getHomeworks().get(i).getUser().get(k)==email){
                                            Scanner logar = new Scanner(System.in); 
                                            System.out.println("Score the assignment: ");
                                            String subm = logar.nextLine();
                                            int scor = Integer.parseInt(subm);
                                            courses.get(i).getHomeworks().get(i).getSubmissions().get(k).setScore(scor);
                                        }
                                    }
                                     
                                }
                            }
                        }

                    }
            }

        }
    }
    }
    
    void viewAssignmentScore(){
        if (login()){
            Scanner logc = new Scanner(System.in); 
            System.out.println("Enter your email: ");
            String email = logc.nextLine();
            Scanner logcc = new Scanner(System.in); 
            System.out.println("Enter the course code: ");
            String courseCode = logcc.nextLine();
            Scanner logas = new Scanner(System.in); 
            System.out.println("Enter the assignment name: ");
            String assignmentName = logas.nextLine();
            for(int i = 0; i < courses.size(); i++)
            {
                if(courses.get(i).getcourseCode()==courseCode){
                    for(int j = 0; j < courses.get(i).getExams().size();j++){
                        if(courses.get(i).getExams().get(i).getassignmentName().toString() == assignmentName){
                            for(int k = 0; k < courses.get(i).getExams().get(i).getUser().size();k++){
                                if(courses.get(i).getExams().get(i).getUser().get(k)==email){
                                    System.out.println("User score: "+courses.get(i).getExams().get(i).getSubmissions().get(k).getScore());
                                }
                            }
                             
                        }
                    } 
                    for(int j = 0; j < courses.get(i).getQuizzes().size();j++){
                        if(courses.get(i).getQuizzes().get(i).getassignmentName().toString() == assignmentName){
                            for(int k = 0; k < courses.get(i).getQuizzes().get(i).getUser().size();k++){
                                if(courses.get(i).getQuizzes().get(i).getUser().get(k)==email){
                                    System.out.println("User score: "+courses.get(i).getQuizzes().get(i).getSubmissions().get(k).getScore());
                                }
                            }
                             
                        }
                    } 
                    for(int j = 0; j < courses.get(i).getHomeworks().size();j++){
                        if(courses.get(i).getHomeworks().get(i).getassignmentName().toString() == assignmentName){
                            for(int k = 0; k < courses.get(i).getHomeworks().get(i).getUser().size();k++){
                                if(courses.get(i).getHomeworks().get(i).getUser().get(k)==email){
                                    System.out.println("User score: "+courses.get(i).getHomeworks().get(i).getSubmissions().get(k).getScore());
                                }
                            }
                             
                        }
                    }
                    for(int j = 0; j < courses.get(i).getProjects().size();j++){
                        if(courses.get(i).getProjects().get(i).getassignmentName().toString() == assignmentName){
                            for(int k = 0; k < courses.get(i).getProjects().get(i).getUser().size();k++){
                                if(courses.get(i).getProjects().get(i).getUser().get(k)==email){
                                    System.out.println("User score: "+courses.get(i).getProjects().get(i).getSubmissions().get(k).getScore());
                                }
                            }
                             
                        }
                    }  
                }
            }
            
        }
        }
    
        

    

    void viewAssignmentScores(Course cc){
        if(login()){
            if(isFaculty()){
                Scanner logc = new Scanner(System.in); 
                System.out.println("Enter your email: ");
                String email = logc.nextLine();
                if(cc.creatorEmail == email){
                    Scanner log = new Scanner(System.in); 
                    System.out.println("Enter your email: ");
                    String emai= log.nextLine();
                    Scanner logcc = new Scanner(System.in); 
                    System.out.println("Enter the course code: ");
                    String courseCode = logcc.nextLine();
                    Scanner logas = new Scanner(System.in); 
                    System.out.println("Enter the assignment name: ");
                    String assignmentName = logas.nextLine();
                    for(int i = 0; i < courses.size(); i++)
                    {
                        if(courses.get(i).getcourseCode()==courseCode){
                            for(int j = 0; j < courses.get(i).getExams().size();j++){
                                if(courses.get(i).getExams().get(i).getassignmentName().toString() == assignmentName){
                                    for(int k = 0; k < courses.get(i).getExams().get(i).getUser().size();k++){
                                        System.out.println(courses.get(i).getExams().get(i).getSubmissions().get(k).getScore());
                                        }
                                    }
                                     
                                }
                                for(int j = 0; j < courses.get(i).getQuizzes().size();j++){
                                    if(courses.get(i).getQuizzes().get(i).getassignmentName().toString() == assignmentName){
                                        for(int k = 0; k < courses.get(i).getQuizzes().get(i).getUser().size();k++){
                                            System.out.println(courses.get(i).getQuizzes().get(i).getSubmissions().get(k).getScore());
                                            }
                                        }
                                         
                                    }
                                    for(int j = 0; j < courses.get(i).getProjects().size();j++){
                                        if(courses.get(i).getProjects().get(i).getassignmentName().toString() == assignmentName){
                                            for(int k = 0; k < courses.get(i).getProjects().get(i).getUser().size();k++){
                                                System.out.println(courses.get(i).getProjects().get(i).getSubmissions().get(k).getScore());
                                                }
                                            }
                                             
                                        }
                                        for(int j = 0; j < courses.get(i).getHomeworks().size();j++){
                                            if(courses.get(i).getHomeworks().get(i).getassignmentName().toString() == assignmentName){
                                                for(int k = 0; k < courses.get(i).getHomeworks().get(i).getUser().size();k++){
                                                    System.out.println(courses.get(i).getHomeworks().get(i).getSubmissions().get(k).getScore());
                                                    }
                                                }
                                                 
                                            }
                            
                            }
                        }
                    }
                

    }
}
    }

    // void viewAllAssignmentScores(String email, String courseCode){

    // }

    void viewAssignmentGrade(){
        if (login()){
            Scanner logc = new Scanner(System.in); 
            System.out.println("Enter your email: ");
            String email = logc.nextLine();
            Scanner logcc = new Scanner(System.in); 
            System.out.println("Enter the course code: ");
            String courseCode = logcc.nextLine();
            Scanner logas = new Scanner(System.in); 
            System.out.println("Enter the assignment name: ");
            String assignmentName = logas.nextLine();
            for(int i = 0; i < courses.size(); i++)
            {
                if(courses.get(i).getcourseCode()==courseCode){
                    for(int j = 0; j < courses.get(i).getExams().size();j++){
                        if(courses.get(i).getExams().get(i).getassignmentName().toString() == assignmentName){
                            for(int k = 0; k < courses.get(i).getExams().get(i).getUser().size();k++){
                                if(courses.get(i).getExams().get(i).getUser().get(k)==email){
                                    int f = courses.get(i).getExams().get(i).getSubmissions().get(k).getScore();
                                    String y;
                                    if(f>84){
                                        y="A+";
                                   }else if(f>79){
                                       y="A";
                                   }else if(f>74){
                                       y="B+";
                                   }else if(f>69){
                                        y="B";
                                   }else if(f>64){
                                       y="C+";
                                   }else if(f>59){
                                       y="C";
                                   }else if(f>54){
                                       y="D+";
                                   }else if(f>49){
                                       y="D";
                                   }else{
                                       y="E";
                                   }
                                   System.out.println(y);
                                }
                            }
                             
                        }
                    } 
                    for(int j = 0; j < courses.get(i).getQuizzes().size();j++){
                        if(courses.get(i).getQuizzes().get(i).getassignmentName().toString() == assignmentName){
                            for(int k = 0; k < courses.get(i).getQuizzes().get(i).getUser().size();k++){
                                if(courses.get(i).getQuizzes().get(i).getUser().get(k)==email){
                                    if(courses.get(i).getQuizzes().get(i).getUser().get(k)==email){
                                        int f = courses.get(i).getQuizzes().get(i).getSubmissions().get(k).getScore();
                                        String y;
                                        if(f>84){
                                            y="A+";
                                       }else if(f>79){
                                           y="A";
                                       }else if(f>74){
                                           y="B+";
                                       }else if(f>69){
                                            y="B";
                                       }else if(f>64){
                                           y="C+";
                                       }else if(f>59){
                                           y="C";
                                       }else if(f>54){
                                           y="D+";
                                       }else if(f>49){
                                           y="D";
                                       }else{
                                           y="E";
                                       }
                                       System.out.println(y);
                                    }
                                }
                            }
                             
                        }
                    } 
                    for(int j = 0; j < courses.get(i).getHomeworks().size();j++){
                        if(courses.get(i).getHomeworks().get(i).getassignmentName().toString() == assignmentName){
                            for(int k = 0; k < courses.get(i).getHomeworks().get(i).getUser().size();k++){
                                if(courses.get(i).getHomeworks().get(i).getUser().get(k)==email){
                                    if(courses.get(i).getHomeworks().get(i).getUser().get(k)==email){
                                        int f = courses.get(i).getHomeworks().get(i).getSubmissions().get(k).getScore();
                                        String y;
                                        if(f>84){
                                            y="A+";
                                       }else if(f>79){
                                           y="A";
                                       }else if(f>74){
                                           y="B+";
                                       }else if(f>69){
                                            y="B";
                                       }else if(f>64){
                                           y="C+";
                                       }else if(f>59){
                                           y="C";
                                       }else if(f>54){
                                           y="D+";
                                       }else if(f>49){
                                           y="D";
                                       }else{
                                           y="E";
                                       }
                                       System.out.println(y);
                                    }
                                }
                            }
                             
                        }
                    }
                    for(int j = 0; j < courses.get(i).getProjects().size();j++){
                        if(courses.get(i).getProjects().get(i).getassignmentName().toString() == assignmentName){
                            for(int k = 0; k < courses.get(i).getProjects().get(i).getUser().size();k++){
                                if(courses.get(i).getProjects().get(i).getUser().get(k)==email){
                                    if(courses.get(i).getProjects().get(i).getUser().get(k)==email){
                                        int f = courses.get(i).getProjects().get(i).getSubmissions().get(k).getScore();
                                        String y;
                                        if(f>84){
                                            y="A+";
                                       }else if(f>79){
                                           y="A";
                                       }else if(f>74){
                                           y="B+";
                                       }else if(f>69){
                                            y="B";
                                       }else if(f>64){
                                           y="C+";
                                       }else if(f>59){
                                           y="C";
                                       }else if(f>54){
                                           y="D+";
                                       }else if(f>49){
                                           y="D";
                                       }else{
                                           y="E";
                                       }
                                       System.out.println(y);
                                    }
                                }
                            }
                             
                        }
                    }  
                }
            }
            
        }
        
    }

    void viewAssignmentGrades(Course cc){
        if(login()){
            if(isFaculty()){
                Scanner logc = new Scanner(System.in); 
                System.out.println("Enter your email: ");
                String email = logc.nextLine();
                if(cc.creatorEmail == email){
                    Scanner log = new Scanner(System.in); 
                    System.out.println("Enter your email: ");
                    String emai= log.nextLine();
                    Scanner logcc = new Scanner(System.in); 
                    System.out.println("Enter the course code: ");
                    String courseCode = logcc.nextLine();
                    Scanner logas = new Scanner(System.in); 
                    System.out.println("Enter the assignment name: ");
                    String assignmentName = logas.nextLine();
                    for(int i = 0; i < courses.size(); i++)
                    {
                        if(courses.get(i).getcourseCode()==courseCode){
                            for(int j = 0; j < courses.get(i).getExams().size();j++){
                                if(courses.get(i).getExams().get(i).getassignmentName().toString() == assignmentName){
                                    for(int k = 0; k < courses.get(i).getExams().get(i).getUser().size();k++){
                                        int f = courses.get(i).getExams().get(i).getSubmissions().get(k).getScore();
                                        String y;
                                        if(f>84){
                                            y="A+";
                                       }else if(f>79){
                                           y="A";
                                       }else if(f>74){
                                           y="B+";
                                       }else if(f>69){
                                            y="B";
                                       }else if(f>64){
                                           y="C+";
                                       }else if(f>59){
                                           y="C";
                                       }else if(f>54){
                                           y="D+";
                                       }else if(f>49){
                                           y="D";
                                       }else{
                                           y="E";
                                       }
                                       System.out.println(y);
                                        }
                                    }
                                     
                                }
                                for(int j = 0; j < courses.get(i).getQuizzes().size();j++){
                                    if(courses.get(i).getQuizzes().get(i).getassignmentName().toString() == assignmentName){
                                        for(int k = 0; k < courses.get(i).getQuizzes().get(i).getUser().size();k++){
                                            int f = courses.get(i).getQuizzes().get(i).getSubmissions().get(k).getScore();
                                        String y;
                                        if(f>84){
                                            y="A+";
                                       }else if(f>79){
                                           y="A";
                                       }else if(f>74){
                                           y="B+";
                                       }else if(f>69){
                                            y="B";
                                       }else if(f>64){
                                           y="C+";
                                       }else if(f>59){
                                           y="C";
                                       }else if(f>54){
                                           y="D+";
                                       }else if(f>49){
                                           y="D";
                                       }else{
                                           y="E";
                                       }
                                       System.out.println(y);
                                            }
                                        }
                                         
                                    }
                                    for(int j = 0; j < courses.get(i).getProjects().size();j++){
                                        if(courses.get(i).getProjects().get(i).getassignmentName().toString() == assignmentName){
                                            for(int k = 0; k < courses.get(i).getProjects().get(i).getUser().size();k++){
                                                int f = courses.get(i).getProjects().get(i).getSubmissions().get(k).getScore();
                                        String y;
                                        if(f>84){
                                            y="A+";
                                       }else if(f>79){
                                           y="A";
                                       }else if(f>74){
                                           y="B+";
                                       }else if(f>69){
                                            y="B";
                                       }else if(f>64){
                                           y="C+";
                                       }else if(f>59){
                                           y="C";
                                       }else if(f>54){
                                           y="D+";
                                       }else if(f>49){
                                           y="D";
                                       }else{
                                           y="E";
                                       }
                                       System.out.println(y);
                                                }
                                            }
                                             
                                        }
                                        for(int j = 0; j < courses.get(i).getHomeworks().size();j++){
                                            if(courses.get(i).getHomeworks().get(i).getassignmentName().toString() == assignmentName){
                                                for(int k = 0; k < courses.get(i).getHomeworks().get(i).getUser().size();k++){
                                                    int f = courses.get(i).getHomeworks().get(i).getSubmissions().get(k).getScore();
                                        String y;
                                        if(f>84){
                                            y="A+";
                                       }else if(f>79){
                                           y="A";
                                       }else if(f>74){
                                           y="B+";
                                       }else if(f>69){
                                            y="B";
                                       }else if(f>64){
                                           y="C+";
                                       }else if(f>59){
                                           y="C";
                                       }else if(f>54){
                                           y="D+";
                                       }else if(f>49){
                                           y="D";
                                       }else{
                                           y="E";
                                       }
                                       System.out.println(y);
                                                    }
                                                }
                                                 
                                            }
                            
                            }
                        }
                    }
                

    }
}
    }

    

     public class Course{
        String courseCode;
        String courseName;
        String creatorName;
        String creatorEmail;
        ArrayList<String> users = new ArrayList<String>();
        ArrayList<Assignment> quiz = new ArrayList<Assignment>();
        ArrayList<Assignment> homework = new ArrayList<Assignment>();
        ArrayList<Assignment> project = new ArrayList<Assignment>();
        ArrayList<Assignment> exam = new ArrayList<Assignment>();

        public void addQuiz(Assignment x){
            quiz.add(x);
        }
    
        public ArrayList<Assignment> getQuizzes(){
            return quiz;
        }

        public void addHomework(Assignment x){
            homework.add(x);
        }
    
        public ArrayList<Assignment> getHomeworks(){
            return homework;
        }

        public void addProject(Assignment x){
            project.add(x);
        }
    
        public ArrayList<Assignment> getProjects(){
            return project;
        }

        public void addExam(Assignment x){
            exam.add(x);
        }
    
        public ArrayList<Assignment> getExams(){
            return exam;
        }

        public String getcourseCode() { 
            return courseCode; 
         } 
        public void setcourseCode(String x) { 
            this.courseCode = x; 
         }
         public void addUsers(String x){
             users.add(x);
         }
         public ArrayList<String> getUsers(){
            return users;
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

     public class Assignment{
        String assignmentName;
        String description;
        String dueDate;
        ArrayList<Submit> submissions = new ArrayList<Submit>();
        ArrayList<String> user = new ArrayList<String>();

        public String getassignmentName() { 
            return assignmentName; 
         } 
        public void setassignmentName(String x) { 
            this.assignmentName = x; 
        }
        public String getDescription() { 
            return description; 
         } 
        public void setDescription(String x) { 
            this.description = x; 
        }
        public String getdueDate() { 
            return dueDate; 
         } 
        public void setdueDate(String x) { 
            this.dueDate = x; 
        }
        public void addUser(String x){
            user.add(x);
        }
        public ArrayList<String> getUser(){
           return user;
        }
        public void addSubmissions(Submit x){
            submissions.add(x);
        }
        public ArrayList<Submit> getSubmissions(){
            return submissions;
        }

    }

    public class Submit{
        String sub;
        int score;
        String grade;
        String user;

        public String getUser(){
            return user;
        }
        public void setUser(String c){
            this.user = c;
        }
        public String getSubmission() { 
            return sub; 
         } 
        public void setSubmission(String x) { 
            this.sub = x; 
        }
        public String getGrade() { 
            return grade; 
         } 
        public void setGrade(String x) { 
            this.grade = x; 
        }
        public int getScore() { 
            return score; 
         } 
        public void setScore(int x) { 
            this.score = x; 
        }
    }
    

    
    public static void main(String[] args) {
        
        // Canvas acc = new Canvas();
        // // acc.createAccount();
        // // acc.login();
        // // acc.updateProfile();
        // // acc.viewProfile();
        // // acc.isAdmin();
        // // acc.makeFaculty();
        // Course cc = acc.new Course();
        // // acc.createCourse(cc);
        // // acc.viewCourses();
        // // acc.registerCourse(cc);
        // acc.viewCourseByCode();
        // Assignment ss = acc.new Assignment();
        // acc.addAssignment(cc, ss);
        // Submit sb = acc.new Submit();
        // acc.submitAssignment(cc,ss,sb);
        }
    }

 
