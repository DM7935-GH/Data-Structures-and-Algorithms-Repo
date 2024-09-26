package mainPackage;

/** The class for a basic list. */
@SuppressWarnings("null")
public class BasicList {
    private int[] array;
    private int max_size;
    private int size;
    private String name;
    private boolean printMessages;

    public BasicList(int max_size, String name, boolean printMessages) {
        if (max_size <= 0) {
            this.max_size = 20;
            if (printMessages) {
                System.err.println("Number given for basic list maximum size is invalid - 20 has been used.");
            }
        } else {
            this.max_size = max_size;
        }
        this.array = new int[this.max_size];
        this.size = 0;
        this.name = name;
        this.printMessages = printMessages;
    }

    public boolean IsEmpty() {
        if (size == 0) {
            if (printMessages) { System.out.println("Basic list " + name + " is empty."); }
            return true;
        } else {
            if (printMessages) { System.out.println("Basic list " + name + " is not empty."); }
            return false;
        }
    }

    public boolean IsEmpty(boolean internal) {
        //Overloaded method that ensures messages are not printed unnecessarily.
        if (size == 0) {
            if (printMessages) { System.out.println("Basic list " + name + " is empty."); }
            return true;
        } else { return false; }
    }

    public boolean IsFull() {
        if (size == max_size) {
            if (printMessages) { System.out.println("Basic list " + name + " is full."); }
            return true;
        } else {
            if (printMessages) { System.out.println("Basic list " + name + " is not full."); }
            return false;
        }
    }

    public boolean IsFull(boolean internal) {
        //Overloaded method that ensures messages are not printed unnecessarily.
        if (size == max_size) { 
            if (printMessages) { System.out.println("Basic list " + name + " is full."); }
            return true;
        } else { return false; }
    }

    public void Add(int value) {
        if (IsFull(true) == false) {
            array[size++] = value;
        }
    }

    public void Insert(int index, int value) {
        //Insert the given value into the list at the given position
        if (IsFull(true) == false) {
            if (index <= size && index >= 0) {
                for (int i = size - 1; i >= index; i--) {
                    array[i+1] = array[i];
                }
                array[index] = value;
                size++;
            } else {
                if (printMessages) { System.err.println("Invalid insertion index for basic list " + name + "."); }
            }
        }
    }

    public Integer Get(int index) {
        //Return the value of the item with the given index
        if (index < size && index >= 0) {
            return array[index];
        } else {
            if (printMessages) { System.err.println("Invalid index for basic list " + name + "."); }
            return (Integer) null;
        }
    }

    public Integer GetIndexOf(int value) {
        //Return the index of the first item with the given value
        Integer location = null;
        if (IsEmpty(true) == false) {
            for (int i = 0; i < size; i++) {
                if (array[i]== value) {
                    location = i;
                }
            }
        }
        return location;
    }

    public Integer Pop(int index) {
        //Remove the item with the given index, return its value
        if (index < size && index >= 0) {
            int value = array[index];
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i+1];
            }
            array[size-1] = 0;
            size--;
            return value;
        } else {
            if (printMessages) { System.err.println("Invalid index for basic list " + name + "."); }
        }
        return null;
    }

    public Integer Remove(int value) {
        //Remove the first item with the given value, return its index
        if (IsEmpty(true) == false) {
            for (int i = 0; i < size; i++) {
                if (array[i] == value) {
                    for (int j = i; j < size - 1; j++) {
                        array[j] = array[j+1];
                    }
                    array[size-1] = 0;
                    size--;
                    return i;
                }
            }
        }
        return null;
    }

    public void RemoveAll(int value) {
        //Remove all items with the given value
        if (IsEmpty(true) == false) {
            Integer check = 0;
            while (check != null) {
                check = Remove(value);
            }
        }
    }

    public void Swap(int index1, int index2) {
        if (IsEmpty(true) == false && index1 < size && index1 >= 0 && index2 < size && index2 >= 0) {
            int temp = array[index2];
            array[index2] = array[index1];
            array[index1] = temp;
        } else {
            if (printMessages) { System.err.println("One or more invalid indexes for basic list " + name + "."); }
        }
    }

    public void Clear() {
        array = new int[this.max_size];
        size = 0;
    }

    public Integer Length() {
        return size;
    }

    public void Print() {
        //Print all items in the list
        System.out.print("Basic list " + name + " : [ ");
        for(int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i != size - 1) {
                System.out.print(" , ");
            }
        }
        System.out.println(" ]");
    }
}
