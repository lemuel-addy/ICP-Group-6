#include <iostream>
#include <map>
#include <list>
#include <iterator>
using namespace std;


//maps
map<string, string> studentLogin;  //Map for email and password pairs
map<string, list<string>> profile;

//Lists
list<string> profileList, adminList, facultyList; //List to hold admin emails and faculty emails for ID purposes
//list<Student> profiles;

//Variables
string emailInput, passwordInput, generalInput;

//Class
class Person{

    private:
        string firstName;
        string lastName;
        int yearGroup;
        double gpa;
        string DoB;

    public:
    
        // Person(string aFirstName, string aLastName, int aYearGroup, double aGpa, string aDoB){

        //     setFirstName(aFirstName);
        //     setLastName(aLastName);
        //     setYearGroup(aYearGroup);
        //     setGpa(aGpa);
        //     setDateOfBirth(aDoB);

        // }


        //setters
        void setFirstName(string aFirstName){

            firstName = aFirstName;
        }

        void setLastName(string aLastName){

            lastName = aLastName;
        }

        void setYearGroup(int aYearGroup){

            yearGroup = aYearGroup;
        }

        void setGpa(double aGpa){

            gpa = aGpa;
        }

         void setDateOfBirth(string aDoB){

            DoB = aDoB;
        }


        //getters
        string getFirstName(){

            return firstName;
        }

        string getLastName(){

            return lastName;
        }

        int getYearGroup(){

            return yearGroup;
        }

        double getGpa(){

            return gpa;
        }

        string getDateOfBirth(){

            return DoB;
        }


        //isEqual

};





class LMS: public Person{

    public: 
        //Functions

        //---Inputs
        void emailEntry(){

            //string emailInput;
            cout<< "Enter your email address: "<<endl;
            getline(cin, emailInput);

        }

        void passwordEntry(){

            //string passwordInput;
            cout<< "Enter your Password: "<<endl;
            getline(cin, passwordInput);
        }

        void generalEntry(){

            
            //cout << "Enter your Input: "<<endl;
            getline(cin, generalInput);
        }

        //---End of Inputs


        //First function (Create Account)
        void createAccount(){
            //variable
            char reply;

            cout<< "Welcome to the Create Account Page"<<endl;

            //Email input
            emailEntry();

            //Password input
            passwordEntry();

            //Verification ***************

            
            //Adding to the map
            studentLogin.insert(pair<string, string>(emailInput, passwordInput));

        }

        //#2
        bool login(){

            //Variables
            bool response = false;

            //check if map is empty
            if(studentLogin.empty()){
                cout<< "No registered accounts!\nYou would be directed to create one"<<endl;

            }

            //Create Account function call
            createAccount();

            //Actual login
            //Collect email & password
            emailEntry();

            passwordEntry();

            //Check map for email
            if(studentLogin.count(emailInput) > 0){
                response = passwordInput.compare(studentLogin.at(emailInput));
            }

            //return boolean value
            return response;
        }

        //#3
        void updateProfile(){

            //Student update;

            cout<<"Welcome to the Profile Update page" <<endl;

            if(login()){
                cout<< "Login was successful"<<endl;

                string fName, lName, DoB;
                int yearGroup;
                double gpa;

                //First name
                cout<< "Enter your First Name: " <<endl;
                generalEntry();
                fName = generalInput;

                //last name
                cout<< "Enter your Last Name" <<endl;
                generalEntry();
                lName = generalInput;

                //year group
                cout<< "Enter your year group" <<endl;
                cin>>yearGroup;


                //gpa
                cout<< "Enter your current GPA" <<endl;
                cin>> gpa;

                //Date of Birth
                cout<< "Enter your Date of Birth" <<endl;
                generalEntry();
                DoB = generalInput;

                //Person Class
                //Person update(fName, lName, yearGroup, gpa, DoB);

                //List
                profileList.push_back(fName);
                profileList.push_back(lName);
                profileList.push_back(to_string(yearGroup));
                profileList.push_back(to_string(gpa));
                profileList.push_back(DoB);

                //main function

                if(profile.count(emailInput) == 0){ //Checks to see if there is a pre-existing profile

                    profile.insert(pair<string, list<string>>(emailInput, profileList));//adds when there aren't

                }

                else{
                    profile.at(emailInput) = profileList;  //replace previous profile data with new one
                }


                profileList.clear();//clears list for use again

            }
        }



            //Function #4
            void viewProfile(){

                cout<< "\nWelcome to the view Profile Page\n";
                map<string, list<string>>::iterator pos;
                if(login()){
                    

                    if(profile.empty()){ //|| profile.c emailInput) == 0
                        cout<< "N/A";
                    }

                    else{
                        for (pos = profile.begin(); pos != profile.end(); pos++){

                            if (pos -> first == emailInput) { //checks for email in the map
                                for(auto itr : profileList) { //returns value(details) at the key
                                    cout << itr << endl;
                                }
                            }
                        }

                    }
                }
            }


            //#5
            bool isAdmin(){
                bool state = false;

                for(auto itr: adminList){  //iterates through admin list
                    if(itr == emailInput){ //
                        state = true;       //returns true if email holder is an admin
                    }
                }

                return state;
                
            }
            //#7

            void makeFaculty(){

                cout<<"Make Faculty Page" <<endl;
                if(login() && isAdmin()){

                    cout<< "Enter faculty address\n";

                    generalEntry();

                    //add to faculty list
                    facultyList.push_back(generalInput);
                    cout<< "Email added successfully\n";

                }

                else{
                    cout<< "N/A\n";
                }
            }


            bool isFaculty(){

                bool state = false;

                for(auto itr: facultyList){  //iterates through admin list
                    if(itr == emailInput){ //
                        state = true;       //returns true if email holder is an admin
                    }
                }

                return state;
            }


                
};



//main function
int main()
{

    adminList.push_back("admin@gmail.com");
    
    LMS student; 

    student.createAccount();
    student.updateProfile();
    student.viewProfile();

    student.makeFaculty();
    
    return 0;


}
