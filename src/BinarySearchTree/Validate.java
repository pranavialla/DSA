class Validate{
    Validate(TreeNode root){
        boolean isValid = isBST(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
        System.out.println(isValid);
    }

    public boolean isBST(int lowerBound, int upperBound, TreeNode root){
        if(root!=null){
            if(lowerBound<root.val && root.val<upperBound){
                return  isBST(lowerBound, root.val, root.left) && isBST(root.val, upperBound, root.right) ;
            }
            else return false;
        }
        return true;
    }

}