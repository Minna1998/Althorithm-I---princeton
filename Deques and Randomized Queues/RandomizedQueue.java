import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] randomque;
    private int n = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
        randomque = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (n == randomque.length) resize(n*2);
        randomque[n] = item;
        n++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int index = StdRandom.uniform(n);
        Item item = randomque[index];
        if (index != n-1) randomque[index] = randomque[n-1];
        randomque[n-1] = null;
        n--;
        if (n > 0 && n == randomque.length/4) resize(randomque.length/2);
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int index = StdRandom.uniform(n);
        Item item = randomque[index];
        return item;

    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() { // 每次iterator之后，randomqueue就变了！！first, last也不对了！！
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator<Item> {
        private int size = n;
        private Item[] sequence;

        public ArrayIterator() {
            sequence = (Item[]) new Object[n];
            for (int j = 0; j < n; j++) {
                sequence[j] = randomque[j];
            }
        }

        public boolean hasNext() {
            return size > 0;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            int index = StdRandom.uniform(size);
            Item item = sequence[index];
            if (index != size-1) sequence[index] = sequence[size-1];
            size--;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = randomque[i];
        }
        randomque = copy;
        copy = null;
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        rq.enqueue("a");
        rq.enqueue("b");
        rq.enqueue("c");
        StdOut.println(rq.isEmpty());
        StdOut.println(rq.size());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.sample());
        StdOut.println(rq.size());

        Iterator<String> i = rq.iterator();
        while (i.hasNext()) {
            StdOut.println(i.next());
        }
        i = rq.iterator();
        while (i.hasNext()) {
            StdOut.println(i.next());
        }
    }


}
