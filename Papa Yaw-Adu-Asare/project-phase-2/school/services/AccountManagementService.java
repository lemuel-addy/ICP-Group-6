package school.services;

/**
 * The interface Account management service.
 */
public interface AccountManagementService {
    /**
     * Create account.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @param password  the password
     * @param type      the type
     */
    public void createAccount(String firstName, String lastName, String email, String password, String type);
    public Boolean login(String email, String password, String type);
    public boolean isFaculty(String email);
    public boolean isAdmin(String email);
}
