public class BinaryTree {
    BinaryNode root;

    public static boolean isMirror(BinaryNode node1, BinaryNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null && node1.element == node2.element) {
            return (isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));
        }
        return false;
    }
}