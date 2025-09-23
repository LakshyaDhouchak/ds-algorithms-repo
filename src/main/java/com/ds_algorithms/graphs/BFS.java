package com.ds_algorithms.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Implementation of Breath-First Search
 * 
 * Key points:
 * - Iterative using Queue
 * - Works for both directed and undirected graphs
 * - Uses visited[] (boolean array) to avoid cycles
 * 
 * Time Complexity: O(V + E)

 */
public class BFS {
    // define the properties
    private ArrayList<ArrayList<Integer>> adjList;
    private int numvertices;
    private boolean isDirected;

    // define the constructor
    public BFS(int numvertices, boolean isDirected){
        this.numvertices = numvertices;
        this.isDirected = isDirected;
        this.adjList =  new ArrayList<>();

        // define the for-loop
        for(int i = 0;i<numvertices;i++){
            adjList.add(new ArrayList<>());
        }
    }

    // define the addEdges() methord
    public void addEdge(int source,int dest){
        adjList.get(source).add(dest);
        // define the condition
        if(!isDirected){
            adjList.get(dest).add(source);
        }
    }

    // define the bfs() methord
    public void bfs(int vertex){
        System.out.println("The vertex present in graph is:");
        // define the Queue() 
        boolean[] visited = new boolean[numvertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[vertex] = true;
        queue.add(vertex);

        // define the while loop
        while(!queue.isEmpty()){
            int elem = queue.poll();
            System.out.print(elem+" ");

            // define the for-loop
            for(int num : adjList.get(elem)){
                // define the condition
                if(!visited[num]){
                    visited[num] = true;
                    queue.add(num);
                }
            }

        }
    }

}
