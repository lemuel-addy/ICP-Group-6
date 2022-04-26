#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Person{  //person class which creates users with their variables and methods
public:
string firstName;
string lastName;
string email;
string password;
string dob;
string gpa;
string yearGroup;

public:
Person(string fn, string ln, string e, string p, string d, string g, string yg){
        firstName = fn;
        lastName = ln;
        email = e;
        password = p;
        dob = d;
        gpa = g;
        yearGroup = yg;
    }
Person(string e){
        email = e;   
    }

Person(){
        
    }

string getDob() {
        return dob;
    }

void setDob(string d) {
        dob = d;
    }

string getGpa() {
        return gpa;
    }

void setGpa(string g) {
        gpa = g;
    }

string getYearGroup() {
        return yearGroup;
    }

void setYearGroup(string yg) {
        yearGroup = yg;
    }

string getFirstname() {
        return firstName;
    }

void setFirstname(string fn) {
        firstName = fn;
    }

string getLastname() {
        return lastName;
    }

void setLastname(string ln) {
        lastName = ln;
    }

string getEmail() {
        return email;
    }

void setEmail(string e) {
        email = e;
    }

string getPassword() {
        return password;
    }

void setPassword(string p) {
        password = p;
    }

};
class Faculty: public Person{ //faculty class that is used to create faculty members and inherits from the person class
public:
Faculty(){

}


};
vector<class Faculty> faculty;
vector<class Person> users; 
vector<string> admins; 

bool accountUpdate;

void createAccount(Person p){
    string email;
    string password;
    string verifier;
    cout << "Welcome to Canvas" << endl;
    cout << "To create an account, please enter your email: " ;
    getline(cin,email);
    cout << "Please enter your new password: "  ;
    cin >> password;
    cout << "Please verify your new password: " ;
    cin >> verifier;
    if(password == verifier){
        cout << "Account successfully created!" << endl;
        p.setPassword(password);
        users.push_back(p);
    }
    else{
        cout << "Password does not match. Try again" << endl;
    }
}

bool login(){
    string email;
    string password;
    cout << "Welcome to Canvas" << endl;
    cout << "To Log in, please enter your email: ";
    cin >> email;
    cout << "Enter your password: ";
    cin >> password;
    for(int i = 0; i < users.size(); i++){
        if(users.at(i).getEmail()==(email) && users.at(i).getPassword()==(password)){
                return true;
        }
        return false;
    }
    return false;

}

bool login (string email,string password){
        for(int i = 0; i < users.size(); i++)
        {
            if(users.at(i).getEmail()==(email) && users.at(i).getPassword()==(password)){
                return true;
        }    
            
        }
        return false;
    }

bool updateProfile(){
    string email;
    string password;
    string firstName;
    string lastName;
    string yearGroup;
    string gpa;
    string dob;
    cout << "To Update your profile" << endl;
    cout << "Enter your email: ";
    cin >> email;
    cout << "Enter your password: ";
    cin >> password;
    if(login(email,password)){
     for(int i = 0; i < users.size(); i++)
        {   
    cout <<"Enter your first name: ";
    cin >> firstName;
    users.at(i).setFirstname(firstName);
    cout <<"Enter your last name: ";
    cin >> lastName;
    users.at(i).setLastname(lastName);
    cout <<"Enter your year group: ";
    cin >> yearGroup;
    users.at(i).setYearGroup(yearGroup);
    cout << "Enter your current GPA: ";
    cin >> gpa; 
    users.at(i).setGpa(gpa);
    cout << "Enter your date of birth(dd/mm/yy): ";
    cin >> dob;
    users.at(i).setDob(dob);
        }
    }
            accountUpdate = false;
            return accountUpdate;
}

void viewProfile(){
    string email;
    string password;
    cout << "To view your profile" << endl;
    cout << "Enter your email: ";
    cin >> email;
    cout << "Enter your password: ";
    cin >> password;
    if(login(email,password)){
    if (accountUpdate == false){
            for(int i = 0; i < users.size(); i++)
        {
            if(users.at(i).getEmail()==email){
            users.at(i).setFirstname("NA");
            users.at(i).setLastname("NA");
            users.at(i).setYearGroup("NA");
            users.at(i).setGpa("NA");
            users.at(i).setDob("NA");
            cout << "User Profile" << endl;
            cout << "Email: " + email  << endl;
            cout << "First Name: "+users.at(i).getFirstname() << endl;
            cout << "Last Name: "+users.at(i).getLastname() << endl;
            cout << "Year Group: "+users.at(i).getYearGroup() << endl;
            cout << "Current GPA: "+users.at(i).getGpa() << endl;
            cout << "Date of birth: "+users.at(i).getDob();
            }
        }
        }
        else{
            for(int i = 0; i < users.size(); i++)
        {
            if(users.at(i).getEmail()==email){
                cout << "User Profile" << endl;
                cout << "Email: " + email  << endl;
                cout << "First Name: "+users.at(i).getFirstname() << endl;
                cout << "Last Name: "+users.at(i).getLastname() << endl;
                cout << "Year Group: "+users.at(i).getYearGroup() << endl;
                cout << "Current GPA: "+users.at(i).getGpa() << endl;
                cout << "Date of birth: "+users.at(i).getDob();
            }
            }
        }
    }
}

bool isAdmin(){
    string entry;
    cout << "Admin verification: ";
    cin >> entry;
    admins.push_back("daniel.nettey@ashesi.edu.gh");
    admins.push_back("dennis.owusu@ashesi.edu.gh");
    if ( std::find(admins.begin(), admins.end(), entry) != admins.end() ){
            return true;
        }
        else{
            return false;
        }

}

bool isAdmin(string email){
        if ( std::find(admins.begin(), admins.end(), email) != admins.end() ){
            return true;
        }
        else{
            return false;
        }
    }

void makeFaculty(Faculty f){
    string email;
    string password;
    cout << "To assign Faculty, Enter your email: ";
    cin >> email;
    cout << "Enter your password: ";
    cin >> password;
    if (login(email,password)){
            if(isAdmin(email)){
                f.setEmail(email);
                    faculty.push_back(f);
                    cout << "Assigned role of Faculty." << endl;
             }
    }

}

bool isFaculty(){
    string email;
    cout << "Enter your email to verify you are a faculty member: " << endl;
    cin >> email;
    for(int i = 0; i < faculty.size(); i++)
        {
            if(faculty.at(i).getEmail()==email){
                cout << "Yes";
                return true;
            }
        }
        return false;
}

void setNotificationPreferences(){
    string email;
    string password;
    string notifassignmentPost;
    string notifscoreSubmission;
    string notifregisterCourse;
    cout <<  "Please enter your email: ";
    cin >> email;
    cout << "Enter your password: ";
    cin >> password;
    if(login(email,password)){
    cout << "Do you want to receive notifications when\nAn assignment is posted: ";
    cin >> notifassignmentPost; 
    cout << "A score is submitted for their assignment: ";
    cin >> notifscoreSubmission;
    cout << "You register for a course: ";
    cin >> notifregisterCourse;
    }
}




int main()
{
        
        Person p ;
        createAccount(p);
        login();
        Faculty f;
        makeFaculty(f);
        isFaculty();
        isAdmin();
        viewProfile();

}
