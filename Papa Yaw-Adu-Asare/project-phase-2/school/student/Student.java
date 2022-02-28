package school.student;

import school.services.ProfileManagementService;
import school.User;

import java.util.Date;

public class Student extends User implements ProfileManagementService {

    private String yearGroup;
    private double gpa;
    private Date dob;
    /**
     * Instantiates a new school.User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @param password  the password
     */
    public Student(String firstName, String lastName, String email, String password, String yearGroup, double gpa, Date dob) {
        super(firstName, lastName, email, password);
        this.yearGroup = yearGroup;
        this.gpa = gpa;
        this.dob = dob;
    }


    @Override
    public void updateProfile(String email, String firstName, String lastName, String yearGroup, double gpa, Date dob) {
        super.setEmail(email);
        super.setFirstName(firstName);
        super.setLastName(lastName);
        this.dob = dob;
        this.yearGroup = yearGroup;
        this.gpa = gpa;
    }

    @Override
    public void viewProfile(String email) {

    }

    public String getYearGroup() {
        return yearGroup;
    }

    public void setYearGroup(String yearGroup) {
        this.yearGroup = yearGroup;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "yearGroup='" + yearGroup + '\'' +
                ", gpa=" + gpa +
                ", dob=" + dob +
                '}';
    }
}
