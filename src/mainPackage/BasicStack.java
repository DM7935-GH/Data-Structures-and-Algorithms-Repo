package mainPackage;

/** The class for a basic stack */
public class BasicStack {
    private int[] array;
    private int max_size;
    private int size = 0;
    private String name = "";
    private boolean printMessages = false;

    /**
     * Creates a basic stack object with no given name.
     * @param max_size - The maximum number of items this stack will allow.
     */
    public BasicStack(int max_size) {
        if (max_size <= 0) {
            this.max_size = 20;
        } else {
            this.max_size = max_size;
        }
        this.array = new int[this.max_size];
    }

    /**
     * Creates a basic stack object.
     * @param max_size - The maximum number of items this stack will allow.
     * @param name - The name that this stack will be referred to by.
     */
    public BasicStack(int max_size, String name) {
        if (max_size <= 0) {
            this.max_size = 20;
        } else {
            this.max_size = max_size;
        }
        this.array = new int[this.max_size];
        this.name = name;
    }

    /**
     * Creates a basic stack object.
     * @param max_size - The maximum number of items this stack will allow. 
     * @param name - The name that this stack will be referred to by.
     * @param printMessages - Determines whether debug messages will be printed to the console.
     * Does not affect the Print() method.
     */
    public BasicStack(int max_size, String name, boolean printMessages) {
        if (max_size <= 0) {
            this.max_size = 20;
            if (printMessages) {
                System.err.println("Number given for basic list maximum size is invalid - 20 has been used.");
            }
        } else {
            this.max_size = max_size;
        }
        this.array = new int[this.max_size];
        this.name = name;
        this.printMessages = printMessages;
    }

    /**
     * Checks whether the stack is empty.
     * @return True if there are no items in the stack, false if otherwise.
     */
    public boolean IsEmpty() {
        if (size == 0) {
            if (printMessages) { System.out.println("Stack " + name + " is empty."); }
            return true;
        } else {
            if (printMessages) { System.out.println("Stack " + name + " is not empty."); }
            return false;
        }
    }

    /**
     * Checks whether the stack is full.
     * @return True if the number of items in the stack is equal to its max size, false if otherwise.
     */
    public boolean IsFull() {
        if (size == max_size) {
            if (printMessages) { System.out.println("Stack " + name + " is full."); }
            return true;
        } else {
            if (printMessages) { System.out.println("Stack " + name + " is not full."); }
            return false;
        }
    }

    /**
     * Adds an item to the top of the stack.
     * @param value - The integer value to be added.
     */
    public void Push(int value) {
        if (size == max_size) {
            if (printMessages) { System.out.println("Stack " + name + " is full."); }
        } else {
            array[size++] = value;
        }
    }

    /**
     * Removes and returns the item at the top of the stack.
     * @return The integer value of the item, or false if the stack is empty.
     */
    public Integer Pop() {
        if (size == 0) {
            if (printMessages) { System.out.println("Stack " + name + " is empty."); }
            return null;
        } else {
            size--;
            return array[size];
            // The old value is not explicitly removed, instead it is overwritten later.
        }
    }

    /**
     * Returns the item at the top of the stack without removing it.
     * @return The integer value of the item, or false if the stack is empty.
     */
    public Integer Peek() {
        if (size == 0) {
            if (printMessages) { System.out.println("Stack " + name + " is empty."); }
            return null;
        } else {
            return array[size-1];
        }
    }

    /**
     * Returns the number of items currently on the stack.
     */
    public Integer Size() {
        return size;
    }

    /**
     * Removes all items from the stack.
     * This is done logically, not by manually clearing the underlying array.
     */
    public void Clear() {
        size = 0;
        // Again, none of the old values are explicitly removed, instead they are overwritten later
    }
}
