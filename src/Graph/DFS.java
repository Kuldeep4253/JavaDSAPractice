package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS {

    public void isPathExist(int source,boolean[] visited,ArrayList<ArrayList<Integer>> adj_list){
        visited[source]=true;
        for (int u:adj_list.get(source)
             ) {
            if(visited[u]==false){
                isPathExist(u,visited,adj_list);
            }
        }
    }
    public static void main(String... k) {
        int a = 5;
        int[][] B = {{1, 2},
                {4, 1},
                {2, 4},
                {3, 4},
                {5, 2},
                {1, 3}};
        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=a;i++){
        adj_list.add(i,new ArrayList<>());
        }
        adj_list.get(0).add(0);
        // Creating adjlist and add neighbour node in its parents
        for(int i=0;i<B.length;i++){
            int source=B[i][0];
            int dest=B[i][1];
            adj_list.get(source).add(dest);
        }
        DFS dfs=new DFS();
        boolean[] visited=new boolean[a+1];
        visited[0]=true;
        dfs.isPathExist(1,visited,adj_list);
        if(visited[a]);
    }
}
