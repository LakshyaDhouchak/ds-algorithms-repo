package com.ds_algorithms.algorithms.sorting;

/*
 * Implementation of Selection Sort
 * 
 * Key points :
 * - we sort the data by picking the first smallest element from the array and then 
 *   put it in right place then repeat the same process until yoy don't sort all.
 *   
 * Time Complexity:
 * - Best Case: O(n^2)
 * - Average Case: O(n^2)
 * - Worst Case: O(n^2) 
 */
public class selectionSort {
    
    // define the sort() methord
    /*
     * Inside this methord i have created a feature where we sort the data in ascending order 
     * based on selection sorting.
     */
    public int[] sort(int[] arr){
        // define the base condition
        if(arr == null || arr.length == 0){
            System.out.println("SORRY!!Array is empty");
            return arr;
        }

        // define the for-loop
        for(int i = 0;i<arr.length;i++){
            // define the properties
            int min = i;
            // define the for-loop
            for(int j = i+1;j<arr.length;j++){
                // define the condition
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            if(min !=i){
                int pointer = arr[i];
                arr[i] = arr[min];
                arr[min] = pointer;
            }    
        }
        return arr;
    }

}
