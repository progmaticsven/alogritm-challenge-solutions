import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.junit.Assert.*;

public class RandomizedQueueTest {

    @Test
    public void init() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        assertEquals(0, randomizedQueue.size());
        assertTrue(randomizedQueue.isEmpty());
    }

    @Test
    public void sizeIncreasesWhenItemIsEnqueued() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        assertEquals(0, randomizedQueue.size());

        randomizedQueue.enqueue("foo");
        assertEquals(1, randomizedQueue.size());
    }

    @Test
    public void sizeDecreasesWhenItemIsDequeued() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue("foo");
        randomizedQueue.enqueue("bar");
        assertEquals(2, randomizedQueue.size());

        randomizedQueue.dequeue();
        assertEquals(1, randomizedQueue.size());

        randomizedQueue.dequeue();
        assertEquals(0, randomizedQueue.size());
        assertTrue(randomizedQueue.isEmpty());
    }

    @Test
    public void addElementToEndAndPopThem() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue("one");
        randomizedQueue.enqueue("two");
        randomizedQueue.enqueue("three");

        assertEquals("one", randomizedQueue.dequeue());
        assertEquals("two", randomizedQueue.dequeue());
        randomizedQueue.enqueue("four");
        assertEquals("three", randomizedQueue.dequeue());
        assertEquals("four", randomizedQueue.dequeue());
        assertTrue(randomizedQueue.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentWhenEnqueueWithNull() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void DequeueOnEmpty() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.dequeue();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iteratorRemoveThrowsUnsupportedOperationException() {
        new RandomizedQueue<>().iterator().remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorNextOnEmpty() {
        new RandomizedQueue<>().iterator().next();
    }

    @Test
    public void iteratorIterates() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue("one");
        randomizedQueue.enqueue("two");
        randomizedQueue.enqueue("three");

        Iterator iterator = randomizedQueue.iterator();


        assertThat(iterator.next(), anyOf(CoreMatchers.is("one"), CoreMatchers.is("two"), CoreMatchers.is("three")));
        assertThat(iterator.next(), anyOf(CoreMatchers.is("one"), CoreMatchers.is("two"), CoreMatchers.is("three")));
        assertThat(iterator.next(), anyOf(CoreMatchers.is("one"), CoreMatchers.is("two"), CoreMatchers.is("three")));
        assertFalse(iterator.hasNext());
    }

    @Test
    public void sample() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue("one");
        randomizedQueue.enqueue("two");
        randomizedQueue.enqueue("three");


        String var = randomizedQueue.sample();
        assertThat(var, anyOf(CoreMatchers.is("one"), CoreMatchers.is("two"), CoreMatchers.is("three")));
    }

    @Test
    public void addAndRemoveMillion() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        for(int i = 0; i < 1000000; i++){
            randomizedQueue.enqueue(String.valueOf(System.currentTimeMillis()));
        }

        assertEquals(1000000, randomizedQueue.size());

        for(int i = 0; i < 1000000; i++){
            randomizedQueue.dequeue();
        }
        assertEquals(0, randomizedQueue.size());
    }


    @Test
    public void decreaseInSpace() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue("one");
        randomizedQueue.enqueue("two");
        randomizedQueue.enqueue("three");
        randomizedQueue.enqueue("four");
        randomizedQueue.enqueue("five");
        randomizedQueue.enqueue("six");
        randomizedQueue.enqueue("seven");

        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();

        assertTrue(randomizedQueue.isEmpty());
    }

}