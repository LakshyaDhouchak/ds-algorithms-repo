package com.ds_algorithms.DataStructure.graphs;

/*
 * Graph Implementation of Adjacent Matrix:
 * 
 * Key points:
 * - We implement by using 2-Dim matrix.
 * - It is suitable for dense Graph.
 * - Support both Directed or Undirected Graph. 
 * 
 * Time Complexity:
 * - Add Edge: O(1)
 * - Remove Edge : O(1)
 * - Traversal : O(n)
 * - Check Edge :O(1) 
 */
public class AdjacentMatrix {
    //define the properties
    private int numVertices;
    private int[][] matrix;
    private boolean isDirected;

    // define the constructor
    public AdjacentMatrix(int numVertices,boolean isDirected){
        this.numVertices = numVertices;
        this.matrix = new int[numVertices][numVertices];
        this.isDirected = isDirected;
    }

    // define the addEdges() methord
    public void addEdges(int i,int j){
        addWeightEdges(i,j,1);
    }

    // define the addWeightEdges() methord
    public void addWeightEdges(int i , int j, int data){
        matrix[i][j] = data;
        if(!isDirected){
            matrix[j][i] = data;
        }    
    }

    // define the removeEdges() methord
    public void removeEdges(int i, int j){
        matrix[i][j] = 0;
        if(!isDirected){
            matrix[j][i] = 0;
        }    
    }

    // define the checkEdge() methord
    public boolean checkEdge(int i , int j){
        return matrix[i][j] != 0;
    }

    // define the traversal() methord
    public void traversal(){
        System.out.println("The adjacent matrix is: ");
        // define the for-loop
        for(int i = 0;i<numVertices;i++){
            for(int j = 0;j<numVertices;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    // define the isDegree() methord
    public int[] isDegree(int v){
        // define the condition
        if(!isDirected){
            // define the properties
            int degreeCount = 0;
            // define the for loop
            for(int i = 0;i<numVertices;i++){
                // define the condition
                if(matrix[v][i] != 0){
                    degreeCount++;
                }
            }
            return new int[]{degreeCount};
        }
        else{
            // define the properties
            int indegree = 0;
            int Outdegree = 0;
            // define the for-loop
            for(int i = 0;i<numVertices;i++){
                // define the condition
                if(matrix[v][i] !=0){
                    indegree++;
                }
                if(matrix[i][v] != 0){
                    Outdegree++;
                }
            }
            return new int[]{indegree,Outdegree};
        }
    }
}
