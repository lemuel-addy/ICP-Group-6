package school.services;

import school.staff.Course;
import school.staff.assignmentType;

import java.util.Date;

public interface CourseControlService {
    public Course createCourse(String email, String courseCode, String courseName);
    public String viewCourses();
    public Course viewCourseByEmail(String email);
    public Course viewCourseByCode(String courseCode);
    public void addAssignment(String email, String courseCode, String assignmentName, String assignmentDescription, Date assignmentDueDate, assignmentType type);
    public void  viewAssignmentsByCourse(String courseCode);
    public void viewAssignmentByEmail(String email);
    public void submitAssignment(String email, String assignmentName,String submission);

}
