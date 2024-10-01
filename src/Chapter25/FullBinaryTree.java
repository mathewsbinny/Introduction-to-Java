package Chapter25;

public class FullBinaryTree {
    public static class TreeNode<E> {
        E element;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E element) {this.element = element;}
    }

    public static class BinaryTree<E> {
        public int getSize(TreeNode<E> root, int level, int deepestLevel) {
            if (root == null) {
                return deepestLevel;
            }
            deepestLevel = getSize(root.left, level + 1, deepestLevel);
            if (level > deepestLevel) {
                deepestLevel = level;
            }
            deepestLevel = getSize(root.right, level + 1, deepestLevel);
            return deepestLevel;
        }

        public int getNumNodes(TreeNode<E> root) {
            if(root == null) {
                return 0;
            }
            return 1 + getNumNodes(root.left) + getNumNodes(root.right);
        }

        public boolean isComplete(TreeNode<E> root, int nodes) {
            int deepestLevel = getSize(root, 0, 0);
            return (Math.pow(2, (deepestLevel + 1)) - 1) == nodes;
        }
    }

    public static void main(String args[]) {
        //create tree
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);

        BinaryTree<Integer> tree = new BinaryTree<>();

        int numNodes = tree.getNumNodes(root);
        int deepestLevel = tree.getSize(root, 0, 0);
        boolean isComplete = tree.isComplete(root, numNodes);

        //test methods
        System.out.println("Num of Nodes: " + numNodes);
        System.out.println("Deepest Level: " + deepestLevel);
        System.out.println("Is tree complete: " + isComplete);
    }
}

//find depth
//find number of nodes
//check to make sure depth is same on both sides

// 1. find total depth
// 2. count number of nodes per level & verify if full for each level
// 3.
