package seminar1.iterators;

import seminar1.collections.Heap;

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
    private int n;
    private PeekingIncreasingIterator[] array;
    private IteratorElem[] iteratorElems;
    private Heap<IteratorElem> heap;

    public MergingPeekingIncreasingIterator() {
        heap = new Heap<>();
    }

    public MergingPeekingIncreasingIterator(IPeekingIterator... peekingIterator) {

        /* TODO: implement it */
        n = peekingIterator.length;
        array = new PeekingIncreasingIterator[n];
        iteratorElems = new IteratorElem[n];
        for (int i = 0; i < n; i++){
            array[i] = (PeekingIncreasingIterator) peekingIterator[i];
            iteratorElems[i] = new IteratorElem(i);
        }
        heap = new Heap<>();
    }

    @Override
    public boolean hasNext() {
        /* TODO: implement it */
        boolean check = false;
        for (PeekingIncreasingIterator peekingIncreasingIterator : array) {
            if (peekingIncreasingIterator.hasNext()) {
                check = true;
                break;
            }
        }
        return !(heap.isEmpty() && !check);
    }


    @Override

    public Integer next() {
        /* TODO: implement it */
        if (heap.isEmpty()) {
            for (int i = 0; i < n; i++) {
                iteratorElems[i].changeValue(array[i].next());
                heap.insert(iteratorElems[i]);
            }
        }
        IteratorElem temp = heap.extract();
        int value = temp.getValue();
        int iterNumber = temp.getIteratorNumber();

        if(array[iterNumber].hasNext()){
            iteratorElems[iterNumber].changeValue(array[iterNumber].next());
            heap.insert(iteratorElems[iterNumber]);
        }

        return value;
    }


}
