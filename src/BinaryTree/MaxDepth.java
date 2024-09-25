package BinaryTree;
import BinaryTree.BinaryTree.Node;

public class MaxDepth {
    public int maxDepth(Node root) {
        if(root==null) return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
