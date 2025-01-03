package BinaryTree;

public class BalancedBinaryTree {
    public boolean isBalanced(Node root) {
        return diffInHight( root )!=-1;
    }
    public int diffInHight(Node node){
        if(node!=null){
            int l = diffInHight( node.left );
            int r = diffInHight( node.right );

            if( l==-1 || r==-1 || Math.abs(l-r)>1){
                return -1;
            }
            return  Math.max(l, r) + 1;
        }
        return 0;
    }
}
