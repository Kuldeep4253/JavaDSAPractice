package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prims {
        public class Pair {
            int weight;
            int node;
            public Pair(int weight,int node){
                this.weight=weight;
                this.node=node;
            }
        }
        public int solve(int A, int[][] B) {
            ArrayList<ArrayList<Pair>> adj=new ArrayList<ArrayList<Pair>>();
            boolean vis[]=new boolean[A+1];
            for(int i=0;i<=A;i++)
            {
                adj.add(new ArrayList<Pair>());
            }
            buildAdjacency(adj,B);
            PriorityQueue<Pair> pq= new PriorityQueue(100,new Comparator<Pair>() {
                public int compare(Pair p1,Pair p2){
                    if(p1.weight<p2.weight) {
                        return -1;
                    } else if(p1.weight>p2.weight) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
//put neighbors of any node to pq here we are adding for first node (nodes are 1 based indexed)
            for(int i=0;i<adj.get(1).size();i++){
                pq.offer(adj.get(1).get(i));
            }
            vis[1]=true;//see
            int minCost=0;
            while(!pq.isEmpty()){
                Pair p=pq.poll();
                if(vis[p.node]){
                    continue;
                }
                minCost+=p.weight;
                vis[p.node]=true;
//traversing neighbors
                for(int i=0;i<adj.get(p.node).size();i++){
                    Pair nbr=adj.get(p.node).get(i);
                    if(!vis[nbr.node]){
                        pq.offer(nbr);
                    }
                }

            }
            return minCost;

        }
        public void buildAdjacency(ArrayList<ArrayList<Pair>>adj,int[][] B)
        {
            for(int i=0;i<B.length;i++)
            {
                adj.get(B[i][0]).add(new Pair(B[i][2],B[i][1]));
                adj.get(B[i][1]).add(new Pair(B[i][2],B[i][0]));
            }
        }
    }
