

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }

    private Node<Item> first, last;
    private int n;   // number of elements in queue

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        n = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        first.prev = null;
        n++;
        if (size() == 1) last = first;
        else oldFirst.prev = first;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.prev = oldLast;
        last.next = null;
        n++;
        if (size() == 1) first = last;
        else oldLast.next = last;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item ans = first.item;
        Node<Item> newFirst = first.next;
        first = newFirst;
        n--;
        if (isEmpty()) last = null;
        else first.prev = null;
        return ans;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Item ans = last.item;
        Node<Item> newLast = last.prev;
        last = newLast;
        n--;
        if (isEmpty()) first = null;
        else last.next = null;
        return ans;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node<Item> curr = first;

        public boolean hasNext() {
            return curr != null;
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = curr.item;
            curr = curr.next;
            return item;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Deque<Integer> dq = new Deque<>();
        StdOut.println(dq.isEmpty());
        dq.addFirst(3);
        dq.addFirst(2);
        dq.addLast(4);
        StdOut.println(dq.removeFirst());
        StdOut.println(dq.removeFirst());
        StdOut.println(dq.removeFirst());

        // Iterator<Integer> i = dq.iterator();
        // StdOut.println("Now the deque is: ");
        // while (i.hasNext()) {
        //     StdOut.println(i.next());
        // }
        // StdOut.println("The first element is: " + dq.removeFirst());
        // StdOut.println("The last element is:" + dq.removeLast());
        // i = dq.iterator();
        // StdOut.println("Now the deque is: ");
        // while (i.hasNext()) {
        //     StdOut.println(i.next());
        // }
        // StdOut.println(dq.isEmpty());

    }

}
