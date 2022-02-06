
import java.util.Scanner; 
import java.util.ArrayList;

public class papayaw {

  ArrayList<String> emailArr = new ArrayList<String>();
  ArrayList<String> passArr = new ArrayList<String>();
  ArrayList<String> firstnameArr = new ArrayList<String>();
  ArrayList<String> lastnameArr = new ArrayList<String>();
  ArrayList<String> yeargArr = new ArrayList<String>();
  ArrayList<String> curgpaArr = new ArrayList<String>();
  ArrayList<String> dobArr = new ArrayList<String>();
  ArrayList<String> adminArr = new ArrayList<String>();
  ArrayList<String> facultyArr = new ArrayList<String>();
  ArrayList<String> courseNameArr = new ArrayList<String>();
  ArrayList<String> courseCodeArr = new ArrayList<String>();
  ArrayList<String> courseRegE22 = new ArrayList<String>();
  ArrayList<String> assignmentNameArr = new ArrayList<String>();
  ArrayList<String> assignmentDescriptionArr = new ArrayList<String>();
  ArrayList<String> assignmentDueArr = new ArrayList<String>();
  ArrayList<String> assignmentTypeArr = new ArrayList<String>();
  ArrayList<String> assignmentSubArr = new ArrayList<String>();
  ArrayList<Integer> ScoresArr = new ArrayList<Integer>();



  boolean profileExists;
 

  String email, password, firstname, lastname, yearGroup, currentGpa,  dOB, admin, faculty, courseName, courseCode, courseRegister1, viewCC, assignmentName, assignmentDescription, assignmentDue,assignmentType, viewAA, subAssignment, viewSub, scoreAssign, submitEmail, viewAssign, submitCourseCode, submitVCourseCode, viewGrade, viewCourseCodeGrade, viewCourseCodeAll, viewEmailsAll ;
  int scores;



  public static void main(String[] args) {

    papayaw user = new papayaw();
    //user.createAccount();
    //user.login();
    //user.updateProfile();
    //user.viewProfile();
   //user.isAdmin();
   //user.makeFaculty();
   // user.isFaculty();
   // user.createCourse();
    //user.viewCourses();
    //user.registerCourse();
   // user.viewCourseByCode();
    //user.addAssignment();
   //user.viewAssignmentByCourse();
   //user.submitAssignment();
   //user.viewSubmission();
   //user.scoreAssignment();
   //user.viewAssignmentScore();
   //user.viewAssignmentScores();
   //user.viewAssignmentGrade();
   //user.viewAssignmentGrades();
   //user.viewAllAssignmentScores();
   //user.setNotificationsPreferences();

    





  }
 
  public void createAccount(){

    Scanner allEmails = new Scanner(System.in);
    Scanner allPass = new Scanner(System.in);

    System.out.println(" Sign up Here ");


    System.out.println("Enter your Email ");
    email = allEmails.nextLine();

    System.out.println("Enter your Password ");
    password = allPass.nextLine();

    emailArr.add(email);
    passArr.add(password);

    System.out.println("Thank you for signing up.");




  }

public boolean login(){
 

    Scanner allEmails = new Scanner(System.in);
    Scanner allPass = new Scanner(System.in);

    System.out.println(" Log in Here ");


    System.out.println("Enter your Email ");
    email = allEmails.nextLine();

    System.out.println("Enter your Password ");
    password = allPass.nextLine();


    if(emailArr.contains(email) && (passArr.contains(password))){
      System.out.println("Welcome !");
      return true;
     
    
    }else {
      System.out.println("Try again !");
      return false;
    
    }
}

public void updateProfile(){

  if (login() == true ){


    Scanner allFirstnames = new Scanner(System.in);
    Scanner allLastnames = new Scanner(System.in);
    Scanner allyearg = new Scanner(System.in);
    Scanner allcurgpa = new Scanner(System.in);
    Scanner alldob = new Scanner(System.in);

    System.out.println(" Update Profile ");


    System.out.println("Enter your Firstname ");
    firstname = allFirstnames.nextLine();

    System.out.println("Enter your Lastname ");
    lastname = allLastnames.nextLine();

    System.out.println("Enter your Year Group ");
    yearGroup = allyearg.nextLine();

    System.out.println("Enter your Current GPA ");
    currentGpa = allcurgpa.nextLine();

    System.out.println("Enter your Date of Birth ");
    dOB = alldob.nextLine();


    firstnameArr.add(firstname);
    lastnameArr.add(lastname);
    yeargArr.add(yearGroup);
    curgpaArr.add(currentGpa);
    dobArr.add(dOB);

   profileExists = true;

    System.out.println("Thank You !");


  }


}


public void viewProfile(){

  if ( profileExists == true){

    System.out.println(" Profile ");

    System.out.println(" Firstname :  " + firstname);
    System.out.println(" Lastname :  " + lastname);
    System.out.println(" Year Group :  " + yearGroup);
    System.out.println(" current GPA :  " + currentGpa);
    System.out.println(" Date of Birth :  " + dOB);

  }else{

    System.out.println(" Firstname : N/A ");
    System.out.println(" Lastname : N/A ");
    System.out.println(" Year Group : N/A ");
    System.out.println(" current GPA : N/A " );
    System.out.println(" Date of Birth : N/A ");

  }

}

public boolean isAdmin(){

  adminArr.add("papa");

  Scanner allAdmin = new Scanner(System.in);

  System.out.println("Enter Admin Email ");
  admin = allAdmin.nextLine();

  if(adminArr.contains(admin)){
    System.out.println("User is an Admin");
    return true;
    

  }else{
    System.out.println("User is not an admin");
    return false;
  }

}

public void makeFaculty(){

  if(login() == true && isAdmin()== true ){

  Scanner allFaculty = new Scanner(System.in);

  System.out.println("Enter Email to become Faculty ");
  faculty = allFaculty.nextLine();

  facultyArr.add(faculty);

  System.out.println("Enrolled as faculty successfully !");

  }



}

public boolean isFaculty(){

  Scanner isFac = new Scanner(System.in);
  System.out.println("Enter Faculty Email ");
  faculty = isFac.nextLine();

  if(facultyArr.add(faculty)){

    System.out.println("User is faculty ");
    return true;


  }else{

    System.out.println("User is not faculty ");
    return false;


  }


}

public void createCourse(){

  if(isFaculty()== true) {

  Scanner allCourseName = new Scanner(System.in);
  Scanner allCourseCode = new Scanner(System.in);

  System.out.println(" Register Course Here ");


  System.out.println("Enter Course Name ");
  courseName = allCourseName.nextLine();

  System.out.println("Enter Course Code ");
  courseCode = allCourseCode.nextLine();

  courseNameArr.add(courseName);
  courseCodeArr.add(courseCode);

  System.out.println("Thank you for creating course !");

  }

}

public void viewCourses(){

  System.out.println(" Courses ");

  System.out.println(" Name :  " + firstname);
  System.out.println(" Course name :  " + courseName);
  System.out.println(" Course code :  " + courseCode);
  System.out.println(" Email :  " + email);
    


}


public void registerCourse(){

  if(login()== true ){

  Scanner allReg = new Scanner(System.in);

  System.out.println("Enter Course code to register ");
  courseRegister1 = allReg.nextLine();

  if(courseRegister1.equals("E222")){

    courseRegE22.add(email);

    System.out.println("Successfully Registered !");
    //System.out.print(courseRegE22);

  }

  }



}

public void viewCourseByCode(){


  Scanner allCC = new Scanner(System.in);

  System.out.println("Enter Course code  ");
  viewCC = allCC.nextLine();

  if(courseRegister1.equals(viewCC)){

    System.out.print(" Emails of users" + courseRegE22);
   

  }

}

public void addAssignment(){


  Scanner allAssignmentName = new Scanner(System.in);
  Scanner allAssignmentDescription = new Scanner(System.in);
  Scanner allAssignmenDueDate= new Scanner(System.in);
  Scanner allAssignmentType = new Scanner(System.in);

  System.out.println(" Add an assignment here ! ");


  System.out.println("Enter Assignment Name ");
  assignmentName = allAssignmentName.nextLine();

  System.out.println("Enter Assingmnet Description ");
  assignmentDescription = allAssignmentDescription.nextLine();


  System.out.println("Enter Assignment due date ");
  assignmentDue = allAssignmenDueDate.nextLine();

  System.out.println("Enter Assignment Type ");
  assignmentType = allAssignmentType.nextLine();

  

  assignmentNameArr.add(assignmentName);
  assignmentDescriptionArr.add(assignmentDescription);
  assignmentDueArr.add(assignmentDue);
  assignmentTypeArr.add(assignmentType);


  System.out.println("Thank you for adding an assignment.");

}


public void viewAssignmentByCourse(){


  Scanner allAA = new Scanner(System.in);

  System.out.println("Enter Course code  ");
  viewAA = allAA.nextLine();

  if(courseRegister1.equals(viewAA)){

    System.out.print(" Assingnemt name " + assignmentNameArr);
    System.out.print(" Assingnemt description " + assignmentDescriptionArr);
    System.out.print(" Assingnemt due date " + assignmentDueArr);
    System.out.print(" Assingnemt type " + assignmentTypeArr);

    System.out.println("Thank you");

   

  }

}

public void submitAssignment(){
  if(login() ==  true){

    System.out.println("Submit Assignment");

    Scanner allSubAssignment = new Scanner(System.in);

    System.out.println("Enter your Assignment ");
    subAssignment = allSubAssignment.nextLine();

    assignmentSubArr.add(subAssignment);

    System.out.println("Thank you for submitting!");


  }


}


public void viewSubmission(){
  if (login() == true){

  Scanner allSub = new Scanner(System.in);

  System.out.println("Enter Assignment Name  ");
  viewSub = allSub.nextLine();

  if(assignmentNameArr.contains(viewSub)){

    System.out.println("Submissions : " + assignmentSubArr );

  }else{
    System.out.println("No submissions");
  }
}


}


public void scoreAssignment(){

  System.out.println(" Score Assignment ");

  Scanner allScoreAssignment = new Scanner(System.in);
  Scanner allSubmitEmail = new Scanner(System.in);
  Scanner allScores = new Scanner(System.in);
  Scanner allSCourseCode = new Scanner(System.in);



  System.out.println("Enter your Assignment Name ");
  scoreAssign = allScoreAssignment.nextLine();

  System.out.println("Enter your Email ");
  submitEmail = allSubmitEmail.nextLine();

  System.out.println("Enter your course code ");
  submitCourseCode = allSCourseCode.nextLine();

  System.out.println("Enter Score ");
  scores = allScores.nextInt();

  if(viewSub.equals(scoreAssign)){
    ScoresArr.add(scores);

  }else{
    System.out.println(" Error ! ");

  }


}


public void viewAssignmentScore(){
  if(login() == true){

  Scanner allviewScoreAssignment = new Scanner(System.in);
  Scanner allviewCourseCode = new Scanner(System.in);

  System.out.println("Enter your Assignment Name ");
  viewAssign = allviewScoreAssignment.nextLine();

  System.out.println("Enter your course code ");
  submitVCourseCode = allviewCourseCode.nextLine();

  if(viewAssign.equals(scoreAssign)){
    //ScoresArr.add(scores);
    System.out.println("This is your assignment score " + scores);

  }


}


}

public void viewAssignmentScores(){

  if(login() == true){

    Scanner allviewScoreAssignment = new Scanner(System.in);
    Scanner allviewCourseCode = new Scanner(System.in);
  
    System.out.println("Enter your Assignment Name ");
    viewAssign = allviewScoreAssignment.nextLine();
  
    System.out.println("Enter your course code ");
    submitVCourseCode = allviewCourseCode.nextLine();
  
    if(viewAssign.equals(scoreAssign)){
      ScoresArr.add(scores);
      System.out.println("These are your assignment scores " + ScoresArr);
  
    }
  }


}

//viewAssignmentGrade


public void viewAssignmentGrade(){
  if(login() == true){

  Scanner allviewAssignmentGrade = new Scanner(System.in);
  Scanner allviewCourseCodeG = new Scanner(System.in);

  System.out.println("Enter your Assignment Name ");
  viewGrade = allviewAssignmentGrade.nextLine();

  System.out.println("Enter your course code ");
  viewCourseCodeGrade = allviewCourseCodeG.nextLine();


  if(viewGrade.equals(scoreAssign)){
    //ScoresArr.add(scores);
    System.out.println("This is your assignment score " + scores);

    if( scores > 50){

      System.out.println("Grade is an A for " + email );
    }else if(scores < 50){

      System.out.println("Grade is an B " + email);
      
    }

  }


}

}

public void viewAssignmentGrades(){
  if(login() == true){

  Scanner allviewAssignmentGrade = new Scanner(System.in);
  Scanner allviewCourseCodeG = new Scanner(System.in);

  System.out.println("Enter your Assignment Name ");
  viewGrade = allviewAssignmentGrade.nextLine();

  System.out.println("Enter your course code ");
  viewCourseCodeGrade = allviewCourseCodeG.nextLine();

  System.out.println("These are assignment scores " + ScoresArr);

  for (int i = 0; i < ScoresArr.size(); i++) {
    if(viewGrade.equals(scoreAssign)){
      //ScoresArr.add(scores);
     
      if( scores > 50){


    
        System.out.println("Grade is an A");
      }else if(scores < 50){

       
        System.out.println("Grade is an B");
        
      }
  
    }
  
  
  }
  }



}

public void viewAllAssignmentScores(){
  if(login() == true){

    Scanner allviewAllAssignScores = new Scanner(System.in);
    Scanner allAssignmentEmail = new Scanner(System.in);

    System.out.println("Enter your email ");
    viewEmailsAll = allAssignmentEmail.nextLine();


    System.out.println("Enter your course code ");
    viewCourseCodeAll = allviewAllAssignScores.nextLine();

    System.out.println( email + " your Assignment : " + viewAssign + " and your score : " + scores +  " and grade :"  );






  }
}


public void setNotificationsPreferences(){

  if(login() == true){

   Scanner YesNo = new Scanner(System.in);
   
   System.out.println(" Should an email be sent when an asssignemnt is posted? ");
   String yesno = YesNo.next();
      
   
   if(yesno.equals("yes")) {
    
    System.out.println(" Done successfully !");
    
   }
   else if(yesno.equals("no")) {
    
    System.out.println(" Okay, you might need it tho ");
    
   }

   Scanner YesNot = new Scanner(System.in);
   
   System.out.println(" Should an email be sent to user when score is submitted ? ");
   String yesnot = YesNot.next();
      
   
   if(yesnot.equals("yes")) {
    
    System.out.println(" Done successfully !");
    
   }
   else if(yesnot.equals("no")) {
    
    System.out.println(" Okay, you might need it though ! ");
    
   }





  }
   
   
  
  
 }
  
 




}





