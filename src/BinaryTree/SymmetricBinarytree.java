package BinaryTree;
import BinaryTree.BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;


public class SymmetricBinarytree {
    public boolean isSymmetric(Node root) {
        if(root == null)
            return true;
        Queue<Node> q = new LinkedList();

        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            Node left = q.poll();
            Node right = q.poll();
            if(left == null && right == null)
                continue;
            if(left == null || right == null ||left.data != right.data )
                return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);

        }
        return true;
    }

    public boolean isSymmetric(Node left, Node right){
        if(left==null || right==null) return left==right;
        if(left.data==right.data){
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }
}
