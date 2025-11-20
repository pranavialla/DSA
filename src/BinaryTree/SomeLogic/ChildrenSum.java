/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        /*
        
        
        
        */
        
        return recur( root);
        
    }
    
    public boolean recur(Node root){
        if(root==null) return true;
        boolean l = recur( root.left);
        boolean r = recur( root.right);
        
        if(root.left==null && root.right==null) return true;
        
        int leftVal = root.left!=null ?  root.left.data : 0;
        int rightVal = root.right!=null ?  root.right.data : 0;
        
        if((leftVal + rightVal == root.data) && l && r) return true;
        
        return false;
        
    }
}