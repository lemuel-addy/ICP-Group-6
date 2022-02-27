package com.company;

import java.util.Objects;

public class Person {


    //login credentials
    private String email;
    private String password;

    //Person details

    public Person(String email, String password){
        this.email = email;
        this.password = password;
    }

    public Person() {

    }


    //mutators
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //accessors
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return  "\nEmail:" + email +
                " \nPassword:" + password;
    }


    public boolean equals(Person other) {
        return getEmail().equals(other.getEmail()) &&
                getPassword().equals(other.getPassword());
    }


    //interface
    public interface Standards{
        public String toString();

        public boolean equals(Person person);
    }






    public class Profile extends Person implements Standards{

        private String firstName;
        private String lastName;
        private int yearGroup;
        private float currentGPA;
        private String dateOfBirth;

        public Profile(String fName, String lName, int yGroup, float cGPA,
                       String DoB){
            super();
            this.firstName = fName;
            this.lastName = lName;
            this.yearGroup = yGroup;
            this.currentGPA = cGPA;
            this.dateOfBirth = DoB;
        }

        //accessors
        public String getFirstName(){
            return this.firstName;
        }

        public String getLastName(){
            return this.lastName;
        }

        public int getYearGroup(){
            return this.yearGroup;
        }

        public float getCurrentGPA(){
            return this.currentGPA;
        }

        public String getDateOfBirth(){
            return this.dateOfBirth;
        }

        //mutators
        public void setFirstName(String fname){
            this.firstName = fname;
        }

        public void setLastName(String lname){
            this.lastName = lname;
        }

        public void setYearGroup(int ygroup){
            this.yearGroup = ygroup;
        }

        public void setCurrentGPA(float cgpa){
            this.currentGPA = cgpa;
        }

        public void setDateOfBirth(String DoB){
            this.dateOfBirth = DoB;
        }

        //methods
        public String toString(){
            return ("First Name:"+getFirstName()+ "\nLast Name:"+getLastName() +
                    "\nYear Group:" + getYearGroup() + "\nCurrent GPA:" + getCurrentGPA()+
                    "\nDate of Birth: " +getDateOfBirth());
        }

        public boolean equals(Profile other){
            return (getFirstName().equals(other.getFirstName()) &&
                    getLastName().equals(other.getLastName()) &&
                    getYearGroup() == other.getYearGroup() &&
                    getCurrentGPA() == other.getCurrentGPA() &&
                    getDateOfBirth().equals(other.getDateOfBirth()));
        }
    }


}
