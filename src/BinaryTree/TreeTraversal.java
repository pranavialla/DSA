package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import BinaryTree.TreeNode.Node;


public class TreeTraversal {
    public void inOrderRecurTraverssal(Node root){
        if( root!=null ){
            return;
        }

        inOrderRecurTraverssal(root.left);
        System.out.println(root.data);
        inOrderRecurTraverssal(root.right);
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



    public void postOrderRecurTraverssal(Node root){
        if( root!=null ){
            return;
        }

        postOrderRecurTraverssal(root.left);
        postOrderRecurTraverssal(root.right);
        System.out.println(root.data);

    }

    public List postorderTraversal(Node root) {
        Stack stack = new Stack();
        List list = new ArrayList();
        Node pre = null;
        Node current = root;
        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            current = (Node) stack.pop();
            if(current.right != null && pre != current.right) {
                stack.push(current);
                current = current.right;
                continue;
            }
            list.add(current.data);
            pre = current;
            current = null;

        }
        return list;
    }




    public void preOrderRecurTraverssal(Node root){
        if( root!=null ){
            return;
        }

        System.out.println(root.data);
        preOrderRecurTraverssal(root.left);
        preOrderRecurTraverssal(root.right);
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
