package ru.job4j.array;
/**
 * Класс для заполнения массива.
 */
public class Square {
    /**
     * Метод calculate заполняет массив от 1 до bound возведенными в квадрат.
     * @param bound размер массива.
     * @return возвращает заполненный масси rst.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            rst[i] = (i + 1) * (i + 1);
        }
        return rst;
    }
}