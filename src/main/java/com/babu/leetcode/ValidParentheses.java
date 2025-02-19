package com.babu.leetcode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/">Valid Parentheses</a>
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 *
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 *
 * Output: false
 *
 * Example 4:
 *
 * Input: s = "([])"
 *
 * Output: true
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */

public class ValidParentheses {

    public static boolean isValid(String s) {

        if (s == null || s.isEmpty()) {
            return false;
        }

        Stack<Character> characters = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                characters.push(c);
            } else if ((c == ')' && characters.peek() == '(') || (c == '}' && characters.peek() == '{')
                    || (c == ']' && characters.peek() == '[') ) {
                characters.pop();
            } else {
                return false;
            }
        }

        return characters.isEmpty();

    }

    public static void main(String[] args) {
        String testOne = "()";
        String testTwo = "()[]{}";
        String testThree = "(]";
        String testFour = "([])";
        System.out.println("Given string " + testOne + " is :" + ValidParentheses.isValid(testOne));
        System.out.println("Given string " + testTwo + " is :" + ValidParentheses.isValid(testTwo));
        System.out.println("Given string " + testThree + " is :" + ValidParentheses.isValid(testThree));
        System.out.println("Given string " + testFour + " is :" + ValidParentheses.isValid(testFour));
    }

}
