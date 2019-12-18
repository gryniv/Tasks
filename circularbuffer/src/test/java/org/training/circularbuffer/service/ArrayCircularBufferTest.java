package org.training.circularbuffer.service;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArrayCircularBufferTest {
    private Buffer<Integer> bufferFull;
    private Buffer<Integer> bufferEmpty;

    @Before
    public void setUp() throws Exception {
        this.bufferEmpty = new ArrayCircularBuffer<>(10);
        this.bufferFull = new ArrayCircularBuffer<>(10);
        bufferFull.put(3);
        bufferFull.put(2);
        bufferFull.put(4);
        bufferFull.put(5);
        bufferFull.put(7);
        bufferFull.put(8);
        bufferFull.put(6);
        bufferFull.put(1);
        bufferFull.put(10);
    }

    @Test
    public void shouldCorrectlyGetFromTail() {
        assertSame(3, bufferFull.get());
        assertSame(2, bufferFull.get());
        assertSame(4, bufferFull.get());
        assertSame(5, bufferFull.get());
        assertSame(7, bufferFull.get());
        assertSame(8, bufferFull.get());
        assertSame(6, bufferFull.get());
        assertSame(1, bufferFull.get());
        assertSame(10, bufferFull.get());
        assertNull(bufferEmpty.get());
    }

    @Test
    public void shouldTransformToObjectArray() {
        Object[] a = bufferFull.toObjectArray();
        assertArrayEquals(bufferFull.toObjectArray(), a);
        Object[] b = bufferEmpty.toObjectArray();
        assertArrayEquals(bufferEmpty.toObjectArray(), b);
    }

    @Test
    public void shouldTransformToArray() {
        Integer[] a = bufferFull.toArray();
        assertArrayEquals(bufferFull.toArray(), a);
        Integer[] b = bufferEmpty.toArray();
        assertArrayEquals(bufferEmpty.toArray(), b);
    }

    @Test
    public void shouldTransformAsList() {
        List<Integer> a = bufferFull.asList();
        assertEquals(bufferFull.asList(), a);
        List<Integer> b = bufferEmpty.asList();
        assertEquals(bufferEmpty.asList(), b);
    }

    @Test
    public void shouldAddAll() {
        Buffer<Integer> bufferAddAll = new ArrayCircularBuffer<>(10);
        Integer[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        bufferAddAll.addAll(Arrays.asList(b));
        assertArrayEquals(bufferAddAll.toArray(), b);
    }

    @Test(expected = NullPointerException.class)
    public void shouldSort() {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        bufferFull.sort(Integer::compareTo);
        assertArrayEquals(a, bufferFull.toArray());
        bufferEmpty.sort(Integer::compareTo);
    }

    @Test
    public void shouldBeEmpty() {
        assertTrue(bufferEmpty.isEmpty());
    }

    @Test
    public void shouldBeNotEmpty() {
        assertFalse(bufferFull.isEmpty());
    }
}