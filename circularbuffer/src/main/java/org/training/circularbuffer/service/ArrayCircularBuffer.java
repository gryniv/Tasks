package org.training.circularbuffer.service;

import java.lang.reflect.Array;
import java.util.*;

public class ArrayCircularBuffer<T> implements Buffer<T> {

    private int maxSize;
    private int tail;
    private int position;
    private T[] buffer;


    public ArrayCircularBuffer(int maxSize, Class<T> arr) {
        this.maxSize = maxSize;
        this.tail = maxSize - 1;
        this.position = 0;

        buffer = (T[]) Array.newInstance(arr, maxSize);
    }

    public ArrayCircularBuffer(int maxSize) {
        this.maxSize = maxSize;
        this.tail = maxSize - 1;
        this.position = 0;
        this.buffer = (T[]) new Object[maxSize];
    }

    @Override
    public void put(T o) {
        if (position == maxSize) {
            position = 0;
        }
        buffer[position++] = o;
    }

    @Override
    public T get() {
        if (tail <= 0) {
            tail = maxSize - 1;
        }
        tail--;
        while (buffer[tail] == null) {
            tail--;
        }
        return buffer[tail];
    }

    @Override
    public Object[] toObjectArray() {
        return reverse(buffer);
    }

    @Override
    public T[] toArray() {
        int bufferSize = buffer.length;
        T[] r = (T[]) java.lang.reflect.Array
                .newInstance(buffer.getClass().getComponentType(), bufferSize);
        Iterator<T> it = Arrays.stream(buffer).iterator();

        for (int i = 0; i < r.length; i++) {
            r[i] = (T) it.next();
        }
        return r;
    }


    @Override
    public List<T> asList() {
        return Arrays.asList(reverse(buffer));
    }

    @Override
    public void addAll(List<? extends T> toAdd) {
        for (T a : toAdd) {
            put(a);
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        Arrays.sort(buffer, comparator);
    }

    @Override
    public boolean isEmpty() {
        for (T o : buffer) {
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
