package mainPackage;

/** 
 * The class for a circular linked list.
 * While functionally very similar  to the LinkedList class, the backend implementation is considerably more efficient.
 * There is also no need to define the maximum size of the list.
 */
public class CircularLinkedList{
    private IntNode head;
    private String name;
    private boolean printMessages;

    /**
     * Creates a circular linked list object with no given name.
     */
    public CircularLinkedList() {
        this.head = null;
        this.name = "";
        this.printMessages = false;
    }

    /**
     * Creates a circular linked list object.
     * @param name - The name that this list will be referred to by.
     */
    public CircularLinkedList(String name) {
        this.head = null;
        this.name = name;
        this.printMessages = false;
    }

    /**
     * Creates a circular linked list object.
     * @param name - The name that this list will be referred to by.
     * @param printMessages - Determines whether debug messages will be printed to the console.
     * Does not affect the Print() method.
     */
    public CircularLinkedList(String name, boolean printMessages) {
        this.head = null;
        this.name = name;
        this.printMessages = printMessages;
    }

    /**
     * Checks whether the list is empty.
     * @return True if there are no nodes in the list, false if otherwise.
     */
    public boolean IsEmpty() {
        if (head == null) {
            if (printMessages) { System.out.println("List " + name + " is empty."); }
            return true;
        } else {
            if (printMessages) { System.out.println("List " + name + " is not empty."); }
            return false;
        }
    }

    /** 
     * Gets the length/size of the list
     * @return An integer equal to the number of nodes currently in the list.
     */
    public Integer Length() {
        int length = 0;
        if (head != null) {
            IntNode node = head;
            length++;
            while (node.pointer != head) {
                node = node.pointer;
                length++;
            }
        }
        return length;
    }

    /**
     * Gets the last node in the list.
     * @return The last node in the list, or null if the list is empty.
     */
    private IntNode GetLastNode() {
        if (head == null) {
            return null;
        } else {
            IntNode node = head;
            while (node.pointer != head) {
                node = node.pointer;
            }
            return node;
        }
    }

    /**
     * Adds a new node to the end of the list.
     * @param value - The integer value of the new node.
     */
    public void Add(int value) {
        if (head == null) { //If the list is empty
            head = new IntNode(value);
            head.SetPointer(head);
        } else { //If the list is not empty
            IntNode newNode = new IntNode(value, head);
            GetLastNode().SetPointer(newNode);
        }
    }

    /**
     * Inserts a new node into the list.
     * @param pos - The position in the list that the node will be placed at. Uses zero-based positioning.
     * @param value - The integer value of the new node.
     */
    public void Insert(int pos, int value) {
        if (head == null) { //If the list is empty
            if (pos == 0) {
                head = new IntNode(value);
                head.SetPointer(head);
            } else {
                if (printMessages) { System.err.println("Invalid insertion position for list " + name + " - must be 0 if list is empty."); }
            }    
        } else { //If the list is not empty
            if (pos == 0) {
                IntNode newNode = new IntNode(value, head);
                GetLastNode().SetPointer(newNode);
                head = newNode;
            } else {
                IntNode node = head;
                boolean valid = (pos > 0); //Will have a value of true if pos is greater than 0, and a value of false if otherwise.

                for (int tempPos = 1 ; tempPos < pos ; tempPos++) {
                    if (node.pointer == head) {
                        valid = false;
                        break;
                    } else {
                        node = node.pointer;
                    }
                }

                if (valid) {
                    IntNode newNode = new IntNode(value, node.pointer);
                    node.SetPointer(newNode);
                } else {
                    if (printMessages) { System.err.println("Invalid insertion position for list " + name + " - must be between 0 and " + Length() + "."); }
                }
            }
        }
    }

    /**
     * Gets the value of the node at the given position in the list.
     * @param pos - The position of the node. Uses zero-based positioning.
     * @return The integer value of the node, or null if the given position is invalid.
     */
    public Integer Get(int pos) {
        Integer theInt = null;
        if (head == null) { //If the list is empty
            if (printMessages) { System.err.println("List " + name + " is empty."); }
        } else if (pos < 0) { //If the given position is invalid (less than zero)
            if (printMessages) { System.err.println("Invalid position for list " + name + " - must be at least 0."); }
        } else {
            IntNode node = head;
            for (int i = 0; i < pos; i++) {
                if (node.pointer == head) { //This condition will eventually be true if the given position is invalid (too large)
                    if (printMessages) { System.err.println("Invalid position for list " + name + " - must be at most " + i + "."); }
                    node = null;
                    break;
                } else {
                    node = node.pointer;
                }
            }
            if (node != null) {
                theInt = node.value;
            }
        }
        return theInt;
    }

    /**
     * Gets the position of the first node in the list with the given value.
     * @param value - The value of the node whose position is to be returned.
     * @return The integer position of the node, or null if no node in the list has the given value.
     */
    public Integer GetPositionOf(int value) {
        Integer location = null;
        if (head == null) { //If the list is empty
            if (printMessages) { System.err.println("List " + name + " is empty."); }
        } else {
            if (head.pointer == head) { //If there is only one node in the list
                location = (value == head.value) ? 0 : null;
            } else { //If there is more than one node in the list
                IntNode node = head;
                int pos = 0;
                while (true) {
                    if (value == node.value) { //A node with the given value was found
                        location = pos; break;
                    } else if (node.pointer == head) { //No node with the given value was found
                        break;
                    } else {
                        node = node.pointer;
                        pos++; 
                    }
                }
            } 
        }
        return location;
    }

    /**
     * Removes and returns the value of the node at the given position in the list.
     * @param pos - The position of the node. Uses zero-based positioning.
     * @return The integer value of the node removed from the list, or null if the given position is invalid.
     */
    public Integer Pop(int pos) {
        Integer theInt = null;
        if (head == null) { //If the list is empty
            if (printMessages) { System.err.println("List " + name + " is empty."); }
        } else if (pos < 0) { //If the given position is invalid (less than zero)
            if (printMessages) { System.err.println("Invalid position for list " + name + " - must be at least 0."); }
        } else {
            IntNode node = head;
            IntNode prevNode = node;
            for (int i = 0; i < pos; i++) {
                if (node.pointer == head) { //This condition will eventually be true if the given position is invalid (too large)
                    if (printMessages) { System.err.println("Invalid position for list " + name + " - must be at most " + i + "."); }
                    node = null;
                    break;
                } else {
                    prevNode = node;
                    node = node.pointer; //prevNode should be the node pointing to node
                }
            }
            if (node != null) {
                //Nodes are removed by removing/reassigning all references to them.
                theInt = node.value;
                if (pos == 0) {
                    if (node.pointer == node) { //Remove the lastremaining node in the list
                        head = null;
                    } else { //Remove the first node
                        GetLastNode().pointer = node.pointer;
                        head = node.pointer;
                    }
                } else { //Remove a node that isn't the first
                    prevNode.pointer = node.pointer;
                }
            }
        }
        return theInt;
    }

    /**
     * Removes and returns the position of the first node in the list with the given value.
     * @param value - The value of the node to be removed.
     * @return The integer position of the node, or null if no node in the list has the given value.
     */
    public Integer Remove(int value) {
        Integer location = null;
        if (head == null) {
            if (printMessages) { System.err.println("List " + name + " is empty."); }
        } else {
            if (head.pointer == head) {
                if (value == head.value) {
                    location = 0;
                    head = null;
                } else {
                    location = null;
                }
            } else {
                IntNode node = head;
                IntNode prevNode = GetLastNode();
                int pos = 0;
                while (true) {
                    if (value == node.value) {
                        location = pos;
                        prevNode.pointer = node.pointer;
                        if (pos == 0) { head = node.pointer; }
                        break;
                    } else if (node.pointer == head) {
                        break;
                    } else {
                        prevNode = node;
                        node = node.pointer;
                        pos++; 
                    }
                }
            } 
        }
        return location;
    }

    /**
     * Removes all the nodes in the list with the given value.
     * @param value - The value of the nodes to be removed.
     */
    public void RemoveAll(int value) {
        if (head == null) {
            if (printMessages) { System.err.println("List " + name + " is empty."); }
        } else {
            Integer check = 0;
            while (check != null) {
                check = Remove(value);
            }
        }
    }

    /**
     * Swaps around the values of the two nodes at the given positions in the list.
     * For efficiency, the positions of the nodes themselves are not altered, only their values.
     * @param pos1 - The position of the first node to be swapped.
     * @param pos2 - The position of the second node to be swapped.
     */
    public void Swap(int pos1, int pos2) {
        if (head == null) {
            if (printMessages) { System.err.println("List " + name + " is empty."); }
        } else if (pos1 < 0 || pos2 < 0) {
            if (printMessages) { System.err.println("Invalid position for list " + name + " - must be at least 0."); }
        } else {
            IntNode node1 = head;
            IntNode node2 = head;
            for (int i = 0; i < Math.max(pos1, pos2); i++) {
                if (node1.pointer == head || node2.pointer == head) {
                    if (printMessages) { System.err.println("Invalid position for list " + name + " - must be at most " + i + "."); }
                    node1 = null; node2 = null;
                    break;
                } else {
                    //At least one of the following if statements should be true
                    if (i < pos1) { node1 = node1.pointer; }
                    if (i < pos2) { node2 = node2.pointer; }
                }
                
            }
            if (node1 != null) {
                //Swaps the nodes' values rather than their list positions
                int temp = node1.value;
                node1.SetValue(node2.value);
                node2.SetValue(temp);
            }
        }
    }

    /**
     * Removes all existing nodes from the list.
     * Does not delete the list itself.
     */
    public void Clear() {
        // IntNode.deleteNodeChain(head, head);
        //The Java garbage collector makes manually de-referencing each node redundant, hence why the above line goes unused
        head = null;
    }

    /**
     * Prints the value of each node in the circular linked list to the console.
     * Ignores the value of the list's printMessages attribute.
     */
    public void Print() {
        System.out.print("Linked list " + name + " : [ ");
        if (head != null) {
            IntNode node = head;
            System.out.print(node.value);
            if (node.pointer != head) { System.out.print(" , "); }
            while (node.pointer != head) {
                node = node.pointer;
                System.out.print(node.value);
                if (node.pointer != head) { System.out.print(" , "); }
            }
        }
        System.out.println(" ]");
    }
}
