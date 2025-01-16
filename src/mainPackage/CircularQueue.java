package mainPackage;

public class CircularQueue {
    private int[] array;
    private int max_size;
    private int front = 0;
    private int size = 0;
    private String name = "";
    private boolean printMessages = false;

    public CircularQueue(int max_size) {
        if (max_size <= 0) {
            this.max_size = 20;
        } else {
            this.max_size = max_size;
        }
        this.array = new int[this.max_size];
    }

    public CircularQueue(int max_size, String name) {
        if (max_size <= 0) {
            this.max_size = 20;
        } else {
            this.max_size = max_size;
        }
        this.array = new int[this.max_size];
        this.name = name;
    }

    public CircularQueue(int max_size, String name, boolean printMessages) {
        if (max_size <= 0) {
            this.max_size = 20;
            if (printMessages) {
                System.err.println("Number given for circular queue maximum size is invalid - 20 has been used.");
            }
        } else {
            this.max_size = max_size;
        }
        this.array = new int[this.max_size];
        this.name = name;
        this.printMessages = printMessages;
    }

    public boolean IsEmpty() {
        if (size == 0) {
            if (printMessages) { System.out.println("Queue " + name + " is empty."); }
            return true;
        } else {
            if (printMessages) { System.out.println("Queue " + name + " is not empty."); }
            return false;
        }
    }

    public boolean IsFull() {
        if (size == max_size) {
            if (printMessages) { System.out.println("Queue " + name + " is full."); }
            return true;
        } else {
            if (printMessages) { System.out.println("Queue " + name + " is not full."); }
            return false;
        }
    }

    public void Enqueue(int value) {
        if (size == max_size) {
            if (printMessages) { System.err.println("Queue " + name + " is full."); }
        } else {
            array[(front + size) % max_size] = value;
            size++;
        }
    }

    public Integer Dequeue() {
        if (size == 0) {
            if (printMessages) { System.err.println("Queue " + name + " is empty."); }
            return null;
        } else {
            int value = array[front];
            size--;
            front = (front + 1) % max_size;
            return value;
        }
    }

    public Integer Front() {
        if (size == 0) {
            if (printMessages) { System.err.println("Queue " + name + " is empty."); }
            return null;
        } else {
            return array[front];
        }
    }

    public Integer Size() {
        return size;
    }

    public void Clear() {
        size = 0;
    }
}
