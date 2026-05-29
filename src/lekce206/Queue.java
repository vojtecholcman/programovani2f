/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce206;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author vojtech.holcman.s
 */
public class Queue<E> implements Deque<E> {

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.addFirst("1");
        q.addFirst("2");
        q.addFirst("3");
        q.addLast("a");
        q.addLast("b");
        q.addLast("c");
        for (Element<String> e = q.first; e != null; e = e.next) {
            System.out.println(e.element);
        }
//        System.out.println(q.first.element);
//        System.out.println(q.first.next.element);
//        System.out.println(q.first.next.next.element);
    }

    private Element<E> first, last;

    private static class Element<E> {

        private final E element;
        private Element<E> prev, next;

        public Element(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

    }

    @Override
    public void addFirst(E e) {
        if (first == null) {
            first = last = new Element<>(e);
        } else {
            first.prev = new Element<>(e);
            first.prev.next = first;
            first = first.prev;
        }
    }

    @Override
    public void addLast(E e) {
        if (last == null) {
            first = last = new Element<>(e);
        } else {
            last.next = new Element<>(e);
            last.next.prev = last;
            last = last.next;
        }
    }

    @Override
    public boolean offerFirst(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean offerLast(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        E val = first.element;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        return val;
    }

    @Override
    public E removeLast() {
        if (last == null) {
            return null;
        }
        E val = last.element;
        last = last.prev;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        return val;
    }

    @Override
    public E pollFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E pollLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E getFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E getLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E peekFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E peekLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offer(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove() {
        return removeLast();
    }

    @Override
    public E poll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E element() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void push(E e) {
        addFirst(e);
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Object o) {
        Element<E> q = first;
        while (q != last) {
            if (q.element == o) {
                return true;
            }
            q = q.next;
        }
        return false;

        // pomoci for-cyklu
//        for (Element<E> q = first; q != null; q = q.next) {
//            if (q.element == o) {
//                return true;
//            }
//        }
//        return false;
    }

    @Override
    public int size() {
        int size = 0;
        for (Element<E> q = first; q != null; q = q.next) {
            size++;
        }
        return size;

    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<E> descendingIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        first = last = null;
    }
}
