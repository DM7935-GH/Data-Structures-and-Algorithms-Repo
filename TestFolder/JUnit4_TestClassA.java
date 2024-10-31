import mainPackage.BasicList;
import mainPackage.LinkedList;
import mainPackage.CircularLinkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JUnit4_TestClassA {
    BasicList testBL1; BasicList testBL2;

    @Before
    public void basicList_SetUp() throws Exception {
        testBL1 = new BasicList(3, "Test Basic List", false);
        testBL2 = new BasicList(3, "Test Basic List", false);
        testBL2.Add(1); testBL2.Add(2); testBL2.Add(3);
    }

    @Test
    public void test_BasicList_IsEmpty() {
        assertTrue("This list should be recognized as empty.", testBL1.IsEmpty());
        assertEquals("The length of an empty list should be zero.", 0, (int) testBL1.Length());
    }

    @Test
    public void test_BasicList_IsFull() {
        assertTrue("This list should be recognized as full.", testBL2.IsFull());
    }

    @Test
    public void test_BasicList_Add() {
        testBL1.Add(1);
        assertEquals("The length of this list should be 1.", 1, (int) testBL1.Length());
        testBL2.Add(4);
        assertEquals("Using Add() on a full list should not yield any result.", 3, (int) testBL2.Length());
    }

    @Test
    public void test_BasicList_Get() {
        assertEquals("Using Get() on an empty list should return null.", null, testBL1.Get(0));
        testBL1.Add(1);
        assertEquals("The first item of the list should now be 1.", 1, (int) testBL1.Get(0));
        assertNull("Get() should return null if the index is out of bounds.", testBL1.Get(-1));
        assertNull("Get() should return null if the index is out of bounds.", testBL1.Get(1));
        testBL1.Add(2); testBL1.Add(3);
        assertEquals("The second item of the list should now be 2.", 2, (int) testBL1.Get(1));
        assertEquals("The third item of the list should now be 3.", 3, (int) testBL1.Get(2));
    }
}
