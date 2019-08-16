import org.junit.Test;

import static org.junit.Assert.*;

public class IsRotationTest {

    @Test
    public void isRotation() {
        assertTrue(IsRotation.isRotation("a", "a"));
        assertTrue(IsRotation.isRotation("sven", "sven"));
        assertTrue(IsRotation.isRotation("sven", "ensv"));
    }

    @Test
    public void isNotRotation() {
        assertFalse(IsRotation.isRotation("a", "ab"));
        assertFalse(IsRotation.isRotation("sven", "nevs"));
        assertFalse(IsRotation.isRotation("sven", "aaaa"));
    }
}