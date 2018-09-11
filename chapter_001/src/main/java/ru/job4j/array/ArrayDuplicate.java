package ru.job4j.array;

import java.util.Arrays;

/**
 * Удаление дубликатов.
 */
public class ArrayDuplicate {
    /**
     * Метод remove находит и удаляет дубликаты из массива.
     *
     * @param array исходный массив.
     * @return возвращает массив с уникальными элементами.
     */
    public String[] remove(String[] array) {
        int copy = array.length;
        for (int i = 0; i < copy; i++) {
            for (int j = i + 1; j < copy; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[copy - 1];
                    copy--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, copy);
    }
}