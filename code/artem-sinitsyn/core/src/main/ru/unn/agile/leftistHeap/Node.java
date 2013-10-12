package ru.unn.agile.leftistHeap;

public class Node {
    private Pair data;
    private int rank;
    private Node leftChild;
    private Node rightChild;
    private Node parent;

    public Pair getData() {
        return data;
    }

    public void setData(Pair data) {
        this.data = data;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        if (rank > 0)
            this.rank = rank;
        else
            throw new IllegalArgumentException("Node's rank should be positive");
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node() {
        setData(new Pair());
        setRank(1);
        setLeftChild(null);
        setRightChild(null);
        setParent(null);
    }

    public Node(Pair data, int rank, Node leftChild, Node rightChild, Node parent) {
        setData(data);
        setRank(rank);
        setLeftChild(leftChild);
        setRightChild(rightChild);
        setParent(parent);
    }
}
