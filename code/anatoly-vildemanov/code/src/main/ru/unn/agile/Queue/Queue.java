package ru.unn.agile.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 12.10.13
 * Time: 21:33
 * To change this template use File | Settings | File Templates.
 */
public class Queue {

    private int[] queue;
    private int head;
    private int tail;
    private int count;
    private final int SIZE_OF_QUEUE = 10;

    public Queue(){
        queue = new int[SIZE_OF_QUEUE];
        tail  = -1;
        head  =  0;
        count =  0;
    };

    public boolean isEmpty()
    {
        return (count == 0);
    }
    public void push(String elements)
    {
        if (elements == "")
            return;

        String[] tokens = parseStringToElements(elements);

        for (String token: tokens)
            pushOneElement(token);
    }

    public String top()
    {
        if (isEmpty())
            return "queue is empty";
        return Integer.toString(queue[head]);
    }

    public String pop()
    {
        if (isEmpty())
            return "queue is empty";
        count--;
        int res = queue[head];
        head = (head + 1) % getMaxSize();
        return Integer.toString(res);
    }

    private void pushOneElement(String element)
    {
        if (getSize()!= getMaxSize())
        {
            count++;
            tail = (tail + 1) % getMaxSize();
            queue[tail] = Integer.parseInt(element);
        }
    }

    private String[] parseStringToElements(String string)
    {
        return string.split("[,]")  ;
    }

    public int getMaxSize()
    {
        return SIZE_OF_QUEUE;
    }

    public int getSize()
    {
        return count;
    }
}
