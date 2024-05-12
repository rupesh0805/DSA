package Graph;


/*
If adj!=parent && vis[adj] --> cycle
 */

import java.util.ArrayList;

class CycleInUndirectedGraph {


    public boolean dfs(int node, int parent,boolean[] vis,
                       ArrayList<ArrayList<Integer>> adjList){

        vis[node]=true;

        for(int adj : adjList.get(node)){
            if(!vis[adj]){
                if(dfs(adj,node,vis,adjList)){
                    return true;
                }
            }
            else if(adj!=parent && vis[adj]){
                return true;
            }
        }

        return false;

    }


    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        boolean[] vis = new boolean[V];

        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i,-1,vis,adj)){
                    return true;
                }
            }
        }
        return false;

    }
}
