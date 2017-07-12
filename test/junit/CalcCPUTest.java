package junit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IEvgen Boldyr on 21.06.17.
 */
public class CalcCPUTest {

    @Test
    public void testAdditionCalc() {
        assertEquals(4, CalcCPU.calc(2, '+', 2));
        assertNotEquals(5, CalcCPU.calc(3, '+', 7));
    }

    @Test
    public void testSubtractionCalc() {
        assertEquals(4, CalcCPU.calc(6, '-', 2));
        assertNotEquals(5, CalcCPU.calc(3, '-', 1));
    }

    @Test
    public void testMultiplicationCalc() {
        assertEquals(4, CalcCPU.calc(2, '*', 2));
        assertNotEquals(15, CalcCPU.calc(3, '*', 7));
    }

    @Test
    public void testDivisionCalc() {
        assertEquals(4, CalcCPU.calc(8, '/', 2));
        assertNotEquals(8, CalcCPU.calc(10, '*', 2));
    }

    @Test(expected = ArithmeticException.class)
    public void divByZeroExceptionTest() {
        assertEquals(4, CalcCPU.calc(3, '/', 0));
    }

    @Test(timeout = 1500)
    public void testOptimizeMethod() {
        CalcCPU.method();
    }
}