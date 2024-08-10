package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import BinaryTree.BinaryTree.Node;


public class TreeTraversal {
    public void inOrderTraverssal(Node root){
        if( root!=null ){
            return;
        }

        inOrderTraverssal(root.left);
        System.out.println(root.data);
        inOrderTraverssal(root.right);

    }

    public List<Integer> inorderTraversal(Node root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.data);
            cur = cur.right;
        }

        return list;
    }

    public static List < Integer > getPreOrderTraversal(Node root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                list.add(cur.data);
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }

        return list;
    }
}
