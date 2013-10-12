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
    public void createQueueIsEmpty()
    {
        assertEmpty(true);
    }

    @Test
    public void pushNullStringQueueIsEmpty()
    {
        queue.push("");
        assertEmpty(true);
    }

    @Test
    public void pushOneElementQueueIsNotEmpty()
    {
        queue.push("6");
        assertEmpty(false);
    }

    @Test
    public void pushOneElementItOnTop()
    {
        String element = "9";
        queue.push(element);
        assertEquals(element, queue.top());
    }

    @Test
    public void topOneElement()
    {
        String elementList="7,4,9";
        queue.push(elementList);
        assertEquals("7",queue.top());
    }

    @Test
    public void popOneElement()
    {
        String elementList="7,4,9";
        queue.push(elementList);
        assertEquals("7",queue.pop());
    }

    @Test
    public void pushMoreElementsThanQueue()
    {
        String elementList="7,4,9,4,3,2,5,7,5,3,3,4,2,5";
        queue.push(elementList);
        assertEquals("7", queue.pop());
    }

    @Test
    public void pushListPopPartElements()
    {
        String elementList="7,4,9";
        queue.push(elementList);
        for (int i = 0; i < 2; i++)
            queue.pop();
        assertEquals("9", queue.pop());
    }

    @Test
    public void pushListPopAllElements()
    {
        String elementList="7,4,9";
        queue.push(elementList);
        for (int i = 0; i < 3; i++)
            queue.pop();

        assertEmpty(true);
    }

    @Test
    public void popEmptyQueue()
    {
        assertEmptyError();
    }

    @Test
    public void topEmptyQueue()
    {
        assertEmptyError();
    }

    @Test
    public void whenWorkLongTime()
    {
        String elementList="3,5,2,5,7,4";
        for (int j = 0; j < 2; j++)
        {
            queue.push(elementList);
            for (int i = 0; i < 6; i++)
                queue.pop();
        }
        queue.push(elementList);
        assertEquals("3", queue.pop());
    }

    private void assertEmpty(boolean expected)
    {
        assertEquals(expected,queue.isEmpty());
    }

    private void assertEmptyError()
    {
        assertEquals("queue is empty", queue.pop());
    }

}
