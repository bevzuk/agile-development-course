package ru.unn.agile.leftistHeap;

public class LeftistHeap {
    private Node root;
    private int count;

    public boolean isEmpty() {
        if (root == null)
            return true;
        else
            return false;
    }

    public int getCount() {
        return count;
    }

    private void setCount(int value) {
        this.count = value;
    }

    public LeftistHeap(){
        root = null;
        setCount(0);
    }

    public LeftistHeap(Pair data) {
        root = new Node();
        root.setData(data);
        setCount(1);
    }
}
