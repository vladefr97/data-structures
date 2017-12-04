package seminar1.iterators;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Итератор возвращающий последовательность из N возрастающих итераторов в порядке возрастания
 * first = 1,3,4,5,7
 * second = 0,2,4,6,8
 * result = 0,1,2,3,4,4,5,6,7,8
 * <p>
 * Time = O(n + k * log n),
 * n — количество итераторов
 * k — суммарное количество элементов
 */
public class MergingPeekingIncreasingIterator implements Iterator<Integer> {

    private Comparator<PeekingIncreasingIterator> comparator = (p1, p2) -> p1.peek().compareTo(p2.peek());
    int n;
    int k = 0;
    int curr = 0;
    PeekingIncreasingIterator[] array;
    Integer[] intArray;

    public MergingPeekingIncreasingIterator(IPeekingIterator... peekingIterator) {

        /* TODO: implement it */
        n = peekingIterator.length;
        array = new PeekingIncreasingIterator[n];
        for (int i = 0; i < n; i++) {
            array[i] = (PeekingIncreasingIterator) peekingIterator[i];
            k += array[i].stepLimit;
        }
        getElems();

    }

    @Override
    public boolean hasNext() {
        /* TODO: implement it */
        return curr < k;
    }


    private void getElems() {
        intArray = new Integer[k];
        array[0].peek();
        for (int i = 0; i < n; i++) {
            array[i].peek();
        }
        int index = 0;
        for (; index < intArray.length; ) {
            bubbleSort(array);
            for (int j = 0; j < array.length; j++) {
                if (index == k) {
                    break;
                }
                intArray[index] = array[j].peek();
                index++;
                array[j].next();
                array[j].peek();
            }
        }
        bubbleSort(intArray);
    }


    @Override

    public Integer next() {
        /* TODO: implement it */
        curr++;
        return intArray[curr - 1];
    }

    private void bubbleSort(PeekingIncreasingIterator[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    PeekingIncreasingIterator t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }

    }

    private void bubbleSort(Integer[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }
}
