package Chapter25;

import javax.swing.tree.TreeNode;

public class BinaryTreeTraversal {
    public static void main(String[] args) {
        // Create the binary tree
        BinaryTreeTraversal tree = new BinaryTreeTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Print postorder traversal of the binary tree
        System.out.println("Postorder traversal of binary tree is:");
        tree.postorder(root);
        System.out.println("\nInorder traversal of binary tree is:");
        tree.inorder(root);
        System.out.println("\nPreorder traversal of binary tree is:");
        tree.preorder(root);
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    //Post-Order traversal using recursion
    private void postorder (TreeNode root){
    //It won't return any value, but print E as it traverses the binary tree identified by the root node.
        if(root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print("E ");
    }

    private void inorder ( TreeNode root){
    //It won't return any value, but print E as it traverses the binary tree identified by the root node.
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print("E ");
        inorder(root.right);
    }

    private void preorder ( TreeNode root){
    //It won't return any value, but print E as it traverses the binary tree identified by the root node.
        if (root == null) {
            return;
        }
        System.out.print("E ");
        preorder(root.left);
        preorder(root.right);
    }
}
