public interface Canvasinterface {

    public void createAccount(Person P);
    public boolean login();
    public boolean updateProfile();
    public void viewProfile();
    public boolean isAdmin();
    public void makeFaculty(Faculty f);
    public boolean isFaculty();
    public void createCourse(Canvas.Course c);
    public void viewCourses();
    public void registerCourse();
    public void viewCourseByCode();
    public void viewCoursesByEmail();
    public void addAssignment(Canvas.Assignment ss);
    public void viewAssignmentGrade();
    public void viewAssignmentsByCourse();
    public void viewAssignmentsByEmail();
    public void submitAssignment(Canvas.Submit sb);
    public void viewSubmissions();
    public void scoreAssignment();
    public void viewAssignmentScore();
    public void viewAssignmentScores();
    public void viewAssignmentGrades();
    public void setNotificationPreferences();

}
