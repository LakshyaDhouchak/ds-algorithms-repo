package com.ds_algorithms.DataStructure.stack;

/*
 * Implementation of Stack data structure
 * 
 * Key Points:
 * - Stack follows Last In First Out (LIFO) principle.
 * - This implementation is fixed in size (static).
 * - We have implemented Stack using Array.
 * 
 * Time Complexity:
 * - Push : O(1)
 * - Display : O(n)
 * - pop/peek : O(1)
 * - isEmpty : O(1)
 */
public class StaticStack {
    // define the properties
    int[] arr;
    int size;
    int end ;

    // define the constrctor
    public StaticStack(){
        this.size = 10;
        this.arr = new int[size];
        end = -1;
    }
    public StaticStack(int size){
        this.size = size;
        this.arr = new int[size];
        end = -1;
    }


    // define the create() methord
    /*
     * Inside this methord i have created a feature where we store the data in stack 
     * data structure.
     */
    public void push(int data){
        // define the condition
        if(end == size-1){
            System.out.println("SORRY!! Stack Overflow condition");
        }
        else{
            arr[++end] = data;
            
        }
    }


    // define the display() methord
    public void display(){
        /*
         * Inside this methord i have created a feature where i display all element 
         * present in an array.
         */
        // define the condition
        if(end == -1){
            System.out.println("SORRY!! Stack is Empty");
        }
        else{
            System.out.println("The element present n stack is:");
            // define the for-loop
            for(int i = 0; i<= end;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }


    // define the isEmpty() methord
    /*
     * Inside this methord i have created a feature to check weather stack is Empty or not.
     */
    public boolean isEmpty(){
        // define the condition
        if(end == -1){
            System.out.println("CONGRATULATION!! Stack is Empty");
            return true;
        }
        else{
            System.out.println("SORRY!! Stack is not Empty");
            return false;
        }
    }

    // define the pop() methord
    public int pop(){
        // define the condition
        if(end == -1){
            System.out.println("SORRY!! Stack is Empty");
        }
        else{
            System.out.println("The element we are removing from stack is:"+arr[end]);
            return arr[end--];
        }
        return -1;
    }

    // define the peek() methord
    /*
     * Inside this methord i have created a feature where we display the last element present in stack 
     */
    public int peek(){
        // define the condiion
        if(end == -1){
            System.out.println("SORRY!! Stack is Empty");
        }
        else{
            System.out.println("The last element present in stack is:"+arr[end]);
            return arr[end];
        }
        return -1;
    }
}
