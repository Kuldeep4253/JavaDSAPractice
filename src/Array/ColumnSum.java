package Array;

public class ColumnSum {
     public static int[] solve(int[][] A) {

         int [] columnsum=new int[A.length];

         int length=A.length;
         for(int i=0;i<A.length;i++){
             int sum=0;
             for(int j=0;j<A.length;j++){
                 sum=sum+A[j][i];
             }
             columnsum[i]=sum;
         }
         System.out.println(columnsum);

         return columnsum;

        }

        public static void main(String...k){
         int [][] matrics={{1,2,3,4},{5,6,7,8},{9,2,3,4}};

         solve(matrics);
        }

}
