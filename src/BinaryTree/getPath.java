package BinaryTree;
import BinaryTree.TreeNode.Node;

import java.util.List;

public class getPath {
    public boolean getPath(Node root, List<Integer> arr, int x) {
        // Base case: If the current
        // node is null, return false
        if (root == null) {
            return false;
        }

        // Add the current node's
        // value to the path list
        arr.add(root.data);

        // If the current node's value is equal
        // to the target value 'x', return true
        if (root.data == x) {
            return true;
        }

        // Recursively search for the target value
        // 'x' in the left and right subtrees
        if (getPath(root.left, arr, x) || getPath(root.right, arr, x)) {
            return true;
        }

        // If the target value 'x' is not found
        // in the current path, backtrack
        arr.remove(arr.size() - 1);
        return false;
    }
}
