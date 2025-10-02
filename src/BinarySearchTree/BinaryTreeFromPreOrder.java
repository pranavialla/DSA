class Solution {
    int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return recur(Integer.MIN_VALUE, Integer.MAX_VALUE, preorder);
    }

    private TreeNode recur(int min, int max, int[] preorder) {
        if (i >= preorder.length) return null;

        int val = preorder[i];
        if (val < min || val > max) return null;

        TreeNode root = new TreeNode(val);
        i++;
        root.left = recur(min, val, preorder);
        root.right = recur(val, max, preorder);
        return root;
    }

     public static int i = 1;

    public TreeNode bstFromPreorder(int[] preorder) {
        i = 1; // reset index for safety
        TreeNode root  =new TreeNode(preorder[0]);
        recur(root, Integer.MIN_VALUE, Integer.MAX_VALUE, preorder);
        return root;
    }
        

    public void recur(TreeNode root, int min, int max, int[] preorder) {
        // Build left subtree
        if (i < preorder.length && preorder[i] >= min && preorder[i] < root.val) {
            root.left = new TreeNode(preorder[i]);
            i++;
            recur(root.left, min, root.val, preorder);
        }

        // Build right subtree
        if (i < preorder.length && preorder[i] > root.val && preorder[i] <= max) {
            root.right = new TreeNode(preorder[i]);
            i++;
            recur(root.right, root.val, max, preorder);
        }

        return ;
    }
}
