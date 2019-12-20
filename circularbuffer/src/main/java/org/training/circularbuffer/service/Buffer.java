package org.training.circularbuffer.service;

import java.util.Comparator;
import java.util.List;

import org.training.circularbuffer.exception.BufferStateException;

public interface Buffer<T> {

    /**
     * @param t inserts into the buffer at the position of the head
     *          After the insertion, the head points to the next index
     *          in the buffer.
     * @throws BufferStateException if the buffer is full.
     * @apiNote The buffer is full when the head and the tail points
     * to the same index, but the buffer is not empty.
     */
    void put(T t);

    /**
     * @return the value at the tail of the buffer.
     * After that, the tail points to the next index in the buffer.
     * @throws BufferStateException if the buffer is empty.
     * @apiNote The buffer is empty if the head and the tail points
     * to the same index, and the buffer is not full
     */
    T get();

    /**
     * @return the buffer as an Object array. First element in Array is tail
     * @apiNote The size of the array should be equal to the current
     * number of actual elements in the buffer.
     */
    Object[] toObjectArray();

    /**
     * @return the buffer as a type T array. First element in Array is tail
     * @apiNote The size of the array should be equal to the current
     * number of actual elements in the buffer.
     */
    T[] toArray();

    /**
     * @return the buffer as a list with type T. First element in Array is tail
     * @apiNote The size of the list equal to the current number of actual
     * elements in the buffer
     */
    List<T> asList();

    /**
     * @param toAdd adds all elements from a given list
     * @throws BufferStateException if there is not enough free space in the
     *                              buffer to add all elements.
     */
    void addAll(List<? extends T> toAdd);

    /**
     * @param comparator
     * @return sort the buffer with the given comparator
     */
    void sort(Comparator<? super T> comparator);

    /**
     * @return true if the buffer is empty
     */
    boolean isEmpty();
}
