package org.training.circularbuffer.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.training.circularbuffer.exception.BufferStateException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class CircularBufferTest {
    private Buffer<Integer> bufferFull;
    private Buffer<Integer> bufferEmpty;
    private Buffer<Integer> bufferAddAll;
    private Integer[] expectedBufferArray;
    private Integer[] tooBigBufferArray;

    @Before
    public void setUp() {
        this.bufferEmpty = new CircularBuffer<>(10);
        this.bufferFull = new CircularBuffer<>(10);
        this.bufferAddAll = new CircularBuffer<>(10);
        this.expectedBufferArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        this.tooBigBufferArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
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
        Object[] fullBufferToObjectArray = bufferFull.toObjectArray();
        assertArrayEquals(bufferFull.toObjectArray(), fullBufferToObjectArray);
        Object[] emptyBufferToObjectArray = bufferEmpty.toObjectArray();
        assertArrayEquals(bufferEmpty.toObjectArray(), emptyBufferToObjectArray);
    }

    @Test
    public void shouldTransformToArray() {
        Integer[] fullBufferToArray = bufferFull.toArray();
        assertArrayEquals(bufferFull.toArray(), fullBufferToArray);
        Integer[] emptyBufferToArray = bufferEmpty.toArray();
        assertArrayEquals(bufferEmpty.toArray(), emptyBufferToArray);
    }

    @Test
    public void shouldTransformAsList() {
        List<Integer> fullBufferToList = bufferFull.asList();
        assertEquals(bufferFull.asList(), fullBufferToList);
        List<Integer> emptyBufferToList = bufferEmpty.asList();
        assertEquals(bufferEmpty.asList(), emptyBufferToList);
    }

    @Test
    public void shouldAddAll() {
        bufferAddAll.addAll(Arrays.asList(expectedBufferArray));

        assertArrayEquals(bufferAddAll.toArray(), expectedBufferArray);
    }

    @Test
    public void shouldThrowExceptionWhenNotEnoughFreeSpace() {
        thrown.expect(BufferStateException.class);
        thrown.expectMessage("Not enough free space in the buffer exception");

        bufferAddAll.addAll(Arrays.asList(tooBigBufferArray));
        assertArrayEquals(bufferAddAll.toArray(), tooBigBufferArray);
    }

    @Test(expected = NullPointerException.class)
    public void shouldSort() {
        bufferFull.sort(Integer::compareTo);
        assertArrayEquals(bufferFull.toArray(), expectedBufferArray);
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