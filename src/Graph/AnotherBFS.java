package Graph;

import java.util.*;

/*


Problem Description

Given a weighted undirected graph having A nodes, a source node C and destination node D.

Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.

You are expected to do it in Time Complexity of O(A + M).

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.

A = 6
B = [   [2, 5, 1]
        [1, 3, 1]
        [0, 5, 2]
        [0, 2, 2]
        [1, 4, 1]
        [0, 1, 1] ]
C = 3
D = 2

O/p: 4
 */
public class AnotherBFS {
    static int maxn = 200009;
    static int[] vis = new int[maxn];
    static ArrayList < ArrayList < Integer > > adj;
    public static void graph() {
        adj = new ArrayList < ArrayList < Integer > > (maxn);
        for (int i = 0; i < maxn; i++) {
            vis[i] = 0;
            adj.add(new ArrayList < Integer > ());
        }
    }
    public int solve(int A, int[][] B, int C, int D) {
        graph();
        int n = A;
        for (int[] it: B) {
            int x = it[0];
            int y = it[1];
            int w = it[2];
            if (w == 1) {
                adj.get(x).add(y);
                adj.get(y).add(x);
            } else {
                adj.get(x).add(x + n);
                adj.get(x + n).add(y);
                adj.get(y).add(y + n);
                adj.get(y + n).add(x);
            }
        }
        return bfs(C, D);
    }
    public static int bfs(int source, int destination) {
        vis[source] = 1;
        Queue < Pair > q = new ArrayDeque < Pair > ();
        q.offer(new Pair(source, 0));
        while (q.size() > 0) {
            Pair p = q.poll();
            int x = p.ff;
            int w = p.ss;
            if (x == destination)
                return w;
            for (int v: adj.get(x)) {
                if (vis[v] == 0) {
                    vis[v] = 1;
                    q.offer(new Pair(v, w + 1));
                }
            }
        }
        return -1;
    }
}
class Pair {
    int ff;
    int ss;
    public Pair(int a, int b) {
        this.ff = a;
        this.ss = b;
    }

    public static boolean solve(int A, ArrayList<ArrayList<Integer>> B, int C, int D) {
        ArrayList<ArrayList<Integer>> adj_list=new ArrayList<>();
        for(int i=0;i<A;i++){
            adj_list.add(new ArrayList<>());
        }
        for(int i=0;i<A;i++){
            int source=B.get(i).get(0);
            int dest=B.get(i).get(1);
            //int weight=B.get(i).get(2);
            adj_list.get(source).add(dest);
            adj_list.get(dest).add(source);
        }
        boolean[] visited=new boolean[A];
        HashMap<Integer,Integer> parents_control=new HashMap<>();
        bfs(C,visited,adj_list,parents_control);
        return visited[D];

    }

    public static void bfs(int source, boolean[] visited, ArrayList<ArrayList<Integer>> adj_list,HashMap<Integer,Integer> hs){
        visited[source]=true;
        hs.put(source,-1);
        Queue<Integer> q=new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()){
            int current=q.poll();
            System.out.println(current);
            for(int a:adj_list.get(current)){
                if(visited[a]==false) {
                    hs.put(a,current);
                    visited[a]=true;
                    q.add(a);
                }
            }
        }

    }

    public static void main(String...k){
        ArrayList<ArrayList<Integer>> rs=new ArrayList<>();
        rs.add(new ArrayList<>(){
            {
                add(2);
                add(5);
                add(1);
            }});
        rs.add(new ArrayList<>(){
            {
                add(1);
                add(3);
                add(1);
            }});
        rs.add(new ArrayList<>(){
            {
                add(0);
                add(5);
                add(2);
            }});
        rs.add(new ArrayList<>(){
            {
                add(0);
                add(2);
                add(2);
            }});
        rs.add(new ArrayList<>(){
            {
                add(1);
                add(4);
                add(1);
            }});
        rs.add(new ArrayList<>(){
            {
                add(0);
                add(1);
                add(1);
            }});
        System.out.println(solve(6,rs,3,2));
    }
}
