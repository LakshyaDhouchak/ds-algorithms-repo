package com.ds_algorithms.algorithms.sorting;

/*
 * Implementation of Bubble Sort
 * 
 * Key points :
 * - we sort element from the back side it means for sorting we move right to left.
 * - we do sorting for n-1 times where n is no of element
 *   
 * Time Complexity:
 * - Best Case: O(n)
 * - Average Case: O(n^2)
 * - Worst Case: O(n^2) 
 */
public class BubbleSort {

    // define the sort() methord
    /*
     * Inside this methord i have created a feature where we sort data based on bubble sort
     */
    public int[] sort(int[] arr){
        // define the base condition
        if(arr == null || arr.length == 0){
            System.out.println("SORRY!! Array is empty");
            return arr;
        }
        // define the for-loop
        for(int i = 0;i<arr.length-1;i++){
            // define the propeties
            boolean flag = false;
            // define the for loop
            for(int j = 0;j<arr.length-i-1;j++){
                // define the condition
                if(arr[j]>arr[j+1]){
                    int pointer = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = pointer;
                    flag = true;
                }
            }
            // define the condition
            if(flag == false){
                break;
            }
        }
        return arr;
    }
}
