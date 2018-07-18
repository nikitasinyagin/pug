package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {
    private int result; //поле класса Converter с переменно result
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        this.result = value / 70;
        return this.result;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        this.result = value / 60;
        return this.result;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value Евро.
     * @return Рубли
     */
    public int euroToRuble(int value) {
        this.result = value * 70;
        return this.result;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value Доллары.
     * @return Рубли
     */
    public int dollarToRuble(int value) {
        this.result = value * 60;
        return this.result;
    }
}