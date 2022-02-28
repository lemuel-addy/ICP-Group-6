package school;

import school.services.AccountManagementService;
import school.staff.Admin;
import school.staff.Course;
import school.staff.Faculty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SchoolManagementSystem implements AccountManagementService {

    private List<User> users = new ArrayList<>();
    private List<Faculty> faculties = new ArrayList<>();
    private List<Admin> admins = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();



    @Override
    public void createAccount(String firstName, String lastName, String email, String password, String type) {
        // create account for normal users

        if(Objects.equals(type, "faculty")){
            faculties.add(new Faculty(firstName,lastName,email,password));
        }
        else if(Objects.equals(type, "user")){
            users.add(new User(firstName,lastName,email,password));
        }
    }


    @Override
    public Boolean login(String email, String password, String type) {
        // logging in for faculties
        if (Objects.equals(type, "faculty")){
            for (Faculty f : faculties)
                if(f.getEmail().equals(email) && f.getPassword().equals(password))
                    return true;
        }
        // logging in for users
        if (Objects.equals(type, "user")){
            for (User u : users)
                if(u.getEmail().equals(email) && u.getPassword().equals(password))
                    return true;
        }
        return false;
    }

    @Override
    public boolean isFaculty(String email) {
        for (Faculty f : faculties){
            if(f.getEmail().equals(email))
                return true;
        }
        return false;
    }

    @Override
    public boolean isAdmin(String email) {
        return false;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "SchoolManagementSystem{" +
                "users=" + users +
                ", faculties=" + faculties +
                ", admins=" + admins +
                ", courses=" + courses +
                '}';
    }
}
