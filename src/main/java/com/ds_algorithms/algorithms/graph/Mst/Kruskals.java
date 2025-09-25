package com.ds_algorithms.algorithms.graph.Mst;

import java.util.ArrayList;

public class Kruskals {
    // define the static Edges class
    static class Edge{
        // define the properties
        int source;
        int destination;
        int weight;

        // define the constructor
        public Edge(int source,int destination,int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // define the properties
    private int numVertex;
    private ArrayList<Edge> adjEdges;

    // define the constructor
    public Kruskals(int numVertex){
        this.numVertex = numVertex;
        this.adjEdges = new ArrayList<>();
    }

    // define the addEdge() methord
    public void addEdge(int source, int dest, int weight){
        adjEdges.add(new Edge(source, dest, weight));
    }
}
