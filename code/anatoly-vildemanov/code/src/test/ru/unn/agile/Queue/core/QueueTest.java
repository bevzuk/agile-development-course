package ru.unn.agile.Queue.core;

import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.Queue.Queue;

import static org.junit.Assert.assertEquals;

public class QueueTest {

    private Queue queue;

    @Before
    public void setUp() {
        queue = new Queue();
    }

    @Test
    public void createEmptyQueue()
    {
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void pushElement()
    {
        queue.push(2);
        assertEquals(false, queue.isEmpty());
    }

    @Test
    public void pushManyElements()
    {
        fillUpQueue(12);
        assertEquals(false, queue.isEmpty());
    }

    @Test
    public void fullTank()
    {
        fillUpQueue(7);
        assertEquals(false, queue.isFull());
    }

    @Test
    public void lookElement()
    {
        fillUpQueue(7);
        assertEquals(0, queue.top());
    }

    @Test
    public void takeHeadElement()
    {
        fillUpQueue(7);
        assertEquals(0, queue.pop());
    }

    @Test
    public void takeHeadElementInOnesElementQueue()
    {
        queue.push(3);
        queue.pop();
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void popPushPopHeadElement()
    {
        queue.push(3);
        queue.pop();
        queue.push(2);
        assertEquals(2, queue.pop());
    }

    @Test
    public void pushListPopPartElements()
    {
        fillUpQueue(3);
        for (int i = 0; i < 2; i++)
            queue.pop();
        assertEquals(2, queue.pop());
    }

    @Test
    public void whenWorkLongTime()
    {
        for (int j = 0; j < 2; j++)
        {
            fillUpQueue(7);
            for (int i = 0; i < 7; i++)
                queue.pop();
        }
        fillUpQueue(7);
        assertEquals(0, queue.pop());
    }

    private void fillUpQueue(int countOfElement)
    {
        for (int i = 0; i < countOfElement; i++)
            queue.push(i);
    }

}
