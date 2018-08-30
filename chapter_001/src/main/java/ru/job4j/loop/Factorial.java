package ru.job4j.loop;
/**
 * Программа вычисляет факториал числа.
 */
public class Factorial {
    /**
     * Метод позволяет вычислить факториал из числа n.
     * @param n
     * @return возвращает результат вычисления.
     */
    public int calc(int n) {
        int result = 1;
        if (n != 0) {
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }
        }
        return result;
    }
}