import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class validParenthesesTest {
    validParentheses vp = new validParentheses();

    // valid test cases
    @Test
    public void testIsValid() {
        assertTrue(vp.isValid("()"));
        assertTrue(vp.isValid("()[]{}"));
    }

    // invalid test cases
    @Test
    public void testIsInValid() {
        assertFalse(vp.isValid("(]"));
        assertFalse(vp.isValid("([)]"));
    }

    // edge test cases
    @Test
    public void testEdges() {
        assertTrue(vp.isValid(""));
        assertFalse(vp.isValid("[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[["));
    }
}
