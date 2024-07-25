package Array;

public class SecondLargest {
    public static void main(String[] args) {
        int A[]={13, 7, 16, 18, 14, 17, 18, 8, 10};
        int firstmax=Integer.MIN_VALUE;
        int secondmax=Integer.MIN_VALUE;
        int len=A.length;
        int div = 1;
        int sum = 0;
        if(A.length==1){
            System.out.println("-1");;
            }
        for(int i=0;i<A.length;i++){
            if(firstmax<A[i]){
                firstmax=A[i];
            }
        }
        System.out.println(firstmax);
        for(int i=0;i<A.length;i++){
            if(secondmax<A[i] && A[i]<firstmax && A[i]!=firstmax){
                secondmax=A[i];
            }
            sum = sum + A[i];
        }
//to handle case when array is like [44,44,44,44,44,44]
        System.out.println(sum);
        div = sum/len;
        System.out.println(div);
        System.out.println(secondmax);
    }
}



