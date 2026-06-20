package Dsa1;

public class SumSubarrays {


    public static void main(String...k){

        int [] arr={1, 2, 3};
        int sum=0;
        int n=arr.length;
        for(int i=0;i<arr.length;i++){
            int rep=(n-i)*(i+1);
            sum +=rep*arr[i];
        }
        System.out.println(sum);

    }
}
