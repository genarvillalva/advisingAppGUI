package advising;

import java.util.ArrayList;

public class Testapp {

    public static void main(String[] args)
    {
        UserList userList = UserList.getInstance(); // Get the instance of UserList
        userList.createAccount("newstudent", "password123", "student", "John", "Doe", "Computer Science", StudentYear.FRESHMAN);
    
                    Advisor a =null;
                    StudentYear studentYear2 = StudentYear.FRESHMAN;
                    Student timmy = new Student("Timmy","Alexander","timey","helloworld","Student","Computer_Science",a,studentYear2,null,null,null);
                    
                    ArrayList<Student>students = new ArrayList<Student>();
                    students.add(timmy);
                    DataWriter.saveStudents(students);
    }


    
}
