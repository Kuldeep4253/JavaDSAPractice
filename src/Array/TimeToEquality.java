package Array;

public class TimeToEquality {
    public static int solve(int[] A) {
        int time=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            if(max<A[i]){
                max=A[i];
            }
        }
        for(int i=0;i<A.length;i++){
            if(A[i]!=max){
                int temp=max-A[i];
                time +=temp;
            }
        }
        return time;

    }
    public static void main(String...k){
        int[] a={731,349,490,781,271,405,811,181,102,126,866,16,622,492,194,735};
        TimeToEquality timeToEquality=new TimeToEquality();
        System.out.println(timeToEquality.solve(a));
        System.out.println(TimeToEquality.solve(a));
    }
}
