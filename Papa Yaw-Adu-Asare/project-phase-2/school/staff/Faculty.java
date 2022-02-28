package school.staff;

import school.services.CourseControlService;

import java.util.Date;

import school.User;

public class Faculty extends User implements CourseControlService {
    /**
     * Instantiates a new school.User.
     * 
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @param password  the password
     */
    public Faculty(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    @Override
    public Course createCourse(String email, String courseCode, String courseName) {
        // email to check logIn
        // email to check isFaculty
        return new Course("212", "ICP");
    }

    @Override
    public String viewCourses() {
        // view a course
        return null;
    }

    @Override
    public Course viewCourseByEmail(String email) {
        return null;
    }

    @Override
    public Course viewCourseByCode(String courseCode) {
        return null;
    }

    @Override
    public void addAssignment(String email, String courseCode, String assignmentName, String assignmentDescription,
            Date assignmentDueDate, assignmentType type) {
        // TODO Auto-generated method stub

    }

    @Override
    public void viewAssignmentsByCourse(String courseCode) {
        // TODO Auto-generated method stub

    }

    @Override
    public void viewAssignmentByEmail(String email) {
        // TODO Auto-generated method stub

    }

    @Override
    public void submitAssignment(String email, String assignmentName, String submission) {
        // TODO Auto-generated method stub

    }
}
