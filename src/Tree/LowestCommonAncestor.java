package Tree;

public class LowestCommonAncestor {

    TreeNode result = null;
    TreeNode p = null;
    TreeNode q = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        getResult(root);
        return result;
    }

    public int getResult(TreeNode node) {
        if (node == null)
            return 0;
        int left = getResult(node.left);
        int right = getResult(node.right);
        int nowPos = (node == p || node == q) ? 1 : 0;
        if (left + right + nowPos == 2 && result == null)
            result = node;
        return left + right + nowPos;
    }
}
