package ru.job4j.array;
/**
 * Массив заполнен true или false
 */
public class Check {
    /**
     * Метод mono проверяет элементы массива.
     * @param data массив.
     * @return возвращает true, если все элементы в массиве одинаковые.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int index = 0; index != data.length; index++) {
            if (data[0] != data[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
