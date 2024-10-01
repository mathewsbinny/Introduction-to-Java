package Chapter26;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BSTTestProgram {
    // TreeNode class
    class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
            left = right = null;
        }
    }

    // BST class
    class BST {
        private TreeNode root;

        public void insert(int value) {
            root = insertRec(root, value);
        }

        private TreeNode insertRec(TreeNode root, int value) {
            if (root == null) {
                root = new TreeNode(value);
                return root;
            }

            if (value < root.value) {
                root.left = insertRec(root.left, value);
            } else if (value > root.value) {
                root.right = insertRec(root.right, value);
            }

            return root;
        }

        public boolean search(int value) {
            return searchRec(root, value);
        }

        private boolean searchRec(TreeNode root, int value) {
            if (root == null) {
                return false;
            }

            if (root.value == value) {
                return true;
            }

            if (root.value > value) {
                return searchRec(root.left, value);
            }

            return searchRec(root.right, value);
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
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }

                root.value = minValue(root.right);
                root.right = deleteRec(root.right, root.value);
            }

            return root;
        }

        private int minValue(TreeNode root) {
            int minValue = root.value;
            while (root.left != null) {
                minValue = root.left.value;
                root = root.left;
            }
            return minValue;
        }
    }

    // Main method to test the BST
    public static void main(String[] args) {
        final int SIZE = 500000;
        Integer[] numbers = new Integer[SIZE];
        Random rand = new Random();

        for (int i = 0; i < SIZE; i++) {
            numbers[i] = rand.nextInt(Integer.MAX_VALUE);
        }

        BSTTestProgram testProgram = new BSTTestProgram();
        BST bst = testProgram.new BST();

        // Record start time for insertion
        long startInsert = System.nanoTime();

        // Insert numbers into BST
        for (int num : numbers) {
            bst.insert(num);
        }

        // Record end time for insertion
        long endInsert = System.nanoTime();

        // Shuffle numbers
        List<Integer> numberList = Arrays.asList(numbers);
        Collections.shuffle(numberList);
        numberList.toArray(numbers);

        // Record start time for search
        long startSearch = System.nanoTime();

        // Search numbers in BST
        for (int num : numbers) {
            bst.search(num);
        }

        // Record end time for search
        long endSearch = System.nanoTime();

        // Shuffle numbers again
        Collections.shuffle(numberList);
        numberList.toArray(numbers);

        // Record start time for deletion
        long startDelete = System.nanoTime();

        // Delete numbers from BST
        for (int num : numbers) {
            bst.delete(num);
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

        System.out.println("BST operations completed.");
    }
}
