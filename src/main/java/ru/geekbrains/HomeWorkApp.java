package ru.geekbrains;

// 1. Отсортировать массив, состоящий из экземпляров класса Notebook в количестве 10_000 штук.
// Условия для сортировки:
// `1)` по цене. От 500 до 3000 долларов с шагом в 50 если цена равная, то
// `2)` по кол-ву оперативной памяти (от 4 до 24 с шагом 4) если памяти тоже равное количество, то
// `3)` по производителю: Lenuvo > Asos > MacNote > Eser > Xamiou

import ru.geekbrains.sort.InsertionSort;
import ru.geekbrains.sort.MargeSort;
import ru.geekbrains.sort.QuickSort;

import java.util.*;

public class HomeWorkApp {
    private static final Random random = new Random();
    private static Long time;

    public static void main(String[] args) {
        List<Notebook> notebooks = getNotebookList(10_000);

        System.out.print("Collections.sort(): ");
        startTime();
        Collections.sort(notebooks);
        endTime();

        Collections.shuffle(notebooks);

        System.out.print("Сортировка слиянием: ");
        startTime();
        MargeSort.sort(notebooks);
        endTime();

        Collections.shuffle(notebooks);

        System.out.print("Сортировка вставками: ");
        startTime();
        InsertionSort.sort(notebooks);
        endTime();

        Collections.shuffle(notebooks);

        System.out.print("Быстрая сортировка: ");
        startTime();
        QuickSort.sort(notebooks);
        endTime();

        // printNotebooks(notebooks);
    }

    private static List<Notebook> getNotebookList(int size) {
        List<Notebook> notebooks = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            notebooks.add(
                    new Notebook(
                            (random.nextInt(50) + 1 + 10) * 50,
                            (random.nextInt(6) + 1) * 4,
                            Brand.getRandom()
                    )
            );
        }
        return notebooks;
    }

    private static void printNotebooks(List<Notebook> notebooks) {
        for (Notebook notebook : notebooks) {
            System.out.printf(
                    "Price: %d, Memory: %d, Brand: %s\n",
                    notebook.getPrice(),
                    notebook.getMemory(),
                    notebook.getBrand().getValue());
        }
    }

    private static void startTime() {
        time = System.currentTimeMillis();
    }

    private static void endTime() {
        time = System.currentTimeMillis() - time;
        System.out.printf("%dms\n", time);

    }
}
