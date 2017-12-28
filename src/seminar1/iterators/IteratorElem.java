package seminar1.iterators;

/**
 * Created by Влад on 28.12.2017.
 */
public class IteratorElem implements Comparable<IteratorElem> {
    int value;
    int iteratorNumber;

    public IteratorElem(int value, int iteratorNumber) {
        this.value = value;
        this.iteratorNumber = iteratorNumber;
    }

    public IteratorElem() {
    }

    public IteratorElem(int iteratorNumber) {
        this.iteratorNumber = iteratorNumber;
    }

    public void changeValue(int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }

    public int getIteratorNumber() {

        return iteratorNumber;
    }

    @Override
    public int compareTo(IteratorElem o) {
        if (this.value > o.value) return 1;
        else if (this.value == o.value) return 0;
        else return -1;
    }
}
