package advising;

import java.util.ArrayList;

public class MajorList {
    private static MajorList majorList;
    private static ArrayList<Major> majors;


    /**
     * Loads the arrayList majors with all majors in a JSON
     */
    public MajorList() {
        majors = DataLoader.getAllMajors();
    }

    /**
     * Gets an instance of the MajorList singleton if it exists, otherwise creates a new instance.
     * @return majorList
     */
    public static MajorList getInstance() {
        if (majorList == null) {
            majorList = new MajorList();
        }
        return majorList;
    }
    public Major getMajor(String majorID) {
        for (Major major : majors) {
            if (major.getMajorID().equals(majorID)) {
                return major;
            }
        }
        return null;
    }

    // Getter method for majors
    public ArrayList<Major> getMajors() {
        return majors;
    }
}
