package observer;
import java.security.cert.Extension;
import java.util.ArrayList;

/**
 * this class build a String with some function include undo function,and use the Observer pattern.
 * the program can update all the member that register to him about all changes will be in the string
 * @author Avihay Finish & Amit Rovshitz
 * @version 1
 */
public class GroupAdmin implements Sender {
    public ArrayList<Member>observerlist;
    public UndoableStringBuilder sbuilder;

    public GroupAdmin(UndoableStringBuilder b) {
        observerlist=new ArrayList<>();
        sbuilder=new UndoableStringBuilder(b.s);
    }

    public GroupAdmin() {
        observerlist=new ArrayList<>();
        sbuilder=new UndoableStringBuilder();
    }

    /**
     * this function registered a member to updating, all member that use this function will be update
     * about chnges in the string
     * @param obj the member that want to register
     */
    @Override
    public void register(Member obj)
    {
        if(observerlist.contains(obj))
        {
            System.out.println("the member is already registered");
        }
        else
        {
            observerlist.add(obj);
            obj.update(sbuilder);
            System.out.println("the member registered is successfully and updated");
        }
    }

    /**
     * this function cancelled the membership off updating
     * @param obj the member that want to cancel the updating option
     */
    @Override
    public void unregister(Member obj)
    {
        if (!observerlist.contains(obj)) {
            System.out.println("the member dont exist");
        }
        else {
            observerlist.remove(obj);
            System.out.println("the member deleted from the list of updated");
        }
    }

    /**
     * this function is the function insert from UndoableStringBuilder,
     * we additional here the notify function that will update the members about insertion
     * @param offset which index to input the string
     * @param obj the string we want to insert
     */
    @Override
    public void insert(int offset, String obj)
    {
        sbuilder.insert(offset,obj);
        notifyall();
    }


    /**
     * this function is the function insert from UndoableStringBuilder,
     * we additional here the notify function that will update the members about appendtion
     * @param obj the string we want to append
     */
    @Override
    public void append(String obj)
    {
        sbuilder.append(obj);
        notifyall();
    }


    /**
     * this function is the function insert from UndoableStringBuilder,
     * we additional here the notify function that will update the members about deletion
     * @param start from where to delete
     * @param end until where to delete
     */
    @Override
    public void delete(int start, int end)
    {
        sbuilder.delete(start,end);
        notifyall();
    }
    /**
     * this function is the function insert from UndoableStringBuilder,
     * we additional here the notify function that will update the members about undo
     */
    @Override
    public void undo()
    {
        sbuilder.undo();
        notifyall();
    }

    /**
     * this function will turn on the update function of all wich member
     */
    public void notifyall()
    {
        for(int i=0;i<observerlist.size();i++)
        {
            observerlist.get(i).update(sbuilder);
        }
    }

    @Override
    public String toString () {
        String s = "[";
        for (int i = 0;i < observerlist.size();i++) {
            s += observerlist.get(i).toString() + " ,";
        }
        s+= "]";
        return s;
    }
}
