package com.ds_algorithms.queue;

/*
 * Implementation of Queue data structure
 * 
 * Key Points:
 * - Queue follows First In First Out (FIFO) principle.
 * - This implementation is variable in size (dynamic).
 * - We have implemented Queue using double LinkedList.
 * 
 * Time Complexity:
 * - EnQueue : O(1)
 * - Display : O(n)
 * - Dequeue/peek : O(1)
 * - isEmpty : O(1)
 */

public class SimpleQueue {

    // define the static class Node
    static class Node{
        // define the properties
        int data;
        Node next;
        Node prev;
        // define the constructor
        public Node(int data){
            this.data =  data;
            this.next = null;
            this.prev = null;
        }
    }
    // define the properties
    Node front = null;
    Node rear = null;

    // define the Enqueue() methord
    /*
     * Inside this methord i have created a feature where we inserted data in Queue based
     * on FIFO(First In First Out) principle.
     */
    public void Enqueue(int data){
        // calling the Node class
        Node node =  new Node(data);
        // define the condition
        if(front == null && rear == null){
            front = node;
            rear = node;
        }
        else{
            rear.next = node;
            node.prev = rear;
            rear = node;
        }
    }

    // define the display() methord
    /*
     * Inside this methord i have created a feature where we display all element 
     * present in queue.
     */
    public void display(){
        // define the properties
        Node duplicate = front;
        // define the condition
        if(front == null && rear == null){
            System.out.println("SORRY!! Queue is Empty");
        }
        else{
            // define the while loop
            System.out.println(" The element present in Queue is:");
            while(duplicate!=null){
                System.out.print(duplicate.data+" ");
                duplicate = duplicate.next;
            }
            System.out.println();
        }
    }


    // define the IsEmpty() methord
    /*
     * Inside this methord i have created a feature where we check queue is Empty or not.
     */
    public boolean isEmpty(){
        // define the condition
        if(front == null  && rear == null){
            System.out.println("Queue is Empty");
            return true;
        }
        else{
            System.out.println("SORRY!! Queue is not Empty");
            return false;
        }
    }

    // define the Dequeue() methord
    /*
     * Inside this methord i have created a feature where we remove the starting element from the 
     * Queue.
     */
    public int Dequeue(){
        // define the condition
        if(front == null && rear == null){
            System.out.println("SORRY!! Queue is Empty");
            return -1;
        }
        else{
            int data1 = front.data;
            // define the condition
            if(front == rear){
                front = null;
                rear = null;
            }
            else{
                front = front.next;
                front.prev = null;
            }
            return data1;
        }
    }


    // define the peek() methord
    /*
     * Inside this methord i have created a feature where we display the starting element
     * without removing it from the Queue.
     */
    public int peek(){
        // define the condition
        if(front == null && rear == null){
            System.out.println("SORRY!! Queue is Empty");
            return -1;
        }
        else{
            System.out.println("The starting element present in Queue is:"+ front.data);
            return front.data;
        }
    }


}
