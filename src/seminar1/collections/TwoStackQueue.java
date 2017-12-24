package seminar1.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoStackQueue<Item> implements IQueue<Item> {

    private IStack<Item> stack1;
    private IStack<Item> stack2;

    public TwoStackQueue() {
        /* TODO: implement it */
        stack1 = new LinkedStack<>();
        stack2 = new LinkedStack<>();


    }

    @Override
    public void enqueue(Item item) {
        stack1.push(item);
        /* TODO: implement it */
    }

    @Override
    public Item dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (isEmpty()) {
            return null;
        }
        /* TODO: implement it */
        return stack2.pop();
    }

    @Override
    public boolean isEmpty() {
        /* TODO: implement it */
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        /* TODO: implement it */

        return stack2.size() + stack1.size();
    }

    @Override
    public Iterator<Item> iterator() {
        /* TODO: implement it (optional) */
        return new Iterator<Item>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Item next() {
                return null;
            }
        };
    }

}
