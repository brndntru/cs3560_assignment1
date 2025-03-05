import java.util.*;

public class validParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); // creates stack to store and track expected closed brackets

        // iterates through each character to check validity of parentheses
        for (char c : s.toCharArray()) {
            // if open bracket, push corresponding close bracket onto stack
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            // if close bracket, check if matches top of stack
            else if (stack.isEmpty() || stack.pop() != c)
                return false; // returns false if doesn't match or stack is empty
        }
        return stack.isEmpty();
    }
}
