package BinaryTree;

import BinaryTree.TreeNode.Node;


public class LowestCommonAncester {
    public Node lowestCommonAncestor(Node root, Node p, Node q) {

        if(root==null || root.data==p.data || root.data==q.data){
            return root;
        }

        Node isFoundInLeft = lowestCommonAncestor( root.left, p, q);
        Node ifFoundInRight = lowestCommonAncestor( root.right, p, q);

        if(isFoundInLeft != null && ifFoundInRight != null){
            return root;
        }
        else if(isFoundInLeft == null ){
            return ifFoundInRight;
        }
        else{
            return isFoundInLeft;
        }
        
    }
}
