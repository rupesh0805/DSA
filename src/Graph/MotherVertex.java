package Graph;

/*
Given a Directed Graph, find a Mother Vertex in the Graph (if present).
A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.

Soln:
    Apply DFS and keep track of last node
    Last node is potential MV
    Run again on Last node, and check if it is MV(keep count of vertex visited = V)

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)
 */

import java.util.ArrayList;


public class MotherVertex
{
    //Last Processed Node is a potential answer

    public void dfs(int node,int[] arr,boolean[] vis,ArrayList<ArrayList<Integer>>adj){

        vis[node] = true;
        arr[0]++;

        for(int adjNode : adj.get(node)){
            if(!vis[adjNode]){
                dfs(adjNode,arr,vis,adj);
            }
        }
    }


    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        boolean[] vis = new boolean[V];
        int[] arr = new int[1];
        int lastProcessedi = -1;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                lastProcessedi = i;
                dfs(i,arr,vis,adj);
            }
        }

        arr = new int[1];
        vis = new boolean[V];
        dfs(lastProcessedi,arr,vis,adj);

        return arr[0]==V ? lastProcessedi : -1;

    }
}
