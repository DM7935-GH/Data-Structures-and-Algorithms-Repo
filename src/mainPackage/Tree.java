package mainPackage;

import java.util.ArrayList;

/** The ADT class for a regular tree.
 * Each object serves as both a standalone tree node and the root of its own tree.
 * Any code using this class should have a reference to the designated root of the tree they want to work with.
 */
public class Tree <T extends Object> {
    T value;
    ArrayList <Tree<T>> children;
    // Tree<T> parent; Not sure if kept this is necessary

    Tree () {}
    Tree (T value) {
        this.value = value;
    }

    public int Size () {
        int size = 1;
        for (Tree<T> child : children) {
            size += child.Size();
        }
        return size;
    }

    public int Height () {
        int subtreeHeight = 0;
        for (Tree<T> child : children) {
            if (child.Height() > subtreeHeight) { subtreeHeight = child.Height(); }
        }
        return subtreeHeight + 1;
    }

    public boolean IsLeaf () {
        return children.size() == 0;
    }

    public String toString() {
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
}
