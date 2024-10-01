package Chapter25;

public class TreeNode<E> {

        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }

        protected void preorder(TreeNode<E> root) {
            if (root == null) {
                return;
            }
            System.out.print(root.element + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void main(String[] args) {
            // Creating a sample tree
            TreeNode<Integer> root = new TreeNode<>(1);
            root.left = new TreeNode<>(2);
            root.right = new TreeNode<>(3);
            root.left.left = new TreeNode<>(4);
            root.left.right = new TreeNode<>(5);
            root.right.left = new TreeNode<>(6);
            root.right.right = new TreeNode<>(7);

            root.preorder(root); // Expected output: 1 2 4 5 3 6 7
        }
}
