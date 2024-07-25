package Graph;

import java.util.ArrayList;

public class CycleDirectedGraph {
    boolean isCycleExist(int node,boolean[] visit,boolean[] dfsvisit,ArrayList<ArrayList<Integer>> adj_list){
        visit[node]=true;
        dfsvisit[node]=true;
        for (int a:adj_list.get(node)
             ) {
            if(!visit[a]){
                boolean cycleDetect=isCycleExist(a,visit,dfsvisit,adj_list);
                if(cycleDetect) return true;
            } else if (dfsvisit[a]) {
                return true;
            }
        }
        dfsvisit[node]=false;
        return false;
    }

    public static void main(String... k) {
        int a = 2;
        int[][] B = {{1,2},
                };
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
        CycleDirectedGraph cycleDetection=new CycleDirectedGraph();
        boolean[] visited=new boolean[a+1];
        boolean[] dfsvisited=new boolean[a+1];
        visited[0]=true;
        System.out.println(cycleDetection.isCycleExist(1,visited,dfsvisited,adj_list));
    }

}
