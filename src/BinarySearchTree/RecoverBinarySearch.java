/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> sorted = new ArrayList();
        sort( root, sorted) ;
        int[] swappedIndex = check(sorted);
        int temp = sorted.get(swappedIndex[0]).val;
        sorted.get(swappedIndex[0]).val = sorted.get(swappedIndex[1]).val;
        sorted.get(swappedIndex[1]).val = temp;
    }

    public void sort(TreeNode root, List<TreeNode> sorted ) {
        if(root!=null){
            sort( root.left,  sorted );
            sorted.add(root);
            sort( root.right,  sorted );
        }
    }

    public int[] check(List<TreeNode> sorted){
        int[] swappedIndex = new int[2];
        //int c=0;
        boolean firstFound = false;
        for(int i=0; i<sorted.size()-1; i++){
            if(sorted.get(i).val > sorted.get(i+1).val){
                if(!firstFound){
                    swappedIndex[0]=i;
                    firstFound = true;
                }
                swappedIndex[1]=i+1;
            }
        }
        return swappedIndex;
    }

    TreeNode firstElement = null;
    TreeNode secondElement = null;
    // The reason for this initialization is to avoid null pointer exception in the first comparison when prevElement has not been initialized
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree2(TreeNode root) {
        
        // In order traversal to find the two elements
        traverse(root);
        
        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    
    private void traverse(TreeNode root) {
        
        if (root == null)
            return;
            
        traverse(root.left);
        
        // Start of "do some business", 
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }
    
        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }        
        prevElement = root;

        // End of "do some business"

        traverse(root.right);
}
public void recoverTree3(TreeNode root) {
    TreeNode pre = null, first = null, second = null;

    while (root != null) {
        if (root.left != null) {
            TreeNode temp = root.left;
            while (temp.right != null && temp.right != root) {
                temp = temp.right;
            }
            if (temp.right == null) {
                temp.right = root;
                root = root.left;
            } else {
                temp.right = null;
                if (pre != null && pre.val > root.val) {
                    if (first == null) first = pre;
                    second = root;
                }
                pre = root;
                root = root.right;
            }
        } else {
            if (pre != null && pre.val > root.val) {
                if (first == null) first = pre;
                second = root;
            }
            pre = root;
            root = root.right;
        }
    }

    // Swap values
    if (first != null && second != null) {
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }
}
}