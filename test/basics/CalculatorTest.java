package basics;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void should_be_able_to_add_2_plus_2_using_assertEquals() throws Exception {
        // arrange
        Calculator calculator = new Calculator(); // <-- Calculator is the System Under Test (SUT)
        int expectedValue = 4;

        // act
        int actualValue = calculator.add(2, 2);

        // assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void should_be_able_to_add_2_plus_2_using_assertTrue() throws Exception {
        // arrange
        Calculator calculator = new Calculator(); // <-- Calculator is the System Under Test (SUT)
        int expectedValue = 4;

        // act
        int actualValue = calculator.add(2, 2);

        // assert
        assertTrue(expectedValue == actualValue);
    }

    @Test
    public void should_be_able_to_add_2_plus_2_using_equalTo_matcher() throws Exception {
        // arrange
        Calculator calculator = new Calculator(); // <-- Calculator is the System Under Test (SUT)
        int expectedValue = 4;

        // act
        int actualValue = calculator.add(2, 2);

        // assert
        assertThat(actualValue, equalTo(expectedValue));
    }

    @Test
    public void should_be_able_to_add_2_plus_2_using_is_matcher() throws Exception {
        // arrange
        Calculator calculator = new Calculator(); // <-- Calculator is the System Under Test (SUT)
        int expectedValue = 4;

        // act
        int actualValue = calculator.add(2, 2);

        // assert
        assertThat(actualValue, is(expectedValue));
    }

    @Test
    public void should_be_able_to_subtract_two_numbers() throws Exception {
        fail();
    }

    @Test
    public void should_be_able_to_multiply_two_numbers() throws Exception {
        fail();
    }

    @Test
    public void should_be_able_to_divide_two_numbers() throws Exception {
        fail();
    }
}
