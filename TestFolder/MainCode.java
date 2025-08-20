import java.text.NumberFormat.Style;

import mainPackage.*;

public class MainCode {
    public static void main(String[] args) throws Exception {
        System.out.println("\n=== Basic List Test ===");
        BasicListTest();
        System.out.println("\n=== Linked List Test ===");
        LinkedListTest();
        System.out.println("\n=== Country Linked List Test ===");
        CountryListTest();
        System.out.println("\n=== Hash Table Test ===");
        HashTableTest();
    }

    public static void BasicListTest() {
        BasicList bList1 = new BasicList(5, "List 1", true);
        bList1.IsEmpty();
        bList1.Print();
        bList1.Add(5); bList1.Add(7); bList1.Add(3); bList1.Add(11); bList1.Add(11);
        bList1.Print();
        System.out.println("Length: " + bList1.Length());
        bList1.Add(5);
        System.out.println("Item at index -2: " + bList1.Get(-2));
        System.out.println("Item at index 4: " + bList1.Get(4));
        System.out.println("Index of the item 3: " + bList1.GetIndexOf(3));
        System.out.println("Index of the item 45: " + bList1.GetIndexOf(45));
        bList1.Remove(7);
        bList1.Insert(1, 11);
        bList1.Print();
        bList1.RemoveAll(11);
        bList1.Add(20);
        bList1.Add(10);
        bList1.Print();
        bList1.Swap(0, 1);
        bList1.Print();
        bList1.Clear();
        System.out.println("Length: " + bList1.Length());
        System.out.println("Popped item at index 0: " + bList1.Pop(0));
    }

    public static void LinkedListTest() {
        LinkedList LList1 = new LinkedList(6, "List 2", true);
        LList1.IsEmpty();
        LList1.Print();
        System.out.println("Length: " + LList1.Length());
        LList1.Add(2); LList1.Add(4); LList1.Add(6);
        LList1.Add(8); LList1.Add(10); LList1.Add(12);
        LList1.Print();
        System.out.println("Length: " + LList1.Length());
        LList1.Add(14);
        System.out.println("Item at position -2: " + LList1.Get(-2));
        System.out.println("Item at position 0: " + LList1.Get(0));
        System.out.println("Item at position 5: " + LList1.Get(5));
        System.out.println("Item at position 6: " + LList1.Get(6));
        System.out.println("Position of the item 14: " + LList1.GetPositionOf(14));
        System.out.println("Position of the item 10: " + LList1.GetPositionOf(10));
        LList1.Remove(10);
        LList1.Print();
        LList1.Pop(1);
        LList1.Insert(1, 14);
        LList1.Print();
        LList1.Insert(4, 14);
        LList1.Get(-2);
        LList1.RemoveAll(14);
        LList1.Print();
        LList1.Swap(1, 3);
        LList1.Print();
        LList1.Swap(-1, 5);
        System.out.println("Length: " + LList1.Length());
        LList1.Clear();
        LList1.Add(33);
        LList1.Pop(0); LList1.Pop(0);
        System.out.println("Length: " + LList1.Length());
    }

    public static void circularListTest() {
        CircularLinkedList CLL1 = new CircularLinkedList("List 2", true);
        CLL1.IsEmpty();
        CLL1.Print();
    }

    public static void CountryListTest() {
        CountryLinkedList CLL1; CLL1 = new CountryLinkedList("Country List", true);
        CLL1.IsEmpty();
        CLL1.Length();
        CLL1.Add("Japan", 125, 340);
        CLL1.Add("UK", 71, 280);
        CLL1.Add("Nepal");
        CLL1.Print(true, false, "alpha");
        CLL1.Add("Russia", 143, 17100);
        CLL1.Add("Nigeria", 240, 900);
        CLL1.Print(false, true, "area");
        CLL1.Remove("Nepal");
        CLL1.Remove("Japan");
        CLL1.Remove(null);
        System.out.println("----\n \n");
        CLL1.Print();
    }

    public static void HashTableTest() {
        HashTable HT1; HT1 = new HashTable_OA(17);
        HashTable HT2; HT2 = new HashTable_SC(0);

        HT1.Print();
        HT1.Add(0); HT1.Add(10); HT1.Add(16); HT1.Add(17); HT1.Add(25);
        System.out.println("Output of adding 101: " + HT1.Add(101));
        HT1.Print();
        System.out.println("Index of 101: " + HT1.GetIndex(101));
        HT1.Remove(0); HT1.Remove(10);
        HT1.Print();
        System.out.println("Output of removing 13: " + HT1.Remove(13) + "\n");

        HT2.Print();
        HT2.Add(0); HT2.Add(45); HT2.Add(50); HT2.Add(77); HT2.Add(555); HT2.Add(45);
        HT2.Print();
        System.out.println("Sub-list index of 45: " + HT2.GetIndex(45));
        HT2.Remove(50); HT2.Remove(555);
        HT2.Print();
        System.out.println("Output of removing 50 (again): " + HT2.Remove(50));
    }
}
