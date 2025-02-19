package com.babu;

import com.babu.leetcode.ValidParentheses;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for Valid Parentheses.
 */
public class ValidParenthesesTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testValidParentheses() {
        String s = "{[()]}";
        assertTrue(ValidParentheses.isValid(s));
    }

    @Test
    public void testInvalidParentheses() {
        String s = "{[)]}";
        assertFalse(ValidParentheses.isValid(s));
    }
}
