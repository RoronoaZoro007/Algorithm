package Tree;

public class IsBalanced {

    /**
     * 判断平衡二叉树 offer-55-2
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return getTreeDepth(root) != -1;
    }

    public int getTreeDepth(TreeNode node) {
        if (node == null)
            return 0;
        int left = getTreeDepth(node.left);
        if (left == -1)
            return -1;
        int right = getTreeDepth(node.right);
        if (right == -1)
            return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }

}
