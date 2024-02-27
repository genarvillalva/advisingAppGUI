package advising;

import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        testGetAllStudents();
        testGetAllAdvisors();
    }

    public static void testGetAllStudents() {
        ArrayList<Student> students = DataLoader.getAllStudents();
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void testGetAllAdvisors() {
        ArrayList<Advisor> advisors = DataLoader.getAllAdvisors();
        System.out.println("List of Advisors:");
        for (Advisor advisor : advisors) {
            System.out.println(advisor);
        }
    }
}
