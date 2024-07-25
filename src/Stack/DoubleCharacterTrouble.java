package Stack;

import java.util.Stack;

public class DoubleCharacterTrouble {
    public static String solve(String A) {
        Stack<Character> st =new Stack<>();
        for(int i=0;i<A.length();i++) {
            if (!st.empty() && st.peek() == A.charAt(i)) {
                st.pop();
            } else {
                st.push(A.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }


    public static void main(String...k){
        String A ="ab";
        System.out.println(solve(A));
    }
}
