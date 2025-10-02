class Insert {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
            recur( root, val);
            return root;
    }
    
    public static int recur(TreeNode root, int x){
        if(root==null) return -1;
        
        if(root.val<x){
            int ret = recur( root.right, x);
            if (ret==-1) {
                root.right = new TreeNode(x);
                return 1;
            }
            return ret;
        }
        else{
            int ret = recur( root.left, x);
            if (ret==-1) {
                root.left = new TreeNode(x);
                return 1;
            }
            return ret;
        }
    }
}