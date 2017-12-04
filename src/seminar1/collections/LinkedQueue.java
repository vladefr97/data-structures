package seminar1.collections;

import java.util.Iterator;

public class LinkedQueue<Item> implements IQueue<Item> {

    // -> [tail -> .. -> .. -> head] ->
    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    @Override
    public void enqueue(Item item) {
        /* TODO: implement it */
//        if(head==null){
//            head=item;
//            tail=item;
//        }
//        else {
//        tail.next=item;
//        tail=item;
//        }
        Node<Item> n = new Node<Item>(item);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;

    }

    @Override
    public Item dequeue() {
        /* TODO: implement it */
//        Item i=head;
//        if(head.next!=null){
//            head=head.next;
//        }
//
//        return i;

        Item i = head.item;
        if (head.next != null) {
            head = head.next;
        }
        size--;
        return i;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            /* TODO: implement it */
            if (head != null) {
                return true;
            } else {
                return false;
            }

            //return false;
        }

        @Override
        public Item next() {
            /* TODO: implement it */
            return head.next.item;

        }

    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;

        public Node(Item item) {
            this.item = item;
        }

        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }
}
