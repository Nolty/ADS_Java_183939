package ru.geekbrains.sort;

import java.util.List;

public class QuickSort {
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private static <T extends Comparable<? super T>> void quickSort(List<T> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    private static <T extends Comparable<? super T>> int partition(List<T> list, int low, int high) {
        T pivotValue = list.get(high);
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (list.get(j).compareTo(pivotValue) < 0) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, high);
        return (i + 1);
    }

    private static <T> void swap(List<T> list, int firstIndex, int secondIndex) {
        list.set(firstIndex, list.set(secondIndex, list.get(firstIndex)));
    }
}
