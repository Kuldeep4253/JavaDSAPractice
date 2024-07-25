package Recursion;

import java.util.ArrayList;

public class NQueens {
    /*
    Problem Description
The N-queens puzzle is the problem of placing N queens on an N×N chessboard
such that no two queens attack each other.
Given an integer A denoting the value of N, return all distinct solutions to the N-queens puzzle.
Each solution contains a distinct board configuration of the N-queens' placement, where 'Q' and '.'
both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be
in reverse lexicographical order.
     */

    ArrayList<ArrayList<String>> ans;
    public  ArrayList<ArrayList<String>> solveNQueens(int A) {
        ArrayList<ArrayList<String>> queens = new ArrayList<>();
        this.ans = new ArrayList<>();
        for(int i=0;i<A;i++){
            queens.add(i,new ArrayList<>());
        }
        for(int i=0;i<A;i++){
            for(int j=0;j<A;j++){
                queens.get(i).add(".");
            }

        }
        for(int i=0;i<A;i++){
            queens.get(0).remove(i);
            queens.get(0).add(i,"Q");
           if(queensCount(queens,1,0,i)==true){

           }
               queens.get(0).remove(i);
               queens.get(0).add(i,".");
        }
        return ans;
    }

    public  boolean queensCount(ArrayList<ArrayList<String>> queens, int qp, int i,int j){
        if(qp==queens.size()){
            System.out.println("Queen can be seat here!!!!!");
            ans.add(convert(queens));
            return true ;
        }
        for(int c=0;c<queens.size();c++){
            int col=(j+2+c)%queens.size();
            if(isSafePlace(queens,i+1,col)==true){
                queens.get(i+1).remove(col);
                queens.get(i+1).add(col,"Q");
                boolean ans=queensCount(queens,qp+1,i+1,col);
                if(ans==true){
                    queens.get(i+1).remove(col);
                    queens.get(i+1).add(col,".");
                    return true;
                }
                else{
                    queens.get(i+1).remove(col);
                    queens.get(i+1).add(col,".");
                }
            }
        }
        queens.get(i).remove(j);
        queens.get(i).add(j,".");
        return false;
    }
    public boolean isSafePlace(ArrayList<ArrayList<String>> queens,int row,int col){
        int n=queens.size();

        // Row Validation
        for(int i=0;i<n;i++){
            if(i==row){
                continue;
            }
            if(queens.get(i).get(col).equals("Q")){
                return false;
            }
        }

        //Col Validation
        for(int i=0;i<n;i++){
            if(i==col){
                continue;
            }
            if(queens.get(row).get(i).equals("Q")){
                return false;
            }
        }

        // Upper Diagonal Validation
        int indrow=row-1;
        int indcol=col-1;
        while(indrow>=0 && indcol>=0){
            if(queens.get(indrow).get(indcol).equals("Q")){
                return false;
            }
            indrow=indrow-1;
            indcol=indcol-1;
        }

        // Below Diagonal
        indrow=row+1;
        indcol=col+1;
        while(indrow<n && indcol<=n-1){
            if(queens.get(indrow).get(indcol).equals("Q")){
                return false;
            }
            indrow=indrow+1;
            indcol=indcol+1;
        }

        // Anti Upper Diagonal Validation
        indrow=row-1;
        indcol=col+1;
        while(indrow>=0 && indcol<=n-1){
            if(queens.get(indrow).get(indcol).equals("Q")){
                return false;
            }
            indrow=indrow-1;
            indcol=indcol+1;
        }

        // Anti Below Diagonal
        indrow=row+1;
        if(col>0){
            indcol=col-1;
        }
        else{
            indcol=col;
        }

        while(indrow<=n-1 && indcol<=n-1){
            if(queens.get(indrow).get(indcol).equals("Q")){
                return false;
            }
            indrow=indrow+1;
            indcol=indcol+1;
        }
        return true;
    }

    // Convert the board configuration to the required output format
    private ArrayList<String> convert(ArrayList<ArrayList<String>> M) {
        ArrayList<String> temp = new ArrayList<>();
        for (ArrayList<String> str: M) {
            StringBuilder s = new StringBuilder();
            for(int i=0;i<str.size();i++) {
                if (str.get(i).equals(".")) {
                    s.append(".");
                } else {
                    s.append("Q");
                }
            }
            temp.add(s.toString());
        }
        return temp;
    }
    public static void main(String...k){
        NQueens nq=new NQueens();
        System.out.println(nq.solveNQueens(5));
    }
}
