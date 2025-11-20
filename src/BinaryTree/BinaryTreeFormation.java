package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFormation {


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderIndex.put(inorder[i], i);}
        return build(postorder.length-1 , 0, inorder.length-1, postorder, inorderIndex);
        }
        
    
    public TreeNode build(int rootIndex, int inStart, int inEnd, int[] postorder, Map<Integer, Integer> inorder){
        if(inEnd<inStart) return null;
        
        TreeNode root = new TreeNode(postorder[rootIndex]);
        
        int rootIndexInInOrder = inorder.get(postorder[rootIndex]);
        int rightSubtreeSize = inEnd - rootIndexInInOrder;

        root.left  = build( rootIndex-rightSubtreeSize-1, inStart, rootIndexInInOrder-1, postorder, inorder);
        root.right = build( rootIndex-1, rootIndexInInOrder+1, inEnd, postorder, inorder);
        
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderIndex.put(inorder[i], i);}
        return build(0 , 0, inorder.length-1, preorder, inorderIndex);
    }
        
    
    public TreeNode build(int rootIndex, int treeStart, int treeEnd, int[] preorder, Map<Integer, Integer> inorder){
        if(treeEnd<treeStart) return null;
        
        TreeNode root = new TreeNode(preorder[rootIndex]);
        
        int rootIndexInInOrder = inorder.get(preorder[rootIndex]);
        int nodesInLeftSubTree =  rootIndexInInOrder-treeStart ;
        int leftTreeEnd = treeStart + nodesInLeftSubTree - 1;
        int rightSubtreeStart = leftTreeEnd+2;
        int rightTreeRootIndex = rootIndex + nodesInLeftSubTree +1;
        
        root.left =  build( rootIndex+1, treeStart, leftTreeEnd, preorder, inorder);
        root.right =  build( rightTreeRootIndex, rightSubtreeStart, treeEnd, preorder, inorder);
        
        return root;
    }
}
