package org.training.circularbuffer.service;

public interface Buffer<T> {

    void put(T t);

    T get();

    Object[] toObjectArray();

}
