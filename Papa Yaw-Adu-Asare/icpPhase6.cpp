#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Biodata
{

    //Variable Declarations
private:
    string fName, lName, dob, email, password, ygroup;

private:
    float gpa;

public:
    //Constructor
    Biodata()
    {
        fName = " ";
        lName = " ";
        dob = " ";
        email = " ";
        password = " ";
        ygroup = " ";
        gpa = 0;
    }

    //Setter methods
    void setFname(string firstname)
    {
        fName = firstname;
    }
    void setLname(string lastname)
    {
        lName = lastname;
    }
    void setDob(string date)
    {
        dob = date;
    }
    void setEmail(string Email)
    {
        email = Email;
    }
    void setPassword(string Password)
    {
        password = Password;
    }
    void setYgroup(string Yeargroup)
    {
        ygroup = Yeargroup;
    }
    void setGPA(float GPA)
    {
        gpa = GPA;
    }


    // Getter Methods
        string getFname()
    {
        return fName;
    } 
       string getLname()
    {
        return lName;
    }
        string getDob()
    {
        return dob;
    }
        string getEmail()
    {
        return email;
    }
        string getPassword()
    {
        return password;
    }
        string getYgroup()
    {
        return ygroup;
    }
    float getGPA()
    {
        return gpa;
    };

    //Functions for Biodata Class

    void createAccount(string email1, string pwd1)
    {
        setEmail(email1);
        setPassword(pwd1);
        cout << "Account created successfully !" << endl;
    };

    void login(string email1, string pwd1)
    {
        if (getEmail() == email1)
        {
            if (getPassword() == pwd1)
            {
                cout << "Login successful!" << endl;
            }
            else
            {
                cout << "Incorrect password, Try again. " << endl;
            }
        }
    };

    void updateProfile(string firstN, string lastN, string dob1, string email1, string ygrp, float gpa1)
    {
        setFname(firstN);
        setLname(lastN);
        setDob(dob1);
        setEmail(email1);
        setYgroup(ygrp);
        setGPA(gpa1);
        cout << "User profile  updated successfully" << endl;
    };

    void viewProfile()
    {
        cout << getFname() << endl;
        cout << getLname() << endl;
        cout << getDob() << endl;
        cout << getEmail() << endl;
        cout << getYgroup() << endl;
        cout << getGPA() << endl;
    };
};

class Registry
{
    //      Variable  Declaration
private:
    string admin, faculty;

// Vector Declaration
public:
    vector<string> facultyVec;

public:
    // Getters and Setters for methods
    void setAdmin(string admin1)
    {
        admin = admin1;
    }
    string getAdmin()
    {
        return admin;
    }
    void setFaculty(string faculty1)
    {
        faculty = faculty1;
    }
    string getFaculty()
    {
        return faculty;
    };

public:
    string adminArr[5] = {"papa.adu-asare@ashesi.edu.gh"};

    //Function declarations
    void isAdmin(string adminEmail)
    {
        for (int i = 0; i < sizeof(adminArr); i++)
        {
            if (adminArr[i] == adminEmail)
            {
                setAdmin(adminEmail);
                cout << "Youre  an  administrator!" << endl;
                return;
            }
            else
            {
                cout << "Youre not an administrator! " << endl;
                return;
            }
        }
    };

    void makeFaculty(string facultyEmail1)
    {
        setFaculty(facultyEmail1);
        facultyVec.push_back(getFaculty());
        cout << " Youve been made faculty successfully !" << endl;
    };

    void isFaculty(string facultyEmail1)
    {

        for (int i = 0; i < facultyVec.size(); i++)
        {
            if (facultyVec[i] == facultyEmail1)
            {
                cout << "User is a Faculty!" << endl;
            }
            else if (facultyVec[i] != facultyEmail1)
            {
                cout << "User is not a faculty member!" << endl;
            }
        }
        cout << endl;
    };
};

//Main function which is used to call functions
int main()
{
    //Object created for Biodata class
    Biodata user;
    user.createAccount("papa@gmail.com", "papa");
    user.login("papa@gmail.com", "papa");
    user.updateProfile("Papa", "Adu-Asare", "07/09/2001", "papa@gmail.com", "2023", 4.0);
    user.viewProfile();
    //Object created for Registry class
    Registry py;
    py.isAdmin("papa.adu-asare@ashesi.edu.gh");
    py.makeFaculty("john.mark@ashesi.edu.gh");
    py.isFaculty("john.mark@ashesi.edu.gh");

    return 0;
}