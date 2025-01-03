package BinaryTree;

import BinaryTree.TreeNode.Node;

public class GoodNode {
    public int goodNodes(Node root) {
        return traverse(root, Integer.MIN_VALUE, 0);
    
}

public int traverse(Node node, int curMax, int count){
    
    if(node!=null){
        
        int countl = traverse(node.left, Math.max(node.data, curMax), count);
        int countr = traverse(node.right, Math.max(node.data, curMax), count);
        
        return node.data>=curMax ? 1+countl+ countr : countl+ countr;
    
    }
    return count;
}
}
