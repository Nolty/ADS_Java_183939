package ru.geekbrains;

public class HomeWorkApp {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
        int missingInt = searchMissingNumber(array);
        System.out.println(missingInt);

        array = new Integer[]{1, 2, 4, 5, 6};
        missingInt = searchMissingNumber(array);
        System.out.println(missingInt);

        array = new Integer[]{};
        missingInt = searchMissingNumber(array);
        System.out.println(missingInt);
    }

    public static int searchMissingNumber(Integer[] array) {
        if (array.length == 0) return 1;

        int min = 0;
        int max = array.length - 1;
        boolean missingNum = true;
        int mid;
        int diff;

        while (min < max) {
            mid = (min + max) / 2;
            diff = array[mid] - array[min];
            if (diff > (mid - min)) {
                if (mid - min == 1)
                    return (array[mid] + array[min]) / 2;
                max = mid;
                missingNum = false;
                continue;
            }

            diff = array[max] - array[mid];
            if (diff > (max - mid)) {
                if (max - mid == 1)
                    return (array[max] + array[mid]) / 2;
                min = mid;
                missingNum = false;
                continue;
            }
            if (missingNum)
                break;
        }

        return -1;
    }
}
