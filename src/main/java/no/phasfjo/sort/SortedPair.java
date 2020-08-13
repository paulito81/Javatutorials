package no.phasfjo.sort;

public class SortedPair<T extends Comparable<T>> {

    // Not possible to override
    private final T first;
    private final T second;

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    // We use extended comparable
    public SortedPair(T left, T right){
        if(left.compareTo(right) < 0) {
            first = left;
            second = right;
        }
        else{
            first = right;
            second = left;
        }
    }

}
