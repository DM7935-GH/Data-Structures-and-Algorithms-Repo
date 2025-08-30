package mainPackage;

import java.util.ArrayList;

/** The ADT class for a regular tree.
 * Each object serves as both a standalone tree node and the root of its own tree.
 * Any code using this class should have a reference to the designated root of the tree they want to work with.
 */
public class Tree <T extends Object> {
    private T value;
    private ArrayList <Tree<T>> children;
    private Tree<T> parent; //Not sure if keeping this is necessary

    Tree () {}
    Tree (T value) {
        this.value = value;
    }

    public T GetValue () { return value; }

    public ArrayList <Tree<T>> GetChildren () { return children; }

    public Tree<T> GetChild (int index) { return children.get(index);  }

    public Tree<T> GetParent () { return parent; }

    public int Size () {
        int size = 1;
        for (Tree<T> child : children) {
            size += child.Size();
        }
        return size;
    }

    public int Height () {
        // Remember: if there is one node, then the height of the tree is zero, not one.
        int subtreeHeight = -1;
        for (Tree<T> child : children) {
            if (child.Height() > subtreeHeight) { subtreeHeight = child.Height(); }
        }
        return subtreeHeight + 1;
    }

    public boolean IsLeaf () {
        return children.size() == 0;
    }

    public String toString () {
        if (IsLeaf() == true) {
            return value.toString();
        } else {
            String string = value.toString() + " : { ";
            for (int i = 0; i < children.size(); i++) {
                if (i == children.size() - 1) {
                    string += children.get(i).toString() + " }";
                } else {
                    string += children.get(i).toString() + " , ";
                }
            }
            return string;
        }
    }

    public void AddChild (Tree<T> child) {
        if (children == null) { children = new ArrayList<Tree<T>>(); }
        children.add(child);
        child.parent = this;
    }

    public void RemoveChild (Tree<T> child) {
        if (children.contains(child)) {
            children.remove(child);
            child.parent = null;
            if (children.size() == 0) { children = null; }
        }
    }

    public void SwapNodes (Tree<T> node1, Tree<T> node2) {
        T temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }
}
