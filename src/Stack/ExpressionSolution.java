package Stack;

import java.util.Stack;

public class ExpressionSolution {
    public static int evalRPN(String[] A) {
        Stack<Integer> st = new Stack<>();
        int op1, op2;
        for (int i = 0; i < A.length; i++) {
            String ch = A[i];
            switch (ch) {
                case "+":
                    op2 = st.pop();
                    op1 = st.pop();
                    st.push(op1 + op2);
                    break;
                case "-":
                    op2 = st.pop();
                    op1 = st.pop();
                    st.push(op1 - op2);
                    break;
                case "*":
                    op2 = st.pop();
                    op1 = st.pop();
                    st.push(op1 * op2);
                    break;
                case "/":
                    op2 = st.pop();
                    op1 = st.pop();
                    st.push(op1 / op2);
                    break;
                default:
                    st.push(Integer.valueOf(ch));
            }


        }
        return st.pop();
    }

    public static void main(String...k){
        String[] A ={"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(A));
    }
}
