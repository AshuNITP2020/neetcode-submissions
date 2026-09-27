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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();

                if (node != null) {
                    subList.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            if (subList.size() > 0)
            list.add(subList);
        }

        return list;
    }

    //DFS
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     Map<Integer, List<Integer>> map = new HashMap<>();
    //     dfs(map, root, 0);

    //     return map.values()
    //               .stream()
    //               .toList();
    // }

    // public void dfs(Map<Integer, List<Integer>> map, TreeNode root, int depth) {
    //     if (root == null) {
    //         return;
    //     }

    //     map.computeIfAbsent(depth, k -> new ArrayList<>())
    //        .add(root.val);

    //     dfs(map, root.left, depth + 1);
    //     dfs(map, root.right, depth + 1);   
    // }
}
