package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

/*

Problem Description
Given a undirected graph having A nodes. A matrix B of size M x 2 is given which represents
the edges such that there is an edge between B[i][0] and B[i][1].

Find whether the given graph is bipartite or not.

A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that
every edge in the graph has one node in A and another node in B

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
 */
public class BipertiteGraph {

    public int solve(int A, int[][] B) {
        int colorArr[] = new int[A];
        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<>();
        for (int i = 0; i < A; ++i) {
            adj_list.add(i, new ArrayList<>());
            colorArr[i] = -1;
        }

        // Create Adj_list
        for (int i = 0; i < B.length; i++) {
            int source = B[i][0];
            int dest = B[i][1];
            adj_list.get(source).add(dest);
            adj_list.get(dest).add(source);
        }
        int ans=1;
        // If any not connected component then Visit all node and verify all coverd
        for (int i = 0; i < B.length; i++) {
            if(colorArr[i]==-1){
                int temp=isBipertite(i,colorArr,adj_list);
                ans=ans*temp;
            }
        }
        return ans;

    }

    public int isBipertite(int source,int[] colorArr,ArrayList<ArrayList<Integer>> adj_list){
        // Assign first color to source
        colorArr[source] = 1;
        // Create a queue (FIFO) of vertex numbers
        // and enqueue source vertex for BFS traversal
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(source);
        // Run while there are vertices in queue (Similar to BFS)
        while (q.size() != 0)
        {
            // Dequeue a vertex from queue
            int u = q.poll();

            // Find all non-colored adjacent vertices
            for (int a:adj_list.get(u))
            {
                // An edge from u to v exists
                // and destination v is not colored
                if (colorArr[a]==-1)
                {
                    // Assign alternate color to this adjacent v of u
                    colorArr[a] = 1-colorArr[u];
                    q.add(a);
                }

                // An edge from u to v exists and destination
                //  v is colored with same color as u
                else if (colorArr[a]==colorArr[u])
                    return 0;
            }
        }
        return 1;
    }
    // Driver program to test above function
    public static void main (String[] args)
    {
        //int G[][] = {{7,8},{1,2},{0,9},{1,3},{6,7},{0,3},{2,5},{3,8},{4,8}};
        int G[][] = {{0,1},{0,2},{3,4},{3,5},{4,5}};
        System.out.println(G.length);
        BipertiteGraph b = new BipertiteGraph();
        System.out.println(b.solve(10,G));
    }
}
