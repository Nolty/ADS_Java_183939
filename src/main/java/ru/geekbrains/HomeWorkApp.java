package ru.geekbrains;

import java.util.Iterator;

public class HomeWorkApp {

    public static void main(String[] args) {
        // testLinkedList();
        // testLinkedListIterator();
        testLinkedDeque();
    }

    private static void testLinkedDeque() {
        LinkedDeque<Integer> linkedDeque = new LinkedDeque<>();

        linkedDeque.insertRight(1);
        linkedDeque.insertRight(2);
        linkedDeque.insertRight(3);
        linkedDeque.insertRight(4);
        linkedDeque.insertRight(5);
        linkedDeque.insertRight(6);
        linkedDeque.insertRight(7);
        linkedDeque.insertRight(8);
        linkedDeque.insertLeft(9);
        linkedDeque.insertLeft(10);
        linkedDeque.insertLeft(11);

        linkedDeque.display();

        linkedDeque.removeRight();
        linkedDeque.removeLeft();
        linkedDeque.display();
    }

    private static void testLinkedListIterator() {
        SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);

        linkedList.display();

        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value <= 3) {
                iterator.remove();
                System.out.printf("item %d removed\n", value);
                continue;
            }
            System.out.println(value);
        }

        linkedList.display();
    }

    private static void testLinkedList() {
        /*SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();*/
        TwoSideLinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);
        linkedList.insertLast(9);
        linkedList.insertLast(10);
        linkedList.insertLast(11);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));

        linkedList.removeFirst();
        linkedList.remove(4);

        linkedList.display();
    }
}
