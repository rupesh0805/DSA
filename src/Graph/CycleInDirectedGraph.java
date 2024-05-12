package Graph;

import java.util.ArrayList;


/*
Check the dfs run of node as well, using dfsvisit
Simpily checking parent won't work, as directed edges are present
if vis[adjNode] && dfsVisit[adjNode] --> cycle present
 */

class CycleInDirectedGraph {
    // Function to detect cycle in a directed graph.


    public boolean dfs(int node,boolean[] vis,boolean[] dfsVisit,
                       ArrayList<ArrayList<Integer>> adj){


        vis[node]=true;
        dfsVisit[node]=true;

        for(int adjNode : adj.get(node)){
            if(!vis[adjNode]){
                boolean ans = dfs(adjNode,vis,dfsVisit,adj);
                if(ans){
                    return true;
                }
            }
            else{
                if(dfsVisit[adjNode]){
                    return true;
                }
            }
        }
        dfsVisit[node]=false;
        return false;

    }


    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here

        boolean[] vis = new boolean[V];
        boolean[] dfsVisit = new boolean[V];

        for(int i=0;i<V;i++){
            if(!vis[i]){
                boolean ans = dfs(i,vis,dfsVisit,adj);
                if(ans){
                    return true;
                }
            }
        }

        return false;
    }
}

/*
Alternate Approach
Intuition
To detect cycles in a directed graph using Kahn's algorithm. Kahn's algorithm is typically used for topological sorting, and if the graph has a cycle, it won't be able to complete the topological sort successfully.

Implementation
Calculate the indegree (number of incoming edges) for each vertex in the graph.
Initialize a queue with vertices having an indegree of 0.
Perform a BFS (Breadth-First Search) traversal using the queue, decrementing the indegree of neighboring vertices and adding them to the queue if their indegree becomes 0.
If the number of vertices traversed during BFS is equal to the total number of vertices in the graph (ans.size() == V), then there is no cycle in the graph. Otherwise, there is a cycle.
 */
