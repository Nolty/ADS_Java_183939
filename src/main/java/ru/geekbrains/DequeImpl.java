package ru.geekbrains;

public class DequeImpl<E> implements Deque<E> {
    protected final Object[] data;
    protected int head;
    protected int tail;

    public DequeImpl(int size) {
        this.data = new Object[size + 1];
        this.head = 0;
        this.tail = 0;
    }

    private int inc(int i) {
        if (++i >= data.length) i = 0;
        return i;
    }

    private int dec(int i) {
        if (--i < 0) i = data.length - 1;
        return i;
    }

    private int sub(int i, int j) {
        if ((i -= j) < 0) i += data.length;
        return i;
    }

    @Override
    public boolean insertLeft(E value) {
        head = dec(head);
        data[head] = value;
        return head != tail;
    }

    @Override
    public boolean insertRight(E value) {
        data[tail] = value;
        tail = inc(tail);
        return head != tail;
    }

    @Override
    public E removeLeft() {
        E value = elementAt(head);
        if (value != null) {
            data[head] = null;
            head = inc(head);
        }
        return value;
    }

    @Override
    public E removeRight() {
        tail = dec(tail);
        E value = elementAt(tail);
        if (value != null)
            data[tail] = null;
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
        return elementAt(head);
    }

    @Override
    public int size() {
        return sub(tail, head);
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return ((head == 0 && tail >= data.length) || head == tail + 1);
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @SuppressWarnings("unchecked")
    private E elementAt(int index) {
        return (E) data[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int index = head;

        while (index != tail) {
            sb.append(data[index]);
            index = inc(index);
            if (index != tail) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
