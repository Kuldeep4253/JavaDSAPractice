package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinDaysRotten {
        public int  minDaysRotten(ArrayList<ArrayList<Integer>> A){
            Queue<Triplet> q=new LinkedList<>();
            int col=A.get(0).size()-1;
            int row=A.size()-1;
            for(int i=0;i<=row;i++){
                for(int j=0;j<=col;j++){
                    if(A.get(i).get(j)==2){
                        q.add(new Triplet(i,j,0));
                    }
                }
            }
            int ans=0;
            while(q.size()>0){
                Triplet t=q.remove();
                int x=t.i;
                int j=t.j;
                ans=t.days;
                // Uper element Check if it is 1
                if(x-1>=0 && A.get(x-1).get(j)==1){

                    A.get(x-1).remove(j);
                    A.get(x-1).add(j,2);
                    q.add(new Triplet(x-1,j,ans+1));
                }
                // Lower element Check if it is 1
                if(x+1<=row && A.get(x+1).get(j)==1){
                    A.get(x+1).remove(j);
                    A.get(x+1).add(j,2);
                    q.add(new Triplet(x+1,j,ans+1));
                }
                // Right element Check if it is 1
                if(j+1<=col && A.get(x).get(j+1)==1){
                    A.get(x).remove(j+1);
                    A.get(x).add(j+1,2);
                    q.add(new Triplet(x,j+1,ans+1));
                }
                // Left element Check if it is 1
                if(j-1>=0 && A.get(x).get(j-1)==1){
                    A.get(x).remove(j-1);
                    A.get(x).add(j-1,2);
                    q.add(new Triplet(x,j-1,ans+1));
                }
            }
            for(int i=0;i<=row;i++){
                for(int j=0;j<=col;j++){
                    if(A.get(i).get(j)==1){
                        return -1;
                    }
                }
            }
            return ans;
        }

        public static void main(String...k){
            ArrayList<ArrayList<Integer>> rs=new ArrayList<>();
            rs.add(new ArrayList<>(){
                {
                    add(2);
                    add(1);
                    add(1);
                }});
            rs.add(new ArrayList<>(){
                {
                    add(1);
                    add(1);
                    add(0);
                }});
            rs.add(new ArrayList<>(){
                {
                    add(0);
                    add(1);
                    add(1);
                }});

            MinDaysRotten minDaysRotten=new MinDaysRotten();
            minDaysRotten.minDaysRotten(rs);
        }

    }
    class Triplet{
        int i,j,days;
        public Triplet(int i,int j,int days){
            this.i=i;
            this.j=j;
            this.days=days;
        }
    }
