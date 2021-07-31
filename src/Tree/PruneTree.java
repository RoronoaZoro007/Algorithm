package Tree;

/**
 * 814 二叉树剪枝
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 * <p>
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * <p>
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 * <p>
 * 示例1:
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 * <p>
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 */
public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        return getResult(root) ? null : root;
    }

    private boolean getResult(TreeNode root) {
        if (root == null)
            return true;
        //表示左子树是否全为0
        boolean left = getResult(root.left);
        //表示右子树是否全为0
        boolean right = getResult(root.right);
        if (left)
            root.left = null;
        if (right)
            root.right = null;
        //左子树全为0&&右子树全为0&&当前root的val也为0
        return left && right && (root.val == 0);
    }

}
