package advising;
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
                case "0":
                    // Exit the program
                    scanner.close();
                    System.out.println("Thank you for using DegreeWorks!");
                    System.exit(0);
                default:
                    // Invalid option
                    System.out.println("Invalid option, please try again.");
            }
        }
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
            // Display different menus based on the user type
            if ("advisor".equalsIgnoreCase(userType)) {
                advisorMenu(userName, auditFacade, scanner);
            } else if ("student".equalsIgnoreCase(userType)) {
                //displays the student menu
                studentMenu(userName, auditFacade, scanner);
            }       
        } else {
            System.out.println("Login failed. Please check your credentials and try again.");
        }
    }
    private static void advisorMenu(String advisorUsername, AuditFacade auditFacade, Scanner scanner) {
        String username;
        boolean running = true;
        while (running) {
            // Display advisor menu options
            System.out.println("\nAdvisor Menu:");
            System.out.println("1. Look up a student");
            System.out.println("2. Add student as advisee");
            System.out.println("3. Write a note");
            System.out.println("0. Logout");
    
            // Prompt user for choice
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
    
            switch (choice) {
                case "1":
                    // Look up a student
                    lookUpStudent(advisorUsername, auditFacade, scanner);
                    break;
                case "2":
                    System.out.println("Enter the student's username");
                    username = scanner.nextLine();
                    auditFacade.addStudentToAdvisor(username);
                    break;
                case "3":
                    System.out.println("Enter the student's username");
                    username = scanner.nextLine();
                    System.out.println("Type your note (press Enter when finished):");
                    String note = scanner.nextLine(); // Get the note from the advisor
                    auditFacade.adviseStudent(note, username);
                     //System.out.println("Note added to.");
                    
                    break;
                case "0":
                    // Logout
                    System.out.println("User is being logged out");
                    auditFacade.logoutAdvisor();
                    main(null);
                    break;
                default:
                    // Invalid option
                    System.out.println("Invalid option, please try again.");
            }
        }
    }


    private static void studentMenu(String studentUsername, AuditFacade auditFacade, Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\nStudent Menu:");
            System.out.println("1. View Progress");
            System.out.println("2. Pick Course");
            System.out.println("3. Pick Application Area");
            System.out.println("4. Generate 8-Semester Plan");


            System.out.println("0. Logout");
    
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
    
            switch (choice) {
                case "1":

                System.out.println("\n--- Student Progress ---");
                break;

                case "2":
                    System.out.println("Pick Course...");
                    break;
                case "3":
                    System.out.println("Choose Application Area...");
                    break;
                case "4":
                    System.out.println("Generating 8-Semester Plan...");

                    
                    //plan goes here---

                    System.out.println("8-Semester plan generated.");

                    break;

                case "0":
                    auditFacade.logoutAdvisor();
                    login(auditFacade, scanner);
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
    
private static void lookUpStudent(String advisorUsername, AuditFacade auditFacade, Scanner scanner) {
    System.out.print("Enter Student Username: ");
    String studentUsername = scanner.nextLine();

    // Look up the student by advisor
    Student student = auditFacade.lookUpStudent(advisorUsername, studentUsername);

    // Display result
    if (student != null) {
        System.out.println("Student found: " + student);
        boolean success = true;
    } else {
        // Student not found
        System.out.println("Student not found.");
        // Set success to false 
        boolean success = false;
        return;
    }
}

    
    

}
