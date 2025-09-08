package com.ds_algorithms.algorithms.sorting;

/*
 * Implementation of Insertion Sort
 * 
 * Key points :
 * - we sort the data by assuming that first element is already sorted then from second element we compare 
 *   and then we compare it from element toward left side one by one. And we check that condition
 *   for n-1 times where n is no of element.
 *   
 * Time Complexity:
 * - Best Case: O(n)
 * - Average Case: O(n^2)
 * - Worst Case: O(n^2) 
 */
public class InsertionSort {
    
    // define the sort()methord
    /*
     * Inside this methord i have created a feature where sort data based on Insertion sort in ascending 
     * order.
     */
    public int[] sort(int[] arr){
        // define the base condition
        if(arr == null && arr.length == 0){
            System.out.println("SORRY!! Array is empty");
            return arr;
        }

        // define the for -loop
        for(int i = 1;i<arr.length;i++){
            int j = i-1;
            int element = arr[i];
            // define the while loop
            while(j>=0 && arr[j]>element){
                // define the condition
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = element;
        }

        return arr;
    }
}
