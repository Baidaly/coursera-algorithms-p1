import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int n;            // number of elements
    private Node first;
    private Node last;


    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        n = 0;
        assert check();
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
        if (item == null) throw new IllegalArgumentException("Cannot addFirst null");
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        if (oldfirst != null) oldfirst.prev = first;
        else if (last != null) { last.prev = first; first.next = last; }
        else last = first;

        n++;
        assert check();                      // add item
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("Cannot addLast null");
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if (oldlast != null) oldlast.next = last;
        else if (first != null) { last.prev = first; first.next = last; }
        else first = last;
        last.prev = oldlast;
        n++;
        assert check();
    }


    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        if (first != null) first.prev = null;
        else last = null;
        n--;
        assert check();
        return item;                   // return the saved item
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = last.item;        // save item to return
        last = last.prev;            // delete first node
        if (last != null) last.next = null;
        else first = null;
        n--;
        assert check();
        return item;                   // return the saved item
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // check internal invariants
    private boolean check() {

        // check a few properties of instance variable 'first'
        if (n < 0) {
            return false;
        }
        if (n == 0) {
            if (first != null) return false;
            if (last != null) return false;
        }
        else if (n == 1) {
            if (first == null)      return false;
            if (first.next != null) return false;
            if (first.prev != null) return false;
            if (last != first) return false;
            if (last.next != null) return false;
            if (last.prev != null) return false;
        }
        else {
            if (first == null)      return false;
            if (last == null)      return false;
            if (first.next == null) return false;
            if (last.prev == null) return false;
        }

        // check internal consistency of instance variable n
//        int numberOfNodes = 0;
//        for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
//            numberOfNodes++;
//        }
//        if (numberOfNodes != n) return false;

        return true;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();

        assert deque.size() == 0;

        deque.isEmpty();
        deque.isEmpty();
        deque.addFirst(1);
        deque.isEmpty();
        System.out.println(deque.removeFirst());

//        deque.addLast(3);
//        deque.addFirst(2);
//        deque.addFirst(1);
//
//        for (int item: deque) {
//            System.out.print(item + ", ");
//        }
//
//        System.out.println();
//
//        deque = new Deque<>();
//
//        assert deque.size() == 0;
//
//        deque.addFirst(2);
//        deque.addFirst(1);
//        deque.addLast(3);
//
//
//        for (int item: deque) {
//            System.out.print(item + ", ");
//        }
    }
}