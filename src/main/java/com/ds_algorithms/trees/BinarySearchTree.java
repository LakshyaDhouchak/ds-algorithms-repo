package com.ds_algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Implmentation of Binary Search Tree
 *  Key Points:
 * - BST Rule: Left child < Parent, Right child > Parent
 * - Insertion: Insert at correct leaf position, maintaining BST property
 * - Search: Traverse left or right depending on key
 * - Deletion:
 *    1. Node has no child (leaf) → delete directly
 *    2. Node has one child → replace node with child
 *    3. Node has two children → replace with inorder successor (min of right subtree)
 * - Traversals:
 *    * InOrder → Left, Root, Right (gives sorted order)
 *    * PreOrder → Root, Left, Right
 *    * PostOrder → Left, Right, Root
 *    * Level Order → BFS using Queue
 * - Min Value → left-most node
 * - Max Value → right-most node
 *
 * Time Complexity (n = number of nodes, h = height of tree):
 * - Insertion: O(h)   → O(log n) in balanced, O(n) in skewed
 * - Search:    O(h)   → O(log n) in balanced, O(n) in skewed
 * - Deletion:  O(h)   → O(log n) in balanced, O(n) in skewed
 * - Traversals: O(n)  (visit every node once)
 * - Find Min/Max: O(h)
 *
 */
public class BinarySearchTree {
    // define the Node class
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node parent;

    // define the constructor
    public BinarySearchTree() {
        parent = null;
    }

    // define the Insert() methord
    public void Insert(int key) {
        parent = Create(parent, key);
    }

    // define the create() methord
    private Node Create(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = Create(root.left, key);
        } else if (key > root.data) {
            root.right = Create(root.right, key);
        }
        return root;
    }

    // define the Traversals() methord
    public void traversal(Node head, String mode) {
        if (head == null) return;

        if (mode.equalsIgnoreCase("InOrder")) {
            traversal(head.left, mode);
            System.out.print(head.data + " ");
            traversal(head.right, mode);
        } else if (mode.equalsIgnoreCase("PreOrder")) {
            System.out.print(head.data + " ");
            traversal(head.left, mode);
            traversal(head.right, mode);
        } else if (mode.equalsIgnoreCase("PostOrder")) {
            traversal(head.left, mode);
            traversal(head.right, mode);
            System.out.print(head.data + " ");
        } else {
            System.out.println("Invalid mode, defaulting to InOrder:");
            traversal(head.left, "InOrder");
            System.out.print(head.data + " ");
            traversal(head.right, "InOrder");
        }
    }

    //  define the LevelOrder() methord
    public void LevelOrder(Node head) {
        if (head == null) return;

        System.out.println("Level order traversal:");
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    // define the Search() methord
    public boolean Search(int key) {
        return SearchRec(parent, key);
    }

    private boolean SearchRec(Node head, int key) {
        if (head == null) return false;
        if (head.data == key) return true;

        if (key < head.data) {
            return SearchRec(head.left, key);
        } else {
            return SearchRec(head.right, key);
        }
    }

    // define the Minimum() methord
    public int min() {
        Node dup = parent;
        if (dup == null) {
            throw new IllegalStateException("Tree is Empty !!");
        }
        while (dup.left != null) {
            dup = dup.left;
        }
        return dup.data;
    }

    // define the Maximum() methord
    public int max() {
        Node dup = parent;
        if (dup == null) {
            throw new IllegalStateException("Tree is Empty !!");
        }
        while (dup.right != null) {
            dup = dup.right;
        }
        return dup.data;
    }

    // define the Delete() methord
    public void delete(int key) {
        parent = deleteRec(parent, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) return null;

        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        } else {
            // Case 1: no children
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: one child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: two children
            root.data = MinValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private int MinValue(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    // Getter for root
    public Node getRoot() {
        return parent;
    }
}
