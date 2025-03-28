package BlindLeetCode75;

import java.util.Stack;

public class LongestValidParentheses {
    /**
     * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.
     * Example 1:
     * Input: s = "(()"
     * Output: 2
     * Explanation: The longest valid parentheses substring is "()".
     * Example 2:
     * Input: s = ")()())"
     * Output: 4
     * Explanation: The longest valid parentheses substring is "()()".
     * Example 3:
     * Input: s = ""
     * Output: 0
     *
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);  // Initialize the stack with -1 for handling edge case
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(') {
                // Push the index of '(' onto the stack.
                st.push(i);
            } else {
                // Pop the index of the last unmatched '('.
                st.pop();

                // If the stack is empty, push the current index as the base for future valid parentheses.
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    // Calculate the length of the valid parentheses substring.
                    maxLength = Math.max(maxLength, i - st.peek());
                }
            }
        }

        return maxLength;
    }

    public static void main(String...k){
        LongestValidParentheses longestValidParentheses=new LongestValidParentheses();
        String ip="()(()";
        System.out.println(longestValidParentheses.longestValidParentheses(ip));
    }


}
