package advising.testers;

import advising.MajorList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorListTest {

    @Test
        void testGetInstance() {
            // Test getInstance method to ensure it returns the same instance
            MajorList majorListInstance = new MajorList(); // Create an instance
            
            MajorList instance1 = majorListInstance.getInstance(); // Call getInstance() 
            MajorList instance2 = majorListInstance.getInstance(); // Call getInstance()
            assertSame(instance1, instance2);
    }

    @Test
    void testMajorsLoaded() {
        // Test if majors are loaded properly
        MajorList MajorList = new MajorList(); // Create an instance


        MajorList majorList = MajorList.getInstance(); 
       
        assertNotNull(majorList.getMajors(), "Majors should not be null");
        assertFalse(majorList.getMajors().isEmpty(), "Majors list should not be empty");
    }

    @Test
    void testSingleton() {
        // Ensure that no new instances are created
        MajorList MajorList = new MajorList(); // Create an instance

        MajorList majorList1 = MajorList.getInstance(); 
        MajorList majorList2 = MajorList.getInstance(); 
        assertEquals(majorList1, majorList2, "No new instances of MajorList should be created");
    }
}
