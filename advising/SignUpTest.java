package advising;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;


public class SignUpTest {
    static Student currentStudent = null;

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
        UserList userList = UserList.getInstance();
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
                currentStudent = userList.getStudentByUsername(userName);
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
            System.out.println("2. View required elective clusters progress");
            System.out.println("3. Show Application Areas");
            System.out.println("4. Generate 8-Semester Plan");
            System.out.println("5. Add Courses To Next Semester");

            System.out.println("0. Logout");
    
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
    
            switch (choice) {
                case "1":
                System.out.println("\n--- Student Progress ---");
                StudentPortfolio.printStudentPortfolioByUsername(studentUsername);
                System.out.println();

                System.out.println("Portfolio UUID: " + currentStudent.getPortfolio().getPortfolioUUID());
                    //System.out.println("Required Courses: " + portfolio.getRequiredCourses());
                    System.out.println("\nEight Semester Plan:");
                    currentStudent.getPortfolio().getEightSemesterPlan().forEach((semester, courses) -> {
                        System.out.print("\nSemester " + semester + ": \n");
                        courses.forEach(course -> System.out.print(course +"\n"));
                    });
                break;

                case "2":
                    showRequiredCourses(currentStudent);
                    break;
                case "3":
                    showApplicationAreas(currentStudent);
                    break;
                case "4":
                    System.out.println("Generating 8-Semester Plan...");                  
                    //plan goes here---
                    String filePath = "BraxWestFile.txt";
                    StudentPortfolio.printAStudentPortfolioToFile(filePath, studentUsername);
                    //System.out.println("8-Semester plan generated.");
                    break;

                case "0":
                    System.out.println("User is being logged out");
                    auditFacade.logoutStudent();
                    login(auditFacade, scanner);
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void showApplicationAreas(Student currentStudent) {
        System.out.println("Here are the available Application Areas:");
                    currentStudent.showApplicationAreas();
                    System.out.println("Do you want to choose a new Application Area? (yes/no)");
                    Scanner scanner = new Scanner(System.in);
                    String response = scanner.nextLine();
                    
                    
                    // imma loop through this 3 times bcc 3 courses = 1 application area.  3 credits each 
                    for (int i = 1; i < 4; i++) {
                        
                        // if the user wants to choose a new application area
                        if (response.equalsIgnoreCase("yes")) {
                            // asks the user to enter the name of the application area
                            System.out.println("Enter the name of Application Area Elective #" + i + " you want to choose:");
                            StudentPortfolio portfolio = currentStudent.getPortfolio();
                            
                            // check if the students portfolio is even there
                            if (portfolio != null) {
                                // get the list of electives from the student portfolio
                                ArrayList<ElectiveCluster> electives = portfolio.getStudentElectives().getElectives();
                                
                                // ask the user to enter the name of the elective they want to choose
                                String inputElectiveName = scanner.nextLine();
                                
                                // prints an input statement
                                System.out.println("Searching for elective: " + inputElectiveName);
                                boolean found = false;
                                
                                // checks to see if electives exist
                                if (electives != null) {
                                    // finnnaaa loop thought elective cluster to see if the elective is there
                                    for (ElectiveCluster electiveCluster : electives) {
                                        // gonna get the electives for the current cluster
                                        Map<String, Boolean> clusterElectives = electiveCluster.getElectives();
                                        
                                        // check if the elective name exists in the current cluster
                                        if (clusterElectives.containsKey(inputElectiveName)) {
                                            // print that it found the elective and its application area
                                            System.out.println("Elective found: " + inputElectiveName);
                                            System.out.println(" -- Application Area-- " + electiveCluster.getElectiveName());
                                            found = true;
                                            break; 
                                        }
                                    }
                                    
                                    // if the elective is not found print thissss
                                    if (!found) {
                                        System.out.println("Elective not found for " + currentStudent.getFirstName() + ".");
                                    }
                                } else {
                                    System.out.println("No electives found for " + currentStudent.getFirstName() + ".");
                                }
                            } else {
                                System.out.println("Portfolio not found for " + currentStudent.getFirstName() + ".");
                            }
                        }
                    }
                    }


                
    
    /**
     * Shows the required courses/elective clusters for a student to complete
     * @param currentStudent
     */
    private static void showRequiredCourses(Student currentStudent) {
        HashSet<String> titlesToMatch = new HashSet<>();
        titlesToMatch.add("CMW");
        titlesToMatch.add("ARP");
        titlesToMatch.add("SCI");
        titlesToMatch.add("GFL");
        titlesToMatch.add("GHS");
        titlesToMatch.add("AIU");
        titlesToMatch.add("CMS");
        titlesToMatch.add("INF");
        titlesToMatch.add("VSR");
        titlesToMatch.add("PR");
        titlesToMatch.add("MR");
        titlesToMatch.add("IC");
        titlesToMatch.add("FD");
    
        if (currentStudent != null) {
            StudentPortfolio portfolio = currentStudent.getPortfolio();
            if (portfolio != null) {
                ArrayList<ElectiveCluster> electives = portfolio.getStudentElectives().getElectives();
                if (electives != null) {
                    for (ElectiveCluster elective : electives) {
                        String electiveName = elective.getElectiveName();
                        if (electiveName != null && titlesToMatch.contains(electiveName)) {
                            if(elective.getHoursRequired() < elective.getHoursCompleted()) {
                                System.out.println("\nYou have completed the required hours for this elective: " + electiveName);
                            } else {
                                System.out.println("You have not completed the required hours for this elective");
                                System.out.println("Hours required: " + elective.getHoursRequired());
                                System.out.println("Hours completed: " + elective.getHoursCompleted());
                            }
                            System.out.println("Course options to fulfill " + electiveName + "\n");
                            for (String courseId : elective.getElectives().keySet()) {
                                System.out.println(courseId);
                            }
                            System.out.println();
                        }
                    }
                } else {
                    System.out.println("No electives found for the current student.");
                }
            } else {
                System.out.println("Portfolio not found for the current student.");
            }
        } else {
            System.out.println("Current student is null.");
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


private static void percentComplete() {
    int totalCreditHours = currentStudent.getPortfolio().getTotalCreditHours(); 
    System.out.println(currentStudent.getPortfolio().getTotalCreditHours());
    double percent = ((totalCreditHours / 130) * 100);
    System.out.println("Percent complete with degree: " + percent + "%");
}
    
    

}
