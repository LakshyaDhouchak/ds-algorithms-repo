package com.ds_algorithms.hashing;

public class probingFxnMenu {
    
    // define the methord
    public ProbingFunction getProbingFunction(int choice1,int choice2, int tableSize){
        // define the switch case
        switch(choice1){
            case 1:
                return new LinearProbing();
            case 2:
                return new QuadreaticProbing();
            case 3:
                HashFunction second = HashFunctionMenu.getHashFunction(choice2,tableSize-1);
                return new DoubleProbing();
            default:
                System.out.println("SORRY!! Invalid choice");
                return new LinearProbing();           
        }
    }
}
