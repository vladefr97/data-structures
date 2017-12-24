package seminar1.iterators;

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
    int a , b;
    boolean check = true;
    //private int step;


    public MergingIncreasingIterator(IncreasingIterator first, IncreasingIterator second) {
        this.first = first;
        this.second = second;
        a = first.next();
        b = second.next();


        /* TODO: implement it */
    }

    @Override
    public boolean hasNext() {

        /* TODO: implement it */
        return first.hasNext() || second.hasNext();
    }



    @Override
    public Integer next() {
        int temp;
        if (check) {
            if (a < b) {
                temp = a;
                a = first.next();

            } else {
                temp = b;
                b = second.next();
            }
            check = false;
            return temp;
        }
        if (first.hasNext() && second.hasNext()) {

            if (a < b) {
                temp = a;
                a = first.next();

            } else {
                temp = b;
                b = second.next();

            }
            return temp;

        } else {
            if (first.hasNext()) return first.next();
            else return second.next();
        }

    }



        /* TODO: implement it */


}
