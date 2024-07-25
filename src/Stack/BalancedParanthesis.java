package Stack;

import java.util.Stack;

public class BalancedParanthesis {

    public  static int  solve(String A) {
        Stack<Character> st=new Stack<Character>();
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            switch (ch)
            {
                case '}':
                    if(st.size()>0 && st.peek()=='{'){
                        st.pop();
                    }
                    else{
                        st.push(ch);
                    }
                    break;
                case ')':
                    if( st.size()>0 && st.peek()=='('){
                        st.pop();
                    }
                    else{
                        st.push(ch);
                    }
                    break;
                case ']':
                    if(st.size()>0 && st.peek()=='['){
                        st.pop();
                    }
                    else{
                        st.push(ch);
                    }
                    break;
                default:
                    st.push(ch);
            }

        }
        if(st.size()==0){
            return 1;
        }
        return 0;
    }
    public static void main(String...k){
        String A ="{([])}";
        System.out.println(solve(A));
    }
}
