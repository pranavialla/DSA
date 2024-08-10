package BinaryTree;
import BinaryTree.BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;


public class MirrorOfBinaryTree {
    void iterativemirror(Node node) {
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        while(q.size()!=0){
            Node a=q.remove();
            Node temp;
            if(a.left!=null)q.add(a.left);
            if(a.right!=null)q.add(a.right);
            temp=a.left;
            a.left=a.right;
            a.right=temp;

        }
    }
}
