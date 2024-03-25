package advising.testers;

import advising.ElectiveCluster;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ElectiveClusterTest {

    @Test
    void testIsClusterComplete() {
        // Create electives map with completed and required hours
        HashMap<String, Boolean> electives = new HashMap<>();
        electives.put("ELECTIVE1", true);
        electives.put("ELECTIVE2", true);
        electives.put("ELECTIVE3", true);

        // Create an ElectiveCluster instance
        ElectiveCluster electiveCluster = new ElectiveCluster("Cluster1", 3, 3, electives);

        // Test isClusterComplete method
        assertTrue(electiveCluster.isClusterComplete(), "Elective cluster should be complete");

        // Modify completed hours to be less than required
        electiveCluster.setHoursCompleted(2);

        // Test isClusterComplete method again
        assertFalse(electiveCluster.isClusterComplete(), "Elective cluster should not be complete");
    }

    @Test
    void testUpdateCourseCompletion() {
        // Create electives map with one completed and one incomplete course
        HashMap<String, Boolean> electives = new HashMap<>();
        electives.put("ELECTIVE1", true);
        electives.put("ELECTIVE2", false);

        // Create an ElectiveCluster instance
        ElectiveCluster electiveCluster = new ElectiveCluster("Cluster1", 2, 1, electives);

        // Update completion status of an existing course
        electiveCluster.updateCourseCompletion("ELECTIVE1", false);

        // Test if completion status is updated correctly
        assertFalse(electiveCluster.getElectives().get("ELECTIVE1"), "Course completion status should be false");

        // Try to update completion status of a non-existing course
        electiveCluster.updateCourseCompletion("ELECTIVE3", true);

        // Test if a message is printed when trying to update a non-existing course
        assertEquals("Course not found in elective cluster", electiveCluster.toString().trim(), "Expected message not found");
    }
}
