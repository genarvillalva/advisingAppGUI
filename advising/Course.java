package advising;

import java.util.ArrayList;

public class Course{
    private String courseName;
    private String courseID;
    private CourseCode courseCode;
    private int creditHours;
    private ArrayList<Course> prerequisiteCourses;
    private ArrayList<Course> corequisiteCourses;
    private Semester semester;
    private char minGrade;
    private String courseUUID;

    public String Course(String courseName, String courseCode) {
        
        return "";
    }

    public boolean PrereqComplete (ArrayList<prerequisiteCourses>, ArrayList<completedCourses){

        return true;
    }
}
