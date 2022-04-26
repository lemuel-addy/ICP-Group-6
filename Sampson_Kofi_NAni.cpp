# include <stdio.h>
# include <conio.h>
# include <stdlib.h>
# include <string.h>

int main()
{//create account that takes a username and a password
    char email[],passwrd[];
    char uoid[] = "Sampson.nani@ashesi.edu.gh ",passwrd[] = "icp2022";
        printf("Enter your email -> ");
        scanf("%s", email);
        printf("\n");
        printf("Enter Your Password -> ");
        scanf("%s", passwrd);
//checking if the email and password matches with the one initialized 
        if (strcmp(uoid, userId) == 0 && strcmp(passwrd, opasswrd) == 0)
        {
            printf("Correct User Id And Password\n");//if the password and email matches, the user is allowed entry
            break;
        }
        else
        {
            printf("Invalid User Id And Password\n\n");//if email and password does not match, the user is not allowed
    }

    getch();

    return 0;
}
//Login Account
//This function should take the email and password of a user and return true if the user exists; 
string email;
    string passwrd;
        cout << "Please enter your email: ";
        cin >> email;
        cout << "Please enter your password: ";
        cin >> passwrd;

        if (email == "Sampson.nani@ashesi.edu.gh" && password == "icp2022")
        {
            cout << "Welcome Sampson!\n";
            break;
        }
        else
        {
            cout << "Invalid login attempt. Please try again.\n" << '\n';
        }
    }
    cout << "Thank you for logging in.\n";
    return 0;
}
//grade Assignment
/* this function assigns letter grades to various grades*/
 int i;
    float mark;
    cout<<"Enter Mark: ";
    for(i=0; i<5; i++)
    {
        cin>>mark;
    }
    cout<<"\nGrade = ";
    if(mark>=85 && mark<=100)
        cout<<"A+";
    else if(mark>=80 && mark<84)
        cout<<"A";
    else if(mark>=75 && mark<79)
        cout<<"B+";
    else if(mark>=70 && mark<74)
        cout<<"B";
    else if(mark>=65 && mark<69)
        cout<<"C+";
    else if(mark>=60 && mark<64)
        cout<<"C";
    else if(mark>=55 && mark<59)
        cout<<"D+";
    else if(mark>=50 && mark<54)
        cout<<"D";
    else if(mark<49)
        cout<<"E";
    else
        cout<<"No score!";
    cout<<endl;
    return 0;
}
//view student

struct student
{
    char email[];
    char email;
} s[];

int main()
{
    cout << "Enter Email: " << endl;

    // storing information
    for(int i = 0; i < 10; ++i)
    {
        s[i].email = i+1;
        cout << "For email" << s[i].email << "," << endl;
        cout << endl;
    }

    cout << "Displaying Information: " << endl;

    // Displaying information
    for(int i = 0; i < 10; ++i)//iteraring the email array
    {
        cout << "\nemail: " << i+1 << endl;
    }

    return 0;
}
/*This function should take the email of a user and their first name, last name, year group, 
current GPA, and date of birth, and update their details accordingly. */
class record
{
public:
	char email[];
	char fname[];
	char lname[];
    int yeargroup[];
    double gpa[];
    char dob[];
	
	void studentinfo()
	{
		ifstream input;
	input.open("save.txt");//the parameters are saved in a txt file that should be opened
	ofstream output;
	output.open("show.xls");
	string line;
	if(input.is_open())
	{
		while (getline(input,line))
		{
          
			output<<line<<endl;

		}
    }
	}
	void info()
	{
		ofstream myfile;
		myfile.open("save.txt");

		for(int i= 0; i<3; i++)
		{
         cout<<"Enter the email"<<endl;//taking the various inputs
		 getline(cin,email[i]);

        }

	for(int i= 0; i<3; i++)
		{
         cout<<"Enter the fname"<<endl;
		 cin>>fname[i];
        }
    for(int i= 0; i<3; i++)
		{
         cout<<"Enter the lname"<<endl;
		 cin>>lname[i];
        }
    for(int i= 0; i<3; i++)
		{
         cout<<"Enter the yeargroup"<<endl;
		 cin>>yeargroup[i];
        }
    for(int i= 0; i<3; i++)
		{
         cout<<"Enter the GPA"<<endl;
		 cin>>GPA[i];
        }
    for(int i= 0; i<3; i++)
		{
         cout<<"Enter the dob"<<endl;
		 cin>>dob[i];

        }
    //updating them by their index
	myfile<<"email"<<"\t"<<"fname"<<"\t"<<"lname"<<"\t"<<"yeargroup"<<"\t"<<"GPA"<<"\t"<<"dob"<<endl;
	for(int i =0; i<3; i++)
	{

		myfile<<email[i]<<"\t"<<fname[i]<<"\t"<<lname[i]<<"\t"<<yeargroup[i]<<"\t"<<GPA[i]<<"\t"<<dob[i]<<endl;
	} 
	}
private:

};

int main()
{   record c;
	c.info();
	c.studentinfo();
	system("pause");
    return 0;
}
/*#10 viewCourses 
This function should display all created courses, showing the course code and course name 
as well as the email and name of the course creator. */
struct courses
{
    char coursecode[];
    char coursename[];
    char coursecode;
    char coursename;
} s[];

int main()
{
    cout << "Enter course code: " << endl;

    // storing information
    for(int i = 0; i < 10; ++i)
    {
        s[i].coursecode = i+1;
        cout << "For coursecode" << s[i].coursecode << "," << endl;
        cout << endl;
    }
    for(int i = 0; i < 10; ++i)
    {
        s[i].coursename = i+1;
        cout << "For coursename" << s[i].coursename << "," << endl;
        cout << endl;
    }

    cout << "Displaying Information: " << endl;

    // Displaying information
    for(int i = 0; i < 10; ++i)//iteraring the course code array
    {
        cout << "\ncoursecode: " << i+1 << endl;
    }
     for(int i = 0; i < 10; ++i)//iteraring the course name array
    {
        cout << "\ncoursename: " << i+1 << endl;
    }

    return 0;
}
/*17 submitAssignment 
This function should take a user’s email, a course code, an assignment name, and a 
submission which can be just a string and save the submission. Login Required.*/
int main(){
    char email;
    char coursecode;
    char assignmentname;
    char submission;
    fstream newfile;
    newfile.open("Assignment1.txt",ios::out)
    if (newfile.is_open())
        {
        newfile<<"C++ is Object Oriented programming"<<endl;
        newfile<<"JAVA is Object Oriented Programming"<<endl;
        newfile.close();
    }
    system("pause");
    return 0
}