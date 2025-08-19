import mainPackage.SortingAlgorithms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JUnit4_TestClassB {
    SortingAlgorithms SAObject;

    @Before
    public void SetUp() {
        SAObject = new SortingAlgorithms();
    }

    @Test
    public void Test_SelectionSort() {
        int[] inputArray1 = {4,3,7,6,1,2,9,5,8,0}; int[] expectedArray1 = {0,1,2,3,4,5,6,7,8,9};
        int[] inputArray2 = {}; int[] expectedArray2 = {};
        int[] inputArray3 = {-50}; int[] expectedArray3 = {-50};
        int[] inputArray4 = {22,-22}; int[] expectedArray4 = {-22,22};

        assertArrayEquals(expectedArray1, SAObject.SelectionSort(inputArray1));
        assertArrayEquals(expectedArray2, SAObject.SelectionSort(inputArray2));
        assertArrayEquals(expectedArray3, SAObject.SelectionSort(inputArray3));
        assertArrayEquals(expectedArray4, SAObject.SelectionSort(inputArray4));
    }

    @Test
    public void Test_InsertionSort() {
        int[] inputArray1 = {4,3,7,6,1,2,9,5,8,0}; int[] expectedArray1 = {0,1,2,3,4,5,6,7,8,9};
        int[] inputArray2 = {}; int[] expectedArray2 = {};
        int[] inputArray3 = {-50}; int[] expectedArray3 = {-50};
        int[] inputArray4 = {22,-22}; int[] expectedArray4 = {-22,22};
        
        assertArrayEquals(expectedArray1, SAObject.InsertionSort(inputArray1));
        assertArrayEquals(expectedArray2, SAObject.InsertionSort(inputArray2));
        assertArrayEquals(expectedArray3, SAObject.InsertionSort(inputArray3));
        assertArrayEquals(expectedArray4, SAObject.InsertionSort(inputArray4));
    }

    @Test
    public void Test_Quicksort() {
        int[] inputArray1 = {4,3,7,6,1,2,9,5,8,0}; int[] expectedArray1 = {0,1,2,3,4,5,6,7,8,9};
        int[] inputArray2 = {}; int[] expectedArray2 = {};
        int[] inputArray3 = {-50}; int[] expectedArray3 = {-50};
        int[] inputArray4 = {22,-22}; int[] expectedArray4 = {-22,22};
        
        assertArrayEquals(expectedArray1, SAObject.Quicksort(inputArray1));
        assertArrayEquals(expectedArray2, SAObject.Quicksort(inputArray2));
        assertArrayEquals(expectedArray3, SAObject.Quicksort(inputArray3));
        assertArrayEquals(expectedArray4, SAObject.Quicksort(inputArray4));
    }

    @Test
    public void Test_MergeSort() {
        int[] inputArray1 = {4,3,7,6,1,2,9,5,8,0}; int[] expectedArray1 = {0,1,2,3,4,5,6,7,8,9};
        int[] inputArray2 = {}; int[] expectedArray2 = {};
        int[] inputArray3 = {-50}; int[] expectedArray3 = {-50};
        int[] inputArray4 = {22,-22}; int[] expectedArray4 = {-22,22};
        
        assertArrayEquals(expectedArray1, SAObject.MergeSort(inputArray1));
        assertArrayEquals(expectedArray2, SAObject.MergeSort(inputArray2));
        assertArrayEquals(expectedArray3, SAObject.MergeSort(inputArray3));
        assertArrayEquals(expectedArray4, SAObject.MergeSort(inputArray4));
    }

    @Test
    public void Test_CountingSort() {
        int[] inputArray1 = {4,3,7,6,1,2,9,5,8,0}; int[] expectedArray1 = {0,1,2,3,4,5,6,7,8,9};
        int[] inputArray2 = {}; int[] expectedArray2 = {};
        int[] inputArray3 = {12,16,7,14,4,18,2,16,2,10}; int[] expectedArray3 = {2,2,4,7,10,12,14,16,16,18};

        assertArrayEquals(expectedArray1, SAObject.CountingSort(inputArray1));
        assertArrayEquals(expectedArray2, SAObject.CountingSort(inputArray2));
        assertArrayEquals(expectedArray3, SAObject.CountingSort(inputArray3));
    }

    @Test
    public void Test_RadixSort() {
        int[] inputArray1 = {4,3,7,6,1,2,9,5,8,0}; int[] expectedArray1 = {0,1,2,3,4,5,6,7,8,9};
        int[] inputArray2 = {}; int[] expectedArray2 = {};
        int[] inputArray3 = {12,16,7,14,4,18,2,16,2,10}; int[] expectedArray3 = {2,2,4,7,10,12,14,16,16,18};

        assertArrayEquals(expectedArray1, SAObject.RadixSort(inputArray1));
        assertArrayEquals(expectedArray2, SAObject.RadixSort(inputArray2));
        assertArrayEquals(expectedArray3, SAObject.RadixSort(inputArray3));
    }
}
