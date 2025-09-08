package com.ds_algorithms.algorithms.sorting;

/*
 * Implementation of Quick Sort
 * 
 * key points:
 * - This algorithms is based of divide and conquer approch .
 * - firstly we have to choose pivot then according to that put the less than or equal to pivot on left
 *   side and remaining on right side. after then we split the array based on divide and conquer technique.
 * 
 * Time Complexity:
 * - Best case : O(nlog(n))
 * - Average case : O(nlog(n))
 * - Worst case : O(n^2)
 */
public class QuickSort {
    
    // define the quickSort() methord
    /*
     * Inside this methord i have created a feature where we sort the data based on quick sort approch.
     */
    public void quickSort(int[] arr, int l , int h){
        // define the properties
        if(l<h){
            int pivot = partition(arr, l, h);
            quickSort(arr, l, pivot-1);
            quickSort(arr, pivot+1, h);
        }
    
    }

    // define the partition() methord
    public int partition(int[] arr,int l,int h){
        // define the properties
        int pivot = arr[h];
        int low = l;
        int high = h-1;

        // define the while loop
        while(low<=high){
            // define the condition
            while(low<=high && arr[low]<=pivot){
                low++;
            }
            while(low<=high && arr[high]> pivot){
                high--;
            }
            if(low<high){
                int pointer = arr[low];
                arr[low] = arr[high];
                arr[high] = pointer;
                low++;
                high--;
            }
        }
        int pointer1 = arr[low];
        arr[low] = arr[h];
        arr[h] = pointer1;

        return low;
    }
}
