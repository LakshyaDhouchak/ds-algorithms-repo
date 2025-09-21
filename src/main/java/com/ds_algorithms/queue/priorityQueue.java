package com.ds_algorithms.queue;

/*
 * Implementation of PriorityQueue
 * 
 * KeyPoints:
 * - It is a special type of queue where we rearrange the element present in Queue based on priority.
 * - To implement we use array data structure 
 * 
 * NOTE: 
 * This implementation of Priority Queue uses a Max-Heap built with an array of Node objects.
 *  Each Node stores:

 *  data → the actual element
 *  priority → the priority value (higher number = higher priority).
 * 
 * Time Complexity:
 *  -Insertion (insert) → O(log n)
 *  -Deletion (delete) → O(log n)
 *  -Peek (peek) → O(1)
 *  -isEmpty() → O(1)
 *  -Display() → O(n)
 */
public class priorityQueue {
    // define the Static class
    static class Node{
        // define the properties
        int data;
        int priority;

        // define the constructor
        public Node(int data,int priority){
            this.data = data;
            this.priority = priority;
        }
    }
    // define the properties
    private int size;
    private int capacity;
    private Node[] queue;

    // define the constructor
    public priorityQueue(int initialCapacity){
        this.capacity = initialCapacity;
        this.size = 0;
        this.queue = new Node[initialCapacity];
    }

    // define the swap() methord
    private void swap(int i , int j){
        Node pointer = queue[i];
        queue[i] = queue[j];
        queue[j] = pointer;
    }

    // define the Insert() methord
    public void Insert(int key,int priority){
        // define the condition
        if(size == capacity){
            throw new IllegalStateException("Queue is full!!");
        }
        // calling the Node class
        Node node =  new Node(key,priority);
        queue[size] = node;
        int i = size;
        size++;

        // define the heapify up feature
        while(i>0 && queue[(i-1)/2].priority<queue[i].priority){
            swap(i,(i-1)/2);
            i = (i-1)/2;
        }
    }

    // define the display() methord
    public void display(){
        // define the condition
        if(size<=0){
            throw new IllegalStateException("Queue is Empty");
        }
        System.out.println("The element present in queue is:");
        // define the for-loop
        for(int i = 0;i<size;i++){
            System.out.print(queue[i].data+" ");
        }
        System.out.println();
    }

    // define the isEmpty() methord
    public boolean isEmpty(){
        // define the condition
        if(size<=0 ){
            return true;
        }
        return false;
        
    }

    // define the peek() methord
    public int peek(){
        // define the condition
        if(size<=0 ){
            throw new IllegalStateException("Queue is Empty!!")
        }
        return queue[0].data;
    }


    // define the delete() methord
    public void  delete(){
        // define the condition
        if(size<=0 ){
            throw new IllegalStateException("Queue is Empty");
        }
        int data = queue[0].data;
        queue[0] = queue[size-1];
        size--;
        int i = 0;
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < size && queue[left].priority > queue[largest].priority) {
                largest = left;
            }
            if (right < size && queue[right].priority > queue[largest].priority) {
                largest = right;
            }
            if (largest == i) break; 

            swap(i, largest);
            i = largest;
        }
        
    }

}
