package com.ds_algorithms.graphs;

import java.util.ArrayList;

/*
 * Implementation of Adjacent List
 * 
 * Key points:
 * - we implement by using ArrayList of ArrayLists
 * - it is suitable for sparse graph
 * - we can easily implement both directed and undirected graph
 * 
 * Time Complecity:
 *  - Add Edges: O(1)
 *  - Remove Edges : O(E)
 *  - traversal : O(V+E)
 *  - checkEdges : O(E)
 */
public class AdjacentList {
    // define the properties
    private int numVertices;
    private ArrayList<ArrayList<Integer>> adjList;
    private boolaen isDirected;

    // define the constructor
    public AdjacentList(int numVertices, boolean isDirected){
        this.numVertices = numVertices;
        this.isDirected = isDirected;
        this.adjList =  new ArrayList<>();

        // define the for-loop
        for(int i = 0;i<numVertices;i++ ){
            adjList.add(new ArrayList<>());
        }
    }

    // define the addEdges() methord
    public void addEdges(int source, int dest){
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        
        adjList.get(source).add(dest);
        //define the condition
        if(!isDirected){
            adjList.get(dest).add(source);
        }
    }

    // define the removeEdges() methord
    public void removeEdges(int source, int dest){
        adjList.get(source).remove(dest);
        // define the condition
        if(!isDirected){
            adjList.get(dest).remove(source);
        }
    }

    // define the traversal() methord
    public void traversal(){
        System.out.println("The Adjacent list is:");
        // define the for-loop
        for(int i = 0;i<numVertices;i++){
            System.out.print("Vertices " + i +" ->");
            for(int num : adjList.get(i)){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    // define the checkEdges() methord
    public boolean checkEdge(int source, int dest){
        return adjList.get(source).contains(dest);
    }

    // define the degree() methord
    public int[] degree(int v){
        // define the condition
        if(!isDirected){
            int degree = 0;
            // define the for loop
            for(int i = 0;i<numVertices;i++){
                // define the condition
                if(adjList.get(v).contains(i)){
                    degree++;
                }
            }
            return new int[]{degree};
        }
        else{
            int indegree = 0;
            int Outdegree = 0;
            // define the for loop
            for(int i = 0;i<numVertices;i++){
                // define the condition
                if(adjList.get(v).contains(i)){
                    Outdegree++;
                }
                if(adjList.get(i).contains(v)){
                    indegree++;
                }
            }
            return new int[]{indegree,Outdegree};
        }
    }
}
