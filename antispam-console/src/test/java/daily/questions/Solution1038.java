package daily.questions;

class Solution1038 {
    private int s = 0;

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right); 
        s += node.val;
        node.val = s; 
        dfs(node.left); 
    }
}

