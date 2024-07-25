package DynamicPrograming;

import java.util.Arrays;

public class UniquePathsGrid {

    /*
Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids.
Return the total number unique paths from (1, 1) to (n, m).

Note:
1. An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
2. Given Source Point and Destination points are 1-based index.
Input 1:
 A = [
        [0, 0, 0]
        [0, 1, 0]
        [0, 0, 0]
     ]
Input 2:
 A = [
        [0, 0, 0]
        [1, 1, 1]
        [0, 0, 0]
     ]
Example Output
Output 1: 2
Output 2: 0
Example Explanation
Explanation 1:
 Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1), (2, 1), (3, 1), (3, 2), (3, 3)}
 So, the total number of unique paths is 2.
Explanation 2:
 It is not possible to reach (n, m) from (1, 1). So, ans is 0.
     */

    public static int climbStairs(int i,int j) {
        int[][] mem=new int[i][j];
        int[][] tablization=new int[i][j];
        for (int[] e : mem) {
            Arrays.fill(e, -1);
        }
       //return numberWays(i-1,j-1,mem);
        return numberWaysTablization(i,j,tablization);
    }

    public static int numberWays(int i, int j,int[][] mem){
        if(i==0 || j==0){
            return 1;
        }
        if(mem[i][j]!=-1){
            return mem[i][j];
        }
        mem[i][j]=numberWays(i-1,j,mem)+numberWays(i,j-1,mem);
        return mem[i][j];
    }

    public static int numberWaysTablization(int i, int j,int[][] tablization){
       for(int p=0;p<j;p++){
           tablization[0][p]=1;  // store 1 in first column
       }
        for(int p=0;p<j;p++){
            tablization[p][0]=1;  // store 1 in first row
        }

        for(int p=1;p<i;p++){
            for(int q=1;q<j;q++){
                tablization[p][q]=tablization[p-1][q]+tablization[p][q-1];
            }
        }
        return tablization[i-1][j-1];
    }

    public static void main(String...k){
        System.out.println("This is a start here \n"+climbStairs(3,3));

    }

}
