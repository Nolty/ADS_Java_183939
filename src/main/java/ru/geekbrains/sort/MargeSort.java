package ru.geekbrains.sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MargeSort {
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        margeSort(list);
    }

    private static <T extends Comparable<? super T>> List<T> margeSort(List<T> list) {
        if (list.size() <= 1) return list;

        int middle = list.size() / 2;
        List<T> left = list.subList(0, middle);
        List<T> right = list.subList(middle, list.size());

        right = margeSort(right);
        left = margeSort(left);

        return merge(left, right);
    }

    private static <T extends Comparable<? super T>> List<T> merge(List<T> left, List<T> right) {
        List<T> result = new ArrayList<>();
        Iterator<T> iteratorLeft = left.iterator();
        Iterator<T> iteratorRight = right.iterator();

        T valueLeft = iteratorLeft.next();
        T valueRight = iteratorRight.next();
        while (true) {
            if (valueLeft.compareTo(valueRight) <= 0) {
                result.add(valueLeft);
                if (iteratorLeft.hasNext()) {
                    valueLeft = iteratorLeft.next();
                } else {
                    result.add(valueRight);
                    while (iteratorRight.hasNext()) {
                        result.add(iteratorRight.next());
                    }
                    break;
                }
            } else {
                result.add(valueRight);
                if (iteratorRight.hasNext()) {
                    valueRight = iteratorRight.next();
                } else {
                    result.add(valueLeft);
                    while (iteratorLeft.hasNext()) {
                        result.add(iteratorLeft.next());
                    }
                    break;
                }
            }
        }
        return result;
    }
}
