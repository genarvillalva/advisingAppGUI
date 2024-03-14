package advising;

import java.util.HashMap;

public class TestElectiveCluster {

    public static void main(String[] args) {
        HashMap<String, Boolean> electives = new HashMap<>();
        electives.put("CS101", true); 
        electives.put("CS102", false);
        electives.put("CS103", true);

        ElectiveCluster cluster = new ElectiveCluster("Computer Science Basics", 9, 6, electives);

        // Printing the ElectiveCluster
        System.out.println(cluster);

        cluster.updateCourseCompletion("CS102", true);

        System.out.println("After updating CS102 completion status:");
        System.out.println(cluster);
    }
}
