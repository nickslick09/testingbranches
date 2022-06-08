package two_stack.util;

import java.util.EmptyStackException;
import java.util.Iterator;

public class TwoStack<T> {

    private final int capacity;
    private final Object[] stackArray;

    private int indexOfStack1;
    private int indexOfStack2;

    public TwoStack(int size) {
        capacity = size;
        stackArray = new Object[size];
        indexOfStack1 = -1;
        indexOfStack2 = capacity;
    }

    public int size(StackID id) {
        return (id == StackID.ONE) ? indexOfStack1 + 1 : capacity - indexOfStack2;
    }

    public T push(StackID id, T item) {
        if (isFull(id)) {
            throw new StackSizeFullException();
        }
        if (id == StackID.ONE) {
            stackArray[++indexOfStack1] = item;
        } else {
            stackArray[--indexOfStack2] = item;
        }
        return item;
    }

    public T pop(StackID id) {
        if (isEmpty(id)) {
            throw new EmptyStackException();
        }
        return (id == StackID.ONE) ? (T) stackArray[indexOfStack1--] : (T) stackArray[indexOfStack2++];
    }

    public T peek(StackID id) {
        if (isEmpty(id)) {
            throw new EmptyStackException();
        }
        return (id == StackID.ONE) ? (T) stackArray[indexOfStack1] : (T) stackArray[indexOfStack2];
    }

    public boolean isEmpty(StackID id) {
        return (id == StackID.ONE) ? (indexOfStack1 == -1) : (indexOfStack2 == capacity);
    }

    public Iterator<T> iterator(StackID id) {
        return new Iterator<>() {

            private int currentIndex = (id == StackID.ONE) ? 0 : (capacity - 1);

            public boolean hasNext() {
                return (id == StackID.ONE) ? (currentIndex <= indexOfStack1) : (currentIndex >= indexOfStack2);
            }

            public T next() {
                T data = (T) stackArray[currentIndex];
                currentIndex = (id == StackID.ONE) ? (currentIndex + 1) : (currentIndex - 1);
                return data;
            }
        };
    }

    private boolean isFull(StackID id) {
        return (id == StackID.ONE) ? ((indexOfStack1 + 1) >= indexOfStack2) : (indexOfStack1 >= (indexOfStack2 - 1));
    }
}

