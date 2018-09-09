package ru.job4j.array;
/**
 * сортировка массива методом перестановки.
 */
public class BubbleSort {
   public int i;

    /**
     * Метод sort перебирает элементы попарно.
     * @param array исходный массив.
     * @return сортированный массив.
     */
    public int[] sort(int[] array) {
        this.i = 0;

        for (int j = 0; j < array.length; j++) {
            for (int index = 0; index != array.length - this.i - 1; index++) {
                if (array[index] > array[index + 1]) {
                    int k = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = k;
                }

            }
            this.i++;
        }
        return array;
    }
}
