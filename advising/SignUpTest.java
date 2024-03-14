package advising;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class SignUpTest {
    public static void main(String[] args) {
        AuditFacade auditFacade = new AuditFacade();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Degree Works");

        boolean running = true;
        while (running) {
            // Display menu options
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. See All Users");
            
                    /*Advisor a =null;
                    StudentYear studentYear2 = StudentYear.FRESHMAN;
                    Student timmy = new Student("Timmy","Alexander","timey","helloworld","Student","Computer_Science",a,studentYear2,null,null,null);
                    
                    ArrayList<Student>students = new ArrayList<Student>();
                    students.add(timmy);
                    DataWriter.saveStudents(students);
*/

            System.out.println("0. Exit");

            // Prompt user for choice
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // Call login 
                    login(auditFacade, scanner);
                    break;
                case "2":
                    // Call sign up 
                    signUp(auditFacade, scanner);
                    break;
                case "3":
                    // Display all users
                    UserList.getInstance().printUsers();
                    break;
                case "0":
                    // Exit the program
                    running = false;
                    break;
                default:
                    // Invalid option
                    System.out.println("Invalid option, please try again.");
            }
        }

        // Close scanner
        scanner.close();
        System.out.println("Thank you for using DegreeWorks!");
    }

    // Method for signing up a new user
    private static void signUp(AuditFacade auditFacade, Scanner scanner) {
        String userType = ""; // Initialize user type
        String firstName = null; // Initialize first name
        String lastName = null; // Initialize last name
        String major = null; // Initialize major
        StudentYear studentYear = StudentYear.FRESHMAN; // Initialize studentYear

        // Prompt user for user type
        System.out.print("User Type (student/advisor/admin): ");
        userType = scanner.nextLine();

        // If user type is student, prompt for additional information
        if (userType.equalsIgnoreCase("student")) {
            System.out.print("First Name: ");
            firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            lastName = scanner.nextLine();
            System.out.print("Major: ");
            major = scanner.nextLine();
            System.out.print("Student Year (FRESHMAN/SOPHOMORE/JUNIOR/SENIOR): ");
            studentYear = StudentYear.valueOf(scanner.nextLine());
        
        }


        
        // If user type is advisor, prompt for additional information
        if (userType.equalsIgnoreCase("advisor")) {
            System.out.print("First Name: ");
            firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            lastName = scanner.nextLine();
        }

        // Prompt for username and password
        System.out.print("Username: ");
        String userName = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Call sign up method in AuditFacade
        auditFacade.signUp(userName, password, userType, firstName, lastName, major, studentYear);
    }



    // Method for logging in a user
    private static void login(AuditFacade auditFacade, Scanner scanner) {
        // Prompt for username, password, and user type
        System.out.print("Username: ");
        String userName = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("User Type (student/advisor/admin): ");
        String userType = scanner.nextLine();

        // Attempt login
        boolean success = auditFacade.login(userName, password, userType);

        // Display login result
        if (success) {            
            System.out.println("Login successful for: " + userType + " - " + userName);
            advisorMenu(userName, auditFacade, scanner);

            
        } else {
            System.out.println("Login failed. Please check your credentials and try again.");
        }
    
    }
    private static void advisorMenu(String advisorUsername, AuditFacade auditFacade, Scanner scanner) {
        boolean running = true;
        while (running) {
            // Display advisor menu options
            System.out.println("\nAdvisor Menu:");
            System.out.println("1. Look up a student");
            //System.out.println("2. Suggest courses");
            //System.out.println("3. Add student to advisor");
            //System.out.println("4. Remove student from program");
            //System.out.println("5. Write a note");
            //System.out.println("6. Generate eight semester plan");
            System.out.println("0. Logout");
    
            // Prompt user for choice
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
    
            switch (choice) {
                case "1":
                    // Look up a student
                    lookUpStudent(advisorUsername, auditFacade, scanner);
                    break;
                case "0":
                    // Logout
                    running = false;
                    break;
                default:
                    // Invalid option
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
    
    private static void lookUpStudent(String advisorUsername, AuditFacade auditFacade, Scanner scanner) {
        // Prompt for student username
        System.out.print("Enter Student Username: ");
        String studentUsername = scanner.nextLine();
    
        // Look up the student by advisor
        Student student = auditFacade.lookUpStudent(advisorUsername, studentUsername);
    
        // Display result
        if (student != null) {
            // Student found, do something with the student object
            System.out.println("Student found: " + student);
            boolean success = true;
        } else {
            // Student not found
            System.out.println("Student not found.");
            // Set success to false or perform further actions
            boolean success = false;
        }
        
    }

}
