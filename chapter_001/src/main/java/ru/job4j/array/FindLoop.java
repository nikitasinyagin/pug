package ru.job4j.array;
/**
 * Поиск перебором.
 */
public class FindLoop {
    /**
     * Метод indexOf позволяет определить индекс необходимого жлемента.
     * @param data массив.
     * @param el элемент, индекс которого необходимо определить.
     * @return возвращает индекс.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}