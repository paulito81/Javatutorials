package circular;

import java.io.*;
// A parameter to a class T - can be any javaclass, interface
public class CircularBuffer<T> {
    private T[] buffer;
    private int readCursor = 0;
    private int writeCursor = 0;

    public CircularBuffer(int size){
        buffer = (T[]) new Object[size];
    }

    public boolean offer(T value) {

        if(buffer[writeCursor] != null){
            return false;
        }
        buffer[writeCursor] = value;
        writeCursor = next(writeCursor);

        return true;
    }

    // If the buffer is not null, we will look at the next element to readout
    // we want to read the value once  -then remove it
    public T poll() {
        final T value = buffer[readCursor];
        if(value != null){
            buffer[readCursor] = null;
            readCursor = next(readCursor);
        }
        return value;
    }

    // increment index by +1 that is goes back to zero.
    private int next(int index){
        return (index + 1) % buffer.length;
    }

}
