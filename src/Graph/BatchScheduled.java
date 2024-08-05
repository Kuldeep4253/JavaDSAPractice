package Graph;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BatchScheduled {
    /*
    A = 7
 B = [1, 6, 7, 2, 9, 4, 5]
 C = [  [1, 2]
        [2, 3]
       `[5, 6]
        [5, 7]  ]
 D = 12
 Output 1:
 2
 Initial Batches :
    Batch 1 = {1, 2, 3} Batch Strength = 1 + 6 + 7 = 14
    Batch 2 = {4} Batch Strength = 2
    Batch 3 = {5, 6, 7} Batch Strength = 9 + 4 + 5 = 18
    Selected Batches are Batch 1 and Batch 2.
A students applied for admission in IB Academy. An array of integers B is given representing the strengths of A people i.e.
 B[i] represents the strength of ith student.
Among the A students some of them knew each other. A matrix C of size M x 2 is given which
represents relations where ith relations depicts that C[i][0] and C[i][1] knew each other.
All students who know each other are placed in one batch.
Strength of a batch is equal to sum of the strength of all the students in it.
Now the number of batches are formed are very much, it is impossible for IB to handle them. So IB set
criteria for selection: All those batches having strength at least D are selected.
Find the number of batches selected.
NOTE: If student x and student y know each other, student y and z know each other then student x and
student z will also know each other.
     */

    public int solve(int A, int[] B, int[][] C, int D) {
        ArrayList<ArrayList<Integer>> adj_list=new ArrayList<>();
        boolean[] visited=new boolean[A];
        Arrays.fill(visited,false);
        // Created List of Adjencency list of every node
        for(int i=0;i<A;i++){
            adj_list.add(i,new ArrayList<>());
        }
        // Adding neighbour into the list
        for(int i=0;i<C.length;i++){
            int source=C[i][0];
            int dest=C[i][1];
            adj_list.get(source-1).add(dest-1);
            adj_list.get(dest-1).add(source-1);
        }
        int count=0;
        int connectedComponent=0;
        // Traverse for all the node if graph is not connected
        for(int i=0;i<A;i++){
            if(visited[i]==false){
                connectedComponent++;
                int temp=findWeightConnectedGraph(i,visited,adj_list,B);
                if(temp>=D){
                    System.out.println(temp);
                    count++;
                }
            }
        }
        System.out.println("Number of Not Connected Component :"+connectedComponent);
        return count;
    }

    public int findWeightConnectedGraph(int source, boolean[] visited, ArrayList<ArrayList<Integer>> adj_list,int[] weight){
        visited[source]=true;
        int sum=weight[source];
        LinkedList<Integer> q=new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()){
            int t=q.poll();
            for(int a:adj_list.get(t)){
                if(visited[a]==false){
                    visited[a]=true;
                    sum+=weight[a];
                    q.add(a);
                }
            }
        }
        return sum;
    }

    public static void main (String[] args)
    {
        //int G[][] = {{7,8},{1,2},{0,9},{1,3},{6,7},{0,3},{2,5},{3,8},{4,8}};
        int G[][] = {{1,2},{2,3},{5,6},{6,7}};
        int B[]={1, 6, 7, 2, 9, 4, 5};
        System.out.println(G.length);
        BatchScheduled batchScheduled=new BatchScheduled();
        System.out.println(batchScheduled.solve(7,B,G,12));
    }
}




