package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku {
    ArrayList<ArrayList<Character>> A;
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        this.A=a;
        sudoku(A,0,0,9);
        System.out.println(A);
    }

    public boolean sudoku(ArrayList<ArrayList<Character>> a,int i,int j,int p){
        if(j==9){
            i=i+1;
            j=0;
        }
        if(i==9){
            return true;
        }
        if(a.get(i).get(j)>48 && a.get(i).get(j)<=57){
            boolean ans=sudoku(a,i,j+1,p);
            if(ans==true){
                return true;
            }
        }
        else if(a.get(i).get(j)==48){
            for(int x=49;x<57;x++){
                a.get(i).remove(j);
                a.get(i).add(j, (char) x);
                if(isValidPlace(a,i,j,x)==true){
                    if(sudoku(a,i,j+1,p)==true){
                        return true;
                    }
                }
                a.get(i).remove(j);
                a.get(i).add(j, '0');
            }
        }
        return false;
    }
    public boolean isValidPlace(ArrayList<ArrayList<Character>> a,int row,int col,int x){
        // Check Row
        for(int i=0;i<9;i++){
            if(i==row){
                continue;
            }
            if(a.get(i).get(col)==x){
                return false;
            }
        }
        //Check Col
        for(int i=0;i<9;i++){
            if(i==col){
                continue;
            }
            if(a.get(row).get(i)==x){
                return false;
            }
        }
        //Check 3*3 box if number present or not
        int r=row;
        int c=col;
        row=row-row%3;
        col=col-col%3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(row+i==r && col+j==c){
                    continue;
                }
                if(a.get(row+i).get(col+j)==x){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String...k) {
        Sudoku sd = new Sudoku();
        ArrayList<ArrayList<Character>> ar=new ArrayList<>();
        for (int i = 0; i < 9; i++)
            ar.add(i, new ArrayList<>());
        String[] ip = {"530070000", "600195000", "098000060", "800060003", "400803001", "700020006", "060000280", "000419005", "000080079"};

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < ip[i].toCharArray().length; j++) {
                ar.get(i).add(j,ip[i].charAt(j));
            }
        }
        sd.solveSudoku(ar);
        System.out.println(ar);
    }
}
