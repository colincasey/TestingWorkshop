package basics;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void should_be_able_to_add_two_numbers() throws Exception {
        assertThat(calculator.add(2, 1), is(3));
    }

    @Test
    public void should_be_able_to_subtract_two_numbers() throws Exception {
        assertThat(calculator.subtract(2, 1), is(1));
    }

    @Test
    public void should_be_able_to_multiply_two_numbers() throws Exception {
        assertThat(calculator.multiply(2, 2), is(4));
    }

    @Test
    public void should_be_able_to_divide_two_numbers() throws Exception {
        assertThat(calculator.divide(1, 2), is(0.5));
    }
}
