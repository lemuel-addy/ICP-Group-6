package school.services;

import java.util.Date;

/**
 * The interface Profile management service.
 */
public interface ProfileManagementService {

    /**
     * Update profile.
     *
     * @param email     the email
     * @param firstName the first name
     * @param lastName  the last name
     * @param yearGroup the year group
     * @param gpa       the gpa
     * @param dob       the dob
     */
    public void updateProfile(String email, String firstName, String lastName, String yearGroup, double gpa, Date dob);

    /**
     * View profile.
     *
     * @param email the email
     */
    public void viewProfile(String email);


    // logIn
}
