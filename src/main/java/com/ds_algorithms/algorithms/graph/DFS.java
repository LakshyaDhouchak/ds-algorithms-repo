package com.ds_algorithms.algorithms.graph;

import java.util.ArrayList;

/*
 * Implementation of Depth-First Search
 * 
 * Key points:
 * - Uses recursion
 * - Works for both directed and undirected graphs
 * - Uses visited[] (boolean array) to avoid cycles
 * 
 * Time Complexity: O(V + E)

 */
public class DFS {
    // define the properties
    private ArrayList<ArrayList<Integer>> adjList;
    private int numvertices;
    private boolean isDirected;

    // define the constructor
    public DFS(int numvertices,boolean isDirected){
        this.numvertices =  numvertices;
        this.adjList = new ArrayList<>();
        this.isDirected = isDirected;

        // define the for-loop
        for(int i = 0;i<numvertices;i++){
            adjList.add(new ArrayList<>());
        }
    }

    // define the addEdges() methord
    public void addEdges(int source, int dest){
        adjList.get(source).add(dest);
        // define the condition
        if(!isDirected){
            adjList.get(dest).add(source);
        }
    }

    // define the dfsUtil() methord
    public void dfsUtil(int vertex,boolean[] visited){
        // define the condition
        visited[vertex] = true;
        System.out.print(vertex+" ");
        // define the for-loop
        for(int num: adjList.get(vertex)){
            // define the condition
            if(!visited[num]){
                dfsUtil(num, visited);
            }
        }
    }

    // define the dfs() methord
    public void dfs(int startVertices){
        System.out.println("The vertex present in graph is:");
        // define the boolean array 
        boolean[] visited =  new boolean[numvertices];
        dfsUtil(startVertices,visited);
    }
}
