package seminar1.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDeque<Item> implements IDeque<Item> {

    private Node<Item> head;
    private Node<Item> tail;
    private int size;


    @Override
    public void pushFront(Item item) {
        /* TODO: implement it */
        Node<Item> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
            // head.next=null;
            tail = newNode;
            //tail.next=null;
        } else {
            head.next = newNode;
            newNode.prev = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public void pushBack(Item item) {
        /* TODO: implement it */
        Node<Item> newNode = new Node<>(item);
        if (tail == null) {
            tail = newNode;
            //tail.next=null;
            tail = newNode;
            //tail.next=null;
        } else {
            tail.prev = newNode;
            newNode.next = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public Item popFront() {
        /* TODO: implement it */
        Item i = head.item;
        if (head.prev == null) {
            head = tail = null;
            return i;
        }
        head = head.prev;
        head.next = null;
        size--;
        return i;
    }

    @Override
    public Item popBack() {
        /* TODO: implement it */
        Item i = tail.item;
        if (tail.next == null) {
            tail = head = null;
            return i;
        }
        tail = tail.next;
        tail.prev = null;

        size--;
        return null;
    }

    @Override
    public boolean isEmpty() {
        /* TODO: implement it */
        return size == 0;
    }

    @Override
    public int size() {
        /* TODO: implement it */
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        /* TODO: implement it */
        return new Iterator<Item>() {
            private Node<Item> currElement = tail;
            @Override
            public boolean hasNext() {

                return currElement!=null;
            }

            @Override
            public Item next() {
                if(currElement == null) throw new NoSuchElementException();
                Item temp = currElement.item;
                currElement = currElement.next;
                return temp;
            }
        };
    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> prev;

        public Node(Item item) {
            this.item = item;
        }

        public Node(Item item, Node<Item> next, Node<Item> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
