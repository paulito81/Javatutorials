package no.phasfjo.collections;

import java.util.AbstractList;

public class CustomArrayList<T> extends AbstractList<T> {

    // private T[] values;
    private Object[] values;

    public CustomArrayList(){
        // Case to T
        // values = (T[]) new Object[0];
        values = new Object[0];
    }

    public T get(final int index) {
        //  return values[index];
        return (T) values[index];
    }

    public boolean add(final T o){

        // T[] newValues = (T[]) new Object[size() +1];
        Object[] newValues = new Object[size() + 1];
        /*
            for(int i = 0; i < size(); i ++){
            newValues[i] = values[i];
        }*/
        System.arraycopy(values, 0, newValues, 0, size());
        newValues[size()] = o; //new array copy the old elements in and add
        values = newValues; //copy over new values
        return true;
    }

    public int size() {
        return values.length;
    }
}
