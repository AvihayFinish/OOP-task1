package observer;

/**
 * that function create the member that want to register the updating of GroupAdmin
 * @author Avihay Finish and Amit Rovshitz
 * @version 1
 */
public class ConcreteMember implements  Member{
    public UndoableStringBuilder buil;

    public ConcreteMember (UndoableStringBuilder u) {
        this.buil = u;
    }

    public ConcreteMember () {
        this.buil = new UndoableStringBuilder();
    }

    /**
     * this function change the string off the member, to the updated string
     * @param usb the UndoableStringBuilder we want to update to his
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.buil = usb;
    }

    public String toString() {
        return buil.toString();
    }

}
