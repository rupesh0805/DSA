package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class BFS {


    public void bfs(int node1, Queue<Integer> q, ArrayList<ArrayList<Integer>> adj,
                    boolean[] vis, ArrayList<Integer> list){

        q.add(node1);
        vis[node1]=true;

        while(!q.isEmpty()){
            int node = q.poll();
            list.add(node);

            for(int nei : adj.get(node)){
                if(!vis[nei]){
                    q.offer(nei);
                    vis[nei]=true;
                }
            }
        }

    }


    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        ArrayList<Integer> list = new ArrayList<Integer>();

         for(int i=0;i<V;i++){
             if(!vis[i]){
                 bfs(i,q,adj,vis,list);
             }
         }

        return list;
    }
}