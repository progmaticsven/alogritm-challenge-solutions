import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int size;

    private Element last;
    private Element first;

    private class Element {
        Element(Item value) {
            this.value = value;
        }

        Element previous;
        Element next;
        Item value;
    }

    // construct an empty deque
    public Deque() {

    }

    // is the deque empty?
    public boolean isEmpty() {
        return size < 1;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        size++;

        if (first == null) {
            first = last = new Element(item);
        } else {
            Element oldFirst = first;
            Element newFirst = new Element(item);
            oldFirst.previous = newFirst;
            newFirst.previous = null;
            newFirst.next = oldFirst;

            first = newFirst;
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        size++;

        if (last == null) {
            first = last = new Element(item);
        } else {
            Element oldLast = last;
            Element newLast = new Element(item);
            oldLast.next = newLast;
            newLast.previous = oldLast;
            last = newLast;
        }

    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        size--;

        Element oldFirst = first;
        Element newFirst = first.next;


        if (newFirst != null) {
            newFirst.previous = null;
            first = newFirst;
        } else {
            first = last = null;
        }

        return oldFirst.value;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        size--;

        Element oldLast = last;
        Element newLast = last.previous;

        if (newLast != null) {
            newLast.next = null;
            last = newLast;
        } else {
            first = last = null;
        }
        return oldLast.value;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Element pointer = first;
            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            @Override
            public Item next() {
                if(!hasNext())  throw new NoSuchElementException();

                Item current =  pointer.value;
                pointer = pointer.next;
                return current;
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args) {
    }

}