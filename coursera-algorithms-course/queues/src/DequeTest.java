import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DequeTest {

    @Test
    public void init() {
        Deque<String> deque = new Deque<>();
        assertEquals(0, deque.size());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void sizeIncreasesWhenItemIsAddedToBeginning() {
        Deque<String> deque = new Deque<>();
        assertEquals(0, deque.size());

        deque.addFirst("foo");
        assertEquals(1, deque.size());
    }

    @Test
    public void sizeIncreasesWhenItemIsAddedToEnd() {
        Deque<String> deque = new Deque<>();
        assertEquals(0, deque.size());

        deque.addLast("foo");
        assertEquals(1, deque.size());
    }

    @Test
    public void sizeDecreasesWhenItemIsRemovedFromStart() {
        Deque<String> deque = new Deque<>();
        deque.addLast("foo");
        deque.addLast("bar");
        assertEquals(2, deque.size());

        deque.removeFirst();
        assertEquals(1, deque.size());
    }

    @Test
    public void sizeDecreasesWhenItemIsRemovedFromEnd() {
        Deque<String> deque = new Deque<>();
        deque.addLast("foo");
        deque.addLast("bar");
        assertEquals(2, deque.size());

        deque.removeLast();
        assertEquals(1, deque.size());
    }

    @Test
    public void addElementToEndAndPopThem() {
        Deque<String> deque = new Deque<>();
        deque.addLast("one");
        deque.addLast("two");
        deque.addLast("three");

        assertEquals("three", deque.removeLast());

        deque.addLast("foo");
        assertEquals("foo", deque.removeLast());

        assertEquals("two", deque.removeLast());
        assertEquals("one", deque.removeLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void addElementToBeginningAndPopThem() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("one");
        deque.addFirst("two");
        deque.addFirst("three");

        assertEquals("three", deque.removeFirst());
        assertEquals("two", deque.removeFirst());
        assertEquals("one", deque.removeFirst());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void queueItemsAndProcessFromLast() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("one");
        deque.addFirst("two");
        deque.addFirst("three");

        assertEquals("one", deque.removeLast());
        assertEquals("two", deque.removeLast());
        assertEquals("three", deque.removeLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void queueItemsAndProcessFromFirst() {
        Deque<String> deque = new Deque<>();

        deque.addFirst("1");
        deque.addFirst("2");
        deque.addFirst("3");

        deque.addLast("1");
        deque.addLast("2");
        deque.addLast("3");


        assertEquals("3", deque.removeFirst());
        assertEquals("3", deque.removeLast());

        assertEquals("2", deque.removeFirst());
        assertEquals("2", deque.removeLast());

        assertEquals("1", deque.removeFirst());
        assertEquals("1", deque.removeLast());
        assertTrue(deque.isEmpty());
    }


    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentWhenAddFirstWithNull() {
        Deque<String> deque = new Deque<>();
        deque.addFirst(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentWhenAddLastWithNull() {
        Deque<String> deque = new Deque<>();
        deque.addLast(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeFirstOnEmptyList() {
        Deque<String> deque = new Deque<>();
        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void removeLastOnEmptyList() {
        Deque<String> deque = new Deque<>();
        deque.removeLast();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iteratorRemoveThrowsUnsupportedOperationException() {
        new Deque<>().iterator().remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorNextOnEmpty() {
        new Deque<>().iterator().next();
    }

    @Test
    public void iteratorStartsAlwaysFromFirst() {
        Deque deque = new Deque<>();
        deque.addLast("one");
        deque.addLast("two");
        deque.addLast("three");

        assertEquals("one", deque.iterator().next());
        assertEquals("one", deque.iterator().next());
    }

    @Test
    public void iteratorIterates() {
        Deque deque = new Deque<>();
        deque.addLast("one");
        deque.addLast("two");
        deque.addLast("three");

        Iterator iterator = deque.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("one", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("two", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("three", iterator.next());
        assertFalse(iterator.hasNext());
    }

}