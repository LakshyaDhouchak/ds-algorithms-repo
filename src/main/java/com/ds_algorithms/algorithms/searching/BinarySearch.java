package com.ds_algorithms.algorithms.searching;

/* 
 * Implementation of Binary Search
 * 
 * Key points:
 * - Most impotant data must be sorted(Ascending order).
 * - Binary searching is divide and conqar approch in which i search for the mid element present in an array
 *   if element match with key then simply return the index of element 
 *   otherwise check if mid element is less than key then (length = mid+1) 
 *   otherwise (height = mid-1).
 * 
 * Time complexity:
 * - Best case : O(1)
 * - Average case : O(log(n))
 * - Worst case : O(log(n))
 * 
 * NOTE : if data is stored in contigious memeory allocation then it is recommended to use binary Search and data is sorted in ascending order.
 */
public class BinarySearch {

    // define the Search() methord
    /*
     * Inside this methord i have created a feature where i search a given key is present in array
     * or not.
     */
    public int search(int[] arr , int key){
        // define the properties
        int length = 0;
        int height = arr.length-1;
        int mid = 0;

        // define the base condition
        if(arr == null || arr.length == 0){
            return -1;
        }
        while(length<= height){
            mid = length+(height-length)/2;
            // define the condition
            if(arr[mid] == key){
                return mid;
            }
            else if(arr[mid]<key){
                length = mid+1;
            }
            else{
                height = mid-1;
            }
        }
        return -1;
    }
}
