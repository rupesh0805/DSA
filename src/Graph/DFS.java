package Graph;


import java.util.ArrayList;

class Graph{
    int V;
    ArrayList<ArrayList<Integer>> adjList;

    Graph(int V){
        this.V = V;
        adjList = new ArrayList<>();

        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
}


class DFS {

    public void dfs(int node, boolean[] vis,
                    ArrayList<ArrayList<Integer>> adjList,ArrayList<Integer> list){

        vis[node]=true;
        list.add(node);

        for(int adj : adjList.get(node)){
            if(!vis[adj]){
                dfs(adj,vis,adjList,list);
            }
        }

    }


    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        Graph g = new Graph(V);
        boolean[] vis = new boolean[V];
        ArrayList<Integer> list = new ArrayList<Integer>();

        // for(int i=0;i<adj.size();i++){
        //     g.addEdge(adj.get(i).get(0),adj.get(i).get(1));
        // }

        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis,adj,list);
            }
        }

        return list;

    }
}
