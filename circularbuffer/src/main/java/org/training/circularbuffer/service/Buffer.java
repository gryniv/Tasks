package org.training.circularbuffer.service;

import java.util.Comparator;
import java.util.List;

public interface Buffer<T> {

    /**
     * @throws RuntimeException if the buffer is full.
     * @apiNote The buffer is full when the head and the tail points
     *          to the same index, but the buffer is not empty.
     * @param t inserts into the buffer at the position of the head
     *          After the insertion, the head points to the next index
     *          in the buffer.
     */
    void put(T t);

    /**
     * @throws RuntimeException if the buffer is empty.
     * @apiNote The buffer is empty if the head and the tail points
     *          to the same index, and the buffer is not full
     * @return the value at the tail of the buffer.
     *         After that, the tail points to the next index in the buffer.
     */
    T get();

    /**
     * @apiNote The size of the array should be equal to the current
     *          number of actual elements in the buffer.
     * @return the buffer as an Object array. First element in Array is tail
     */
    Object[] toObjectArray();

    /**
     * @apiNote The size of the array should be equal to the current
     *          number of actual elements in the buffer.
     * @return  the buffer as a type T array. First element in Array is tail
     */
    T[] toArray();

    /**
     * @apiNote The size of the list equal to the current number of actual
     *          elements in the buffer
     * @return the buffer as a list with type T. First element in Array is tail
     */
    List<T> asList();

    /**
     * @throws Exception if there is not enough free space in the
     *         buffer to add all elements.
     * @param toAdd
     * @return adds all elements from a given list
     */
    void addAll(List<? extends T> toAdd);

    /**
     * @return sort the buffer with the given comparator
     * @param comparator
     */
    void sort(Comparator<? super T> comparator);

    /**
     * @return true if the buffer is empty
     */
    boolean isEmpty();
}
