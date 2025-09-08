package com.ds_algorithms.algorithms.searching;

/*
 * Implementation of Linear Search
 * 
 * Key points:
 * - Linear searching is brute force approch in which i search for all element present in an array
 *   if element match with key then simply return the index of element 
 *   otherwise return -1.
 * 
 * Time complexity:
 * - Best case : O(1)
 * - Average case : O(n)
 * - Worst case : O(n)
 * 
 * NOTE : if data is stored in contigious memeory allocation then it is recommended to use binary Search instead of LinearSearch
 */
public class LinearSearch {
    
    // define the Search() methord
    /*
     * Inside this methord i have created a feature where we search the given key weather present
     * or not.
     * NOTE: Not recommended for contigious memory allocation
     */
    public int search(int[] arr,int key){
        // define the base condition
        if(arr == null || arr.length == 0){
            return -1;
        }
        // define the for -loop
        for(int i = 0;i<arr.length;i++){
            // define the condition
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
}
