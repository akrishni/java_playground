import java.util.Iterator;

/**
 * Created by akrishniyer on 4/10/17.
 * <p>
 * //
 */


public class Deque<Item> implements Iterable<Item> {
    private int numItems;
    private Node<Item> first;
    private Node<Item> last;

    private class Node<Item> {
        private Node<Item> right = null;
        private Node<Item> left = null;
        private Item item = null;

        public Node(Item item) {
            this.item = item;
        }
    }

    public Deque() {                         // construct an empty deque
        numItems = 0;
        Node<Item> first = null;
        Node<Item> last = null;
    }

    public boolean isEmpty() {              // is the deque empty?
        if (numItems == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {                       // return the number of items on the deque
        return numItems;
    }

    public void addFirst(Item item) {         // add the item to the front
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        Node<Item> newNode = new Node<Item>(item);
        if (first == null) {
            first = newNode;
            last = first;
        } else {
            first.left = newNode;
            newNode.right = first;
            first = newNode;
        }
        numItems++;
    }


    public void addLast(Item item) {         // add the item to the end
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        Node<Item> newNode = new Node<Item>(item);
        if (first == null) {
            first = newNode;
            last = first;
        } else {
            last.right = newNode;
            newNode.left = last;
            last = newNode;
        }
        numItems++;
    }

    public Item removeFirst() {              // remove and return the item from the front
        if (numItems == 0) {
            throw new java.util.NoSuchElementException();
        }
        Item fItem = first.item;
        if(first.right != null) {
            first = first.right;
            first.left = null;
        } else {
            first = last = null;
        }
        numItems--;
        return fItem;
    }

    public Item removeLast() {                 // remove and return the item from the end
        if (numItems == 0) {
            throw new java.util.NoSuchElementException();
        }
        Item lItem = last.item;
        if(last.left != null) {
            last = last.left;
            last.right = null;
        } else {
            first = last = null;
        }
        numItems--;
        return lItem;
    }

    public Iterator<Item> iterator() {         // return an iterator over items in order from front to end
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        Node<Item> current = first;

        public boolean hasNext() {
            if (current != null)
                return true;
            else
                return false;
        }

        public Item next() {
            if (current == null) {
                throw new java.util.NoSuchElementException();
            }
            Item item = current.item;
            current = current.right;
            return item;
        }
    }

    public static void main(String[] args) {  // unit testing (optional)
/**
        Deque<Integer> dq = new Deque<Integer>();
        dq.addFirst(1);
        dq.removeFirst();

        Iterator it = dq.iterator();

        while(it.hasNext()){
            System.out.println((Integer)it.next());
        }

        dq.addFirst(2);
        dq.addFirst(3);
        dq.removeLast();


        dq.addLast(5);
        dq.removeLast();
        dq.addLast(6);
        dq.addLast(7);

        Iterator it2 = dq.iterator();
        while(it2.hasNext()){
            System.out.println((Integer)it2.next());
        }


**/
    }

}
