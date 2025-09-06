package com.ds_algorithms.arrays;

/*
 * Static Array Implementation in java 
 * 
 * Key points:
 * - fixed in size(can't grow/srink).
 * - suitable when we want to store data in contigious memory.
 * - best when we already know size in advance otherwise may lead to wasted or insufficient memory.
 * - basic operation : Insertion, Deletion, traversal , creation , update etc.
 * 
 * Time Complexity(Worst case):
 * - Search : O(n)
 * - Insert/Delete : O(n)
 * - Traversal : O(n)
 * - Access : O(1)
 * - Update : O(1)
 */

public class StaticArrays {
    // define the properties
    int size;
    int[] arr = null;
    int index;

    // define the constructor
    public StaticArrays(){
        this.size = 10;
        this.arr =  new int[size];
        this.index= -1;
    }
    public StaticArrays(int size){
        this.size = size;
        this.arr = new int[size];
        this.index = -1;
    }

    // define the create() methord
    /*
     * Inside this methord I have created a feature where we are Initializing
     * the data value in static array and it will give ArrayOverflow condition
     * when (index == size-1). 
     */
    public void create(int data){
        // define the condition
        if(index == size-1){
            System.out.println("SORRY !! Array overflow condition");
        }
        else{
            arr[++index] = data;
        }    
    }

    // define the Search() methord
    /*
     * Inside this methord i have created a feature if key element present in an array then it will
     * return the index value where it present. if not then it will return -1.
     */
    public int search(int key){
        int pointer = -1;
        // define the for-loop
        for(int i = 0;i<=index;i++){
            // define the condition
            if(arr[i] == key){
                pointer = i;
            }
        }
        return pointer;
    }

    // define the traversal() methord
    /*
     * Inside this methord I have created a feature where we display all the 
     * element present in an array 
     */
    public void traversal(){
        // define the for-loop
        System.out.println("The element present in an array is:");
        for(int i = 0;i<=index;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        
    }
    
    // define the Insert() methord
    /*
     * Inside this methord we have created a feature where we can insert data in static Array
     * based on given index. 
     * - if (index1>= size-1) then array overflow condition occur.
     * - else if( index1>=index+1 && index<=size-1) then it means index is beyond to actual array index
     *   then if condition satisfy then change the origional index with given index.
     * - If inserting inside the current filled range,
     *   it shifts elements to the right to make space, then inserts. 
     */
    public void insert(int index1,int data){
        // define the condition
        if(index1 >= size-1 ){
            System.out.println("SORRY!! Array overflow condition");
        }
        else{
            if(index1==index+1 && index1<=size-1){
                arr[index1] = data;
                index = index1;
                System.out.println("Congratulation !! Element is inserted Successfully");
            }
            else if(index1<=index&& index1>=0){
                // define the for loop
                for(int i = index;i>=index1;i--){
                    arr[i+1] = arr[i];
                }
                arr[index1] = data;
                index++;
                System.out.println("Congratulation !! Element is inserted Successfully");
            }
            else{
                System.out.println("SORRY !! Invalid index");
            }
        }
        
    }

    // define the delete() methord
    /*
     * Inside this methord I have created a feature where we delete element in static
     * Array
     * - if(index == -1) then "Array underflow condition".
     * - else if(index1>index) then " Index out of bound"
     * - If inserting inside the current filled range,
     *   it shifts elements to the left to make space.
     */
    public void delete(int index1){
        // define the condition
        if(index != -1){
            if(index1 > index || index1<0){
                System.out.println("SORRY !! Index Out of bounds");
            }
            else{
                // define the for-loop
                for(int i = index1;i<index;i++){
                    arr[i] = arr[i+1];
                }
                index--;
                System.out.println("CONGRATULATION!! Element is removed successfully");
            }
        }
        else{
            System.out.println("SORRY!! Array underflow condition");
        }
    }

}
