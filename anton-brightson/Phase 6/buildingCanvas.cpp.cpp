#include <iostream>
using namesapce std;

class buildingCanvas{
    private:
    int count;
    int logGPA;
    int logYrgroup;
    int courseCode;

    string accounts[100];
    string facAccnts;
    string adminAccnts;
    string courseArray[100];
    
    String createAccount(){
        int count = 0;
        cout <<"To create account, enter email: ";
        cin >> userEmail; //get a store input from keyboard into variable
        cin >> accounts[count];
        cout <<"Please enter your password: ";
        cin >> userPassword;
        if (count < 100){
            count++;
        }

    boolean login(){
        cout <<"Enter email: ";
        cin >> logEmail;
        cout <<"Enter password: ";
        cin >> logPassword;
        for ( String [] acc: accounts){
            if (logEmail.equals(acc[1])){
                return true;
            }
        }

    }
    return false;

    String makeFaculty(){
        int count = 0;
        cout >>"Faculty signup, enter email: ";
        cin << facEmail;
        facAccnts [count];
        count++;
    }

    String createCourse(){
        cout>>"To create course, enter email: ";
        cin<< userEmail;
        courseArray [count] = userEmail;
        cout>>"Enter course code: ";
        cin<< courseCode;
        courseArray [count] = courseCode;
        cout>>"Enter course name: ";
        cin<< courseName;
        courseArray [count] = courseName
        if (count<100){
            count++;
        }
    }
    }
    class Output{
        public:
            static void print( );
    }

}