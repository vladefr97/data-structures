package seminar1.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CyclicArrayDeque<Item> implements IDeque<Item> {

    private Item[] elementData;
    int back;
    int front;
    int size = 4;
    int elemCount = 0;

    public int getBack() {
        return back;
    }

    public CyclicArrayDeque() {

        elementData = (Item[]) new Object[(int) size];
        back = front = size / 2;

    }

    @Override
    public void pushFront(Item item) {

        /* TODO: implement it */
        if (front == back) {
            if (elemCount == 0)
                elementData[front] = item;
            else
                elementData[++front] = item;

            elemCount++;
            return;

        }
        if (front + 1 == size) {
            if (back == 0) grow();
            else {
                front = 0;
                elementData[front] = item;
                elemCount++;
                return;
            }
        }
        if (front + 1 == back && elemCount != 0) grow();
        elementData[++front] = item;
        elemCount++;
       /* if (front == back && elemCount == 0) {
            elementData[front] = item;
            elemCount++;
            return;
        }
        if (front + 1 >= size) {
            if (back <= 0) {
                grow();
            } else {
                front = 0;
                elementData[front] = item;
                elemCount++;
                front++;
                return;
            }
        } else if (front + 1 == back) {
            grow();
        }
        front++;
        elemCount++;
        elementData[front] = item;
        */
    }

    @Override
    public void pushBack(Item item) {
        /* TODO: implement it */
        if (front == back) {
            if (elemCount == 0)
                elementData[back] = item;
            else
                elementData[--back] = item;

            elemCount++;
            return;

        }

        if (back - 1 == -1) {
            if (front == size - 1) grow();

            back = size - 1;
            elementData[back] = item;
            elemCount++;
            return;
        }
        if (back - 1 == front && elemCount != 0) {
            grow();
            back = size;
        }
        elementData[--back] = item;
        elemCount++;
       /* if (front == back && elemCount == 0) {
            elementData[back] = item;
            elemCount++;
            return;
        }
        if (back - 1 < 0) {
            if (front + 1 >= size) {
                grow();
            }

        } else if (back - 1 == front) {
            grow();
        }
        if (back - 1 < 0) {
            back = size - 1;
        } else {
            back--;
        }
        elemCount++;
        elementData[back] = item;*/

    }

    @Override
    public Item popFront() {
        /* TODO: implement it */
        Item item = elementData[front];
        if (item == null) {
            return null;
        }
        elementData[front] = null;
        if (elemCount == 1) {
            elemCount--;
            return item;
        }
        if (front - 1 < 0) {
            front = size - 1;
        } else {
            front--;
        }
        elemCount--;
        if (elemCount * 4 < size) {
            shrink();
        }
        return item;
    }

    @Override
    public Item popBack() {
        /* TODO: implement it */
        Item item = elementData[back];
        if (item == null) {
            return null;
        }
        elementData[back] = null;
        if (elemCount == 1) {
            elemCount--;
            return item;
        }
        if (back + 1 > size - 1) {
            back = 0;
        } else {
            back++;
        }
        elemCount--;
        if (elemCount * 4 < size) {
            shrink();
        }
        return item;

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

        Item[] newArray = (Item[]) new Object[(int) (size * 1.5)];
        int index;
        int i = 0;
        if (front > back) {
            index = back;
            for (; index <= front; i++) {
                newArray[i] = elementData[index];
                index++;
            }
        } else {
            index = back;
            for (; index < size; i++) {
                newArray[i] = elementData[index];
                index++;
            }
            index = 0;
            for (; index <= front; i++) {
                newArray[i] = elementData[index];
                index++;
            }

        }
        back = 0;
        front = i - 1;
        elementData = newArray;
        size = elementData.length;
    }

    private void shrink() {
        /**
         * TODO: implement it
         * Если количество элементов в четыре раза меньше,
         * то уменьшить его размер в два раза
         */
        Item[] newArray = (Item[]) new Object[(int) (size / 2)];
        if (elemCount == 1) {
            newArray = (Item[]) new Object[4];
            newArray[0] = elementData[back];
            elementData = newArray;
            size = 4;
            back = front = 0;
            return;

        }
        int index;
        int i = 0;
        if (front > back) {
            index = back;
            for (; index <= front; i++) {
                newArray[i] = elementData[index];
                index++;
            }
        } else {
            index = back;
            for (; index < size; i++) {
                newArray[i] = elementData[index];
                index++;
            }
            index = 0;
            for (; index <= front; i++) {
                newArray[i] = elementData[index];
                index++;
            }
        }
        back = 0;
        front = i - 1;
        elementData = newArray;
        size = elementData.length;
    }


    @Override
    public Iterator<Item> iterator() {
        /* TODO: implement it */
        return new Iterator<Item>() {
            private int currElement = back;

            @Override
            public boolean hasNext() {
                return currElement != front + 1;
            }

            @Override
            public Item next() {

                if (currElement == front + 1) throw new NoSuchElementException();
                if (currElement == size) currElement = 0;
                return elementData[currElement++];
            }
        };
    }
}
