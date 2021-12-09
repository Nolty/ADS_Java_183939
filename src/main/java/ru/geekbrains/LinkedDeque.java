package ru.geekbrains;

import ru.geekbrains.deque.Deque;

public class LinkedDeque<E> implements Deque<E> {
    private final TwoSideLinkedList<E> data;

    public LinkedDeque() {
        this.data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public boolean insertLeft(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E removeLeft() {
        return data.removeFirst();
    }

    @Override
    public E removeRight() {
        E value = data.getLast();
        data.remove(value);
        return value;
    }

    @Override
    public boolean insert(E value) {
        return insertRight(value);
    }

    @Override
    public E remove() {
        return removeRight();
    }

    @Override
    public E peekFront() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        data.display();
    }

    @Override
    public String toString() {
        return "LinkedDeque{" +
                "data=" + data +
                '}';
    }
}
