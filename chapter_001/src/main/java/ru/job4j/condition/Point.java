package ru.job4j.condition;
/**
 * Класс для расчета расстояния между двумя точками.
 */
public class Point {
    private int x;
    private int y;
    /**
     * Инициализация точки в системе координат.
     * @param x координата по оси Х.
     * @param y координата по оси Y.
     */
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Расчет расстояния между двумя точками.
     * @param that координаты точуи b.
     * @return возвращает результат расчета.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }
    /**
     * Метод main выводит резльтаты расчета на экран.
     * @param args
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        // сделаем вызов метода
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);
        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}