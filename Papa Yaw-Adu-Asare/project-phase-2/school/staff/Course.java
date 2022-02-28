package school.staff;

import java.util.Objects;

public class Course {
    private String courseCode;
    private String courseName;


    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return getCourseCode().equals(course.getCourseCode()) && getCourseName().equals(course.getCourseName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseCode(), getCourseName());
    }

    @Override
    public String toString() {
        return "school.staff.Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
