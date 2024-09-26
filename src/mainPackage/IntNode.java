package mainPackage;

public class IntNode {
    /**
     * Differences between this class (IntNode) and NumNode:
     * - The value of the 'pointer' attribute is now an IntNode object, rather than a primitive integer. 
     * - The 'value' and 'pointer' attributes are no longer private, so they can be invoked directly.
     * - The 'print' attribute has been removed.
     * - Method overloading has been used for the class constructor.
     * - The getter methods have been removed due to being redundant.
     */

    int value;
    IntNode pointer;

    public IntNode() { }

    public IntNode(int value) {
        this.value = value;
    }

    public IntNode(int value, IntNode pointer) {
        this.value = value;
        this.pointer = pointer;
    }

    public void SetValue(int value) {
        this.value = value;
    }

    public void SetPointer(IntNode pointer) {
        this.pointer = pointer;
    }

    /**
     * Deletes a chain of nodes.
     * The 'chain' is a collection of nodes that can be reached by recursively following previous nodes' pointers.
     * @param startNode - Defines the first node in the chain.
     * @param headNode - The node pointing to this one will be the last node in the chain
     */
    public static void deleteNodeChain(IntNode startNode, IntNode headNode) {
        if (startNode.pointer != null && startNode.pointer != headNode) { //These conditions prevent infinite recursion.
            deleteNodeChain(startNode.pointer, headNode);
        }
        startNode = null;
    }
}
