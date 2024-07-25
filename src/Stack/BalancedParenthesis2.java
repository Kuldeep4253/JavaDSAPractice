package Stack;

import java.nio.channels.Channel;
import java.util.Stack;

public class BalancedParenthesis2 {
    /*
Given a parentheses string `s` containing only the characters '(' and ')'.
A parentheses string is balanced if:
● Any left parenthesis ( must have a corresponding one consecutive right parenthesis )
● Left parenthesis ( must go before the corresponding one consecutive right parenthesis ).
In other words, we treat "(" as open needing one ")" to close. Your task is to insert the minimum number of
parentheses '(' and/or ')' to make the string balanced and return the minimum number of insertionvs needed.
Input: " ( ( ) ) ) "
Output: 1
Explanation:
The string needs one more '(' at the end to be balanced.

Input: " (( )) "
Output: 0
Explanation:
The string is already balanced.
/*
( insert
( insert
) remove
) remove
) remove  check remove and top is (
(())
()) return 1
(()
(
(
(())  length =4
)))((  -->5
        */
    public static int countParentheses(String s){
        char[] ch=s.toCharArray();
        Stack<Character> st=new Stack<>();
        st.push(ch[0]);
        for(int i=1;i<ch.length;i++){
            if(ch[i]=='(')
            {
                st.push(ch[i]);
            }
            if(ch[i]==')' && st.peek()=='(' )
            {
                st.pop();
            }
            if(ch[i]==')' && st.peek()!='(' && st.size()>0)
            {
                st.push(ch[i]);
            }


        }
        return st.size();
    }
    public static void main(String...k){
        String A ="(()";
        System.out.println(countParentheses(A));

    }
}
