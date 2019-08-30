import static org.junit.Assert.*;

public class PointTest {

    @org.junit.Test
    public void compareTo() {
        assertEquals(-1, new Point(0, 0).compareTo(new Point(0, 10)));
        assertEquals(-1, new Point(0, 0).compareTo(new Point(1, 0)));
        assertEquals(1, new Point(0, 0).compareTo(new Point(0, 0)));
        assertEquals(1, new Point(0, 0).compareTo(new Point(0, -1)));
    }
}