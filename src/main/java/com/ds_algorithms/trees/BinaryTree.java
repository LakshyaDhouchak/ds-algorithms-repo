package com.ds_algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;


/*
 * Implementation of BinaryTree
 *
 * Key Operations Implemented:
 * 1. buildTree()  -> Build a binary tree from array input (with -1 as null marker).
 * 2. traversal()  -> Perform InOrder, PreOrder, and PostOrder traversals.
 * 3. Search()     -> Search for a key in the binary tree.
 * 4. countNode()  -> Count total number of nodes in the tree.
 * 5. levelOrder() -> Breadth First Search (BFS) / Level Order traversal.
 *
 * Time Complexity Analysis:
 * - Build Tree: O(n), each node is visited once while creating.
 * - Traversals (InOrder/PreOrder/PostOrder): O(n), each node is visited once.
 * - Search: O(n), in the worst case we might visit all nodes.
 * - Count Nodes: O(n), requires visiting all nodes.
 * - Level Order Traversal: O(n), each node is enqueued and dequeued once.
 * 
 */
public class BinaryTree {
    // define the static class node
    static class Node{
        // define the properties
        int data;
        Node left;
        Node right;
        // define the constructor
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // define the properties
    Node parent;
    int index = 0;

    // define the constructor
    public BinaryTree(){
        parent = null;
    }

    // define the buildTree() methord
    public void buildTree(int[] arr){
        index = 0;
        parent = Create(arr);
    }

    // define the create() methord
    public Node Create(int[] table){
        // define the condition
        if(index>= table.length){
            return null;
        }
        int data = table[index++];
        // define the base condition
        if(data == -1){
            return null;
        }
        // calling the node class Object
        Node node =  new Node(data);
        node.left = Create(table);
        node.right = Create(table);

        return node; 
    }

    // define the traversal() methord
    public void traversal(Node head, String mode){
        // define the base condition
        if(head == null){
            return;
        }
        // define the condition
        if(mode.equalsIgnoreCase("InOrder")){
            traversal(head.left,mode);
            System.out.print(head.data+" ");
            traversal(head.right, mode);
        }
        else if(mode.equalsIgnoreCase("PreOrder")){
            System.out.print(head.data+" ");
            traversal(head.left, mode);
            traversal(head.right, mode);
        }
        else if(mode.equalsIgnoreCase("PostOrder")){
            traversal(head.left, mode);
            traversal(head.right, mode);
            System.out.print(head.data+" ");
        }
    }

    // define the Search() methord
    public boolean Search(Node head,int key){
        // define the properties
        if(head == null){
            return false;
        }
        if(head.data == key){
            return true;
        }
        boolean leftresult = Search(head.left, key);
        // define the condition
        if(leftresult == true){
            return true;
        }
        boolean rightresult = Search(head.right, key);
        return rightresult;
    }

    // define the countNode() methord
    public int countNode(Node head){
        // define the condition
        if(head == null){
            return 0;
        }
        return 1+ countNode(head.left) + countNode(head.right);
    }

    // define the LevelOrder() methord
    public void levelOrder(Node head){
        if(head == null){
            return;
        }
        // define the properties
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        System.out.println("The element present in tree in Level Order");
        // define the condition
        while(!queue.isEmpty()){
            // define the properties
            Node current = queue.poll();
            System.out.print(current.data+" ");
            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right !=null){
                queue.add(current.right);
            }
        }
        System.out.println();
    }

    // define the height() methord 
    public int height(Node head){
        if(head == null) return 0;
        return 1 + Math.max(height(head.left), height(head.right));
    }

}
