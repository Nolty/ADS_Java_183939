package ru.geekbrains.sort;

import java.util.List;

public class InsertionSort {
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T value = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).compareTo(value) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, value);
        }
    }
}
