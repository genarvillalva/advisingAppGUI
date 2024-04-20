package advisorfx;

import advising.Course;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CourseDetailsController {

    @FXML
    private Label titleLabel;

    @FXML
    private Label codeLabel;

    @FXML
    private Label creditHoursLabel;

    @FXML
    private Label semesterOfferedLabel;

    @FXML
    private Label prerequisitesLabel;

    @FXML
    private Label corequisitesLabel;

    public void initData(Course course) {
        if (course != null) {
            titleLabel.setText("Course Title: " + course.getCourseTitle());
            codeLabel.setText("Course Code: " + course.getCourseCode());
            creditHoursLabel.setText("Credit Hours: " + course.getCreditHours());
            semesterOfferedLabel.setText("Semester Offered: " + course.getSemester());
            prerequisitesLabel.setText("Prerequisite Courses: " + course.getPrerequisiteCourses());
            corequisitesLabel.setText("Corequisite Courses: " + course.getCorequisiteCourses());

            String prerequisites = course.getPrerequisiteCourses().toString();
            if (!prerequisites.isEmpty()) {
                prerequisites = prerequisites.substring(1, prerequisites.length() - 1);
                prerequisites = prerequisites.replaceAll("\\s+", ""); 
                prerequisites = prerequisites.replaceAll("(?i)Title:.*?(?=CourseID:|$)", ""); 
                prerequisites = prerequisites.replaceAll("[A-Za-z]+:", ""); 
            } else {
                prerequisites = "None";
            }
            prerequisitesLabel.setText("Prerequisite Courses: " + prerequisites);
            
            String corequisites = course.getCorequisiteCourses().toString();
            if (!corequisites.isEmpty()) {
                corequisites = corequisites.substring(1, corequisites.length() - 1);
                corequisites = corequisites.replaceAll("\\s+", ""); 
                corequisites = corequisites.replaceAll("(?i)Title:.*?(?=CourseID:|$)", ""); 
                corequisites = corequisites.replaceAll("[A-Za-z]+:", ""); 
            } else {
                corequisites = "None";
            }
            corequisitesLabel.setText("Corequisite Courses: " + corequisites);
        } else {
            titleLabel.setText("Course Details Not Available");
            codeLabel.setText("");
            creditHoursLabel.setText("");
            semesterOfferedLabel.setText("");
            prerequisitesLabel.setText("");
            corequisitesLabel.setText("");
        }
    }
}
