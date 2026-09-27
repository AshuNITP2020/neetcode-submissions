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
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[index++]);

        int nodeindex = 0;

        for (int i = start; i <= end; i++) {
            if (inorder[i] == node.val) {
                nodeindex = i;
                break;
            }
        }

        node.left = buildTree(preorder, inorder, start, nodeindex - 1);
        node.right = buildTree(preorder, inorder, nodeindex + 1, end);
        return node;
    }
}
