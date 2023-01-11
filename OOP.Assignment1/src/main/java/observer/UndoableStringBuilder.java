package observer;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * this class build a Sting with some function include undo function
 * @author Avihay Finish & Amit Rovshitz
 * @version 2
 */
public class UndoableStringBuilder {
    public String s;

    public static Stack<StringBuilder> finish = new Stack<>();

    public UndoableStringBuilder() {
        s = "";
        StringBuilder s2 = new StringBuilder(s);
        finish.add(s2);
    }

    public UndoableStringBuilder(String s1) {
        try {
            s = s1;
            StringBuilder s2 = new StringBuilder(s);
            finish.add(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Appends the specified string to this character sequence.
     * @param str is the string we want to addition
     * @return the new string with the addition
     */
    public UndoableStringBuilder append(String str) {
        StringBuilder st=new StringBuilder(s);
        finish.push(st.append(str));
        s=st.toString();
        return this;
    }

    /**
     * Removes the characters in a substring of this sequence.
     * @param start is the index from which to start deleting
     * @param end is the index up to which is deleted
     * @return the new string after deletion
     */
    public UndoableStringBuilder delete(int start, int end) {
        try {
            StringBuilder st=new StringBuilder(s);
            finish.push(st.delete(start, end));
            s=st.toString();
        } catch (StringIndexOutOfBoundsException e) {
            if (start < 0 || end < 0){
                System.out.println("the start and the end index must be positive");
            }
            else System.out.println("the end must be at least like the start");
        }
        return this;
    }

    /**
     * Inserts the string into this character sequence.
     * @param offset is the index from witch we addition
     * @param str is what we addition to the original string
     * @return the new string after addition in the offset index
     */
    public UndoableStringBuilder insert(int offset, String str)  {
        try {
            StringBuilder st = new StringBuilder(s);
            finish.push(st.insert(offset, str));
            s = st.toString();
        } catch (Exception e) {
            System.out.println("the offset must be positive");
        }
        return this;
    }

    /**
     * Replaces the characters in a substring of this sequence with characters in
     * the specified String.
     * @param start from where we replace
     * @param end until where we replace
     * @param str is the new string after replacing
     * @return
     */
    public UndoableStringBuilder replace(int start, int end, String str) {
        try {
            StringBuilder st=new StringBuilder(s);
            finish.push(st.replace(start, end, str));
            s=st.toString();
        } catch (NullPointerException e) {
            System.out.println("the String input cannot be null");
        } catch (StringIndexOutOfBoundsException ex) {
            if (start < 0 || end < 0){
                System.out.println("the start and the end index must be positive");
            }
            else System.out.println("the end must be at least like the start");
        }
        return this;
    }

    /**
     * Causes this character sequence to be replaced by the reverse of the
     * sequence.
     * @return the new string with reversing
     */
    public UndoableStringBuilder reverse() {
        try {
            StringBuilder st=new StringBuilder(s);
            finish.push(st.reverse());
            s=st.toString();
        } catch (NullPointerException e) {
            System.out.println("the String cannot be null");
        }
        return this;
    }

    /**
     * This function gives you the previous action you did
     */
    public void undo() {
        try {
            finish.pop();
            System.out.println(finish.peek());
            s = finish.peek().toString();
        } catch (EmptyStackException ex) {
            System.out.println("The stack is empty");
        }
    }

    public String toString() {
        return this.s;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof UndoableStringBuilder))
            return false;
        UndoableStringBuilder st=(UndoableStringBuilder) (obj);
        return st.s.equals(this.s);
    }

}