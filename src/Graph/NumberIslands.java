package Graph;

import java.util.ArrayList;

public class NumberIslands {


    int count=0;
    public int solve(int[][] A) {
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j]==1) {isIsland(A,i,j); count+=1;}
            }
        }
        return count;
    }

    public void isIsland(int[][] a,int i,int j){
        if(i<0 || i>=a.length || j<0 || j>=a[0].length || a[i][j]==0 || a[i][j]==2) return;
        a[i][j]=2;
        isIsland(a,i-1,j);   //upper element
        isIsland(a,i+1,j);  //below element
        isIsland(a,i,j-1);   //left side element
        isIsland(a,i,j+1); //right side
        isIsland(a,i-1,j-1);  //right diognal upper element
        isIsland(a,i+1,j-1);  //left diognal below element
        isIsland(a,i-1,j+1);  //left diognal upper element
        isIsland(a,i+1,j+1); //right diognal below element
    }

    public static void main(String...k){
        int[][] temp = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 0}
        };
        NumberIslands numberIslands=new NumberIslands();
        System.out.println(numberIslands.solve(temp));
    }


}
