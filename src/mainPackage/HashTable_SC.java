package mainPackage;

/** A HashTable implementation that uses seperate chaining for collision resolution.
 * This version can hold an unlimited number of elements (with respect to the available memory).
 */
public class HashTable_SC implements HashTable {
    CircularLinkedList[] table;

    public HashTable_SC (int maxTableSize) {
        table = (maxTableSize > 0) ? new CircularLinkedList[maxTableSize] : new CircularLinkedList[10];
    }

    /** Adds an element to the HashTable.
     * @param value - The integer to be added.
     * @return Returns the element's new sub-list index within the table.
     */
    public Integer Add (int value) {
        if (table[value % table.length] == null) {
            table[value % table.length] = new CircularLinkedList();
        }
        table[value % table.length].Add(value);
        return table[value % table.length].Length() - 1;
    }

    public Integer GetIndex (int value) {
        return table[value % table.length].GetPositionOf(value);
    }

    public Integer Remove (int value) {
        return table[value % table.length].Remove(value);
    }

    public void Print () {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                System.out.println(i + " - Null");
            } else {
                System.out.print(i + " - ");
                table[i].Print();
            }
        }
    }
}