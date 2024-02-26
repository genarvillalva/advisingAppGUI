package advising;

public class MajorList {
    private MajorList majorList;

    private MajorList() {
        
    }

    /**
     * Gets an instance of the MajorList singleton if it exists, otherwise creates a new instance.
     */
    public MajorList getInstance() {
        if (majorList == null) {
            majorList = new MajorList();
        }
        return majorList;
    }
}
