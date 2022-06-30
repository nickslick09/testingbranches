package util;

import java.util.Iterator;

public class FixedCircularList<T> implements Iterable<T> {

    private final Object[] circularArray;
    private final int capacity;

    private int currentSize;
    private int index;

    public FixedCircularList(int listSize) {
        index = -1;
        capacity = listSize;
        circularArray = new Object[listSize];
    }

    public int size() {
        return currentSize;
    }

    public void add(T value) {
        index = (index == -1) ? 0 : ((index + 1) % capacity);
        circularArray[index] = value;
        if (currentSize < capacity) {
            currentSize++;
        }
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {

            private int currentIndex = (index + 1) % capacity;

            public boolean hasNext() {
                return (currentIndex < (((index + 1) % capacity) + size()));
            }

            public T next() {
                T data = (T) circularArray[currentIndex % size()];
                currentIndex = (currentIndex + 1);
                return data;
            }
        };
    }
}