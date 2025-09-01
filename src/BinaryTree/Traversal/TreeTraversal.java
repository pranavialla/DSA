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

    public List<Integer> inorderTraversalIterativeWhile(Node root) {
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

    public List<Integer> inorderTraversalIteraitve2(TreeNode root) {
        List<Integer> inOrder = new ArrayList();
        Stack<Object> stack = new Stack();
        if(root==null) return inOrder;
        stack.push(root);
        while(!stack.isEmpty()){
            Object obj = stack.pop();

            if (obj instanceof TreeNode) {
                TreeNode cur = (TreeNode) obj;
                
                if(cur.right!=null){
                    stack.push(cur.right);
                }
                stack.push(cur.val);
                if(cur.left!=null){
                    stack.push(cur.left);
                }
            }
            else{
                inOrder.add((Integer) obj);
            }
            
            
        }
        return inOrder;
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

    public List<Integer> postorderTraversalIterative2(TreeNode root) {
        List<Integer> inOrder = new ArrayList();
        Stack<Object> stack = new Stack();
        if(root==null) return inOrder;
        stack.push(root);
        while(!stack.isEmpty()){
            Object obj = stack.pop();
            if (obj instanceof TreeNode) {
                TreeNode cur = (TreeNode) obj;
                stack.push(cur.val);
                if(cur.right!=null){
                    stack.push(cur.right);
                }
                
                if(cur.left!=null){
                    stack.push(cur.left);
                }
            }
            else{
                inOrder.add((Integer) obj);
            }
            
            
        }
        return inOrder;
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

    public List<Integer> preorderTraversalIterative2(TreeNode root) {
        List<Integer> inOrder = new ArrayList();
        Stack<Object> stack = new Stack();
        if(root==null) return inOrder;
        stack.push(root);
        while(!stack.isEmpty()){
            Object obj = stack.pop();
            if (obj instanceof TreeNode) {
                TreeNode cur = (TreeNode) obj;
                
                if(cur.right!=null){
                    stack.push(cur.right);
                }
                if(cur.left!=null){
                    stack.push(cur.left);
                }
                stack.push(cur.val);
            }
            else{
                inOrder.add((Integer) obj);
            }
            
            
        }
        return inOrder;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        System.gc();
        return result;
    }

    void dfs(TreeNode root, int level, List<List<Integer>> result) {
        if(root == null) return;

        if(result.size() <= level) 
            result.add(new LinkedList<>());

        result.get(level).add(root.val);

        dfs(root.left, level+1, result);
        dfs(root.right, level+1, result);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
        }
        return result;
    }


}
