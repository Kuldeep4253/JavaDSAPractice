package Array;

public class SubArrayPrint {
    public static int[][] solve(int[] A) {

        int len=A.length;
        int subarraysize=(len*(len+1))/2;
        int [][] subarray=new int[subarraysize][subarraysize];

        for(int i=0;i<len;i++){
            int [] temp={A[i]};
            subarray[i]=temp;
            for(int j=i+1;j<len;j++){
               // int [] temp1={,A[j]};
                //subarray[j]=temp1;
            }
        }


        return subarray;
    }

    public static void main(String...k){
        int[] arr = { 1, 2, 3 };
        solve(arr);
    }

}

