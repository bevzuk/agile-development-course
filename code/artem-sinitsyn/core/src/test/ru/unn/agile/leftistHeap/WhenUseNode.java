package ru.unn.agile.leftistHeap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

public class WhenUseNode {
    private Node node;

    @Before
    public void setUp(){
        node = new Node();
    }

    @Test
    public void correctlyCreatedNode() {
        node = new Node(new Pair(0,"Node"), 1, null, null ,null);
        assertArrayEquals(new Object[] {node.getData().getKey(), node.getData().getValue(), node.getRank(),
                node.getLeftChild(), node.getRightChild(), node.getParent()},
                new Object[] {0, "Node", 1, null, null, null});
    }

    @Test
    public void incorrectNodeRank() {
        try {
            node = new Node(new Pair(0, "Node"), -1, null, null ,null);
            fail("IllegalArgumentException should be thrown");
        }
        catch (IllegalArgumentException ex) {
        }
    }
}
