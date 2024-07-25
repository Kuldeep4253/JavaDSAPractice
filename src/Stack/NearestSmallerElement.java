package Stack;


import java.util.Stack;
public class NearestSmallerElement {
    public int[] prevSmaller(int[] A) {
        int n=A.length;
        int[] res= new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<n;i++) {
            while(stk.size() > 0 && stk.peek() >= A[i]){
                stk.pop();
            }
            if(stk.size() >0){
                res[i]=stk.peek();
            }
            else{
                res[i]=-1;
            }
            stk.push(A[i]);
        }
        return res;
    }



    public static void main(String...k){
        int [] a={4, 5, 2, 10, 8};
        NearestSmallerElement nse=new NearestSmallerElement();
        System.out.println(nse.prevSmaller(a));
    }
}
