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
    //private int step;
    boolean nextA = true, nextB = true, nextC = false;
    int size = 2;
    int[][] array = new int[size][];
    boolean getTwo = true;


    public MergingIncreasingIterator(IncreasingIterator first, IncreasingIterator second) {
        this.first = first;
        this.second = second;
        array[0] = new int[first.stepLimit];
        array[1] = new int[second.stepLimit];
        int index = 0;
        while (first.hasNext()) {
            array[0][index] = first.next();
            index++;
        }
        index = 0;
        while (second.hasNext()) {
            array[1][index] = second.next();
            index++;
        }

        /* TODO: implement it */
    }

    @Override
    public boolean hasNext() {

        /* TODO: implement it */
        return cur1 < array[0].length || cur2 < array[1].length;
    }

    int cur1 = 0, cur2 = 0;

    @Override


    public Integer next() {
        if (cur1 < array[0].length && cur2 < array[1].length) {
            if (array[0][cur1] <= array[1][cur2]) {
                cur1++;
                return array[0][cur1 - 1];
            } else if (array[0][cur1] > array[1][cur2]) {
                cur2++;
                return array[1][cur2 - 1];
            }
        } else {
            if (cur2 >= array[1].length) {
                if (cur1 < array[0].length) {
                    cur1++;
                    return array[0][cur1 - 1];
                } else {
                    return null;
                }
            } else {
                cur2++;
                return array[1][cur2 - 1];
            }
        }
        return null;

    }



        /* TODO: implement it */


}
