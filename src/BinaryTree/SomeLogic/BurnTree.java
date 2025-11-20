class Solution {
    public static int maxTime;

    public static int minTime(Node root, int target) {
        maxTime = Integer.MIN_VALUE;
        burnTree(root, target);
        return maxTime;
    }

    public static int[] burnTree(Node node, int target) {
        if (node == null) {
            return new int[]{-1, 0}; // -1 = target not found, 0 = height
        }

        int[] left = burnTree(node.left, target);
        int[] right = burnTree(node.right, target);

        int currHeight = 1 + Math.max(left[1], right[1]);

        // If current node is the target
        if (node.data == target) {
            maxTime = Math.max(maxTime, currHeight - 1); // subtree burn time
            return new int[]{0, currHeight};
        }

        // If target was found in left subtree
        if (left[0] != -1) {
            int distFromTarget = left[0] + 1;
            maxTime = Math.max(maxTime, distFromTarget + right[1]);
            return new int[]{distFromTarget, currHeight};
        }

        // If target was found in right subtree
        if (right[0] != -1) {
            int distFromTarget = right[0] + 1;
            maxTime = Math.max(maxTime, distFromTarget + left[1]);
            return new int[]{distFromTarget, currHeight};
        }

        // Target not found
        return new int[]{-1, currHeight};
    }
    public static int height(Node root) {
        if (root == null) return 0; // null means no edges
        //if (root.left == null && root.right == null) return 1; // leaf
        return 1 + Math.max(height(root.left), height(root.right));
    }
}