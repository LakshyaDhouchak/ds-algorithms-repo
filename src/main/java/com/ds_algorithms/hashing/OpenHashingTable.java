package com.ds_algorithms.hashing;

public class OpenHashingTable {
    // define the properties
    private final int size;
    private final Integer[] table;
    private final HashFunction hashFunction;
    private final ProbingFunction probingFxn;

    // define the constructor
    public OpenHashingTable(int size ,HashFunction hashFunction, ProbingFunction probingFunction){
        this.size =  size;
        this.hashFunction = hashFunction;
        this.probingFxn = probingFunction;
    }

    // define the Insert() methord
    /*
     * Inside this methord we have created a feature where we insert data in 
     * Hash Table.
     */
    public void insert(int key){
        int baseHash = hashFunction.hash(key);
        // define the for-loop
        for(int i = 0;i<size;i++){
            int index = probingFxn.probe(baseHash, i, size, key);
            // define the condition
            if(table[index] == null){
                table[index] = key;
                return;
            }
        }
        throw new RuntimeException("HashTable is Full");
    }

    // define the Delete() methord
    /*
     * Inside this methord we have created a feature where we delete key from hashtable.
     */
    public void delete(int key){
        int baseHash = hashFunction.hash(key);
        // define the for-loop
        for(int i = 0;i<size;i++){
            int index = probingFxn.probe(baseHash,i,size,key);
            // define the condition
            if(table[index] == null){
                return null;
            }
            if(table[index] == key){
                table[index] = null;
                return;
            }
        }
    }

    // define the search() methord
    /*
     * Inside this methord we have created a feature where we search the key in the hashtable.
     * if not present return false otherwise true.
     */
    public boolean Search(int key){
        int baseHash = hashFunction.hash(key);
        // define the for-loop
        for(int i = 0;i<size;i++){
            int index = probingFxn.probe(baseHash, i, size, key);
            // define the condition
            if(table[index] == null){
                return false;
            }
            if(table[index] == key){
                return true;
            }
        }
        return false;
    }

    // define the display() methord
    /*
     * Inside this methord we have created a feature where we display all the 
     * element present in an hashtable.
     */
    public void display(){
        System.out.println("The element present in an array:");
        // define the for-loop
        for(int i = 0;i<size;i++){
            System.out.print(table[i]);
        }
        System.out.println();
    }
}
