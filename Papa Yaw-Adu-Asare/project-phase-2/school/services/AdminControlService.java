package school.services;

import school.User;
import school.staff.Faculty;

/**
 * The interface Admin control service.
 */
public interface AdminControlService {

    Faculty makeFaculty(User user);
}
