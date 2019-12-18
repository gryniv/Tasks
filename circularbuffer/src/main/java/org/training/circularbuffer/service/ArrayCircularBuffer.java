package org.training.circularbuffer.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArrayCircularBuffer<T> implements Buffer<T> {

    private int maxSize;
    private int tail;
    private int position;
    private Object[] buffer;

    public ArrayCircularBuffer(int maxSize) {
        this.maxSize = maxSize;
        this.tail = maxSize - 1;
        this.position = 0;
        this.buffer = new Object[maxSize];
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
        return (T) buffer[tail];
    }

    @Override
    public Object[] toObjectArray() {
        return reverse((T[]) buffer);
    }

    @Override
    public T[] toArray() {
        if (buffer.length != 0) {
            int bufferSize = buffer.length;
            final Class<?> componentType = buffer[0].getClass();
            T[] r = (T[]) java.lang.reflect.Array
                    .newInstance(componentType, bufferSize);
            Iterator<Object> it = Arrays.stream(buffer).iterator();

            for (int i = 0; i < r.length; i++) {
                r[i] = (T) it.next();
            }
            return r;
        } else {
            return (T[]) new Object[0];
        }
    }


    @Override
    public List<T> asList() {
        final T[] buffer = (T[]) this.buffer;
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
        final T[] buffer = (T[]) this.buffer;
        Arrays.sort(buffer, comparator);
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
