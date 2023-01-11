import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(()->JvmUtilities.objectFootprint(s1));

        logger.info(()->JvmUtilities.objectFootprint(s1,s2));

        logger.info(()->JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }

    UndoableStringBuilder u1 = new UndoableStringBuilder();
    UndoableStringBuilder u2 = new UndoableStringBuilder("abcd");
    ConcreteMember c1 = new ConcreteMember();
    ConcreteMember c2 = new ConcreteMember(u2);
    GroupAdmin g1 = new GroupAdmin();

    @Test
    public void register () {
        System.out.println("the memory before registering a Member:");
        logger.info(()->JvmUtilities.objectFootprint(g1));
        logger.info(()->JvmUtilities.objectTotalSize(g1));
        logger.info(() -> JvmUtilities.jvmInfo());
        g1.register(c2);
        assertEquals(1,g1.observerlist.size());
        System.out.println("the memory after registering a Member:");
        logger.info(()->JvmUtilities.objectFootprint(g1));
        logger.info(()->JvmUtilities.objectTotalSize(g1));
        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    public void unregister () {
        System.out.println("the memory before registering and unregistering a Member:");
        logger.info(()->JvmUtilities.objectFootprint(g1));
        logger.info(()->JvmUtilities.objectTotalSize(g1));
        logger.info(() -> JvmUtilities.jvmInfo());
        g1.register(c1);
        g1.unregister(c1);
        assertEquals(0,g1.observerlist.size());
        System.out.println("the memory before registering and unregistering a Member:");
        logger.info(()->JvmUtilities.objectFootprint(g1));
        logger.info(()->JvmUtilities.objectTotalSize(g1));
        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    public void insert () {
        System.out.println("the memory before inserting a String:");
        logger.info(()->JvmUtilities.objectFootprint(g1));
        logger.info(()->JvmUtilities.objectTotalSize(g1));
        logger.info(() -> JvmUtilities.jvmInfo());
        g1.insert(0,"test");
        assertEquals("test",g1.sbuilder.toString());
        System.out.println("the memory before inserting a String:");
        logger.info(()->JvmUtilities.objectFootprint(g1));
        logger.info(()->JvmUtilities.objectTotalSize(g1));
        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    public void append () {
        System.out.println("the memory before appending a String:");
        logger.info(()->JvmUtilities.objectFootprint(g1));
        logger.info(()->JvmUtilities.objectTotalSize(g1));
        logger.info(() -> JvmUtilities.jvmInfo());
        g1.append("finish");
        assertEquals("finish",g1.sbuilder.toString());
        System.out.println("the memory after appending a String:");
        logger.info(()->JvmUtilities.objectFootprint(g1));
        logger.info(()->JvmUtilities.objectTotalSize(g1));
        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    public void delete () {
        System.out.println("the memory before appending and deleting a String:");
        logger.info(()->JvmUtilities.objectFootprint(g1));
        logger.info(()->JvmUtilities.objectTotalSize(g1));
        logger.info(() -> JvmUtilities.jvmInfo());
        g1.append("finish");
        g1.delete(1,3);
        assertEquals("fish",g1.sbuilder.toString());
        System.out.println("the memory after appending and deleting a String:");
        logger.info(()->JvmUtilities.objectFootprint(g1));
        logger.info(()->JvmUtilities.objectTotalSize(g1));
        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    public void undo () {
        System.out.println("the memory before undo function:");
        logger.info(()->JvmUtilities.objectFootprint(g1));
        logger.info(()->JvmUtilities.objectTotalSize(g1));
        logger.info(() -> JvmUtilities.jvmInfo());
        g1.append("finish");
        g1.delete(0,2);
        g1.undo();
        assertEquals("finish",g1.sbuilder.toString());
        System.out.println("the memory before undo function:");
        logger.info(()->JvmUtilities.objectFootprint(g1));
        logger.info(()->JvmUtilities.objectTotalSize(g1));
        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    public void notifyall () {
        System.out.println("the memory before registered member:");
        logger.info(()->JvmUtilities.objectFootprint(g1));
        logger.info(()->JvmUtilities.objectTotalSize(g1));
        logger.info(() -> JvmUtilities.jvmInfo());
        g1.register(c1);
        g1.register(c2);
        assertEquals(2,g1.observerlist.size());
        System.out.println("the memory of member after registered to groupadmin and before notify function:");
        logger.info(()->JvmUtilities.objectFootprint(c1));
        logger.info(()->JvmUtilities.objectTotalSize(c1));
        logger.info(() -> JvmUtilities.jvmInfo());
        g1.append("avihay");
        g1.delete(2,3);
        assertEquals("avhay" , g1.sbuilder.toString());
        System.out.println("the memory of member after appending and deleting and before notify function:");
        logger.info(()->JvmUtilities.objectFootprint(c1));
        logger.info(()->JvmUtilities.objectTotalSize(c1));
        logger.info(() -> JvmUtilities.jvmInfo());
        g1.notifyall();
        assertEquals("avhay" , c1.buil.toString());
        assertEquals("avhay" , c2.buil.toString());
        System.out.println("the memory of member after notify function:"); // this not will change because the member already updated after all function
        logger.info(()->JvmUtilities.objectFootprint(c1));
        logger.info(()->JvmUtilities.objectTotalSize(c1));
        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    public void update () {
        System.out.println("the memory of member before update:");
        logger.info(()->JvmUtilities.objectFootprint(c1));
        logger.info(()->JvmUtilities.objectTotalSize(c1));
        logger.info(() -> JvmUtilities.jvmInfo());
        c1.update(u2);
        System.out.println("the memory of member after update:");
        logger.info(()->JvmUtilities.objectFootprint(c1));
        logger.info(()->JvmUtilities.objectTotalSize(c1));
        logger.info(() -> JvmUtilities.jvmInfo());
    }
}
