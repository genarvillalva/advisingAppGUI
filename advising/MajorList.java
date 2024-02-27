package advising;

import java.util.ArrayList;

public class MajorList {
    private MajorList majorList;
    private ArrayList<Major> majors;


    /**
     * Loads the arrayList majors with all majors in a JSON
     */
    private MajorList() {
        majors = DataLoader.getAllMajors();
    }

    /**
     * Gets an instance of the MajorList singleton if it exists, otherwise creates a new instance.
     * @return majorList
     */
    public MajorList getInstance() {
        if (majorList == null) {
            majorList = new MajorList();
        }
        return majorList;
    }
}
