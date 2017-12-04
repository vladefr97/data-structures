package seminar1.collections;

import java.util.Iterator;

public class CyclicArrayDeque<Item> implements IDeque<Item> {

    private Item[] elementData;
    int back;
    int front;
    int size = 4;
    int elemCount = 0;

    public CyclicArrayDeque() {
        elementData = (Item[]) new Object[(int) size];
        back = front = size / 2;

    }

    @Override
    public void pushFront(Item item) {

        /* TODO: implement it */
        if (front == back && elemCount == 0) {
            elementData[front] = item;
            elemCount++;
            return;
        }
        if (front + 1 >= size) {
            if (back <= 0) {
                grow();
            } else {
                front = 0;
            }
        } else if (front + 1 == back) {
            grow();
        }
        front++;
        elemCount++;
        elementData[front] = item;
    }

    @Override
    public void pushBack(Item item) {
        /* TODO: implement it */
        if (front == back && elemCount == 0) {
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
        elementData[back] = item;

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
            @Override
            public boolean hasNext() {
                return elemCount > 1;
            }

            @Override
            public Item next() {

                if (back < front) {
                    return elementData[back + 1];
                } else if (back == front) {
                    return null;
                } else {
                    if (back + 1 != size) {
                        return elementData[back + 1];
                    } else {
                        return elementData[0];
                    }
                }
            }
        };
    }
}
