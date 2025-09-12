package com.ds_algorithms.hashing;

import java.util.LinkedList;
import java.util.List;

/*
 * Implementation of closed Addressing hashTable
 * 
 * Key points:
 * - In closed addressing, collisions are handled by keeping a list (chain) of keys at each index of the table.
 * - Each bucket points to a linked list (or dynamic array) of keys that hash to the same index.
 * 
 * Time Complexity:
 * - Search : O(1)
 * - Insert/delete :O(1)
 * - Traversal :O(n)
 */

public class ClosedHashingTable {
    // define the properties
    private final int size;
    private final List<Integer>[] table;
    private final HashFunction hashFunction;

    // define the constructor
    public ClosedHashingTable(int size,HashFunction hashFunction){
        this.size = size;
        this.hashFunction = hashFunction;
        this.table =  new List[size];

        // define the for-loop
        for(int i = 0;i<size;i++){
            table[i] = new LinkedList<>();
        }
    }

    // define the insert() methord
    /*
     * Inside this methord we have created a feature where we insert data in hashtable 
     * and if two get the same index  then both store in same index by forming a chain
     * this techique is known as closed chaining.
     */
    public void insert(int key){
        int index = hashFunction.hash(key);
        table[index].add((Integer)key);
    }

    // define the delete() methord
    /*
     * Inside this methord we have created a feature where we delete data in hasttable.
     */
    public void delete(int key){
        int index = hashFunction.hash(key);
        table[index].remove((Integer)key);
    }


    // define the Search() methord
    /*
     * Inside this methord we have created a feature where we search the key if that key 
     * present in hashtable then return true otherwise return false.
     */
    public boolean Search(int key){
        int index = hashFunction.hash(key);
        return table[index].contains((Integer) key);
    }

    // define the display() methord
    /*
     * Inside this methord we have display all the element present in an hashtable.
     */
    public void display(){
        System.out.println("The element present in HashTable is: ");
        // define the for-loop
        for(int i = 0;i<size;i++){
            System.out.print(i+" --> ");
            for(int elem : table[i]){
                System.out.print(elem+" -> ");
            }
            System.out.println();
        }
    }
    
}
