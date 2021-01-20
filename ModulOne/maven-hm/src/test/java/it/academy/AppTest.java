package it.academy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void isTriangleExist() {
        App triangle = new App();
        Boolean actual = triangle.isTriangleExist(3,0,5);
        Boolean expected = false;
        assertEquals(expected, actual);
    }
}
