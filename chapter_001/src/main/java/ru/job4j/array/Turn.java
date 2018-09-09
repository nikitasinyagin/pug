package ru.job4j.array;

/**
 * Программа позволяет перевернуть массив.
 */
public class Turn {
    /**
     * Метод turn принимает массив и возвращает его в зеркальном виде.
     * @param array исходный массив.
     * @return перевернуты массив.
     */
    public int[] turn(int[] array) {
            for (int index = 0; index < array.length / 2; index++) {
                int i = array[index];
                array[index] = array[array.length - index - 1];
                array[array.length - index - 1] = i;
            }
        return array;
    }
}