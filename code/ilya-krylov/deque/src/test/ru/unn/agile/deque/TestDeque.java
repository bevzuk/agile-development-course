package ru.unn.agile.deque;

import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.deque.Deque;

import static org.junit.Assert.*;

public class TestDeque {
    private Deque deque;

    private void fillCompletelyFromBack(){
        while(!deque.isFull()){
            deque.pushBack(0);
        }
    }

    private void fillCompletelyFromFront(){
        while(!deque.isFull()){
            deque.pushFront(0);
        }
    }

    @Before
    public void setUp(){
        deque = new Deque(10);
    }

    @Test
    public void isEmptyWhenCreate(){
       assertEquals(true, deque.isEmpty());
    }

    @Test
    public void isEmptyWhenPushBackNewElement(){
        deque.pushBack(10);
        assertEquals(false, deque.isEmpty());
    }

    @Test
    public void isNotFullWhenCreate(){
        assertEquals(true, !deque.isFull());
    }

    @Test
    public void isFullWhenAmountOfElementsEqualsToMaximum(){
        fillCompletelyFromBack();
        assertEquals(true, deque.isFull());
    }

    @Test
    public void isPushedBackElementEqualsToBack(){
        deque.pushBack(555);
        assertEquals(555, deque.getBack());
    }

    @Test
    public void ExpectedExceptionWhenPushBackToFullDeque(){
        try{
            fillCompletelyFromBack();
            deque.pushBack(100);
            fail("Expected exception");
        }
        catch (Exception e){
            assertEquals("Deque is full, my lord", e.getMessage());
        }
    }

    @Test
    public void isEmptyWhenPushFrontNewElement(){
        deque.pushFront(10);
        assertEquals(false, deque.isEmpty());
    }

    @Test
    public void isPushedFrontElementEqualsToFront(){
        deque.pushFront(555);
        assertEquals(555, deque.getFront());
    }

    @Test
    public void ExpectedExceptionWhenPushFrontToFullDeque(){
        try{
            fillCompletelyFromFront();
            deque.pushFront(100);
            fail("Expected exception");
        }
        catch (Exception e){
            assertEquals("Deque is full, my lord", e.getMessage());
        }
    }

    @Test
    public void ExpectedExceptionWhenPopBackFromEmptyDeque(){
        try{
            deque.popBack();
            fail("Expected exception");
        }
        catch (Exception e){
             assertEquals("Deque is empty, my lord", e.getMessage());
        }
    }

    @Test
    public void ArePushedBackAndPoppedBackElementsEqual(){
        deque.pushBack(666);
        assertEquals(666, deque.popBack());
    }

    @Test
    public void expectedExceptionWhenPopFrontFromEmptyDeque(){
        try{
            deque.popFront();
            fail("Expected exception");
        }
        catch (Exception e){
            assertEquals("Deque is empty, my lord", e.getMessage());
        }
    }

    @Test
    public void arePushedFrontAndPoppedFrontElementsEqual(){
        deque.pushFront(666);
        assertEquals(666, deque.popFront());
    }

    @Test
    public void arePushedBackAndPoppedFrontEqualInEmptyDeque(){
        deque.pushBack(666);
        assertEquals(666, deque.popFront());
    }

    @Test
    public void arePushedFrontAndPoppedBackEqualInEmptyDeque(){
        deque.pushFront(666);
        assertEquals(666, deque.popBack());
    }

    @Test
    public void ddd(){
        fillCompletelyFromFront();
    }

}
