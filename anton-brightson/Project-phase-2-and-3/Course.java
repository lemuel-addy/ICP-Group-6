public class Course{
    private int courseCode;
    private String courseName;
    private String userEmail;

    public String getUserEmail(){
      return userEmail; 
    }

    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }

    public String getcourseName(){
        return courseName;
    }

    public void courseName(String courseName){
        this.courseName = courseName;
    }

    public int getcourseCode(){
        return courseCode;
    }

    public void setcourseCode(int courseCode){
        this.courseCode = courseCode;
    }

}