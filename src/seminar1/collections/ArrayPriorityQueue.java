package seminar1.collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayPriorityQueue<Key extends Comparable<Key>> implements IPriorityQueue<Key> {

    private Key[] elementData;
    private Comparator<Key> comparator;
    int elemCount;
    int arraySize = 4;


    public ArrayPriorityQueue() {
        /* TODO: implement it — O(n) */
        elementData = (Key[]) new Comparable[arraySize];
        this.comparator = new Comparator<Key>() {
            @Override
            public int compare(Key o1, Key o2) {
                return o1.compareTo(o2);
            }
        };
    }


    public ArrayPriorityQueue(Comparator<Key> comparator) {
        /* TODO: implement it — O(n) */
        elementData = (Key[]) new Comparable[arraySize];
        this.comparator = comparator;


    }

    @Override
    public void add(Key key) {
        /* TODO: implement it — O(log n) */
        if (elemCount == arraySize) {
            grow();
        }

        elementData[elemCount] = key;
        siftUp();
        elemCount++;
    }

    @Override
    public Key peek() {
        /**
         * TODO: implement it — O(1)
         * Посмотреть на минимальный элемент
         */

        return elementData[0];
    }

    @Override
    public Key extractMin() {
        /**
         * TODO: implement it — O(log n)
         * Достать минимальный элемент
         *  и перестроить кучу
         */
        if (elemCount == 0) {
            return null;
        }

        Key minValue = elementData[0];
        if (elemCount == 1) {
            elementData[0] = null;
            elemCount--;
            return minValue;
        }
        elementData[0] = elementData[elemCount - 1];
        elementData[elemCount - 1] = null;
        elemCount--;
        siftDown();
        if (elemCount * 4 < arraySize) {
            shrink();
        }
        return minValue;
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

    private void siftUp() {
        /**
         * TODO: implement it — O(log n)
         * Просеивание вверх —
         *  подъём элемента больше родителей
         */
        int parentIndex;
        Key tmp;
        int nodeIndex = elemCount;
        while (nodeIndex != 0) {
            parentIndex = getParentIndex(nodeIndex);
            if (comparator.compare(elementData[parentIndex], elementData[nodeIndex]) > 0) {
                tmp = elementData[parentIndex];
                elementData[parentIndex] = elementData[nodeIndex];
                elementData[nodeIndex] = tmp;
            }
            nodeIndex = parentIndex;
        }
    }

    private void siftDown() {
        /**
         * TODO: implement it — O(log n)
         * Просеивание вниз
         *  спуск элемента меньше детей
         */
        int left, right, minIndex, nodeIndex;
        Key tmp;
        nodeIndex = 0;
        minIndex = nodeIndex;
        while (minIndex <= elemCount - 1) {
            left = 2 * nodeIndex + 1;
            right = 2 * nodeIndex + 2;
            if (right >= elemCount) {
                if (left >= elemCount) {
                    return;
                } else {
                    minIndex = left;
                }
            } else {
                if (comparator.compare(elementData[left], elementData[right]) <= 0) {
                    minIndex = left;
                } else {
                    minIndex = right;
                }
            }
            if (comparator.compare(elementData[nodeIndex], elementData[minIndex]) > 0) {
                tmp = elementData[minIndex];
                elementData[minIndex] = elementData[nodeIndex];
                elementData[nodeIndex] = tmp;
                nodeIndex = minIndex;
            } else {
                return;
            }
        }
    }

    private int getParentIndex(int nodeIndex) {
        if (nodeIndex % 2 == 0) {
            return (nodeIndex - 2) / 2;
        } else {
            return (nodeIndex - 1) / 2;
        }
    }

    private void grow() {
        /**
         * TODO: implement it
         * Если массив заполнился,
         * то увеличить его размер в полтора раз
         */
        Key[] newArray = (Key[]) new Comparable[(int) (arraySize * 1.5)];
        System.arraycopy(elementData, 0, newArray, 0, elementData.length);
        elementData = newArray;
        arraySize = elementData.length;

    }

    private void shrink() {
        /**
         * TODO: implement it
         * Если количество элементов в четыре раза меньше,
         * то уменьшить его размер в два раза
         */
        Key[] newArray = (Key[]) new Comparable[(int) (arraySize / 2)];
        System.arraycopy(elementData, 0, newArray, 0, elemCount);
        elementData = newArray;
        arraySize = elementData.length;
    }

    private boolean greater(int i, int j) {
        return comparator == null
                ? elementData[i].compareTo(elementData[j]) > 0
                : comparator.compare(elementData[i], elementData[j]) > 0
                ;
    }

    private int currElem = 0;

    @Override
    public Iterator<Key> iterator() {
        /* TODO: implement it */
        return new Iterator<Key>() {
            @Override
            public boolean hasNext() {
                return currElem < elemCount;
            }

            @Override
            public Key next() {
                if(currElem>=elemCount) throw new NoSuchElementException();
                return elementData[currElem++];
            }
        };
    }
}
