package ru.unn.agile.Huffman;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class NodeTest {
    @Test
    public void nodeWithoutChildrenIsLeaf(){
        Node node = new Node('\0',0,null,null);
        assertEquals(true,node.isLeaf());
    }

    @Test
    public void nodeWithChildrenIsNotLeaf(){
        Node nodeLeftChild = new Node('\0',0,null,null);
        Node nodeRightChild = new Node('\0',0,null,null);
        Node nodeParent = new Node('\0',0,nodeLeftChild,nodeRightChild);
        assertEquals(false,nodeParent.isLeaf());
    }

    @Test
    public void nodeWithOnlyLeftChildIsNotAllowed(){
         try {
             Node nodeChild = new Node('\0',0,null,null);
             Node nodeParent = new Node('\0',0,nodeChild,null);
             fail("Runtime exception was expected");
         }
         catch (RuntimeException e){
             assertEquals("Node can't have one child", e.getMessage());
         }
         catch (Exception e){
             fail("Unexpected exception: " + e.toString());
         }
    }

    @Test
    public void nodeWithOnlyRightChildIsNotAllowed(){
        try {
            Node nodeChild = new Node('\0',0,null,null);
            Node nodeParent= new Node('\0',0,null,nodeChild);
            fail("Runtime exception was expected");
        }
        catch (RuntimeException e) {
            assertEquals("Node can't have one child", e.getMessage());
        }
        catch (Exception e){
            fail("Unexpected exception: " + e.toString());
        }
    }
}

