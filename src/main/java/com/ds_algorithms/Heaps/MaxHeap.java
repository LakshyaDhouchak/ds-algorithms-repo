package com.ds_algorithms.Heaps;

/*
 * Implementation of MaxHeap
 * 
 * Key points:
 * - It is based on complete Binary Tree.
 * - we are using array to store data of heap instead of Node based tree implementation.
 *   Structure:
 *   - when at index(i):-
 *      i) Parent : (i-1)/2
 *      ii) Left : 2*i + 1
 *      iii) Right : 2*i + 2
 * 
 * NOTE: When we perform (Insert/Delete) operation the technique to convert
 *       into heap  we use Heap Up / Heap Down it is known as Heapify.
 * 
 * Time Complexity:
 *   - Insertion: O(log n) → add at end + bubble up
 *   - Delete (root): O(log n) → remove root + bubble down
 *   - Heapify (build heap from array): O(n) → bottom-up method
 *   - Peek (get root): O(1) → direct access
 *   - Search (arbitrary element): O(n) → linear search
 */
public class MaxHeap {
    // define the properties
    private int index;
    private int[] arr;
    private int capacity;

    // define the constructor
    public MaxHeap(int initialCapacity){
        this.arr =  new int[initialCapacity];
        this.capacity = initialCapacity;
        this.index = 0;
    }

    // define the methord
    private int parent(int index){
        return (index-1)/2;
    }
    private int left(int index){
        return 2*index + 1;
    }
    private int right(int index){
        return 2*index + 2;
    }

    // define the swap methord
    private void swap(int i ,int j){
        int pointer = arr[i];
        arr[i] = arr[j];
        arr[j] = pointer;
    }

    // define the Insert() methord
    public void Insert(int key){
        // define the condition
        if(index == capacity){
            throw new IllegalStateException("Heap is Full!!");
        }
        arr[index] = key;
        int i = index;
        index++;

        // define the heapify up feature
        while(i!=0 && arr[parent(i)]< arr[i] ){
            swap(i, parent(i));
            i = parent(i);
        }
    }


    // define the Search() methord
    public boolean Search(int key){
        // define the condition
        if(index <= 0 ){
            throw new IllegalStateException("Heap is Empty!!");
        }
        // define the for-loop
        for(int i = 0;i<index;i++){
            // define the condition
            if(arr[i] == key){
                return true;
            }
        }
        return false;
    }

    // define the isEmpty() methord
    public boolean isEmpty(){
        // define the condition
        return index == 0;
    }

    // define the MaxElement() methord
    public int MaxElement(){
        // define the condition
        if(index<=0){
            throw new IllegalStateException("Heap is Empty");
        }
        return arr[0];
    }

    // define the Display() methord
    public void Display(){
        // define the condition
        if(index<=0){
            throw new IllegalStateException("Heap is Empty");
        }
        System.out.println("The element present in Heap is:");
        // define the for-loop
        for(int i = 0;i<index;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    // define the delete() methord
    public int delete(){
        // define the condition
        if(index<=0){
            throw new IllegalStateException("Heap is Empty!!");
        }
        int root = arr[0];
        arr[0] = arr[index-1];
        index--;
        heapify(0);
        return root;
    }

    // define the heapify methord(Botton down approch)
    private void heapify(int i){
        int largest = i;
        int left = left(i);
        int right = right(i);

        // define the condition
        if(left < index && arr[largest]<arr[left]){
            largest = left;
        }
        if(right<index && arr[largest]<arr[right]){
            largest = right;
        }

        // define the base condition
        if(largest != i){
            swap(i,largest);
            heapify(largest);
        }
    }


}
