import static java.lang.Math.abs;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximumWithoutComparisionTest {
    public static int max(int a, int b) {
        return ((a + b) + abs(a - b)) / 2;
    }

    @Test
    public void testSecondMax(){
        assertEquals(max( 1,2 ), 2);
    }

    @Test
    public void testFirstMax(){
        assertEquals(max( 42,2 ), 42);
    }

    @Test
    public void testEqualMax(){
        assertEquals(max( 42,2 ), 42);
    }
}