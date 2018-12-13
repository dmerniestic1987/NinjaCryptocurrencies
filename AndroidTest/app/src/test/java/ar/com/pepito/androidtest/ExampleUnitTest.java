package ar.com.pepito.androidtest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void addition_isIncorrect()  {
        assertEquals(4, 2 + 3);
    }

    @Test
    public void testCheckBoolea(){
        assertTrue(System.currentTimeMillis() != 0);
    }
}