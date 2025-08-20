package mainPackage;

/** A HashTable implementation that uses open addressing (specifically linear probing) for collision resolution.
 * This version can only hold a limited number of elements (as defined by the user).
 */
public class HashTable_OA implements HashTable {
    Integer[] table;

    public HashTable_OA (int maxTableSize) {
        table = (maxTableSize > 0) ? new Integer[maxTableSize] : new Integer[10];
    }

    /** Adds an element to the HashTable.
     * @param value - The integer to be added.
     * @return Returns null if the HashTable is full, otherwise returns the number of collisions that occurred.
     */
    public Integer Add (int value) {
        Integer collisions = 0;
        int index = value % table.length;

        while (table[index] != null) {
            collisions += 1;
            if (collisions == table.length) { return null; }

            index = (index == table.length - 1) ? 0 : index + 1;
        }

        table[index] = value;
        return collisions;
    }

    /** Gets the index of an element in the HashTable.
     * @param value - The integer to return the index of.
     * @return Returns null if the element is not present in the HashTable, otherwise returns the index of the element.
     * If there are multiple instances of the element, then the index of the first found instance will be returned.
     */
    public Integer GetIndex (int value) {
        Integer collisions = 0;
        int index = value % table.length;

        while (table[index] != value) {
            collisions += 1;
            if (collisions == table.length) { return null; }

            index = (index == table.length - 1) ? 0 : index + 1;
        }

        return index;
    }

    /** Removes an element from the HashTable
     * @param value - The integer to be removed.
     * @return Returns null if the element is not present in the HashTable, otherwise returns the number of collisions that occurred.
     * If there are multiple instances of the element, then only the first found instance will be removed.
     */
    public Integer Remove (int value) {
        Integer collisions = 0;
        int index = value % table.length;

        while (table[index] == null || table[index] != value) {
            collisions += 1;
            if (collisions == table.length) { return null; }

            index = (index == table.length - 1) ? 0 : index + 1;
        }

        table[index] = null;
        return collisions;
    }

    public void Print () {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                System.out.println(i + " - Null");
            } else {
                System.out.println(i + " - " + table[i]);
            }
        }
    }
}
