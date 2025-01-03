package BinaryTree;

import javax.swing.tree.TreeNode;
import BinaryTree.TreeNode.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class WidthOfBinaryTree {

        public int widthOfBinaryTree(Node root) {
            if(root == null) return 0;
            Queue<Node> q = new LinkedList<>();
            Map<Node, Integer> m = new HashMap<>();
            q.offer(root);
            m.put(root, 1);
            int curW = 0;
            int maxW = 0;
            while(!q.isEmpty()){
                int size = q.size();
                int start = 0;
                int end = 0;
                for(int i = 0; i < size; i++){
                    Node node = q.poll();
                    if(i == 0) start = m.get(node);
                    if(i == size - 1) end = m.get(node);
                    if(node.left != null){
                        m.put(node.left, m.get(node) * 2);
                        q.offer(node.left);
                    }
                    if(node.right != null){
                        m.put(node.right, m.get(node) * 2 + 1);
                        q.offer(node.right);
                    }
                }
                curW = end - start + 1;
                maxW = Math.max(curW, maxW);
            }
            return maxW;

    }
}
