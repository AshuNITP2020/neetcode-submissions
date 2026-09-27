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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        dfs(list, set, root, 0);
        return list;
    }

    public void dfs(List<Integer> list, Set<Integer> set, TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        boolean added = set.add(depth);

        if (added) {
            list.add(root.val);
        }

        dfs(list, set, root.right, depth + 1);
        dfs(list, set, root.left, depth + 1);
    }
}
