package com.ds_algorithms.DataStructure.linkedlists;
/*
 * Implemetation of Double linkedList in java 
 * 
 * Key points:
 * - useful when we want non-contigious memeory allocation
 * - variable length
 * - operation we perform: insert(),create(), delete(, search() etc)
 * 
 * NOTE : In Double linkedlist  element can traverse left to right OR right to left. And it recommended when
 *        we don't want to waste the unused memory present in small chunk around the memory.
 * 
 * Time Complexity(worst case):
 * - insert/delete :O(n)
 * - traversal :O(n)
 * - search :O(n)
 * - update :O(n)
 */
public class doubleLinkedList {
    // define the static node class
    static class Node{
        // define the properties
        int data;
        Node prev;
        Node next;

        // define the constructor
        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    // define the properties
    node head = null;
    node tail = null;

    // define the create() methord
    /*
     * Inside this methord i have created a feature where we add data in double linkedList given
     * by the user.
     */
    public void create(int data){
        // calling the node class object
        Node node =  new Node(data);

        // define the condition
        if(head == null){
            head = node;
            tail = node;
        }
        else{
            node duplicate = head;
            // define the for loop
            while(duplicate.next != null){
                duplicate = duplicate.next;
            }
            duplicate.next = node;
            node.prev = duplicate;
            tail = node;
        }
    }

    // define the  traversal() methord
    /*
     * Inside this methord i have created a feature where we can traversal the double linkedList.
     * The two ways:
     * - Forward traversal
     * - Backward traversal
     */
    public void traversal(String mode){
        // define the choice
        if(mode == null){
            System.out.println("Sorry !! invalid mode. Use Forward Or Backward");
        }
        else{
            if(head == null && tail == null){
                System.out.println("SORRY!! LinkedList is empty");
            }
            else{
                // define the properties
                Node duplicate = null;
                // define the condition
                System.out.println("The element present in double linkedList is:");
                if(mode.equalsIgnoreCase("Forward")){
                    duplicate =  head;
                    // define the while loop
                    while(duplicate != null){
                        System.out.print(duplicate.data+" ");
                        duplicate = duplicate.next;
                    }
                    System.out.println();
                }
                else{
                    duplicate = tail;
                    // define the while loop
                    while(duplicate!=null){
                        System.out.print(duplicate.data+" ");
                        duplicate = duplicate.prev;
                    }
                    System.out.println();
                }
            }
        }
    }

    // define the search() methord
    /*
     * Inside this methord i have created a feature where i have search a given key in double linkedlist.
     * 
     * Key points:
     * - if linkedlist is empty return "LinkedList is empty".
     * - if element found then return address where it present in memeory otherwise
     *   return null.
     */
    public Node search(int key){
        // define the condition
        if(head == null && tail == null){
            System.out.println("SORRY!! LinkedList is empty");
        }
        else{
            // define the properties
            Node duplicate = head;
            // define the while loop
            while(duplicate != null){
                // define the condition
                if(duplicate.data == key){
                    return duplicate;
                }
                duplicate = duplicate.next;
            }
        }
        return null;
    }


    // define the insert() methord
    /*
     * Inside this methord i have created a feature where we have inserted data in doubly linkedlist.
     * 
     * Key points (Before/After):
     * - Insertion at starting
     * - Insertion at end
     * - Insertion at middle
     */
    public void insert(int data1, int data2 , String mode){
        // calling the node class Object
        Node node =  new node(data2);
        // define the base condition
        if(mode == null){
            System.out.println("SORRY!! Invalid mode . use Before Or After");
            return;
        }
        else{
            if(head == null && tail == null ){
                head =node;
                tail= node;
            }
            else{
                // define the condition
                if(head.data == data1 && mode.equalsIgnoreCase("Before")){
                    node.next = head;
                    head.prev = node;
                    head = node;
                }
                else if(tail.data == data1 && mode.equalsIgnoreCase("After")){
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                }
                else{
                    // define the properties
                    Node duplicate = head;
                    // define the while loop
                    while(duplicate != null){
                        // define the condition
                        if(duplicate.data == data1 && mode.equalsIgnoreCase("After")){
                            node.next = duplicate.next;
                            node.prev = duplicate;
                            if(duplicate.next!= null){  
                                duplicate.next.prev = node;
                            }    
                            duplicate.next = node;
                            return;
                        }

                        if(duplicate.data == data1 && mode.equalsIgnoreCase("Before")){
                            node.next = duplicate;
                            node.prev = duplicate.prev;
                            duplicate.prev.next = node;
                            duplicate.prev = node;
                            return;

                        }
                        duplicate = duplicate.next;

                    }
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                    System.out.println("Target not found, inserted at end.");
                }
            }
        }
    }

    // define the delete() methord
    /*
     * Inside this methord i have created a feature where i have delete node from double linkedlist 
     * Basic operation:
     * - Deletion at starting
     * - Deletion at middle
     * - Deletion at end
     */
    public void delete(int data1){
        // define the condition
        if(head == null && tail == null){
            System.out.println("SORRY!! LinkedList is empty");
        }
        else{
            if(head.data == data1){
                if(head == tail){
                    head = null;
                    tail = null;
                }
                else{
                    head = head.next;
                    head.prev = null;
                }    
            }
            else if(tail.data == data1){
                if(head == tail){
                    head = null;
                    tail = null;
                }
                else{
                    tail = tail.prev;
                    tail.next = null; 
                }    
                
            }
            else{
                // define the properties
                Node duplicate = head;
                boolean flag = false;
                // define the while -loop
                while(duplicate != null){
                    // define the condition
                    if(duplicate.data == data1){
                        duplicate.next.prev = duplicate.prev;
                        duplicate.prev.next = duplicate.next;
                        flag = true;
                        break;
                    }
                    duplicate =  duplicate.next;
                }
                // define the base condition
                if(flag == false){
                    System.out.println("SORRY!! Element not present in linkedList");
                }
            }
        }
    }
}
