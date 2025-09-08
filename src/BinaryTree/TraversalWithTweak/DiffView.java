package BinaryTree;

import java.util.*;
import BinaryTree.TreeNode.Node;

class Pair<N, I extends Number> {

    public Pair(N root, I i) {
    }

    public int getValue() {
        return 0;
    }

    public Node getKey() {
        return new Node(1);
    }
}

class DiffView
{
    //Function to return list containing elements of left view of binary tree.
    private void recursionLeft(Node root, int level, List<Integer> res) {
        // Check if the current node is null
        if (root == null) {
            return;
        }

        // Check if the size of the result list
        // is equal to the current level
        if (res.size() == level) {
            // If equal, add the value of the
            // current node to the result list
            res.add(root.data);
        }

        // Recursively call the function for the
        // left child with an increased level
        recursionLeft(root.left, level + 1, res);

        // Recursively call the function for the
        // right child with an increased level
        recursionLeft(root.right, level + 1, res);
    }


    ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> leftveiw = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        
        if(root!=null){
            queue.add(root);
        }
        
        while( !queue.isEmpty() ){
            leftveiw.add(queue.peek().data);
            int size = queue.size();
            for( int i=0; i<size; i++ ){
                Node node =  queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        
        return leftveiw;
    }

    // Recursive function to traverse the
    // binary tree and populate the right-side view
    private void recursionRight(Node root , int level, List<Integer> res) {
        // Check if the current node is null
        if (root == null) {
            return;
        }

        // Check if the size of the result list
        // is equal to the current level
        if (res.size() == level) {
            // If equal, add the value of the
            // current node to the result list
            res.add(root.data);

            // Recursively call the function for the
            // right child with an increased level
            recursionRight(root.right, level + 1, res);

            // Recursively call the function for the
            // left child with an increased level
            recursionRight(root.left, level + 1, res);
        }
    }

    public List<Integer> bottomView(Node root) {
        // List to store the result
        List<Integer> ans = new ArrayList<>();

        // Check if the tree is empty
        if(root == null) {
            return ans;
        }

        // Map to store the bottom view nodes
        // based on their vertical positions
        Map<Integer, Integer> mpp = new TreeMap<>();

        // Queue for BFS traversal, each
        // element is a pair containing node
        // and its vertical position
        Queue<Pair<Node, Integer>> q = new LinkedList<>();

        // Push the root node with its vertical
        // position (0) into the queue
        q.add(new Pair<>(root, 0));

        // BFS traversal
        while(!q.isEmpty()) {
            // Retrieve the node and its vertical
            // position from the front of the queue
            Pair<Node, Integer> pair = q.poll();
            Node node = pair.getKey();
            int line = pair.getValue();

            // Update the map with the node's data
            // for the current vertical position
            mpp.put(line, node.data);

            // Process left child
            if(node.left != null) {
                // Push the left child with a decreased
                // vertical position into the queue
                q.add(new Pair<>(node.left, line - 1));
            }

            // Process right child
            if(node.right != null) {
                // Push the right child with an increased
                // vertical position into the queue
                q.add(new Pair<>(node.right, line + 1));
            }
        }
        return ans;
    }
    public List<Integer> topView(Node root) {
        // List to store the result
        List<Integer> ans = new ArrayList<>();

        // Check if the tree is empty
        if (root == null) {
            return ans;
        }

        // Map to store the top view nodes
        // based on their vertical positions
        Map<Integer, Integer> mpp = new TreeMap<>();

        // Queue for BFS traversal, each element
        // is a pair containing node 
        // and its vertical position
        Queue<Pair<Node, Integer>> q = new LinkedList<>();

        // Push the root node with its vertical
        // position (0) into the queue
        q.add(new Pair<>(root, 0));

        // BFS traversal
        while (!q.isEmpty()) {
            // Retrieve the node and its vertical
            // position from the front of the queue
            Pair<Node, Integer> pair = q.poll();
            Node node = pair.getKey();
            int line = pair.getValue();

            // If the vertical position is not already
            // in the map, add the node's data to the map
            if (!mpp.containsKey(line)) {
                mpp.put(line, node.data);
            }

            // Process left child
            if (node.left != null) {
                // Push the left child with a decreased
                // vertical position into the queue
                q.add(new Pair<>(node.left, line - 1));
            }

            // Process right child
            if (node.right != null) {
                // Push the right child with an increased
                // vertical position into the queue
                q.add(new Pair<>(node.right, line + 1));
            }
        }

        // Function to return list containing elements of right view of binary tree.
        return ans;
    }
}
