package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Nikita Sinyagin (mailto:fofanit@gmail.com)
 * @version [#59058]
 * @since 0.1
 */
public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenSubtracOneMinusOneThenZero() {
        Calculator calc = new Calculator();
        calc.subtrac(1D, 1D);
        double result = calc.getResult();
        double expected = 0D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenDivFourDelitTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.div(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenMultipleTwoYmnozshFourThenEight() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 4D);
        double result = calc.getResult();
        double expected = 8D;
        assertThat(result, is(expected));
    }
}
