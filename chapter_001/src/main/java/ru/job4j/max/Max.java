package ru.job4j.max;
/**
 * Класс определяет максимальное число.
 */
public class Max {
    /**
     * Метод возвращает наибольшее число из двух.
     * @param first первое число.
     * @param second второе число.
     * @return результат.
     */
    public int max(int first, int second) {

        return first > second ? first : second;
    }
    /**
     * Метод возвращает наибольшее число из трех.
     * @param first первое число.
     * @param second второе число.
     * @param third третье число.
     * @return результат.
     */
    public int maxOfThree(int first, int second, int third) {

        return this.max(first, this.max(second, third));
    }
}