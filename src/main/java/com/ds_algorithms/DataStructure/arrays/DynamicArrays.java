package com.ds_algorithms.DataStructure.arrays;

/*
 * Implementation of Dynamic Arrays in java
 * 
 * Key Points:
 * - it is variable size array(can grow/srink).
 * - suitable for contigious memory allocation.
 * - best choice when we don't know size in advance.
 * - Basic operation: Insertion(), creation(), deletion(), search(),traversal() etc.
 * 
 * Time Complexity(Worst case):
 * - traversal :O(n)
 * - delete/insert :O(n)
 * - search :O(n)
 * - access :O(1)
 * - update :O(1)
 * 
 */
public class DynamicArrays {
    // define the properties
    int capacity;
    int fillratio = 75;
    int[] arr = null;
    int index = -1;

    // define the constructor
    public DynamicArrays(){
        this.capacity = 10;
        this.arr = new int[capacity];
    }
    public DynamicArrays(int initialCapacity){
        this.capacity = initialCapacity;
        this.arr = new int[capacity];
    }
    public DynamicArrays(int initialCapacity,int fillratio){
        this.capacity = initialCapacity;
        this.arr =  new int[capacity];
        this.fillratio = fillratio;
    }

    // define the create() methord
    /*
     * Inside this methord i have created a feature where we I initilized the value of array
     * based on given array 
     * NOTE: There is a condition if fillratio is more than or equal to which one we specify
     * then simply resize() the array by the help of that methord.
     */
    public void create(int data){
        // define the condition
        if(((index+1)*100)/capacity >= fillratio){
            resize();
        }
        arr[++index] = data;
    }


    // define the resize() methord
    /*
     * Inside this methord i have created a feature where i have resize the array into double capacity
     * and replace it with new array when fill ration is 75%(it means if array is fill more than 75 then it
     * will create the new array).
     */
    public void resize(){
        // define the properties
        capacity = 2*capacity;
        int[] dup =  new int[capacity];
        // define the for-loop
        for(int i = 0;i<=index;i++){
            dup[i] = arr[i];
        }
        arr = dup;
        dup = null;
    }


    // define the traversal() methord
    /*
     * Inside this methord i have created a feature where i have traversal to all element present 
     * in an array 
     */
    public void traversal(){
        // define the for-loop
        System.out.println("The element present in an array is:");
        // define the for-loop
        for(int i = 0;i<=index;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    // define the search() methord
    /*
     * Inside this methord i have created a feature where we search the key . if key is present in an array
     * it return the index in which it present.otherwise it return -1.
     */
    public int search(int key){
        // define the for-loop
        for(int i = 0;i<=index;i++){
            // define the condition
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }


    // define the insert() methord
    /*
     * Inside this methord i have created a feature where where i insert new data into dynamic array
     * - if ((index/capacity)*100 == fillratio) then simpy resize the array into double size.
     * - if given index is greater than actual index ans less than capacity-1 then simply
     *   insert the data and index will be index1.
     * - if index is witin given range then simply tavel the element on right side. then insert
     *   the data into given index.
     */
    public void insert(int index1, int data){
        // define the condition
        if(((index+1)*100)/capacity>= fillratio){
            resize();
        }
        if(index1==index+1 && index1<=capacity-1){
            arr[index1] = data;
            index = index1;
            System.out.println("CONGRATULATIONS!! Element is inserted successfully");
        }
        else if(index1>=0 && index1<=index){
            //  define the for loop
            for(int i = index;i>=index1;i--){
                arr[i+1] = arr[i];
            }
            arr[index1] = data;
            index++;
            System.out.println("CONGRATULATIONS!! Element is inserted successfully");
        }
        else{
            System.out.println("Sorry !! Invalid index");
            return;
        }
        
    }


    // define the delete() methord
    /*
     * Inside this methord we have created a feature where perform deletion() operation
     * - if (index == -1) then "Array is empty".
     * - if(index1>index) then " Index out of bound".
     * - If deleting inside the current filled range,
     *   it shifts elements to the left to make space.
     */
    public void delete(int index1){
        // define the condition
        if(index == -1){
            System.out.println("SORRY!! Array is empty");
        }
        else{
            if(index1>index){
                System.out.println("SORRY !! Index out of bound");
            }
            else{
                // define the for-loop
                for(int i = index1;i<index;i++){
                    arr[i] = arr[i+1];
                }
                index--;
                System.out.println("CONGRATULATION!! Element is removed sucessfully");
            }
        }
    }
}
