package ru.job4j.calculator;
/**
 * Класс Элементарный калькулятор.
 */
public class Calculator {
    private double result; //поле класса Calculator с переменно result
    /**
     * Метод add.
     * @param first первая переменная.
     * @param second вторая переменная.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     * Метод subtrac метод для вычитания переменных.
     * @param first первая переменная.
     * @param second вторая переменная.
     */
    public void subtrac(double first, double second) {
        this.result = first - second;
    }
    /**
     * Метод div метод для деления переменных.
     * @param first первая переменная.
     * @param second вторая переменная.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     * Метод multiple метод для умножения переменных.
     * @param first первая переменная.
     * @param second вторая переменная.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
    /**
     * Метод getResult возвращает значение переменной result.
     * @return result.
     */
    public double getResult() {
        return this.result;
    }
}
