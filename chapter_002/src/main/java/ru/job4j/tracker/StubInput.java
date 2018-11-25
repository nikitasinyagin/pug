package ru.job4j.tracker;

public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     */
    private final String[] value;

    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове указатель сдвигается на новое число.
     */
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * Метод возвращает значения по порядку для ввода в консоль.
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }
}