package Array;

public class FindPairSum {

    private static boolean findSumPair(int A[],int k){
      int  ptr1=0;
      int ptr2=A.length-1;
      while(ptr1<ptr2) {

          if (A[ptr1] + A[ptr2] == k) {
              System.out.println("pair index is: (" + ptr1 + "," + ptr2 + ")");
              return true;
          } else if (A[ptr1] + A[ptr2] < k) {
              ptr1++;
          } else if (A[ptr1] + A[ptr2] > k) {
              ptr2--;
          }

      }
      return false;
    }

    public static void main(String [] k){
        int A[]={3,7,8,11,14,19,20};
        System.out.println(findSumPair(A,39));
    }
}
