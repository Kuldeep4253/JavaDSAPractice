package Dsa1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatricsProblem {
    public static int[] columSum(int[][] A) {
        int [] res=new int[A[1].length];
        for(int col=0;col<A[0].length;col++){
            int sum=0;
            for(int row=0;row<A.length;row++){
                sum +=A[row][col];
            }
            res[col]=sum;
        }
        return res;
    }

    public static int mainDiagonalSum(int[][] A){
        int res=0,i=0;
        int len=A.length;
        while( i<len){
            res+=A[i][i];
            i++;
        }
        return res;
    }

    public static int[][] antiDiagonals(int[][] A){

        int n = A.length;
        int m = A[0].length;

        int totalDiagonals = n + m - 1;
        int maxLength = Math.min(n, m); // max length of any diagonal (optional fill length)

        int[][] result = new int[totalDiagonals][maxLength];

        int index = 0;

        // Top half (including main diagonal)
        for (int col = 0; col < m; col++) {
            int i = 0, j = col, k = 0;
            while (i < n && j >= 0) {
                result[index][k++] = A[i][j];
                i++;
                j--;
            }
            while (k < maxLength) result[index][k++] = 0; // fill remaining with 0
            index++;
        }

        // Bottom half (excluding main diagonal)
        for (int row = 1; row < n; row++) {
            int i = row, j = m - 1, k = 0;
            while (i < n && j >= 0) {
                result[index][k++] = A[i][j];
                i++;
                j--;
            }
            while (k < maxLength) result[index][k++] = 0; // fill remaining with 0
            index++;
        }

        return result;
        }
    public static int[][] transposeMatrix(int[][] A){

        int row = A.length;
        int col = A[0].length;
        int[][] result = new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                //00 01 02 --> 00 10 20
                //10 11 12 --> 01 11 21
                //20 21 22 --> 02 12 22
                result[j][i]=A[i][j];
            }
        }

        return result;
    }
    public static void main(String...k){
        int [][] A={{1,2,3,4},{5,6,7,8},{9,2,3,4}};
        int [][] N={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("******************* Column Sum *******************");
        Arrays.stream(columSum(A)).forEach(i-> System.out.println(i));
        System.out.println("******************* Main Diagonal Sum *******************");
        System.out.println(mainDiagonalSum(N));
        System.out.println("******************* Anti Diagonal *******************");
        antiDiagonals(A);
        System.out.println("******************* Transpose Diagonal *******************");
        transposeMatrix(A);
    }
}
