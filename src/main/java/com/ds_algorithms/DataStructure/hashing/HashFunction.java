package com.ds_algorithms.DataStructure.hashing;

import java.util.Random;

/*
 * Implementation of all important hash functions
 * 
 * Key points: 
 * 
 * - Division: key % tableSize 
 *      Condition: table size should be prime for good distribution.
 * 
 * - Multiplication: (key * A) % 1 * tableSize 
 *      Condition: constant A should be 0 < A < 1, usually ~0.618 (golden ratio).
 * 
 * - Mid-Square: square the key, use middle digits 
 *      Condition: works only for numeric keys.
 * 
 * - Folding: break key into equal-size digit parts, add them 
 *      Condition: chunkSize should be power of 10 (10, 100, 1000…).
 * 
 * - Universal: (a*key + b) % prime % tableSize 
 *      Condition: 1 ≤ a ≤ prime-1, 0 ≤ b ≤ prime-1, prime > max key.
 */

// define the interface 
public interface HashFunction {
    int hash(int input);
}

// 1) Division Hash Function
class DivisionHash implements HashFunction {
    private final int hashSize;

    public DivisionHash(int size) {
        this.hashSize = size;
    }

    @Override
    public int hash(int input) {
        return input % hashSize;
    }
}

// 2) Multiplication Hash Function
class MultiplicationHash implements HashFunction {
    private final int hashSize;
    private static final double A = 0.618; 

    public MultiplicationHash(int size) {
        this.hashSize = size;
    }

    @Override
    public int hash(int input) {
        double fractional = (input * A) - Math.floor(input * A);
        return (int) Math.floor(hashSize * fractional);
    }
}

// 3) Mid-Square Hash Function
class MidSquareHash implements HashFunction {
    private final int hashSize;

    public MidSquareHash(int size) {
        this.hashSize = size;
    }

    @Override
    public int hash(int input) {
        long square = (long) input * input;
        String inputStr = String.valueOf(square);
        String hashStr = String.valueOf(hashSize);

        int inputLength = inputStr.length();
        int hashLength = hashStr.length();

        if (inputLength <= hashLength) {
            return (int) (square % hashSize);
        } else {
            int mid = (inputLength - hashLength) / 2;
            String value = inputStr.substring(mid, mid + hashLength);
            long parsed = Long.parseLong(value);
            return (int) (parsed % hashSize);
        }
    }
}

// 4) Folding Hash Function
class FoldingHash implements HashFunction {
    private final int hashSize;
    private final int chunkSize;

    /*
     * chunkSize should be power of 10 (10, 100, 1000...) 
     * Example: if chunkSize=100 → splits number into 2-digit parts.
     */
    public FoldingHash(int size, int chunkSize) {
        this.hashSize = size;
        this.chunkSize = chunkSize;
    }

    @Override
    public int hash(int input) {
        int sum = 0;
        while (input > 0) {
            int rem = input % chunkSize;
            sum += rem;
            input = input / chunkSize;
        }
        return sum % hashSize;
    }
}

// 5) Universal Hash Function
class UniversalHash implements HashFunction {
    private final int m;   // table size
    private final int a, b; 
    private static final int P = 10000019; 

    public UniversalHash(int tableSize) {
        this.m = tableSize;
        Random rand = new Random();
        this.a = rand.nextInt(P - 1) + 1; // 1 ≤ a ≤ P-1
        this.b = rand.nextInt(P);        // 0 ≤ b ≤ P-1
    }

    @Override
    public int hash(int key) {
        return (int) (((long) a * (long) key + b) % P % m);
    }
}

                                                                                                                                       