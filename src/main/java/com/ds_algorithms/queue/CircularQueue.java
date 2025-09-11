package com.ds_algorithms.queue;

/*
 * Implementation of Circular Queue 
 * 
 * Key points:
 * - Queue follow FIFO(First In First Out) principle.
 * - this implementation is fixed in size (static).
 * - It is useful to resolve the probleum suppose in queue one side we are removing ans another side
 *   we are adding according to logic we can't use removed space but in reality that space is empty
 *   to resolve that issue we use circular Queue.
 * 
 * Time Complexity:
 * - Display: O(n)
 * - IsEmpty: O(1)
 * - Enqueue/Dequeue : O(1)
 * - peek: O(1)
 */
public class CircularQueue {
    // define the properties
    int size;
    int[] arr;
    int front;
    int rear;

    // define the constructor
    public CircularQueue(){
        this.size = 10;
        this.arr =  new int[size];
        this.front = -1;
        this.rear = -1;
    }
    public CircularQueue(int size){
        this.size = size;
        this.arr =  new int[size];
        this.front = -1;
        this.rear = -1;
    }


    // define the enqueue() methord
    /*
     * Inside this methord I have created a feature where we inserted data in Queue to define
     * Queue we use array.
     * Key condition :
     * - when rear == size-1 and front != 0 it means we dont have and space in queue on right side
     *   but in left side we have deleted some element so we can use that space for storing we define rear = 0
     *   and define base condition if(rear == front+1) it means queue is full.
     */
    public void enqueue(int data){
        // define the condition
        if((front == 0 && rear == size-1) || front == rear+1){
            System.out.println("SORRY !! Queue is Full");
            return;
        }
        if(front == -1){
            front = 0;
            rear = 0;
        }
        else if(rear == size-1 && front !=0){
            rear = 0;
        }
        else{
            rear++;
        }
        arr[rear] = data;
        
    }


    // define the deQueue() methord
    /*
     * Inside this methord i have created a feature where i we are deleting element from the 
     * Queue.
     */
    public int dequeue(){
        // define the condition
        if(front == -1 && rear == -1){
            System.out.println("SORRY!! Queue is Empty");
            return -1;
        }
        int element = arr[front];
        if( front == rear){
            front = -1;
            rear = -1;
        }
        else if(front == size-1){
            front = 0;
        }
        else{
            front++;
        }
        return element;
    }


    // define the isFull() methord
    // Inside this methord we are verifying that Queue is Empty or not.
    public boolean isFull(){
        // define the condition
        if((front == 0 && rear == size-1)|| front== rear+1){
            System.out.println("Queue is Full!!");
            return true;
        } 
        else{
            System.out.println("Queue is Empty!!");
            return false;
        }
    }

    // define the isEmpty() methord
    /*
     * Inside this methord i have created a feature where we check weather Queue is Empty or not.
     */
    public boolean isEmpty(){
        // define the condition
        if(front == -1 && rear == -1){
            System.out.println("Queue is Empty!!");
            return true;
        }
        else{
            System.out.println("Queue is not Empty!!");
            return false;
        }
    }

    // define the peek() methord
    /*
     * Inside this methord i have created a feature where we display the starting element
     * present in the Queue.
     */
    public int peek(){
        // define the condition
        if(front  == -1 && rear == -1){
            System.out.println("Queue is Empty!!");
            return -1;
        }
        System.out.println("The starting element present in Queue is:"+ arr[front]);
        return arr[front];
    }

    // define the display() methord
    public void display(){
        // define the condition
        if(front  == -1 && rear == -1){
            System.out.println("Queue is Empty!!");
            return;
        }
        System.out.println("The element present in Queue is:");
        if(front<= rear){
            // define the for-loop
            for(int i = front;i <= rear ;i++){
                System.out.print(arr[i]+" ");
            }
        }
        else{
            for(int i = front ;i<size;i++){
                System.out.print(arr[i]+" ");
            }
            for(int i = 0;i<= rear ;i++){
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println();
    }
}
