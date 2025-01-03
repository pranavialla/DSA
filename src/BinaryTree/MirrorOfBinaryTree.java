package BinaryTree;
import BinaryTree.TreeNode.Node;

import java.util.LinkedList;
import java.util.Queue;


public class MirrorOfBinaryTree {
    Node iterativemirror(Node node) {
        if(node!=null){
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        while(q.size()!=0){
            Node a=q.poll();
            Node temp;
            if(a.left!=null)q.offer(a.left);
            if(a.right!=null)q.offer(a.right);
            temp=a.left;
            a.left=a.right;
            a.right=temp;

        }}
        return node;
    }
}
