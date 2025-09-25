package com.ds_algorithms.DataStructure.linkedlists;

/*
 * Implemetation of Circular linkedList in java 
 * 
 * Key points:
 * - useful when we want non-contigious memeory allocation
 * - variable length
 * - operation we perform: insert(),create(), delete(, search() etc)
 * 
 * NOTE : In Circular linkedlist  element can traverse left to right. And it recommended when
 *        we don't want to waste the unused memory present in small chunk around the memory.
 *      - But the only difference that last node conatins the addess of starting node to form a 
 *        loop in linkedlist.
 * 
 * Time Complexity(worst case):
 * - insert/delete :O(n)
 * - traversal :O(n)
 * - search :O(n)
 * - update :O(n)
 */
public class circularLinkedList {
    // define the staic Node class
    static class Node{
        // define the properties
        int data;
        Node next;
        // define the constructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    // define the properties
    Node head = null;
    Node tail = null;

    //define the create() methord
    /*
     * Inside this methord i have created a feature where we are adding user data in circular linkedlist.
     */
    public void create(int data1){
        // calling the node class Object
        Node node =  new Node(data1);
        // define the condition
        if(head == null && tail == null){
            head = node;
            tail = node;
            tail.next = head;
        }
        else{
            tail.next = node;
            node.next = head;
            tail = node;
        }
    }

    // define the traversal() methord
    /*
     * Inside this methord i have created a feature where i have display all the element present in an array
     * from the circular linkedList.
     */
    public void traversal(){
        // define the properties
        Node duplicate = head;

        // define the condition
        if(duplicate == null){
            System.out.println("SORRY!! LinkedList is empty");
            return;
        }

        System.out.println("The element present in linkedlist is:");
        
        // define the while loop
        while(duplicate.next!= head){
            System.out.print(duplicate.data+" ");
            duplicate = duplicate.next;
        }
        System.out.print(duplicate.data+" ");
        System.out.println();
    }

    // define the Search() methord
    /*
     * Inside this methord i have created a feature where i search a key if that key present in circular likedlist
     * if that key present then return the address of node otherwise return the null.
     */
    public Node search(int key){
        // define the properties
        Node duplicate = head;
        // define the condition
        if(head == null ){
            System.out.println("SORRY !! Circular LinkedList is empty");
            return null;
        }
        else{
            // define the condition
            while(duplicate.next != head){
                // define the condition
                if(duplicate.data == key) {
                    return duplicate;
                }
                duplicate = duplicate.next;
            }
            if(duplicate.data == key){
                return duplicate;
            }
        }
        return null;
    }

    // define the insert() methord
    public void insert(int data1,int data2,String mode){
        // calling the node class Object
        Node node =  new Node(data2);
        // define the condition
        if (mode == null || (!mode.equalsIgnoreCase("Before") && !mode.equalsIgnoreCase("After"))) {
            System.out.println("SORRY!! Invalid mode. Use Before or After");
            return;
        }
        else{
            if(head == null || tail == null){
                head = node;
                tail = node;
                tail.next = head;
            }
            else{
                if(head.data == data1 && mode.equalsIgnoreCase("Before")){
                    node.next = head;
                    head = node;
                    tail.next = head;
                }
                else if(tail.data == data1 && mode.equalsIgnoreCase("After")){
                    tail.next = node;
                    node.next = head;
                    tail = node;
                }
                else{
                    // define the properties
                    Node duplicate = head;

                    // define the while loop
                    do{
                        // define the condition
                        if(duplicate.data == data1 && mode.equalsIgnoreCase("After")){
                            node.next = duplicate.next;
                            duplicate.next = node;
                            return;
                        }
                        if(duplicate.next.data == data1 && mode.equalsIgnoreCase("Before")){
                            node.next = duplicate.next;
                            duplicate.next = node;
                            return;
                        }
                        duplicate = duplicate.next;
                    }
                    while(duplicate!= head);
                    // define the way if given data not found
                    tail.next = node;
                    tail = node;
                    tail.next = head;
                    System.out.println("Target not found !! Insert at end");
                }
            }
        }
    }

    // define the delete() methord
    public void delete(int data){
        // define the condition
        if(head == null && tail == null){
            System.out.println("SORRY !! Array is empty");
        }
        else{
            if(head == tail){
                head = null;
                tail = null;
            }
            else if(head.data == data){
                head = head.next;
                tail.next = head;
                return;
            }
            else{
                // define the properties
                Node duplicate = head;
                do {
                    if (duplicate.next.data == data) {
                        if (duplicate.next == tail) {
                            tail = duplicate;
                        }
                        duplicate.next = duplicate.next.next;
                        return;
                    }
                    duplicate = duplicate.next;
                } 
                while (duplicate != head);

                System.out.println("SORRY!! Element not found");

            }
        }
    }
}
