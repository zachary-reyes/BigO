package BigO;

public class Node<T> {
    private int data;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
}

