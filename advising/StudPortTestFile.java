package advising;

import java.util.ArrayList;

public class StudPortTestFile {
    public static void main(String[] args) {
        

        UserList userList = UserList.getInstance();
        ArrayList<Student> students = userList.getStudents();
       // System.out.println(students.get(0).getPortfolio().getEightSemesterPlan());

        
        System.out.println("Portfolio UUID: " + students.get(0).getPortfolio().getPortfolioUUID());
            //System.out.println("Required Courses: " + portfolio.getRequiredCourses());
            System.out.println("\nEight Semester Plan:");
            students.get(0).getPortfolio().getEightSemesterPlan().forEach((semester, courses) -> {
                System.out.print("\nSemester " + semester + ": \n");
                courses.forEach(course -> System.out.print(course +"\n"));
            });




      
/* 
        public static void printEightSemesterPlan() {
            StudentPortfolio studentPortfolio = StudentPortfolio.printAllStudentPortfolios();
            System.out.println("Portfolio UUID: " + studentPortfolio.getPortfolioUUID());
            System.out.println("\nEight Semester Plan:");
            studentPortfolio.getEightSemesterPlan().forEach((semester, courses) -> {
              System.out.print("\nSemester " + semester + ": ");
              courses.forEach(course -> System.out.print(course + ", "));
              System.out.println();
            });
          }

        for(StudentPortfolio portfolio : StudentPortfolios) { 

        }
        Student.printEightSemesterPlan();

*/


        String filePath = "student_portfolio13.txt";
        String portfolioUUID = "bwest"; // or any other UUID
        StudentPortfolio.printAStudentPortfolioToFile(filePath, portfolioUUID);

        //Student.printAllStudentPortfolios();
        //String filePath = "student_portfolio12.txt";
        //StudentPortfolio.printAllStudentPortfoliosToFile(filePath);

    }
}
