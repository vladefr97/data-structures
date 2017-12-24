package seminar1.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class CyclicArrayQueue<Item> implements IQueue<Item> {

    private Item[] elementData;
    int front;
    int rear;
    int maxSize = 10;
    int elemCount = 0;

    @SuppressWarnings("unchecked")
    public CyclicArrayQueue(int size) {
        maxSize = size;
        front = maxSize - 1;
        rear = maxSize - 1;
        elementData = (Item[]) new Object[maxSize];

    }

    public CyclicArrayQueue() {
        front = maxSize - 1;
        rear = maxSize - 1;
        elementData = (Item[]) new Object[maxSize];


    }

    @Override
    public void enqueue(Item item) {

        if (front < 0) {
            if (rear == maxSize - 1) {
                grow();
            } else {
                front = maxSize - 1;
            }

        } else if (front == rear && elemCount != 0) {
            grow();
        }

        if (front < 0) {
            front = maxSize - 1;
        }
        if (elemCount == 0) {
            front = rear = maxSize - 1;
        }
        elementData[front] = item;
        front--;
        elemCount++;
        /* TODO: implement it */

    }

    @Override
    public Item dequeue() {
        if (elemCount != 0) {
            Item i = elementData[rear];
            elementData[rear] = null;
            rear--;
            if (rear == -1 && elemCount > 1) {
                rear = maxSize - 1;
            }
            elemCount--;
            if (elemCount * 4 < maxSize && elemCount > 1) {
                shrink();
            }

            return i;
        } else {
            return null;
        }

        /* TODO: implement it */


    }

    @Override
    public boolean isEmpty() {
        /* TODO: implement it */
        return elemCount == 0;
    }

    @Override
    public int size() {
        /* TODO: implement it */
        return elemCount;
    }

    private void grow() {
        /**
         * TODO: implement it
         * Если массив заполнился,
         * то увеличить его размер в полтора раз
         */
        Item[] newArray = (Item[]) new Object[(int) (maxSize * 1.5)];
        if (front < rear) {
            for (int i = front + 1; i <= rear; i++) {
                newArray[i] = elementData[i];
            }
        } else {

            int index = rear;
            int i;
            for (i = newArray.length - 1; index >= 0; i--) {
                newArray[i] = elementData[index];
                index--;
            }
            index = maxSize - 1;
            for (; index != front; i--) {
                newArray[i] = elementData[index];
                index--;
            }
            front = i;
            rear = newArray.length - 1;

        }
        elementData = newArray;
        maxSize = elementData.length;

    }

    private void shrink() {

        /**
         * TODO: implement it
         * Если количество элементов в четыре раза меньше,
         * то уменьшить его размер в два раза
         */
        Item[] newArray = (Item[]) new Object[(int) (maxSize / 4)];
        int index;
        if (front < rear) {
            index = rear;
            int i;
            for (i = newArray.length - 1; index > front; i--) {
                newArray[i] = elementData[index];
                index--;
            }
            front = i;
        } else {
            index = rear;
            int i = newArray.length - 1;
            for (; index >= 0; i--) {
                newArray[i] = elementData[index];
                index--;
            }
            index = maxSize - 1;
            for (; index > front; i--) {
                newArray[i] = elementData[index];
                index--;
            }
            front = index + 1;

        }
        elementData = newArray;
        maxSize = elementData.length;
        rear = maxSize - 1;


    }


    @Override
    public Iterator<Item> iterator() {
        /* TODO: implement it */
        return new Iterator<Item>() {
            private int currElement = rear;
            @Override
            public boolean hasNext() {
               return currElement != front;
            }

            @Override
            public Item next() {
                if (currElement == front - 1) throw new NoSuchElementException();

                return elementData[currElement--];

            }
        };
    }
}
