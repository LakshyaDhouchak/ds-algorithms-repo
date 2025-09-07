package com.ds_algorithms.linkedlists;

/*
 * Implemetation of single linkedList in java 
 * 
 * Key points:
 * - useful when we want non-contigious memeory allocation
 * - variable length
 * - operation we perform: insert(),create(), delete(, search() etc)
 * 
 * NOTE : In single linkedlist only element can traverse left to right. And it recommended when
 *        we don't want to waste the unused memory present in small chunk around the memory.
 * 
 * Time Complexity(worst case):
 * - insert/delete :O(n)
 * - traversal :O(n)
 * - search :O(n)
 * - update :O(n)
 */
public class singleLinkedList {
    // define the node class
    static class node{
        // define the properties
        int data;
        node next;
        // define the constructor
        public node(int data){
            this.data = data;
            this.next = null;
        }
    }
    // define the properties
    node head = null;
    node duplicate = null;

    // define the create() methord
    /*
     * Inside this methord i have created a feature where we creating a linkedlist based on given
     * user data.
     */
    public void create(int data){
        // calling the node class Object
        node node =  new node(data);
        // define the condition
        if(head == null){
            head = node;
            duplicate = node;
        }
        else{
            duplicate.next = node;
            duplicate = node;
        }
    }


    // define the traversal() methord
    /*
     * Inside this methord i have created a feature where we have display all the element
     * present in an array
     */
    public void traversal(){
        // define the properties
        duplicate = head;

        if(head == null){
            System.out.println("Single linkedList is empty");
        }
        else{

            // define the for loop
            System.out.println("The element present in single linkedlist is:");
            while(duplicate!= null){
                System.out.print(duplicate.data+" ");
                duplicate = duplicate.next;
            }
            System.out.println();
        }    
    }

    // define the search() methord
    /*
     * Inside this methord we have created a feature where we traversal the entire single linkedlist
     * and if given key present then return the address of that node otherwise return
     * null.
     */
    public node search(int key){
        // define the properties
        duplicate = head;
        // define the while-loop
        while(duplicate!= null){
            // define the condition
            if(duplicate.data == key){
                return duplicate;
            }
            duplicate = duplicate.next;
        }
        return null;
    }


    // define the insert() methord
    /*
     * Inside this methord i have created a feature where we have inserted data into single
     * linkedList
     * 
     * Key points(Before/After) :
     * - Insertion at starting
     * - Isertion at middle
     * - Insertion at end
     */
    public void insert(int data2,int data1,String mode){
        // define the base condition
        if(mode == null){
            System.out.println("Invalid mode. Use 'Before' or 'After'.");
            return;
        }
        // creating the node class Object
        node node =  new node(data2);
        // define the base condition
        if(head == null){
            head = node;
            return;
        }
        else{
            // define the condition
            if(head.data == data1 && mode.equalsIgnoreCase("Before")){
                node.next = head;
                head = node;
            } 
            else{
                // define the properties
                duplicate = head;

                // define the for-loop
                while(duplicate!= null){
                    // define the condition
                    if(duplicate.data == data1 && mode.equalsIgnoreCase("After")){
                        node.next = duplicate.next;
                        duplicate.next = node;
                        return;
                    }

                    if(duplicate.next!=null&& duplicate.next.data == data1 && mode.equalsIgnoreCase("Before")){
                        node.next = duplicate.next;
                        duplicate.next = node;
                        return;
                    }
                    duplicate = duplicate.next;
                }

                // define the case where data not found so,insert at end
                duplicate = head;
                // define the for-loop
                while(duplicate.next!=null){
                    duplicate = duplicate.next;
                }
                duplicate.next = node;
                System.out.println("Target not found, inserted at end.");
            }  
        }

    }


    // define the delete() methord
    /*
     * Inside this methord i have created a feature where we delete the data from the single
     * linkedList.
     * 
     * Key points:
     * - Deletion at start
     * - Deletion at middle
     * - Deletion at end
     */
    public void delete(int data1){
        // define the condition
        if(head == null){
            System.out.println("SORRY!! LinkedList is empty");
        }
        else{
            if(head.data == data1){
                head = head.next;
            }
            else{
                // define the properties
                boolean flag = false;
                duplicate = head;
                // define the while-loop
                while(duplicate != null){
                    // define the condition
                    if(duplicate.next!=null && duplicate.next.data == data1){
                        duplicate.next = duplicate.next.next;
                        flag = true;
                    }
                    duplicate = duplicate.next;
                }
                // define the condition
                if(flag == false){
                    System.out.println("SORRY!! Element not found");
                }

            }
        }
    }


}
