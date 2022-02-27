package com.company;

public class Courses {

    private String courseName;
    private String courseCode;


    //mutators


    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    //accessors

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }



    @Override
    public String toString() {
        return "\nCourse Name:" + this.getCourseName()+
                ", courseCode='" + this.getCourseCode();
    }

    public boolean equals(Courses other){
        return (getCourseName().equals(other.getCourseName()) &&
                getCourseCode().equals(other.getCourseCode()));
    }


}
