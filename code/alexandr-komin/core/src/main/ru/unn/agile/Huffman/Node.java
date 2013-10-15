package ru.unn.agile.Huffman;


public class Node implements Comparable<Node>  {
    public  char symbol;
    public int freq;
    public Node leftChild, rightChild;

    Node(char symbol, int freq, Node leftChild, Node rightChild){
        if((leftChild==null&& rightChild != null)||(leftChild != null&& rightChild == null)){
            throw new RuntimeException("Node can't have one child");
        }
        this.symbol = symbol;
        this.freq=freq;
        this.leftChild =leftChild;
        this.rightChild = rightChild;
    }

    public boolean isLeaf() {
        return (leftChild == null && rightChild == null);
    }

    public int compareTo(Node node) {
        return this.freq - node.freq;
    }
}