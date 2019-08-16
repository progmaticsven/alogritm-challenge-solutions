import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class StringHasAllUniqueTest {

    @Test
    public void stringHasAllUnique() {
        assertTrue(StringHasAllUnique.stringHasAllUnique("abcdefgH"));
    }

    @Test
    public void stringHasAllDuplicatesInAnotherCase() {
        assertFalse(StringHasAllUnique.stringHasAllUnique("ABCa"));
    }

    @Test
    public void stringHasAllDuplicates() {
        assertFalse(StringHasAllUnique.stringHasAllUnique("aba"));
    }

    @Test
    public void unicodeCharacterNotEnglishUnique() {
        assertFalse(StringHasAllUnique.stringHasAllUnique("õüöü"));
    }

    @Test
    public void unicodeCharacterNotEnglishNotUnique() {
        assertFalse(StringHasAllUnique.stringHasAllUnique("õÕ"));
    }
}