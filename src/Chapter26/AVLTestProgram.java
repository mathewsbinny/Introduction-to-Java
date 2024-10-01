package Chapter26;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AVLTestProgram {
    // TreeNode class for AVL Tree
    class TreeNode {
        int value, height;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
            this.height = 1;
        }
    }

    // AVL Tree class
    class AVLTree {
        private TreeNode root;

        // Get height of the tree
        private int height(TreeNode N) {
            if (N == null)
                return 0;
            return N.height;
        }

        // Get maximum of two integers
        private int max(int a, int b) {
            return (a > b) ? a : b;
        }

        // Right rotate subtree rooted with y
        private TreeNode rightRotate(TreeNode y) {
            TreeNode x = y.left;
            TreeNode T2 = x.right;

            x.right = y;
            y.left = T2;

            y.height = max(height(y.left), height(y.right)) + 1;
            x.height = max(height(x.left), height(x.right)) + 1;

            return x;
        }

        // Left rotate subtree rooted with x
        private TreeNode leftRotate(TreeNode x) {
            TreeNode y = x.right;
            TreeNode T2 = y.left;

            y.left = x;
            x.right = T2;

            x.height = max(height(x.left), height(x.right)) + 1;
            y.height = max(height(y.left), height(y.right)) + 1;

            return y;
        }

        // Get balance factor of node N
        private int getBalance(TreeNode N) {
            if (N == null)
                return 0;
            return height(N.left) - height(N.right);
        }

        public void insert(int value) {
            root = insertRec(root, value);
        }

        private TreeNode insertRec(TreeNode node, int value) {
            if (node == null)
                return new TreeNode(value);

            if (value < node.value)
                node.left = insertRec(node.left, value);
            else if (value > node.value)
                node.right = insertRec(node.right, value);
            else
                return node;

            node.height = 1 + max(height(node.left), height(node.right));

            int balance = getBalance(node);

            if (balance > 1 && value < node.left.value)
                return rightRotate(node);

            if (balance < -1 && value > node.right.value)
                return leftRotate(node);

            if (balance > 1 && value > node.left.value) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            if (balance < -1 && value < node.right.value) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }

        public boolean search(int value) {
            return searchRec(root, value);
        }

        private boolean searchRec(TreeNode node, int value) {
            if (node == null) {
                return false;
            }

            if (node.value == value) {
                return true;
            }

            if (node.value > value) {
                return searchRec(node.left, value);
            }

            return searchRec(node.right, value);
        }

        public void delete(int value) {
            root = deleteRec(root, value);
        }

        private TreeNode deleteRec(TreeNode root, int value) {
            if (root == null) {
                return root;
            }

            if (value < root.value) {
                root.left = deleteRec(root.left, value);
            } else if (value > root.value) {
                root.right = deleteRec(root.right, value);
            } else {
                if ((root.left == null) || (root.right == null)) {
                    TreeNode temp = null;
                    if (temp == root.left)
                        temp = root.right;
                    else
                        temp = root.left;

                    if (temp == null) {
                        temp = root;
                        root = null;
                    } else
                        root = temp;
                } else {
                    TreeNode temp = minValueNode(root.right);
                    root.value = temp.value;
                    root.right = deleteRec(root.right, temp.value);
                }
            }

            if (root == null)
                return root;

            root.height = max(height(root.left), height(root.right)) + 1;

            int balance = getBalance(root);

            if (balance > 1 && getBalance(root.left) >= 0)
                return rightRotate(root);

            if (balance > 1 && getBalance(root.left) < 0) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }

            if (balance < -1 && getBalance(root.right) <= 0)
                return leftRotate(root);

            if (balance < -1 && getBalance(root.right) > 0) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }

            return root;
        }

        private TreeNode minValueNode(TreeNode node) {
            TreeNode current = node;
            while (current.left != null)
                current = current.left;

            return current;
        }
    }

    // Main method to test the AVL Tree
    public static void main(String[] args) {
        final int SIZE = 500000;
        Integer[] numbers = new Integer[SIZE];
        Random rand = new Random();

        for (int i = 0; i < SIZE; i++) {
            numbers[i] = rand.nextInt(Integer.MAX_VALUE);
        }

        AVLTestProgram testProgram = new AVLTestProgram();
        AVLTree avlTree = testProgram.new AVLTree();

        // Record start time for insertion
        long startInsert = System.nanoTime();

        // Insert numbers into AVL Tree
        for (int num : numbers) {
            avlTree.insert(num);
        }

        // Record end time for insertion
        long endInsert = System.nanoTime();

        // Shuffle numbers
        List<Integer> numberList = Arrays.asList(numbers);
        Collections.shuffle(numberList);
        numberList.toArray(numbers);

        // Record start time for search
        long startSearch = System.nanoTime();

        // Search numbers in AVL Tree
        for (int num : numbers) {
            avlTree.search(num);
        }

        // Record end time for search
        long endSearch = System.nanoTime();

        // Shuffle numbers again
        Collections.shuffle(numberList);
        numberList.toArray(numbers);

        // Record start time for deletion
        long startDelete = System.nanoTime();

        // Delete numbers from AVL Tree
        for (int num : numbers) {
            avlTree.delete(num);
        }

        // Record end time for deletion
        long endDelete = System.nanoTime();

        // Calculate elapsed times
        long insertTime = endInsert - startInsert;
        long searchTime = endSearch - startSearch;
        long deleteTime = endDelete - startDelete;

        // Convert to milliseconds and print results
        System.out.println("Insertion time: " + insertTime / 1_000_000.0 + " ms");
        System.out.println("Search time: " + searchTime / 1_000_000.0 + " ms");
        System.out.println("Deletion time: " + deleteTime / 1_000_000.0 + " ms");

        System.out.println("AVL Tree operations completed.");
    }
}

