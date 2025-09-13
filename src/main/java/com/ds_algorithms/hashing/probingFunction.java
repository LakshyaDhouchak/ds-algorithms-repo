package com.ds_algorithms.hashing;

/*
 * Implementation of probing Function
 * 
 * Key Points:
 * - All keys are stored inside the hash table array itself.
 * - On collision, the algorithm probes (searches) for another empty slot according to some probing strategy.
 * - No extra linked lists or chains (unlike closed addressing).
 *
 *  Collision Handling:
 *   - Linear Probing → (hash + i) % size
 *   - Quadratic Probing → (hash + i²) % size
 *   - Double Hashing → (hash1 + i * hash2) % size
 * 
 */
public interface probingFunction {
    // define the methord
    int probe(int hash ,int i ,int size ,int key);
} 

// define the LinearProbing() methord
/*
 * Inside this methord we have created a feature where we place it at given index
 * ((hash + i)%size) if that index space is already occupied then the check the next empty space this
 * process continue until no empty space we get. if i == size-1 and no space we get
 * then hashtable is alredy full.
 */
class LinearProbing implements probingFunction{
    @Override
    public int probe(int hash ,int i ,int size ,int key){
        return (hash + i)%size;
    }
}

// define the QuadraticProbing() methord
/* Inside this methord we have created a feature where we place it at given index
 * ((hash+ i*i)%size).if that index space is already occupied then the check the next empty space this
 * process continue until no empty space we get. if i == size-1 and no space we get
 * then hashtable is alredy full.
 */
class QuadreaticProbing implements probingFunction{
    @Override
    public int probe(int hash ,int i ,int size ,int key){
        return (hash+ i*i)%size;
    }
}

// define the DoubleProbing() methord
class DoubleProbing implements probingFunction{
    // define the properties
    private final HashFunction secondHashFunction;

    // define the constructor
    public DoubleProbing(HashFunction secondHash){
        this.secondHashFunction = secondHash;
    }

    @Override
    public int probe(int hash ,int i ,int size ,int key){
        int step = secondHashFunction.hash(key);
        // define the condition
        if(step == 0){
            step = 1;
        }
        return (hash + i * step)%size;
    }
}
