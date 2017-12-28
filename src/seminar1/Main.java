package seminar1;

import com.sun.corba.se.impl.presentation.rmi.IDLTypeException;
import seminar1.collections.*;
import seminar1.iterators.IncreasingIterator;
import seminar1.iterators.MergingIncreasingIterator;
import seminar1.iterators.MergingPeekingIncreasingIterator;
import seminar1.iterators.PeekingIncreasingIterator;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
       /* System.out.println("LinkedStack");
        IStack<Integer> stack = new LinkedStack<>();
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }
//        for (int i : stack) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        for (int i = 0; i < 30; i++) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("LinkedQueue");
        IQueue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
//        for (int i : queue) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        for (int i = 0; i < 30; i++) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("TwoStackQueue");
        queue = new TwoStackQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 30; i++) {
            System.out.print(queue.dequeue() + " ");
        }*/


     /*   CyclicArrayQueue<Integer> cyclicArrayQueue = new CyclicArrayQueue<>(10);
        for (int i = 0; i < 1000; i++) {
            cyclicArrayQueue.enqueue(i);ц
        cyclicArrayQueue.size();
        for (int i = 0; i < 1000; i++) {
            if (i != cyclicArrayQueue.dequeue()) {
                System.out.println("i = " + i);
            }
        }*/
       /* LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        Iterator iterator = queue.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());*/

       /* ArrayPriorityQueue<Integer> queue = new ArrayPriorityQueue<>();
        for(int i = 0; i < 1000; i++)
        {
            queue.add(i);
        }
       Iterator iterator = queue.iterator();

       for(int i  = 0 ;i< 10 ;i++)
            System.out.println(iterator.next());*/
       /* IncreasingIterator it1 = new IncreasingIterator(100, Integer.MAX_VALUE/2, 1);
        IncreasingIterator it2 = new IncreasingIterator(100, Integer.MAX_VALUE/2, 1);*/

        PeekingIncreasingIterator it1 = new PeekingIncreasingIterator(100,Integer.MAX_VALUE/2,1);
        PeekingIncreasingIterator it2 = new PeekingIncreasingIterator(100,Integer.MAX_VALUE/2,1);
        PeekingIncreasingIterator it3 = new PeekingIncreasingIterator(100,Integer.MAX_VALUE/2,1);
        System.out.println("hasNext it1 = true is " + (it1.hasNext() == true));
        System.out.println("hasNext it2 = true is " + (it2.hasNext() == true));
        System.out.println("hasNext it3 = true is " + (it3.hasNext() == true));
        MergingPeekingIncreasingIterator it = new MergingPeekingIncreasingIterator(it1,it2,it3);
        System.out.println("Здесь должно сейчас вывестить хотя бы три значения");
        System.out.println("hasNext it = true is " + (it.hasNext() == true));
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("-- конец вывода -- ");









    }
}
