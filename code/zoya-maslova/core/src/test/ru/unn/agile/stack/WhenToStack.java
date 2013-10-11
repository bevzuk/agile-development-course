package ru.unn.agile.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class WhenToStack {

    private Stack stack;

    @Before
    public void setUp() {
        stack=new Stack();
    }

    @Test
    public void CreateStackIsEmpty()
    {
        assertEmpty(true);
    }

    @Test
    public void PushNullStringStackIsEmpty()
    {
        stack.Push("");
        assertEmpty(true);
    }

    @Test
    public void PushOneElementStackIsNotEmpty()
    {
        stack.Push("6");
        assertEmpty(false);
    }

    @Test
    public void PushOneElementItOnTop()
    {
        String element="9";
        stack.Push(element);
        assertEquals(element, stack.Top());
    }

    @Test
    public void PushListOfElementsLastElementOnTop()
    {
        String elementList="7,4,9";
        stack.Push(elementList);
        assertEquals("9",stack.Top());
    }


    @Test
    public void PushBigListOfElementsStackOverflow()
    {
        String elementList="8,4,1,6,8,2,6,1,9,5,3";
        try {
        stack.Push(elementList);
        fail();
        }
        catch (Exception e){}
    }

    @Test
    public void PopOneElement()
    {
        String elementList="7,4,9";
        stack.Push(elementList);
        assertEquals("9",stack.Pop());
    }

    @Test
    public void PopAllElements()
    {
        String elementList="7,4,9";
        stack.Push(elementList);
        for (int i=0;i<3;i++)
            stack.Pop();
        assertEmpty(true);
    }

    @Test
    public void PopEmptyStack()
    {
        assertEmptyError();
    }

    @Test
    public void TopEmptyStack()
    {
        assertEmptyError();
    }

    private void assertEmpty(boolean expected)
    {
        assertEquals(expected,stack.IsEmpty());
    }

    private void assertEmptyError()
    {
        assertEquals("stack is empty", stack.Pop());
    }



}
