package ru.job4j.loop;
/**
 *Класс Counter.
 */
public class Counter {
    /**
     * Метод add позволяет вычислить сумму четных чисел от start до finish.
     * @param start первое число
     * @param finish последнее число
     * @return возвращает сумму четных чисел.
     */
    public int add(int start, int finish) {
        int result = 0;
        for ( ; start <= finish; start++) {
            if (start % 2 == 0) {
                result = result + start;
            }
        } return result;
    }
}