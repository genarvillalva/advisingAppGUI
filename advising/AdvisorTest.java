package advising;

import java.util.ArrayList;

public class AdvisorTest {

    public static void main(String[] args) {
        //major 
        String major = "Computer Science";

        // Placeholder for an Advisor
        Advisor mockAdvisor = null; 

        //student year
        StudentYear studentYear = StudentYear.SOPHOMORE; 

        // The portfolio is initialized
        StudentPortfolio portfolio = new StudentPortfolio(major, null, null, null, null, null, major, 0, 0.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);

        // application area 
        String applicationArea = "Math";

        // Instantiated a Student object 
        Student student1 = new Student(

            "Myles", "Carter",
            "mylescarter",
            "pass123",
            "student", 
            major,
            mockAdvisor, 
            studentYear,
            portfolio,
            applicationArea,
            ""
        );

            // Instantiated a Student object 
            Student student2 = new Student(

            "Robbie", "Van",
            "robbievan",
            "pass789",
            "student", 
            major,
            mockAdvisor, 
            studentYear,
            portfolio,
            applicationArea,
            ""
        );




        // Create a list to hold Student objects and add the mock student to this list
        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);


        
        UserList.getInstance().addStudent(student1);
        UserList.getInstance().addStudent(student2);

        // See student being added to UserList
        System.out.println("Students in UserList:");
        
        UserList.getInstance().getStudents().forEach(student -> System.out.println(student.getUsername())); 
        
        System.out.println(" ");

        
        System.out.println("Printing all of the Students:  ");
       
        //prints out students in the array
        for (Student student : students) {
            System.out.println(student);
        }

    
        
        Advisor advisor = new Advisor("Genar", "Villinova", "Genar", "pass456", "advisor", new ArrayList<>());
        
        String note = "Please pick Stats as your App area!!!";

        System.out.println(" ");
        
        
        advisor.addStudentToAdvisor("mylescarter", advisor.getListofAdvisedStudents());

        
        
        
        // Print out the advising notes for Myles Carter
        System.out.println(" ");

        advisor.adviseStudent("mylescarter", note);
        System.out.println("Advising Notes for Myles Carter: " + student1.getAdvisingNotes());

    }
}