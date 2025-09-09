package com.ds_algorithms.stack;

/*
 * Implementation of Dynamic Stack data structure
 * 
 * Key Points:
 * - Stack follows Last In First Out (LIFO) principle.
 * - This implementation is variable in size (dynamic).
 * - We have implemented Stack using LinkedList.
 * 
 * Time Complexity:
 * - Push : O(1)
 * - Display : O(n)
 * - pop/peek : O(1)
 * - isEmpty : O(1)
 */
public class DynamicStack {
    // define the static node class
    static class Node{
        // define the properties
        int data;
        Node next;
        Node prev;
        // define the constructor
        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    } 

    // define the properties
    Node head = null;
    Node tail = null;

    // define the Push() methord
    public void push(int data){
        // calling the Node class
        Node node =  new Node(data);
        // define the condition
        if(head ==  null && tail == null){
            head = node;
            tail = node;
        }
        else{
            node.prev = tail;
            tail.next = node;
            tail = node;
            
        }
    }

    // define the display() methord
    public void display(){
        // define the condition
        if(head == null && tail == null){
            System.out.println("SORRY!! Stack is empty");
        }
        else{
            // define the properties
            Node duplicate =  head;
            // define the while loop
            while(duplicate!= null){
                System.out.print(duplicate.data+" ");
                duplicate =  duplicate.next;
            }
            System.out.println();
        }
    }

    // define the IsEmpty() methord
    public boolean isEmpty(){
        // define the condition
        if(head == null && tail == null){
            return true;
        }
        return false;
    }

    // define the pop() method
    public int pop() {
        if (head == null && tail == null) {
            System.out.println("SORRY!! Stack is Empty");
            return -1;
        } 
        else {
            int data1 = tail.data;

            // If only one element is left
            if (head == tail) {
                head = null;
                tail = null;
            } 
            else {
                tail = tail.prev;  // move tail one step back
                tail.next = null;  // disconnect the old last node
            }

            System.out.println("The element we are removing from stack is: " + data1);
            return data1;
    }
}


    // define the peek() methord
    public int peek(){
        // define the condition
        if(head == null && tail == null){
            System.out.println("Sorry !! stack is Empty");
            return -1;
        }
        else{
            System.out.println("The last element present in stack is: "+tail.data);
            return tail.data;
        }
    }

}
