package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {

    @Test
    void update() {
        UndoableStringBuilder u = new UndoableStringBuilder("abc");
        ConcreteMember c = new ConcreteMember(u);
        UndoableStringBuilder t = new UndoableStringBuilder("def");
        c.update(t);
        ConcreteMember p = new ConcreteMember(t);
        assertEquals("def", c.buil.toString());
    }
}