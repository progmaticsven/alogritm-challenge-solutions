import org.junit.Test;

import static org.junit.Assert.*;

public class StringCompressionTest {
    @Test
    public void compress() {
        assertEquals("a3", StringCompresson.compress("aaa"));
        assertEquals("a2b1c5a3", StringCompresson.compress("aabcccccaaa"));
    }

    @Test
    public void doNotCompressIfLonger() {
        assertEquals("abc", StringCompresson.compress("abc"));
    }
}