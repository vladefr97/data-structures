package seminar1.iterators;

import seminar1.collections.Heap;

import java.util.Iterator;

/**
 * Итератор возвращающий последовательность из двух возрастающих итераторов в порядке возрастания
 * first = 1,3,4,5,7
 * second = 0,2,4,6,8
 * result = 0,1,2,3,4,4,5,6,7,8
 * <p>
 * Time = O(k),
 * k — суммарное количество элементов
 */
public class MergingIncreasingIterator implements Iterator<Integer> {


    private IncreasingIterator first;
    private IncreasingIterator second;
    private IteratorElem[] iteratorElems;
    private Heap<IteratorElem> heap;

    //private int step;
    public MergingIncreasingIterator() {
        heap = new Heap<>();
    }


    public MergingIncreasingIterator(IncreasingIterator first, IncreasingIterator second) {
        this.first = first;
        this.second = second;
        iteratorElems = new IteratorElem[2];
        iteratorElems[0] = new IteratorElem(0);
        iteratorElems[1] = new IteratorElem(1);
        heap = new Heap<>();
        /* TODO: implement it */
    }


    @Override
    public boolean hasNext() {

        /* TODO: implement it */

        return !(heap.isEmpty() && !first.hasNext() && !second.hasNext());
    }


    @Override
    public Integer next() {

        if(heap.isEmpty()){
            iteratorElems[0].changeValue(first.next());
            iteratorElems[1].changeValue(second.next());
            heap.insert(iteratorElems[0]);
            heap.insert(iteratorElems[1]);
        }

        IteratorElem temp = heap.extract();
        int value = temp.getValue();
        int iterNumber  = temp.getIteratorNumber();

        switch (iterNumber){
            case 0:
                if(first.hasNext()) {
                    iteratorElems[0].changeValue(first.next());
                    heap.insert(iteratorElems[0]);
                }
                break;
            case 1:
                if(second.hasNext()){
                    iteratorElems[1].changeValue(second.next());
                    heap.insert(iteratorElems[1]);

                }
                break;
        }
        return value;

    }


}



        /* TODO: implement it */



