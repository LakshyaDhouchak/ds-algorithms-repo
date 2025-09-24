package com.ds_algorithms.graphs.Mst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.ds_algorithms.graphs.Mst.Prims.Pair;

public class Prims {
    // define the pair class
    static class Pair{
        // define the properties
        int edges;
        int weight;
        // define the constructor
        public Pair(int edges,int weight){
            this.edges = edges;
            this.weight = weight;
        }
    }
    // define the properties
    private ArrayList<ArrayList<Pair>> adjList;
    private int numVertex;

    // define the constructor
    public Prims(int numVertex){
        this.numVertex = numVertex;
        this.adjList =  new ArrayList<>();

        // define the for-loop
        for(int i = 0;i<numVertex;i++){
            adjList.add(new ArrayList<>());
        }
    }

    // define the addEdge() methord
    public void addEdges(int source , int dest, int weight){
        // define the properties
        adjList.get(source).add(new Pair(dest, weight));
        adjList.get(dest).add(new Pair(source, weight));

    }

    // define the prims(Minimum Spanning Tree)
    public int prims(int start){
        // calling the PriorityQueue() methord
        PriorityQueue<Pair> pQueue = new PriorityQueue<>(new Comparator<Pair>() {
            // define the compare() methord
            public int compare(Pair a, Pair b){
                return a.weight-b.weight;
            }
        })

        boolean[] visited = new boolean[numVertex];
        pQueue.add(start,0);
        int minCost = 0;

        //define the while loop
        while(!pQueue.isEmpty()){
            Pair elem = pQueue.poll();
            int u = elem.edges;
            int v = elem.weight;
            // define the condition
            if(visited[u]){
                continue;
            }
            visited[u] = true;
            minCost += v;

            for(int neighbor: adjList.get(u)){
                // define the condition
                if (!visited[neighbor.edges]) {
                    pQueue.add(new Pair(neighbor.edges, neighbor.weight));
                }        
            }
        
        }
    }
}
