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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    private void dfs(TreeNode root, StringBuilder sb){
        if(root==null) {
            sb.append("null").append(",");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] st = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(st));

        return build(queue);
    }

    private TreeNode build(Queue<String> queue){
        String string = queue.poll();
        if(string.equals("null")){
            return null;
        }

        TreeNode node  = new TreeNode(Integer.parseInt(string));
        node.left = build(queue);
        node.right = build(queue);
        return node;
    }
}
