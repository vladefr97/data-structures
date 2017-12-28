package seminar1.collections;

/**
 * Created by Влад on 28.12.2017.
 */
public class Heap<T extends Comparable<T>> {
    int elemCount = 0;
    int arraySize = 100;
    T[] array = (T[]) (new Comparable[arraySize]);

    public void insert(T x) {
        if (elemCount == arraySize) {
            increaseArray();
        }
        array[elemCount] = x;
        siftUp(elemCount);
        elemCount++;
    }

    public boolean isEmpty() {
        return elemCount == 0;
    }


    public T extract() {

        T minValue = array[0];
        array[0] = array[elemCount - 1];

        elemCount--;
        siftDown(0);
        array[elemCount] = null;
        return minValue;
    }

    private void increaseArray() {
        T[] newArray = (T[]) new Comparable[arraySize * 5];
        for (int i = 0; i < elemCount; i++)
            newArray[i] = array[i];
        array = newArray;
        arraySize = array.length;
    }


    private void siftUp(int nodeIndex) {
        int parentIndex;
        T tmp;
        if (nodeIndex != 0) {
            parentIndex = getParentIndex(nodeIndex);
            if (array[parentIndex].compareTo(array[nodeIndex]) > 0) {
                tmp = array[parentIndex];
                array[parentIndex] = array[nodeIndex];
                array[nodeIndex] = tmp;
                siftUp(parentIndex);
            }
        }
    }

    private void siftDown(int nodeIndex) {
        int left, right, maxIndex;
        T  tmp;
        left = 2 * nodeIndex + 1;

        right = 2 * nodeIndex + 2;

        if (right >= elemCount) {
            if (left >= elemCount) return;
            else maxIndex = left;
        } else {
            if (array[left].compareTo(array[right]) <= 0)
                maxIndex = left;
            else
                maxIndex = right;
        }
        if (array[nodeIndex].compareTo(array[maxIndex]) > 0) {
            tmp = array[maxIndex];
            array[maxIndex] = array[nodeIndex];
            array[nodeIndex] = tmp;
            siftDown(maxIndex);
        }


    }

    private int getParentIndex(int nodeIndex) {
        if (nodeIndex % 2 == 0)
            return (nodeIndex - 2) / 2;
        else return (nodeIndex - 1) / 2;
    }


}