package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.*;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    /**
     * Генерация случайного числа для заявки
     */
    private static final Random RN = new Random();
    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод заменяет ячейку в массиве items
     *
     * @param id   идентификатор заявки
     * @param item заявка
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if ((this.items[i] != null) && (this.items[i].getId().equals(id))) {
                item.setId(id);
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Метод сравнивает параметр name в массиве с параметром key и записывает результат в новый массив
     *
     * @param key
     * @return массив result.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int j = 0;
        for (int i = 0; i != this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                result[j] = this.items[i];
                j++;
            }
        }
        return Arrays.copyOf(result, j);
    }
    /**
     * Метод удаляет элемент массивы с нужным id и сдвигает эллементы справа от него на одну ячейку влево
     *
     * @param id идентификатор заявки
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if ((this.items[i] != null) && (this.items[i].getId().equals(id))) {
                System.arraycopy(this.items, i + 1, this.items, i, this.position - i);
                this.position--;
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Метод реализует поиск заявки по id
     *
     * @param id идентификатор заявки
     * @return item найденая заявка
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
    /**
     * Метод возвращает копию массива items без null элементов
     *
     * @return result новый массив без null элементов
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}