import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int leftPointer = 0;
    private int rightPointer = 0;

    private Item[] queue = (Item[]) new Object[1];

    // construct an empty randomized queue
    public RandomizedQueue() {

    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return leftPointer == rightPointer;
    }

    // return the number of items on the randomized queue
    public int size() {
        return rightPointer - leftPointer;
    }

    private void resizeQueueIfNeeded() {
        int size = size();
        if (size > 0 && (this.rightPointer >=  queue.length || this.leftPointer >= size)) {
            Item[] newQueue = (Item[]) new Object[size * 2];
            System.arraycopy(queue, leftPointer, newQueue, 0, size);
            this.queue = newQueue;
            this.rightPointer = size;
            this.leftPointer = 0;
        }
    }



    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        resizeQueueIfNeeded();
        queue[rightPointer] = item;
        rightPointer++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        resizeQueueIfNeeded();
        Item item = queue[leftPointer];
        queue[leftPointer] = null;
        leftPointer++;
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        return queue[leftPointer + StdRandom.uniform(size())];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int[] randomOrder = StdRandom.permutation(size());
            int pointer = 0;

            @Override
            public boolean hasNext() {
                return pointer < randomOrder.length;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                return queue[randomOrder[pointer++]];
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args) {

    }

}