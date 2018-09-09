package ru.job4j.array;
/**
 * Двухмерный массив.
 */
public class Matrix {
    /**
     * Метод multiple строит двумерный массив.
     * @param size размер массива.
     * @return возвращает масси с заполненными элементами.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }

        return table;
    }
}