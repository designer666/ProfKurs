package junit;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IEvgen Boldyr on 21.06.17.
 */


public class JUnitEx01Test extends Assert {

    @Test
    public void testSumJUnitEx() {
       assertEquals(4, JUnitEx01.sum(2, 2));
    }

    @Test
    public void testNotSumJUnitEx() {
        assertNotEquals(5, JUnitEx01.sum(3, 7));
    }

}