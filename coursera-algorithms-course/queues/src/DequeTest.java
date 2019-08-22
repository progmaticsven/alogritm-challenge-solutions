import org.junit.Test;

import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class DequeTest {

    @Test
    public void init(){
        Deque<String> deque = new Deque<>();
        assertEquals(0, deque.size());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void sizeIncreasesWhenItemIsAddedToBeginning(){
        Deque<String> deque = new Deque<>();
        assertEquals(0, deque.size());

        deque.addFirst("foo");
        assertEquals(1, deque.size());
    }

    @Test
    public void sizeIncreasesWhenItemIsAddedToEnd(){
        Deque<String> deque = new Deque<>();
        assertEquals(0, deque.size());

        deque.addLast("foo");
        assertEquals(1, deque.size());
    }

    @Test
    public void sizeDecreasesWhenItemIsRemovedFromStart(){
        Deque<String> deque = new Deque<>();
        deque.addLast("foo");
        deque.addLast("bar");
        assertEquals(2, deque.size());

        deque.removeFirst();
        assertEquals(1, deque.size());
    }

    @Test
    public void sizeDecreasesWhenItemIsRemovedFromEnd(){
        Deque<String> deque = new Deque<>();
        deque.addLast("foo");
        deque.addLast("bar");
        assertEquals(2, deque.size());

        deque.removeLast();
        assertEquals(1, deque.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentWhenAddFirstWithNull(){
        Deque<String> deque = new Deque<>();
        deque.addFirst(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentWhenAddLastWithNull(){
        Deque<String> deque = new Deque<>();
        deque.addLast(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeFirstOnEmptyList(){
        Deque<String> deque = new Deque<>();
        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void removeLastOnEmptyList(){
        Deque<String> deque = new Deque<>();
        deque.removeLast();
    }


}