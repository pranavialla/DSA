class Validate{
    Validate(TreeNode root){
        boolean isValid = isBST(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
        System.out.println(isValid);
    }

    public boolean isBST(int lowerBound, int upperBound, TreeNode root){
        if(root!=null){
            if(lowerBound<root.value && root.value<upperBound){
                return  isBST(lowerBound, root.value, root.left) && isBST(root.value, upperBound, root.right) ;
            }
            else return false;
        }
        return true;
    }

}