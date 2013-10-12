package ru.unn.agile.leftistHeap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class WhenUseLeftistHeap {
    private LeftistHeap leftistHeap;

    @Before
    public void SetUp() {
        leftistHeap = new LeftistHeap();
    }

    @Test
    public void NewOneElementHeapIsNotEmpty() {
        leftistHeap = new LeftistHeap(new Pair(0, "FirstElement"));
        assertEquals(leftistHeap.isEmpty(), false);
    }

    @Test
    public void NewOneElementHeapHasOneNode() {
        leftistHeap = new LeftistHeap(new Pair(0, "FirstElement"));
        assertEquals(leftistHeap.getCount(), 1);
    }
}
