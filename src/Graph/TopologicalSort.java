package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class TopologicalSort {
    /*
     A = 6
 B = [  [6, 3]
        [6, 1]
        [5, 1]
        [5, 2]
        [3, 4]
        [4, 2] ]
     */
    public static int[] solve(int A, int[][] B) {
        int[] indegree = new int[A+1];
        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adj_list.add(new ArrayList<>());
        }
        Arrays.fill(indegree, 0);
        // create Adj List for graph
        for (int i = 0; i < B.length; i++) {
            int source = B[i][0];
            int dest = B[i][1];
            adj_list.get(source).add(dest);
        }
        // check indegree vertices
        for(int i=1;i<=A;i++){
            for(int a: adj_list.get(i)){
                indegree[a]++;
            }
        }

        // Ading all the starting point of graph which have no indegree edge
        PriorityQueue<Integer> zerodegree=new PriorityQueue<>();
        for(int i=1;i<=A;i++){
           if(indegree[i]==0){
               zerodegree.add(i);
            }
        }
        // Now start the out the zerodrgree
        ArrayList<Integer> result=new ArrayList<>();
        while (!zerodegree.isEmpty()){
            int node=zerodegree.poll();
            result.add(node);
            for(int a:adj_list.get(node)){
                indegree[a]--;
                if(indegree[a]==0){
                    zerodegree.add(a);
                }
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            arr[i] = result.get(i);
        return arr;
    }

    public static void main(String...k){
        int[][] temp={{1,4},{1,2},{4,2},{4,3},{3,2},{5,2},{3,5},{8,2},{8,6}};

        solve(8,temp);
    }
}

