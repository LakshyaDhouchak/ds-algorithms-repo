package com.ds_algorithms.DataStructure.hashing;

public class HashFunctionMenu {
    // define the methord 
    public HashFunction getHashFunction(int choice , int size){
        // define the switch case
        switch(choice){
            case 1:
                return new DivisionHash(size);
                break;
            case 2:
                return new MultiplicationHash(size);
                break;
            case 3:
                return new MidSquareHash(size);
                break;
            case 4:
                return new UniversalHash(size);
                break; 
            default:
                System.out.println("SORRY !! Invalid Choice");
                return null;               
        }
    }

    // define the methord
    public HashFunction getHashFunction(int choice , int size , int chunkSize){
        // define the choice
        switch(choice){
            case 1:
                return new FoldingHash(size, chunkSize);
                break;
            default:
                System.out.println("SORRY!! Invalid choice");
                return null;    
        }
    }
}
