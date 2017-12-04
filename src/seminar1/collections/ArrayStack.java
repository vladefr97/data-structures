package seminar1.collections;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<Item> implements IStack<Item> {

    private static final int DEFAULT_CAPACITY = 4;

    private Item[] elementData;
    private int size;
    private int head = 0;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this.elementData = (Item[]) new Object[DEFAULT_CAPACITY];
        size = DEFAULT_CAPACITY;
    }

    @Override
    public void push(Item item) {
        if (head == size) {
            grow();
        }
        elementData[head] = item;

        head++;
        //size++;
        /* TODO: implement it */
    }

    @Override
    public Item pop() {
        /* TODO: implement it */
        if (head > 0 && 4 * head < size) {
            shrink();
        }
        head--;
        //size--;
        Item i = elementData[head];
        elementData[head] = null;
        return i;

    }

    @Override
    public boolean isEmpty() {
        return head == 0;
    }

    @Override
    public int size() {
        return head;
    }

    private void grow() {
        /**
         * TODO: implement it
         * Если массив заполнился,
         * то увеличить его размер в полтора раз
         */
        //Item[] newArray = (Item[]) new Object[DEFAULT_CAPACITY*2];;
        Item[] newArray = elementData;
        elementData = (Item[]) new Object[(int) (size * 1.5)];
        for (int i = 0; i < newArray.length; i++)
        //newArray[i]=elementData[i];
        {
            elementData[i] = newArray[i];
        }
        size = elementData.length;

        //elementData=newArray;


    }

    private void shrink() {
        /**
         * TODO: implement it
         * Если количество элементов в четыре раза меньше,
         * то уменьшить его размер в два раза
         */
        Item[] newArray = elementData;
        elementData = (Item[]) new Object[(int) (size / 4)];
        for (int i = 0; i < elementData.length; i++)
        //newArray[i]=elementData[i];
        {
            elementData[i] = newArray[i];
        }
        size = elementData.length;
    }

    private void changeCapacity(int newCapacity) {
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<Item> {

        private int currentPosition = size;

        @Override
        public boolean hasNext() {
            return currentPosition != 0;
        }

        @Override
        public Item next() {
            return elementData[--currentPosition];
        }

    }

}
