package ru.job4j.max;

/**
 * Класс определяет максимальное число из двух.
 */

public class Max {

    /**
     * Метод возвращает наибольшее число.
     * @param first первое число.
     * @param second второе число.
     * @return результат.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}