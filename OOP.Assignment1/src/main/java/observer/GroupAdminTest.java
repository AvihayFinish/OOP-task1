package observer;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {

    @Test
    public void register(){
        UndoableStringBuilder b = new UndoableStringBuilder();
        UndoableStringBuilder c = new UndoableStringBuilder();
        GroupAdmin a = new GroupAdmin(b);
        ConcreteMember obj = new ConcreteMember(b);
        ConcreteMember obj1 = new ConcreteMember(c);
        a.register(obj);
        a.register(obj1);
        assertEquals(2, a.observerlist.size());
    }

    @Test
    public void unregister() {
        UndoableStringBuilder b = new UndoableStringBuilder("amit");
        UndoableStringBuilder d = new UndoableStringBuilder("king");
        GroupAdmin a = new GroupAdmin(b);
        ConcreteMember c = new ConcreteMember(b);
        ConcreteMember e = new ConcreteMember(d);
        a.register(c);
        a.register(e);
        a.unregister(c);
        System.out.println(a.observerlist);
        assertEquals(1, a.observerlist.size());
    }

    @Test
    public void insert(){
        UndoableStringBuilder b = new UndoableStringBuilder();
        UndoableStringBuilder c = new UndoableStringBuilder("fh");
        GroupAdmin a = new GroupAdmin();
        GroupAdmin a1 = new GroupAdmin(c);
        ConcreteMember obj = new ConcreteMember(b);
        ConcreteMember obj1 = new ConcreteMember();
        a.register(obj);
        a1.register(obj1);
        a.insert(0,"amit");
        assertEquals("amit", obj.buil.toString());
        a1.insert(1,"inis");
        assertEquals("finish", obj1.buil.toString());
    }

    @Test
    public void append(){
        UndoableStringBuilder b = new UndoableStringBuilder();
        GroupAdmin a = new GroupAdmin(b);
        ConcreteMember obj = new ConcreteMember();
        a.register(obj);
        a.append("avihay");
        assertEquals("avihay", obj.buil.toString());
        a.append(" and rovshitz");
        assertEquals("avihay and rovshitz", obj.buil.toString());
    }

    @Test
    public void delete(){
        UndoableStringBuilder b = new UndoableStringBuilder("finish");
        GroupAdmin a = new GroupAdmin(b);
        ConcreteMember obj = new ConcreteMember();
        a.register(obj);
        a.delete(0,2);
        assertEquals("nish" , obj.buil.toString());
    }

    @Test
    public void undo(){
        UndoableStringBuilder b = new UndoableStringBuilder();
        GroupAdmin a = new GroupAdmin(b);
        ConcreteMember c = new ConcreteMember();
        a.register(c);
        a.append("avihay");
        a.undo();
        a.append("finish");
        assertEquals("finish" , c.buil.toString());
    }

    @Test
    public  void notifyall() {
        UndoableStringBuilder b=new UndoableStringBuilder();
        GroupAdmin a=new GroupAdmin(b);
        ConcreteMember c1=new ConcreteMember();
        ConcreteMember c2=new ConcreteMember();
        a.register(c1);
        a.register(c2);
        a.append("amit");
        a.notifyall();
        assertEquals("amit" , c1.buil.toString());
        assertEquals("amit" , c2.buil.toString());

    }
}