package mainPackage;

/** The class for a singly linked list. */
public class LinkedList {
    private NumNode[] array;
    private int max_size;
    private int head; //Index of the first node in the list, or -1 if the list is empty
    private BasicList freeSpaces; //Indexes of the underlying array that are not currently occupied by list nodes.
    //Current size of the linked list = max_size - freeSpaces.Length()
    private String name;
    private boolean printMessages;


    /**
     * Creates a linked list object.
     * @param max_size - The maximum number of nodes (items) this linked list will allow.
     * @param name - The name that this linked list will be referred to by.
     * @param printMessages - Determines whether debug messages will be printed to the console.
     * This does not affect the Print() method. 
     */
    public LinkedList (int max_size, String name, boolean printMessages) {
        if (max_size <= 0) {
            this.max_size = 20;
            if (printMessages) {
                System.err.println("Number given for basic list maximum size is invalid - 20 has been used.");
            }
        } else {
            this.max_size = max_size;
        }
        this.array = new NumNode[this.max_size];
        this.head = -1;
        this.freeSpaces = new BasicList(this.max_size, "LinkedList", false);
        for (int i = 0; i < this.max_size; i++) { this.freeSpaces.Add(i); } //Will contain numbers 0 to (max_size - 1)
        this.name = name;
        this.printMessages = printMessages;
    }

    /**
     * Checks whether the linked list is empty.
     * @return True if there are no nodes in the list, false if otherwise.
     */
    public boolean IsEmpty() {
        if (head == -1) {
            if (printMessages) { System.out.println("Linked list " + name + " is empty."); }
            return true;
        } else {
            if (printMessages) { System.out.println("Linked list " + name + " is not empty."); }
            return false;
        }
    }

    /**
     * Same as the public IsEmpty() method, but this one will not print anything if the list isn't empty.
     * Useful for when this method is called directly by another within this class.
     */
    private boolean IsEmpty(boolean internal) {
        if (head == -1) { return true; } else { return false; }
    }

    /**
     * Checks whether the linked list is full.
     * @return True if the number of nodes in the list is equal to its max size, false if otherwise.
     */
    public boolean IsFull() {
        if (freeSpaces.Length() == 0) {
            if (printMessages) { System.out.println("Linked list " + name + " is full."); }
            return true;
        } else {
            if (printMessages) { System.out.println("Linked list " + name + " is not full."); }
            return false;
        }
    }

    /**
     * Same as the public IsFull() method, but this one will not print anything if the list isn't full.
     * Useful for when this method is called directly by another within this class.
     */
    private boolean IsFull(boolean internal) {
        if (freeSpaces.Length() == 0) { return true; } else { return false; }
    }

    /** 
     * Gets the length/size of the linked list
     * @return An integer equal to the number of nodes currently in the list.
     */
    public Integer Length() {
        return max_size - freeSpaces.Length();
    }

    /**
     * Gets the underlying array index (not list position) of the last node within the linked list.
     * @return An integer corresponding to the array index of the last node, or null if the list is empty.
     */
    private Integer TailIndex() {
        if (IsEmpty(true) == false) {
            int tailIndex = head;
            while (array[tailIndex].Pointer() != -1) {
                tailIndex = array[tailIndex].Pointer();
            }
            return tailIndex;
        } else {
            return (Integer) null;
        }
    }

    /**
     * Adds an integer (represented as a node) to the end of the linked list.
     * @param value - The integer to be added to the list.
     */
    public void Add(int value) {
        if (IsFull(true) == false) {
            int nodeIndex = freeSpaces.Pop(0); //Gets the index this node will be placed in (the number at the front of freeSpaces)
            NumNode node = new NumNode(value, -1, printMessages);

            if (head == -1) { //If the linked list is empty
                head = nodeIndex;
            } else { //If the linked list is not empty
                array[TailIndex()].SetPointer(nodeIndex);
            }
            array[nodeIndex] = node;
        }
    }

    /** Inserts an integer (represented as a node) into the linked list at a specific position.
     * @param pos - The position the node will be added at. 
     * Uses zero-based positioning (where position 0 is the first node in the list).
     * For a list with x existing nodes, the value of this parameter can be between 0 and x (inclusive).
     * @param value - The integer to be added to the list.
    */
    public void Insert(int pos, int value) {
        if (IsFull(true) == false) {
            if (pos <= Length() && pos >= 0) {
                int nodeIndex = freeSpaces.Pop(0);

                if (pos == 0) { //Insert as the first node in the linked list
                    if (head == -1) { 
                        array[nodeIndex] = new NumNode(value, -1, printMessages);
                    } else { 
                        array[nodeIndex] = new NumNode(value, head, printMessages); 
                    }
                    head = nodeIndex;

                } else if (pos == Length()) { //Insert as the last node in the linked list
                    array[TailIndex()].SetPointer(nodeIndex);
                    array[nodeIndex] = new NumNode(value, -1, printMessages);
                    
                } else { //Insert as neither the first nor the last node
                    int posIndex = head; //The index of the node that will point to the one being inserted
                    for (int i = 1; i < pos; i++) {
                        posIndex = array[posIndex].Pointer();
                    }
                    int posPointer = array[posIndex].Pointer();
                    array[posIndex].SetPointer(nodeIndex);
                    array[nodeIndex] = new NumNode(value, posPointer, printMessages);
                }
                
            } else {
                if (printMessages) { System.err.println("Invalid insertion position for linked list " + name + " - must be between 0 and " + Length() + "."); }
            }
        }
    }

    /**
     * Gets the value of the node at the specified position in the linked list.
     * @param pos - The position of the node. 
     * Uses zero-based positioning (where position 0 is the first node in the list).
     * @return The node's value as an integer, or null if the pos parameter is invalid.
     */
    public Integer Get(int pos) {
        //Return the value of the node at the given position within the linked list
        if (IsEmpty(true) == false) {
            if (pos < Length() && pos >= 0) {
                int posIndex = head;
                for (int i = 0; i < pos; i++) {
                    posIndex = array[posIndex].Pointer();
                }
                return array[posIndex].Value();
            } else {
                if (printMessages) { System.err.println("Invalid position for linked list " + name + " - must be between 0 and " + (Length() - 1) + "."); }
                return (Integer) null;
            }
        } else {
            return (Integer) null;
        }
    }

    /** 
     * Gets the position of the first node in the linked list with the given value.
     * @param value - The value of the node.
     * @return The node's position in the list as an integer, or null if no node with the given value could be found.
     */
    public Integer GetPositionOf(int value) {
        //Returns the position of the first node with the given value
        Integer location = null;
        if (IsEmpty(true) == false) {
            int posIndex = head;
            for (int i = 0; i < Length(); i++) {
                if (array[posIndex].Value() == value) {
                    location = i;
                    break;
                }
                posIndex = array[posIndex].Pointer();
            }
        }
        return location;
    }

    /**
     * Removes the node at the given position on the linked list.
     * @param pos - The position of the node. 
     * Uses zero-based positioning (where position 0 is the first node in the list).
     * @return The value of the node as an integer, or null if the pos parameter is invalid.
     */
    public Integer Pop(int pos) {
        if (IsEmpty(true) == false) {
            if (pos < Length() && pos >= 0) {
                int posIndex = head;
                for (int i = 0; i < pos; i++) {
                    posIndex = array[posIndex].Pointer();
                }
                
                if (pos == 0) { //If the first node is to be popped
                    if (Length() == 1) {
                        head = -1;
                    } else {
                        head = array[posIndex].Pointer();
                    }
                } else {
                    int prevIndex = head;
                    while (array[prevIndex].Pointer() != posIndex) {
                        prevIndex = array[prevIndex].Pointer();
                    }
                    
                    if (pos == Length() -1) { //If the last node is to be popped
                        array[prevIndex].SetPointer(-1);;
                    } else { //If the node to be popped is neither the first nor the last
                        array[prevIndex].SetPointer(array[posIndex].Pointer());
                    }
                }

                freeSpaces.Add(posIndex);
                return array[posIndex].Value();
            } else {
                if (printMessages) { System.err.println("Invalid position for linked list " + name + " - must be between 0 and " + (Length() - 1) + "."); }
                return (Integer) null;
            }
        } else {
            return (Integer) null;
        }
    }

    /**
     * Removes the first node with the given value in the linked list.
     * @param value - The value of the node to be removed.
     * @return The node's former position in the list as an integer, or null if no node with the given value could be found.
     */
    public Integer Remove(int value) {
        Integer location = null;
        if (IsEmpty(true) == false) {
            int posIndex = head;
            for (int i = 0; i < Length(); i++) {
                if (array[posIndex].Value() == value) {
                    location = i;

                    if (location == 0) { //If the first node is to be popped
                        if (Length() == 1) {
                            head = -1;
                        } else {
                            head = array[posIndex].Pointer();
                        }
                    } else {
                        int prevIndex = head;
                        while (array[prevIndex].Pointer() != posIndex) {
                            prevIndex = array[prevIndex].Pointer();
                        }
                        
                        if (location == Length() -1) { //If the last node is to be popped
                            array[prevIndex].SetPointer(-1);;
                        } else { //If the node to be popped is neither the first nor the last
                            array[prevIndex].SetPointer(array[posIndex].Pointer());
                        }
                    }

                    freeSpaces.Add(posIndex);
                    break;
                }
                posIndex = array[posIndex].Pointer();
            }
        }
        return location;
    }

    /**
     * Removes all nodes with the given value from the linked list.
     * @param value - The value of the node(s) to be removed.
     */
    public void RemoveAll(int value) {
        //Remove all nodes with the given value
        if (IsEmpty(true) == false) {
            Integer check = 0;
            while (check != null) {
                check = Remove(value);
            }
        }
    }

    /**
     * Swaps around the position of two nodes on the linked list.
     * @param pos1 - The position of the first node to be swapped.
     * Uses zero-based positioning (where position 0 is the first node in the list).
     * @param pos2 - The position of the second node to be swapped.
     */
    public void Swap (int pos1, int pos2) {
        if (IsEmpty(true) == false && pos1 >= 0 && pos2 >= 0 && pos1 < Length() && pos2 < Length()) {
            int pos1Index = head;
            for (int i = 0; i < pos1; i++) {
                pos1Index = array[pos1Index].Pointer();
            }
            int pos2Index = head;
            for (int i = 0; i < pos2; i++) {
                pos2Index = array[pos2Index].Pointer();
            }
            
            int temp = array[pos2Index].Value();
            array[pos2Index].SetValue(array[pos1Index].Value());
            array[pos1Index].SetValue(temp);
        }
    }

    /**
     * Removes all existing nodes from the linked list.
     * Does not delete the list itself.
     */
    public void Clear() {
        head = -1;
        array = new NumNode[max_size];
        freeSpaces = new BasicList(this.max_size, "LinkedList", false);
        for (int i = 0; i < this.max_size; i++) { this.freeSpaces.Add(i); }
    }

    /**
     * Prints the value of each node in the linked list to the console.
     * Ignores the value of the list's printMessages attribute.
     */
    public void Print() {
        System.out.print("Linked list " + name + " : [ ");
        if (head != -1) {
            int index = head;
            for (int i = 0; i < this.max_size; i++) {
                System.out.print(array[index].Value());
                if (array[index].Pointer() != -1) {
                    index = array[index].Pointer();
                    System.out.print(" , ");
                } else {
                    break;
                }
            }
        }
        System.out.println(" ]");
    }
}
