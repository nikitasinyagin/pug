package ru.job4j.array;
/**
 * Слово начинается с...
 */
public class ArrayChar {
    private char[] data; // поле с массивом.

    public ArrayChar(String line) {
        this.data = line.toCharArray(); // переводим строку в массив символов.
    }
    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int index = 0; index != value.length; index++) {
            if (value[index] != this.data[index]) {
                result = false;
            }
        }
        return result;
    }
}
