package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
    public int[] solve(int A, int[][] B, int C) {
        // Create Distance Array
        int dist[]=new int[A];
        // Create Adj list
        ArrayList<ArrayList<Pairing>> adj_list=new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adj_list.add(new ArrayList<>());
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        // create Adj List for graph
        for (int i = 0; i < B.length; i++) {
            int source = B[i][0];
            int dest = B[i][1];
            int weight=B[i][2];
            adj_list.get(source).add(new Pairing(weight,dest));
            adj_list.get(dest).add(new Pairing(weight,source));
        }
        return dijkistra(C,dist,adj_list);
    }

    private int[] dijkistra(int source, int[] dist, ArrayList<ArrayList<Pairing>> adjList) {
        dist[source]=0;
        PriorityQueue<Pairing> mp = new PriorityQueue<>(new Comparator<Pairing>(){
            public int compare(Pairing a, Pairing b){
                return a.weight - b.weight;
            }
        });
        mp.add(new Pairing(0,source));
        while(!mp.isEmpty()){
            Pairing temp=mp.poll();
            int node=temp.node;
            int dis=temp.weight;
            if(dis<=dist[node]){
                for(Pairing a:adjList.get(node)){
                    int updatedist=dis+a.weight;
                    if(updatedist<dist[a.node]){
                        dist[a.node]=updatedist;
                        mp.add(new Pairing(updatedist,a.node));
                    }
                }
            }
        }
        return dist;
    }
    public static void main(String...k){
        int a= 6;
        int[][] b= {{0, 4, 9},
                {3, 4, 6},
                {1, 2, 1},
                {2, 5, 1},
                {2, 4, 5},
                {0, 3, 7},
                {0, 1, 1},
                {4, 5, 7},
                {0, 5, 1} };
        int c= 4;
        Dijkstra dijkstra=new Dijkstra();
        dijkstra.solve(a,b,c);
    }
}
class Pairing{
    int weight;
    int node;

    public Pairing(int i, int source) {
        this.weight=i;
        this.node=source;
    }
}
