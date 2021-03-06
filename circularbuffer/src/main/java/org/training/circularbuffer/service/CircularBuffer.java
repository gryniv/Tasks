package org.training.circularbuffer.service;

import org.training.circularbuffer.exception.BufferStateException;

import java.util.*;

public class CircularBuffer<T> implements Buffer<T> {

    private final int maxSize;
    private int tail;
    private int head;
    private Object[] buffer;

    public CircularBuffer(int maxSize) {
        this.maxSize = maxSize;
        this.tail = 0;
        this.head = 0;
        this.buffer = new Object[maxSize];
    }

    @Override
    public void put(T o) {
        if (head == tail && !isEmpty()) {
            throw new BufferStateException("Circular buffer is full exception");
        } else if (head == maxSize) {
            head = 0;
        }
        buffer[head++] = o;
    }

    @Override
    public T get() {
        if (head == tail && !isEmpty()) {
            throw new BufferStateException("Circular buffer is empty exception");
        } else if (tail == maxSize) {
            tail = 0;
        }
        return (T) buffer[tail++];
    }

    @Override
    public Object[] toObjectArray() {
        return reverse((T[]) buffer);
    }

    @Override
    public T[] toArray() {
        if (isEmpty()) {
            return null;
        }
        int bufferSize = buffer.length;
        final Class<?> componentType = buffer[0].getClass();
        T[] arrayBuffer = (T[]) java.lang.reflect.Array
                .newInstance(componentType, bufferSize);

        Iterator<Object> it = Arrays.stream(buffer).iterator();
        for (int i = 0; i < arrayBuffer.length; i++) {
            arrayBuffer[i] = (T) it.next();
        }
        return arrayBuffer;

    }

    @Override
    public List<T> asList() {
        return Arrays.asList(reverse((T[]) buffer));
    }

    @Override
    public void addAll(List<? extends T> toAdd) {
        if (maxSize < toAdd.size()) {
            throw new BufferStateException("Not enough free space in the buffer exception");
        }
        for (T a : toAdd) {
            put(a);
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        Arrays.sort((T[]) buffer, comparator);
    }

    @Override
    public boolean isEmpty() {
        for (Object o : buffer) {
            if (o != null) {
                return false;
            }
        }
        return true;
    }

    private T[] reverse(T[] buffer) {
        List<T> bufferReverse = Arrays.asList(buffer);
        Collections.reverse(bufferReverse);
        return bufferReverse.toArray(buffer);
    }
}
