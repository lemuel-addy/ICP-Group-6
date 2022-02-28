package school.staff;

import school.services.AdminControlService;
import school.services.ProfileManagementService;
import school.User;

import java.util.Date;

public class Admin extends User implements ProfileManagementService, AdminControlService {
    /**
     * Instantiates a new school.User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @param password  the password
     */
    public Admin(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    @Override
    public void updateProfile(String email, String firstName, String lastName, String yearGroup, double gpa, Date dob) {

    }

    @Override
    public void viewProfile(String email) {

    }

    @Override
    public Faculty makeFaculty(User user) {
        return new Faculty(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
    }
}
