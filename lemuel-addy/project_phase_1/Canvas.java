import java.util.Scanner;
import java.util.*;


public class Canvas implements Canvasinterface{
    
    
    ArrayList<Person> users = new ArrayList<Person>();
    ArrayList<Faculty> faculty = new ArrayList<Faculty>();
    ArrayList<String> admins = new ArrayList<String>();
    ArrayList<String> courseCodes = new ArrayList<String>();
    ArrayList<Course> courses = new ArrayList<Course>();
    boolean accountUpdate;
    String notifassignmentPost;
    String notifregisterCourse;
    String notifscoreSubmission;

    public Canvas(){
        admins.add("daniel.nettey@ashesi.edu.gh");
        admins.add("dennis.owusu@ashesi.edu.gh");
        
    }

    public void createAccount(Person p){
        Scanner init = new Scanner(System.in); 
        System.out.println("Welcome to Canvas/n To create an account, please enter your email: ");
        String entry = init.nextLine();
        if(entry.contains("@ashesi.edu.gh")){
            p.setEmail(entry);
            Scanner initp = new Scanner(System.in); 
            System.out.println("Please enter your new password: ");
            String pass = initp.nextLine();
            Scanner verip = new Scanner(System.in); 
            System.out.println("Please verify your new password: ");
            String passv = verip.nextLine();
            if (pass.equals(passv)){
                System.out.println("Account successfully created!");
                p.setPassword(pass);
                users.add(p);
            }
            else{
                System.out.println("Password does not match. Try again");
            }

        }
        else{
            System.out.println("invalid email address. Try again");
        }; 
     
        
    }


     
    
    public boolean login(){
        Scanner loge = new Scanner(System.in); 
        System.out.println("Welcome to Canvas\n To Log in, please enter your email: ");
        String entry = loge.nextLine();
        Scanner logp = new Scanner(System.in); 
        System.out.println("Enter your password: ");
        String pass = logp.nextLine();
        for(int i = 0; i < users.size(); i++)
        {
        if(users.get(i).getEmail().equals(entry) && users.get(i).getPassword().equals(pass)){
            return true;
        }
        
        }
        return false;
    }




    boolean login (String email,String password){
        for(int i = 0; i < users.size(); i++)
        {
            if (users.get(i).getEmail().equals(email)&&users.get(i).getPassword().equals(password)){
                return true;
            }
            
            
        }
        return false;
    }

    public boolean updateProfile(){
        Scanner loge = new Scanner(System.in); 
        System.out.println("To Update your profile\n Enter your email: ");
        String email = loge.nextLine();
        Scanner logp = new Scanner(System.in); 
        System.out.println("Enter your password: ");
        String pass = logp.nextLine();
        if (login(email,pass)){
            for(int i = 0; i < users.size(); i++)
        {
            Scanner logf = new Scanner(System.in); 
            System.out.println("Enter your first name: ");
            String first = logf.nextLine();
            users.get(i).setFirstname(first);
            Scanner logl = new Scanner(System.in); 
            System.out.println("Enter your last name: ");
            String last = logl.nextLine();
            users.get(i).setLastname(last);
            Scanner logy = new Scanner(System.in); 
            System.out.println("Enter your year group: ");
            String year = logy.nextLine();
            users.get(i).setYearGroup(year);
            Scanner logpa = new Scanner(System.in); 
            System.out.println("Enter your current GPA: ");
            String current = logpa.nextLine();
            users.get(i).setGpa(current);
            Scanner logdob = new Scanner(System.in); 
            System.out.println("Enter your date of birth(dd/mm/yy): ");
            String dateofBirth = logdob.nextLine();
            users.get(i).setDob(dateofBirth);
            accountUpdate = true;
            return accountUpdate;
        }
        
    }
            accountUpdate = false;
            return accountUpdate;
        
    }

    public void viewProfile(){
        Scanner log = new Scanner(System.in); 
        System.out.println("To view your profile, please enter you email: ");
        String entry = log.nextLine();
        Scanner logp = new Scanner(System.in); 
        System.out.println("Enter your password: ");
        String pass = logp.nextLine();
        if (login(entry,pass)){
        if (accountUpdate == false){
            for(int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getEmail().equals(entry)){
            users.get(i).setFirstname("NA");
            users.get(i).setLastname("NA");
            users.get(i).setYearGroup("NA");
            users.get(i).setGpa("NA");
            users.get(i).setDob("NA");
            System.out.println("User Profile\nEmail: " + entry + "\nFirst Name: "+users.get(i).getFirstname()+"\nLast Name: "+users.get(i).getLastname()+"\nYear Group: "+users.get(i).getYearGroup()+"\nCurrent GPA: "+users.get(i).getGpa()+"\nDate of birth: "+users.get(i).getDob());
            }
        }
    }
        else{
            for(int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getEmail().equals(entry)){
                System.out.println("User Profile\nEmail: " + entry + "\nFirst Name: "+users.get(i).getFirstname()+"\nLast Name: "+users.get(i).getLastname()+"\nYear Group: "+users.get(i).getYearGroup()+"\nCurrent GPA: "+users.get(i).getGpa()+"\nDate of birth: "+users.get(i).getDob());
            }
        }

        }
        }
        
    }
    

    public boolean isAdmin(){
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
    boolean isAdmin(String email){
        if(admins.contains(email)){
            return true;
        }
        else{
            return false;
        }
    }

    public void makeFaculty(Faculty f){
        Scanner loge = new Scanner(System.in); 
            System.out.println("To assign Faculty, Enter your email: ");
            String email = loge.nextLine();
        Scanner logp = new Scanner(System.in); 
        System.out.println("Enter your password: ");
        String pass = logp.nextLine();
        if (login(email,pass)){
            if(isAdmin(email)){ 
                    f.setEmail(email);
                    faculty.add(f);
                    System.out.println("Assigned role of Faculty.");
                
            }
        }

    }
         

    

    public boolean isFaculty(){
        Scanner loge = new Scanner(System.in); 
        System.out.println("Enter your email to verify you are a faculty member: ");
        String email = loge.nextLine();
        try{
        for(int i = 0; i < faculty.size(); i++)
        {
            if(faculty.get(i).getEmail().equals(email)){
        
            System.out.println( "Yes");
            return true;
        
       
            
        }
    }
}
    catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Not found");
    }
    
    return false;
    }

    boolean isFaculty(String email){
        for(int i = 0; i < users.size(); i++)
        {
            if(faculty.get(i).getEmail().equals(email)){
       return true;
        
       
            
        }
    }
    return false;
    }

        

    

    public void createCourse(Course cc){
        Scanner loge = new Scanner(System.in); 
        System.out.println("Please enter your email: ");
        String entry = loge.nextLine();
        Scanner logp = new Scanner(System.in); 
        System.out.println("Enter your password: ");
        String pass = logp.nextLine();
        if (login(entry,pass)){
            if(isFaculty(entry)){
                Scanner logcc = new Scanner(System.in); 
                System.out.println("Enter the course code: ");
                String courseCode = logcc.nextLine();
                
                cc.setcourseCode(courseCode);
                Scanner logc = new Scanner(System.in); 
                System.out.println("Enter the course name: ");
                String courseName = logc.nextLine();
                
                cc.setcourseName(courseName);
                Scanner logn = new Scanner(System.in); 
                System.out.println("Enter creator's name: ");
                String creatorName = logn.nextLine();
                
                cc.setcreatorName(creatorName);
                Scanner logne = new Scanner(System.in); 
                System.out.println("Enter creator's email: ");
                String creatorEmail = logne.nextLine();
                
                cc.setcreatorEmail(creatorEmail);
                courses.add(cc);
                System.out.println("Course successfully created!");
            }
        }
    }

    public void viewCourses(){
        for(int i = 0; i < courses.size(); i++)
        {
            System.out.println("Course: "+courses.get(i).getcourseName()+"\nCourse code: "+courses.get(i).getcourseCode()+"\nCourse creator's email: "+courses.get(i).getcreatorEmail()+"\nCourse creator's name: "+courses.get(i).getcreatorName());

        }
    }

   public void registerCourse(){
        Scanner loge = new Scanner(System.in); 
        System.out.println("Please enter your email: ");
        String entry = loge.nextLine();
        Scanner logp = new Scanner(System.in); 
        System.out.println("Enter your password: ");
        String pass = logp.nextLine();
        if(login(entry,pass)){
            Scanner logcc = new Scanner(System.in); 
            System.out.println("Enter the course code for registration: ");
            String courseCode = logcc.nextLine();
            try{
            for(int i = 0; i < courses.size(); i++)
            {
                if(courses.get(i).getcourseCode()==courseCode){
                    courses.get(i).addUsers(entry);
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Course not found");
        }
        }
    }

    public void viewCourseByCode(){
        Scanner logcc = new Scanner(System.in); 
        System.out.println("Enter the course code for registration: ");
        String courseCode = logcc.nextLine();
        try{
        for(int i = 0; i < courses.size(); i++)
            {
                if(courses.get(i).getcourseCode()==courseCode){
                    System.out.println("Course: "+courses.get(i).getcourseName()+"\nCourse code: "+courses.get(i).getcourseCode()+"\nCourse creator's email: "+courses.get(i).getcreatorEmail()+"\nCourse creator's name: "+courses.get(i).getcreatorName());
                    System.out.println(courses.get(i).getUsers());
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Course not found");
        }
    }

    public void viewCoursesByEmail(){
        Scanner logc = new Scanner(System.in); 
        System.out.println("Enter your email: ");
        String email = logc.nextLine();
        try{
        for(int i = 0; i < courses.size(); i++)
            {
                if(courses.get(i).getUsers().contains(email)){
                    System.out.println("Course: "+courses.get(i).getcourseName()+"\nCourse code: "+courses.get(i).getcourseCode());
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("User not found");
        }

    }

    public void addAssignment(Assignment ss){
        System.out.println("To Add an assignment, make sure you're logged in");
        Scanner logc = new Scanner(System.in); 
        System.out.println("Enter your email: ");
        String email = logc.nextLine();
        if(isFaculty(email)){
                
                for(int i = 0; i < courses.size(); i++)
                        {   Scanner logcc = new Scanner(System.in); 
                            System.out.println("Enter the course code: ");
                            String courseCode = logcc.nextLine();
                            if(courses.get(i).getcourseCode().equals(courseCode)){
                                
                                if(courses.get(i).getcreatorEmail().equals(email)){
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
                                if(assignmentType.equals("Quiz")||assignmentType.equals("QUIZ")|| assignmentType.equals("quiz")){
                                    courses.get(i).addQuiz(ss);
                                }
                                if(assignmentType.equals("Homework")||assignmentType.equals("HOMEWORK")|| assignmentType.equals("homework")){
                                    courses.get(i).addHomework(ss);
                                }
                                if(assignmentType.equals("Project")||assignmentType.equals("PROJECT")|| assignmentType.equals("project")){
                                    courses.get(i).addProject(ss);
                                }
                                if(assignmentType.equals("Exam")||assignmentType.equals("EXAM")|| assignmentType.equals("exam")){
                                    courses.get(i).addExam(ss);
                                }
                                System.out.println("Assignment Added Successfully");
                            }
                            }
                        }

                    }
                }
                    
                    
                    
                
        
        
    

    public void viewAssignmentsByCourse(){
        Scanner logc = new Scanner(System.in); 
        System.out.println("Enter the course code: ");
        String courseCode = logc.nextLine();
        for(int i = 0; i < courses.size(); i++)
             {
                if(courses.get(i).getcourseCode().equals(courseCode)){
                    try{
                    for (int j = 0; i < courses.get(i).getQuizzes().size(); j++)
                        {
                        System.out.println("Quizzes: "+courses.get(i).getQuizzes().get(j).getassignmentName());
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Assignment not found");
                    }
                        try{
                    for (int r = 0; i < courses.get(i).getHomeworks().size(); r++)
                        {
                        System.out.println("Homeworks: "+courses.get(i).getHomeworks().get(r).getassignmentName());
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Assignment not found");
                    }
                        try{
                    for (int t = 0; i < courses.get(i).getHomeworks().size(); t++)
                        {
                        System.out.println("Projects: "+courses.get(i).getProjects().get(t).getassignmentName());
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Assignment not found");
                    }
                    try{
                    for (int p = 0; i < courses.get(i).getExams().size(); p++)
                        {
                        System.out.println("Exams: "+courses.get(i).getExams().get(p).getassignmentName());
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Assignment not found");
                    }
                
                }
                else{
                    System.out.println("Course not found");
                }
       
             }
       
    }

    public void viewAssignmentsByEmail(){
        Scanner log = new Scanner(System.in); 
        System.out.println("Enter your email: ");
        String email = log.nextLine();
        for(int i = 0; i < courses.size(); i++)
            {
                for(int j = 0; j < courses.get(i).getExams().size();j++){
                    if(courses.get(i).getExams().get(i).getUser().toString().equals(email)){
                        System.out.println(courses.get(i).getExams().get(i));

                    }
                }
                for(int j = 0; j < courses.get(i).getQuizzes().size();j++){
                    if(courses.get(i).getQuizzes().get(i).getUser().toString().equals(email)){
                        System.out.println(courses.get(i).getQuizzes().get(i));

                    }
                }
                for(int j = 0; j < courses.get(i).getHomeworks().size();j++){
                    if(courses.get(i).getHomeworks().get(i).getUser().toString().equals(email)){
                        System.out.println(courses.get(i).getHomeworks().get(i));

                    }
                }
                for(int j = 0; j < courses.get(i).getProjects().size();j++){
                    if(courses.get(i).getProjects().get(i).getUser().toString().equals(email)){
                        System.out.println(courses.get(i).getProjects().get(i));

                    }
                }
            }

    }

    public void submitAssignment(Submit sb){
        Scanner logc = new Scanner(System.in); 
        System.out.println("Enter your email: ");
        String email = logc.nextLine();
        Scanner logp = new Scanner(System.in); 
        System.out.println("Enter your password: ");
        String pass = logp.nextLine();
        if(login(email,pass)){
            
            Scanner logcc = new Scanner(System.in); 
            System.out.println("Enter the course code: ");
            String courseCode = logcc.nextLine();
            Scanner logas = new Scanner(System.in); 
            System.out.println("Enter the assignment name: ");
            String assignmentName = logas.nextLine();
            for(int i = 0; i < courses.size(); i++)
            {
                if(courses.get(i).getcourseCode().equals(courseCode)){
                    for(int j = 0; j < courses.get(i).getExams().size();j++){
                        if(courses.get(i).getExams().get(i).getassignmentName().toString().equals(assignmentName)){
                            Scanner logar = new Scanner(System.in); 
                            System.out.println("Input the submission ");
                            String subm = logar.nextLine();
                            sb.setSubmission(subm);
                            sb.setUser(email);
                            courses.get(i).getExams().get(i).addSubmissions(sb); 
                        }
                    }
                    for(int j = 0; j < courses.get(i).getQuizzes().size();j++){
                        if(courses.get(i).getQuizzes().get(i).getassignmentName().toString().equals(assignmentName)){
                            Scanner logaq = new Scanner(System.in); 
                            System.out.println("Input the submission ");
                            String subm = logaq.nextLine();
                            sb.setSubmission(subm);
                            sb.setUser(email);
                            courses.get(i).getExams().get(i).addSubmissions(sb); 
    
                        }
                    }
                    for(int j = 0; j < courses.get(i).getHomeworks().size();j++){
                        if(courses.get(i).getHomeworks().get(i).getassignmentName().toString().equals(email)){
                            Scanner logah= new Scanner(System.in); 
                            System.out.println("Input the submission ");
                            String subm = logah.nextLine();
                            sb.setSubmission(subm);
                            sb.setUser(email);
                            courses.get(i).getExams().get(i).addSubmissions(sb); 
    
                        }
                    }
                    for(int j = 0; j < courses.get(i).getProjects().size();j++){
                        if(courses.get(i).getProjects().get(i).getassignmentName().toString().equals(email)){
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

    public void viewSubmissions(){
        Scanner logc = new Scanner(System.in); 
        System.out.println("Enter your email: ");
        String email = logc.nextLine();
        Scanner logp = new Scanner(System.in); 
        System.out.println("Enter your password: ");
        String pass = logp.nextLine();
        if(login(email,pass)){
           if(isFaculty(email)){
                for(int i = 0; i < courses.size(); i++)
                        {
                            Scanner logcc = new Scanner(System.in); 
                            System.out.println("Enter the course code: ");
                            String courseCode = logcc.nextLine();
                            if(courses.get(i).getcourseCode().equals(courseCode)){
                                
                                if(courses.get(i).getcreatorEmail().equals(email)){
                                        
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
    public void scoreAssignment(){
        Scanner logc = new Scanner(System.in); 
        System.out.println("Enter your email: ");
        String email = logc.nextLine();
        Scanner logp = new Scanner(System.in); 
        System.out.println("Enter your password: ");
        String pass = logp.nextLine();
        if(login(email,pass)){
            if(isFaculty(email)){
                
                
                    Scanner logcc = new Scanner(System.in); 
                    System.out.println("Enter the course code: ");
                    String courseCode = logcc.nextLine();
                    Scanner logas = new Scanner(System.in); 
                    System.out.println("Enter the assignment name: ");
                    String assignmentName = logas.nextLine();
                    for(int i = 0; i < courses.size(); i++)
                    {
                        
                        if(courses.get(i).getcourseCode().equals(courseCode)){
                            
                            if(courses.get(i).getcreatorEmail().equals(email)){
                            for(int j = 0; j < courses.get(i).getExams().size();j++){
                                if(courses.get(i).getExams().get(i).getassignmentName().toString().equals(assignmentName)){
                                    for(int k = 0; k < courses.get(i).getExams().get(i).getUser().size();k++){
                                        if(courses.get(i).getExams().get(i).getUser().get(k).equals(email)){
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
                                if(courses.get(i).getQuizzes().get(i).getassignmentName().toString().equals(assignmentName)){
                                    for(int k = 0; k < courses.get(i).getQuizzes().get(i).getUser().size();k++){
                                        if(courses.get(i).getQuizzes().get(i).getUser().get(k).equals(email)){
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
                                if(courses.get(i).getProjects().get(i).getassignmentName().toString().equals(assignmentName)){
                                    for(int k = 0; k < courses.get(i).getProjects().get(i).getUser().size();k++){
                                        if(courses.get(i).getProjects().get(i).getUser().get(k).equals(email)){
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
                                if(courses.get(i).getHomeworks().get(i).getassignmentName().toString().equals(assignmentName)){
                                    for(int k = 0; k < courses.get(i).getHomeworks().get(i).getUser().size();k++){
                                        if(courses.get(i).getHomeworks().get(i).getUser().get(k).equals(email)){
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
        
    
    public void viewAssignmentScore(){
        Scanner logc = new Scanner(System.in); 
        System.out.println("Enter your email: ");
        String email = logc.nextLine();
        Scanner logp = new Scanner(System.in); 
        System.out.println("Enter your password: ");
        String pass = logp.nextLine();
        if (login(email,pass)){
            Scanner logcc = new Scanner(System.in); 
            System.out.println("Enter the course code: ");
            String courseCode = logcc.nextLine();
            Scanner logas = new Scanner(System.in); 
            System.out.println("Enter the assignment name: ");
            String assignmentName = logas.nextLine();
            for(int i = 0; i < courses.size(); i++)
            {
                if(courses.get(i).getcourseCode().equals(courseCode)){
                    for(int j = 0; j < courses.get(i).getExams().size();j++){
                        if(courses.get(i).getExams().get(i).getassignmentName().toString().equals(assignmentName)){
                            for(int k = 0; k < courses.get(i).getExams().get(i).getUser().size();k++){
                                if(courses.get(i).getExams().get(i).getUser().get(k).equals(email)){
                                    System.out.println("User score: "+courses.get(i).getExams().get(i).getSubmissions().get(k).getScore());
                                }
                            }
                             
                        }
                    } 
                    for(int j = 0; j < courses.get(i).getQuizzes().size();j++){
                        if(courses.get(i).getQuizzes().get(i).getassignmentName().toString().equals(assignmentName)){
                            for(int k = 0; k < courses.get(i).getQuizzes().get(i).getUser().size();k++){
                                if(courses.get(i).getQuizzes().get(i).getUser().get(k).equals(email)){
                                    System.out.println("User score: "+courses.get(i).getQuizzes().get(i).getSubmissions().get(k).getScore());
                                }
                            }
                             
                        }
                    } 
                    for(int j = 0; j < courses.get(i).getHomeworks().size();j++){
                        if(courses.get(i).getHomeworks().get(i).getassignmentName().toString().equals(assignmentName)){
                            for(int k = 0; k < courses.get(i).getHomeworks().get(i).getUser().size();k++){
                                if(courses.get(i).getHomeworks().get(i).getUser().get(k).equals(email)){
                                    System.out.println("User score: "+courses.get(i).getHomeworks().get(i).getSubmissions().get(k).getScore());
                                }
                            }
                             
                        }
                    }
                    for(int j = 0; j < courses.get(i).getProjects().size();j++){
                        if(courses.get(i).getProjects().get(i).getassignmentName().toString().equals(assignmentName)){
                            for(int k = 0; k < courses.get(i).getProjects().get(i).getUser().size();k++){
                                if(courses.get(i).getProjects().get(i).getUser().get(k).equals(email)){
                                    System.out.println("User score: "+courses.get(i).getProjects().get(i).getSubmissions().get(k).getScore());
                                }
                            }
                             
                        }
                    }  
                }
            }
            
        }
        }
    
        

    

    public void viewAssignmentScores(){
        Scanner logc = new Scanner(System.in); 
        System.out.println("Enter your email: ");
        String email = logc.nextLine();
        Scanner logp = new Scanner(System.in); 
        System.out.println("Enter your password: ");
        String pass = logp.nextLine();
        if(login(email,pass)){
            if(isFaculty(email)){
                    
                    Scanner logcc = new Scanner(System.in); 
                    System.out.println("Enter the course code: ");
                    String courseCode = logcc.nextLine();
                    Scanner logas = new Scanner(System.in); 
                    System.out.println("Enter the assignment name: ");
                    String assignmentName = logas.nextLine();
                    for(int i = 0; i < courses.size(); i++)
                    {
                            if(courses.get(i).getcourseCode().equals(courseCode)){
                            if(courses.get(i).getcreatorEmail().equals(email)){    
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
                

    


    public void viewAssignmentGrade(){
        Scanner logc = new Scanner(System.in); 
        System.out.println("Enter your email: ");
        String email = logc.nextLine();
        Scanner logp = new Scanner(System.in); 
        System.out.println("Enter your password: ");
        String pass = logp.nextLine();
        if (login(email,pass)){
            Scanner logcc = new Scanner(System.in); 
            System.out.println("Enter the course code: ");
            String courseCode = logcc.nextLine();
            Scanner logas = new Scanner(System.in); 
            System.out.println("Enter the assignment name: ");
            String assignmentName = logas.nextLine();
            for(int i = 0; i < courses.size(); i++)
            {
                if(courses.get(i).getcourseCode().equals(courseCode)){
                    for(int j = 0; j < courses.get(i).getExams().size();j++){
                        if(courses.get(i).getExams().get(i).getassignmentName().toString().equals(assignmentName)){
                            for(int k = 0; k < courses.get(i).getExams().get(i).getUser().size();k++){
                                if(courses.get(i).getExams().get(i).getUser().get(k).equals(email)){
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
                        if(courses.get(i).getQuizzes().get(i).getassignmentName().toString().equals(assignmentName)){
                            for(int k = 0; k < courses.get(i).getQuizzes().get(i).getUser().size();k++){
                                if(courses.get(i).getQuizzes().get(i).getUser().get(k).equals(email)){
                                    if(courses.get(i).getQuizzes().get(i).getUser().get(k).equals(email)){
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
                        if(courses.get(i).getHomeworks().get(i).getassignmentName().toString().equals(assignmentName)){
                            for(int k = 0; k < courses.get(i).getHomeworks().get(i).getUser().size();k++){
                                if(courses.get(i).getHomeworks().get(i).getUser().get(k).equals(email)){
                                    if(courses.get(i).getHomeworks().get(i).getUser().get(k).equals(email)){
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
                        if(courses.get(i).getProjects().get(i).getassignmentName().toString().equals(assignmentName)){
                            for(int k = 0; k < courses.get(i).getProjects().get(i).getUser().size();k++){
                                if(courses.get(i).getProjects().get(i).getUser().get(k).equals(email)){
                                    if(courses.get(i).getProjects().get(i).getUser().get(k).equals(email)){
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

    public void viewAssignmentGrades(){
        Scanner logc = new Scanner(System.in); 
        System.out.println("Enter your email: ");
        String email = logc.nextLine();
        Scanner logp = new Scanner(System.in); 
        System.out.println("Enter your password: ");
        String pass = logp.nextLine();
        if(login(email,pass)){
            if(isFaculty(email)){
                                Scanner logcc = new Scanner(System.in); 
                                System.out.println("Enter the course code: ");
                                String courseCode = logcc.nextLine();
                                Scanner logas = new Scanner(System.in); 
                                System.out.println("Enter the assignment name: ");
                                String assignmentName = logas.nextLine();
                                for(int i = 0; i < courses.size(); i++)
                                {
                                        if(courses.get(i).getcourseCode().equals(courseCode)){
                                        if(courses.get(i).getcreatorEmail().equals(email)){   
                        for(int j = 0; j < courses.get(i).getExams().size();j++){
                                if(courses.get(i).getExams().get(i).getassignmentName().toString().equals(assignmentName)){
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
                                    if(courses.get(i).getQuizzes().get(i).getassignmentName().toString().equals(assignmentName)){
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
                                        if(courses.get(i).getProjects().get(i).getassignmentName().toString().equals(assignmentName)){
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
                                            if(courses.get(i).getHomeworks().get(i).getassignmentName().toString().equals(assignmentName)){
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
         
        public void setNotificationPreferences(){
            Scanner logc = new Scanner(System.in); 
            System.out.println("Enter your email: ");
            String email = logc.nextLine();
            Scanner logp = new Scanner(System.in); 
            System.out.println("Enter your password: ");
            String pass = logp.nextLine();
            if(login(email,pass)){
            
            Scanner loga = new Scanner(System.in); 
            System.out.println("Do you want to receive notifications when\nAn assignment is posted: ");
            notifassignmentPost = loga.nextLine();
            Scanner loge = new Scanner(System.in); 
            System.out.println("A score is submitted for their assignment: ");
            notifscoreSubmission = loge.nextLine();
            Scanner logt = new Scanner(System.in); 
            System.out.println("You register for a course: ");
            notifregisterCourse = logt.nextLine();
            
            }



        }

   

    

     protected class Course{
        String courseCode;
        String courseName;
        String creatorName;
        String creatorEmail;
        ArrayList<String> users = new ArrayList<String>();
        ArrayList<Assignment> quiz = new ArrayList<Assignment>();
        ArrayList<Assignment> homework = new ArrayList<Assignment>();
        ArrayList<Assignment> project = new ArrayList<Assignment>();
        ArrayList<Assignment> exam = new ArrayList<Assignment>();

         void addQuiz(Assignment x){
            quiz.add(x);
        }
    
         ArrayList<Assignment> getQuizzes(){
            return quiz;
        }
 
         void addHomework(Assignment x){
            homework.add(x);
        }
    
         ArrayList<Assignment> getHomeworks(){
            return homework;
        }

         void addProject(Assignment x){
            project.add(x);
        }
    
         ArrayList<Assignment> getProjects(){
            return project;
        }

         void addExam(Assignment x){
            exam.add(x);
        }
    
         ArrayList<Assignment> getExams(){
            return exam;
        }

         String getcourseCode() { 
            return courseCode; 
         } 
         void setcourseCode(String x) { 
            this.courseCode = x; 
         }
          void addUsers(String x){
             users.add(x);
         }
          ArrayList<String> getUsers(){
            return users;
         }
          String getcourseName() { 
            return courseName; 
         } 
         void setcourseName(String x) { 
            this.courseName = x; 
        }
         String getcreatorName() { 
            return creatorName; 
         } 
         void setcreatorName(String x) { 
            this.creatorName = x; 
    
        }
         String getcreatorEmail() { 
            return creatorEmail; 
         } 
         void setcreatorEmail(String x) { 
            this.creatorEmail = x; 
        }
    }

     protected class Assignment{
        String assignmentName;
        String description;
        String dueDate;
        ArrayList<Submit> submissions = new ArrayList<Submit>();
        ArrayList<String> user = new ArrayList<String>();

        String getassignmentName() { 
            return assignmentName; 
         } 
        void setassignmentName(String x) { 
            this.assignmentName = x; 
        }
        String getDescription() { 
            return description; 
         } 
        void setDescription(String x) { 
            this.description = x; 
        }
        String getdueDate() { 
            return dueDate; 
         } 
        void setdueDate(String x) { 
            this.dueDate = x; 
        }
        void addUser(String x){
            user.add(x);
        }
        ArrayList<String> getUser(){
           return user;
        }
        void addSubmissions(Submit x){
            submissions.add(x);
        }
        ArrayList<Submit> getSubmissions(){
            return submissions;
        }

    }

    protected class Submit{
        String sub;
        int score;
        String grade;
        String user;

         String getUser(){
            return user;
        }
         void setUser(String c){
            this.user = c;
        }
         String getSubmission() { 
            return sub; 
         } 
         void setSubmission(String x) { 
            this.sub = x; 
        }
         String getGrade() { 
            return grade; 
         } 
         void setGrade(String x) { 
            this.grade = x; 
        }
         int getScore() { 
            return score; 
         } 
         void setScore(int x) { 
            this.score = x; 
        }
    }
    

    
    public static void main(String[] args) {
        
        
        Canvas acc = new Canvas();
        Person p = new Person();
        acc.createAccount(p);
        acc.login();
        Faculty f = new Faculty();
        acc.makeFaculty(f);
        acc.isFaculty();
            
        }
    }
