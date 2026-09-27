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
        maxPathSumCal(root);
        return maxPathSum;
    }

    public int maxPathSumCal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxPathSumCal(root.left));
        int right = Math.max(0, maxPathSumCal(root.right));

        maxPathSum = Math.max(maxPathSum, left + right + root.val);

        return root.val + Math.max(left, right);
    }
}
