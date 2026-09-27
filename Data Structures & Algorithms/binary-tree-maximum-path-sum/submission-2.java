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

    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSum(root, Integer.MIN_VALUE);
        return maxPathSum;
    }

    public int maxPathSum(TreeNode root, int currentSum) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxPathSum(root.left, currentSum + root.val));
        int right = Math.max(0, maxPathSum(root.right, currentSum + root.val));

        maxPathSum = Math.max(maxPathSum, left + right + root.val);

        return Math.max(root.val + left, root.val + right);
    }
}
