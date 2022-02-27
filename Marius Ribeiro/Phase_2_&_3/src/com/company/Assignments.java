package com.company;

public class Assignments {

    //instance variables
    private String assignmentName;
    private String assignmentDescription;
    private String assignmentType;

    //mutators


    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public void setAssignmentDescription(String assignmentDescription) {
        this.assignmentDescription = assignmentDescription;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }


    //accessors
    public String getAssignmentName() {
        return assignmentName;
    }

    public String getAssignmentDescription() {
        return assignmentDescription;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    @Override
    public String toString() {
        return "\nAssignment Name: " + assignmentName +
                "\nAssignment Description: " + assignmentDescription +
                "\nAssignment Type: " + assignmentType;
    }

    public boolean equals(Assignments other) {
        return (getAssignmentName().equals(other.getAssignmentName()) &&
                getAssignmentDescription().equals(other.getAssignmentDescription())
                && getAssignmentType().equals(other.getAssignmentType()));
    }

    public class Score extends Assignments{
        private float score;


        public Score(float score){
            this.score = score;
        }

        //mutator
        public void setScore(float score) {
            this.score = score;

        //exception
        }

        //accessor

        public float getScore() {
            return score;
        }

        @Override
        public String toString() {
            return "\nScore:" + getScore();
        }

        public boolean equals(Score other){
            return this.getScore() == other.score;
        }
    }


}
