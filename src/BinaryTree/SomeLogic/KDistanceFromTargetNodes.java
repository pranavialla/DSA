/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList();
        recur( root,  target,  k, result); 
        return result;
    }

    public int recur(TreeNode root, TreeNode target, int k, List<Integer> result ) {
        if(root==null) return -1;
        if(root.val==target.val) {
            succesorAtDistanceK( root, result,  k);
            return k-1;
        }

        int left = recur( root.left,  target, k, result);
        int right = recur( root.right,  target, k, result);

        if(left>0){
            succesorAtDistanceK( root.right, result,  left-1);
            return left-1;
        }

        if(right>0){
            succesorAtDistanceK( root.left, result,  right-1);
            return right-1;
        }

        if(left==0 || right==0) result.add(root.val);

        return -1;
    }

    public void succesorAtDistanceK(TreeNode root, List<Integer> result, int k){
        if(root==null) return ;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(k!=0){
            int s = q.size();
            for(int i=0; i<s; i++){
                TreeNode cur = q.poll();
                if(k==0) result.add(cur.val);
                if(cur.left!=null) q.offer(cur.left); 
                if(cur.right!=null) q.offer(cur.right); 
            }
            k-=1;
        }
        while(!q.isEmpty()){
            result.add(q.poll().val);
        }
    }
}