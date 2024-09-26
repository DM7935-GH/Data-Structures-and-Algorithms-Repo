package mainPackage;

public class NumNode {
    private int value;
    private int pointer;
    private boolean print;

    public NumNode(int val, int point, boolean print) {
        this.value = val;
        this.print = print;
        if (point < -1) {
            if (print) { System.err.println("Index given for node pointer is invalid, -1 has been used to represent null."); }
            this.pointer = -1;
        } else {
            this.pointer = point;
        }
    }

    public int Value () {
        return value;
    }

    public int Pointer () {
        return pointer;
    }

    public void SetValue (int val) {
        this.value = val;
    }

    public void SetPointer (int point) {
        if (point < -1) {
            if (print) { System.out.println("Index given for node pointer is invalid, -1 has been used to represent null."); }
            this.pointer = -1;
        } else {
            this.pointer = point;
        }
    }
}
