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
    int count = 0;

    public int goodNodes(TreeNode root) {
        goodNodes(root, root.val);
        return count;
    }

    public void goodNodes(TreeNode root, int maxSofar) {
        if (root == null) {
            return;
        }

        if (root.val >= maxSofar) {
            count++;
            maxSofar = root.val;
        }

        goodNodes(root.left, maxSofar);
        goodNodes(root.right, maxSofar);
    }
}
