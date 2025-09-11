package com.ds_algorithms.hashing;

import java.util.Random;

/*
 * Implementation of all important hashFunction:-
 * Key points: 
 * 
 * - Division: key % tableSize → Condition: table size should be prime for good distribution.
 * - Multiplication: key * constant % tableSize → Condition: constant A should be 0 < A < 1.
 * - Mid-Square: square the key, use middle digits → Condition: works only for numeric keys.
 * - Folding: break key into parts, add them → Condition: split key into equal-size parts.
 * - Universal: (a*key + b) % prime % tableSize → Condition: 1 ≤ a ≤ prime-1, 0 ≤ b ≤ prime-1, prime > max key.
 */

// define the interface 
public interface HashFunction {

    // define the methord
    int hash(int input);
}

// define the various hashFunction:

// 1) implementation of division hash function
class DivisionHash implements HashFunction{
    // define the properties
    private final int hashSize;

    // define the constructor
    public DivisionHash(int size){
        this.hashSize = size;
    }

    @Override
    public int hash(int input){
        return input%hashSize;
    }
}

// 2) implementation of multiplication hash function
class MultiplicationHash implements hashFunction{
    // define the properties
    private final int hashSize;

    // define the constructor
    public MultiplicationHash(int size){
        this.hashSize = size;
    }

    @Override
    public int hash(int input ){
        private final double const = 0.613;
        double fractional = (input*const)%1;
        return (int) Math.floor(hashSize*fractional)
    }
}

// 3) implementation of mid square hash function
class MidSquareHash implements hashFunction{
    // define the properties
    private final int hashSize;

    // define the constructor
    public MidSquareHash(int size){
        this.hashSize = size;
    }

    @Override
    public int hash(int input){
        // define the properties
        int square = input*input;
        String inputStr = String.valueOf(square);
        String hashStr = String.valueOf(hashSize);
        int inputLength = inputStr.length();
        int hashLength = hashStr.length();
        // define the condition
        if(inputLength<= hashLength){
            return square%hashSize;
        }
        else{
            int mid = (inputLength- hashLength)/2;
            String value = inputStr.substring(mid , mid+hashLength);
            return Integer.parseInt(value)%hashSize;
        }
    }
}

// 4) implementation of folding hash function
class foldingHash implements hashFunction{
    // define the properties
    private final int hashSize;

    // define the condtructor
    public foldingHash(int size){
        this.hashSize = size;
    }

    @Override
    public int hash(int input){
        // define the properties
        int sum = 0;
        
        // define the for-loop
        while(input>0){
            int rem = input%10;
            sum += rem;
            input = input/10;
        }
        return rem%hashSize;
    }
}

// 5) implementation of universal hash function
class UniversalHash {
    private final int m;   
    private final int a, b; 
    private static final int P = 10000019; 

    public UniversalHash(int tableSize) {
        this.m = tableSize;
        Random rand = new Random();
        this.a = rand.nextInt(P - 1) + 1; 
        this.b = rand.nextInt(P);        
    }

    public int hash(int key) {
        return (int)(((long)a * key + b) % P % m);
    }
}    