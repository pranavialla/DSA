package BinaryTree;

public class BinaryTree {
    Node root;
    public static class Node{
        Node left;
        Node right;
        int data;
        Node (int data){

            this.data=data;
            this.left=null;
            this.right=null;

        }
    }
}
