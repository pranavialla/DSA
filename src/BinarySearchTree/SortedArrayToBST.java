
class  SortedArrayToBST{
    public TreeNode getSortedArrayToBST(int[] nums){
        return RecursiveConverstion(0, nums.length-1, nums);

    }


    public TreeNode RecursiveConverstion(int left, int right, int[] nums){
        if(left<=right){
            int mid = left + (right-left)/2;
            TreeNode node = new TreeNode(nums[mid], null, null );
            node.left = RecursiveConverstion( left, mid-1, nums);
            node.right = RecursiveConverstion( mid+1, right, nums);
            return node;
        }
        else {
            return null;
        }
        
        
    }
}