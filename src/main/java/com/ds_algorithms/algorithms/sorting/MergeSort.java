package com.ds_algorithms.algorithms.sorting;

/*
 * Implementation of Merge Sort
 * 
 * key points:
 * - This algorithms is based of divide and conquer approch .
 * - firstly we split the array in sub- array until (length<height) when condition 
 *   become wrong simply go and merge by doint two pointer sorting.
 * 
 * Time Complexity:
 * - Best case : O(nlog(n))
 * - Average case : O(nlog(n))
 * - Worst case : O(nlog(n))
 */
public class MergeSort {
    
    // define the mergeSort() methord
    /*
     * Inside this methord i have created a feature where we sort the data based  by using divide and
     * conquer approch.
     */
    public void mergeSort(int[] arr, int l, int h){
        // define the properties
        int mid = 0;
        // define the while loop
        if(l<h){
            mid = l+(h-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr, mid+1, h);
            merge(arr,l,mid,h);
        }
    }

    // define the merge() methord
    public void merge(int[] arr , int l, int mid, int h){
        // define the properties
        int l1 = mid - l+1;
        int l2 = h - mid;

        // define the array
        int[] left =  new int[l1];
        int[] right = new int[l2];

        // define the for-loop
        for(int i = 0;i<l1;i++){
            left[i] = arr[i+l];
        }
        for(int j = 0;j<l2;j++){
            right[j] = arr[j+mid+1];
        }

        // define the properties
        int i = 0;
        int j = 0;
        int k = l;
        // define the while loop
        while(i<left.length && j<right.length){
            // define the condition
            if(left[i]<= right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
            }
        }
        while(i<left.length){
            arr[k++] = left[i++];
        }
        while(j<right.length){
            arr[k++] = right[j++];
        }
    }
}
