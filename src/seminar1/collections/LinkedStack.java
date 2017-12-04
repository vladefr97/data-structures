package seminar1.collections;

import java.util.Iterator;

public class LinkedStack<Item> implements IStack<Item> {

    private Node<Item> head;
    private int size;

    @Override
    public void push(Item item) {
        /* TODO: implement it */
        Node<Item> n = new Node<Item>(item, head);

        head = n;
        size++;
    }

    @Override
    public Item pop() {
        if (size == 0) {
            return null;
        }
        /* TODO: implement it */
        Item i = head.item;
        head = head.next;
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
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            /* TODO: implement it */
            if (head.next == null) {
                return false;
            } else {
                return true;
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

        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }
}
