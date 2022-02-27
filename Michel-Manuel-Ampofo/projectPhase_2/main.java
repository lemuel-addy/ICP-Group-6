package projectPhase_2;

public class main {
    public static void main(String[] args) {

        //notification preferences

        // setNotificationPreferences( "no", "yes", "yes");


        //testing addAdmin

        addAdmin( "michelmanuel@gmail.com", "asdf");


        //testing adminLogin
        adminLogin("michelmanuel@gmail.com", "asdf");


        // testing isAdmin
        isAdmin("michelmanuel@gmail.com");

        //testing makeFaculty
        makeFaculty("faculty1@gmail.com");


        // testing makeStudent
        makeStudent("ama@gmail.com");

        // testing is student
        isStudent("ama@gmail.com");


        //testing createAccount for student
        createAccount("ama@gmail.com", "qwer");
        // testing student login
        studentLogin("ama@gmail.com", "qwer");


        // testing update details
        updateProfile("michelmanuel@gmail.com", "asdf");


        //testing view profile
        viewProfile("ama@gmail.com");




        // for faculty
        createAccount("faculty1@gmail.com", "faculty1");
        facultyLogin("faculty1@gmail.com", "faculty1");
        isFaculty("faculty1@gmail.com");

        createCourse("faculty1@gmail.com","faculty1", "001","English", "Dr Kofi");
        viewCourse();
        addAssignment ("faculty1@gmail.com", "faculty" ,"001", "English project",  "Project for the course ","27/02/2022", "Project");
        viewAssignmentByCourse("001");



        // for faculty 2

        createCourse("faculty1@gmail.com","faculty1", "002","RME", "Dr Ama");
        viewCourse();
        addAssignment ("faculty1@gmail.com", "faculty1" ,"002", "RME Exams",  "exams for the course ","27/02/2022", "Project");
        viewAssignmentByCourse("002");




        // for faculty

        createCourse("faculty1@gmail.com","faculty1", "003","ICT", "Dr Charles");

        addAssignment ("faculty1@gmail.com", "faculty1" ,"003", "ICT quiz",  "quiz for the course ","27/02/2022", "Project");
        viewAssignmentByCourse("003");

        viewCourse();











    }



}
