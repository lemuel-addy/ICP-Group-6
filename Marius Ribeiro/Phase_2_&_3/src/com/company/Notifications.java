package com.company;

public class Notifications {
    private String assignmentNotification;
    private String gradeNotification;
    private String courseRegistrationNotification;


    Notifications(String assignmentNotification, String gradeNotification,
                  String courseRegistrationNotification){

        this.assignmentNotification = assignmentNotification;
        this.gradeNotification = gradeNotification;
        this.courseRegistrationNotification = courseRegistrationNotification;

    }

    //mutators
    public void setAssignmentNotification(String assignmentNotification) {
        this.assignmentNotification = assignmentNotification;
    }

    public void setGradeNotification(String gradeNotification) {
        this.gradeNotification = gradeNotification;
    }

    public void setCourseRegistrationNotification(String courseRegistrationNotification) {
        this.courseRegistrationNotification = courseRegistrationNotification;
    }

    //accessors

    public String getAssignmentNotification() {
        return assignmentNotification;
    }

    public String getGradeNotification() {
        return gradeNotification;
    }

    public String getCourseRegistrationNotification() {
        return courseRegistrationNotification;
    }

    //methods

}
