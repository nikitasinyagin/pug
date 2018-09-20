package ru.job4j.array;

/**
 * Класс позволяет поместить два отсортированных массива в третий, который тоже сортированный.
 */
public class BubbleSortThree {
    /**
     * Метод sort перебирает элементы двух массивывов и помещает в третий.
     * @param first первый массив.
     * @param second второй массив.
     * @return третий сортрованный массив.
     */
    public int[] sort(int[] first, int[] second) {
        int[] third = new int[first.length + second.length];
        int countA = 0;
        int countB = 0;
        for (int i = 0; i != third.length; i++) {
            if (countA >= first.length) {
                System.arraycopy(second, countB, third, i, second.length - countB);
                break;
            } else if (countB >= second.length) {
                System.arraycopy(first, countA, third, i, first.length - countA);
                break;
            }
            if (first[countA] < second[countB]) {
                third[i] = first[countA++];
            } else {
                third[i] = second[countB++];
            }
        }
        return third;
    }
}
