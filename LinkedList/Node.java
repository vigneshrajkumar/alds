package LinkedList;

public class Node {
    private int val;
    private Node next;

    public Node(int value, Node next) {
        this.setVal(value);
        this.setNext(next);
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}