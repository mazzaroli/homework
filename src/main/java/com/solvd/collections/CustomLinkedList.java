package com.solvd.collections;

import java.util.Comparator;
import java.util.Iterator;

/**
 * CustomLinkedList is a generic implementation of a linked list.
 *
 * @param <T> The type of elements stored in the linked list.
 */
public class CustomLinkedList<T> implements Iterable<T> {

    // Represents the head node of the linked list.
    private Node<T> head;

    // Represents the size of the linked list.
    private int size;

    /**
     * Adds a new element to the linked list.
     *
     * @param data The data to be added to the linked list.
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        // If the list is empty, the new node becomes the head.
        if (head == null) {
            head = newNode;
        } else {
            // Traverse to the end of the list and add the new node.
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Sorts the linked list using the provided comparator.
     *
     * @param comparator The comparator used for sorting.
     */
    public void sort(Comparator<T> comparator) {
        if (size > 1) {
            boolean swapped;
            do {
                Node<T> current = head;
                Node<T> previous = null;
                Node<T> next = head.next;
                swapped = false;

                // Iterate through the list and perform bubble sort.
                while (next != null) {
                    if (comparator.compare(current.data, next.data) > 0) {
                        swapped = true;

                        // Adjust pointers to swap nodes.
                        Node<T> nextTemp = next.next;
                        if (previous != null) {
                            previous.next = next;
                        } else {
                            head = next;
                        }
                        next.next = current;
                        current.next = nextTemp;

                        previous = next;
                        next = current.next;
                    } else {
                        previous = current;
                        current = next;
                        next = next.next;
                    }
                }
            } while (swapped);
        }
    }

    /**
     * Returns an iterator for the linked list.
     *
     * @return Iterator for the linked list.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * Represents a node in the linked list.
     *
     * @param <T> The type of data stored in the node.
     */
    private static class Node<T> {
        private final T data;
        private Node<T> next;

        /**
         * Creates a new node with the given data.
         *
         * @param data The data to be stored in the node.
         */
        private Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}