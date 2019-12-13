package org.training.circularbuffer.service;

import java.util.List;

public interface Buffer<T> {

    void put(T t);

    T get();

    Object[] toObjectArray();

    List<T> asList();

    void addAll(List<? extends T> toAdd);

    boolean isEmpty();
}
