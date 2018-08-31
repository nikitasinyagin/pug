package ru.job4j.loop;
import java.util.function.BiPredicate;
/**
 * Программа для построения пирамиды в псевдографике.
 */
public class Paint {
    /**
     * Класс rightTrl строит правую сторону треугольника
     * @param height высота треугольника
     * @return
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }
    /**
     * Класс leftTrl строит левую сторону треугольника
     * @param height высота треугольника
     * @return
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }
    /**
     * Класс pyramid строит пирамиду
     * @param height высота пирамиды
     * @return
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}