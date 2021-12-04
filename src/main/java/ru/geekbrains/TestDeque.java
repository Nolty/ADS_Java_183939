package ru.geekbrains;

public class TestDeque {
    public static void main(String[] args) {
        Deque<Integer> deque = new DequeImpl<>(5);

        System.out.println(insertRight(deque, 12));
        System.out.println(insertRight(deque, 16));
        System.out.println(insertLeft(deque, 22));
        System.out.println(insertRight(deque, 5));
        System.out.println(insertRight(deque, 1));
        System.out.println(insertRight(deque, 32));
        deque.display();
        System.out.printf("Size Deque: %d\n", deque.size());
        System.out.println();

        System.out.printf("peek front: %d\n", deque.peekFront());

        System.out.printf("remove left: %d\n", removeLeft(deque));
        deque.display();
        System.out.printf("Size Deque: %d\n", deque.size());
        System.out.println();

        System.out.printf("remove left: %d\n", removeLeft(deque));
        deque.display();
        System.out.printf("Size Deque: %d\n", deque.size());
        System.out.println();

        System.out.printf("remove right: %d\n", removeRight(deque));
        deque.display();
        System.out.printf("Size Deque: %d\n", deque.size());
        System.out.println();

        System.out.printf("remove right: %d\n", removeRight(deque));
        deque.display();
        System.out.printf("Size Deque: %d\n", deque.size());
        System.out.println();

        System.out.printf("remove right: %d\n", removeRight(deque));
        deque.display();
        System.out.printf("Size Deque: %d\n", deque.size());
        System.out.println();

        System.out.printf("remove right: %d\n", removeRight(deque));
        deque.display();
        System.out.printf("Size Deque: %d\n", deque.size());
        System.out.println();

        System.out.println(insertRight(deque, 1));
        System.out.println(insertRight(deque, 2));
        deque.display();
        System.out.printf("Size Deque: %d\n", deque.size());
    }

    private static boolean insertRight(Deque<Integer> deque, int num) {
        if (!deque.isFull()) {
            return deque.insertRight(num);
        }
        return false;
    }

    private static boolean insertLeft(Deque<Integer> deque, int num) {
        if (!deque.isFull()) {
            return deque.insertLeft(num);
        }
        return false;
    }

    private static Integer removeRight(Deque<Integer> deque) {
        if (!deque.isEmpty()) {
            return deque.removeRight();
        }

        return null;
    }

    private static Integer removeLeft(Deque<Integer> deque) {
        if (!deque.isEmpty()) {
            return deque.removeLeft();
        }

        return null;
    }
}
