package ru.job4j.array;

/**
 * сортировка массива методом перестановки.
 */
public class BubbleSort {
    /**
     * Метод sort перебирает элементы попарно.
     *
     * @param array исходный массив.
     * @return сортированный массив.
     */
    public int[] sort(int[] array) {
        int i = 0;

        for (int j = 0; j < array.length; j++) {
            for (int index = 0; index != array.length - i - 1; index++) {
                if (array[index] > array[index + 1]) {
                    int k = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = k;
                }

            }
            i++;
        }
        return array;
    }
}
