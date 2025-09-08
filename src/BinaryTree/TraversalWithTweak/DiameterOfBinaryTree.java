package BinaryTree;

import BinaryTree.TreeNode.Node;

public class DiameterOfBinaryTree {
    int maxDiameter= 0;
    public int diameterOfBinaryTree(Node root) {
         
        getDiameter( root);
        return maxDiameter;
        
    }

    public int getDiameter(Node node){
        if(node!=null){
            int l = getDiameter( node.left);
            int r = getDiameter( node.right);

            maxDiameter = Math.max(maxDiameter, r+l);
            return  Math.max(l, r) + 1;
        }
        return 0;
    }
}
