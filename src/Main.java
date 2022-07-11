import java.util.LinkedList;

/**
 * Kenny Shao
 * Professor: Kianoosh Boroojeni
 * This program calls the 3 different functions that return the count of values greater than target value in a binary tree, checks if a tree is symmetric or not
 * and removes the leaves from a tree.
 */
public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryNode(1);
        tree.root.left = new BinaryNode(2);
        tree.root.right = new BinaryNode(2);
        tree.root.left.left = new BinaryNode(3);
        tree.root.left.right = new BinaryNode(4);
        tree.root.right.left = new BinaryNode(4);
        tree.root.right.right = new BinaryNode(3);

        BinaryNode root = new BinaryNode(1);

        countGreaterThanValue(root, 1);
        if (isSymmetric(root)) {
            System.out.println("The tree is symmetric");
        } else {
            System.out.println("The tree is not symmetric");
        }

        removeLeaves(root);
    }
    // Uses a counter to keep track of number of elements greater than value
    public static void countGreaterThanValue(BinaryNode<Integer> root, int value) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(3);

        if (root == null)
            System.out.println("0 elements");
        int counter = 0;

        for(int child : list) {
            if (child > value)
                counter++;
        }
        System.out.println("The amount of elements greater than" + root + "is: " + counter);
    }
    // checks if the tree is symmetric or not
    public static boolean isSymmetric(BinaryNode<Integer> node) {
        BinaryNode<Integer> root = new BinaryNode(node);
        BinaryTree bTree = new BinaryTree();
        return bTree.isMirror(root, root);
    }
    // removes the leaves of a tree
    public static void removeLeaves(BinaryNode root) {
        if(root == null) return;
        else {
            if(root.left != null) {
                if(root.left.left == null && root.left.right == null) {
                    root.left = null;
                }
                else {
                    removeLeaves(root.left);
                }
            }
            if(root.right != null) {
                if(root.right.left == null && root.right.right == null) {
                    root.right = null;
                }
                else {
                    removeLeaves(root.right);
                }
            }
        }
    }
}
