package Tree;

public class RecoverBinarySearchTree {

    /**
     * 99.给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
     * 二叉搜索树：树的左子树小于根节点，树的右子树大于根节点
     * tip:二叉搜索树的中序遍历是有序的，从小到大的
     * 中序遍历BST，依次访问的节点值是递增的，错误的BST会破坏递增性，就能定位出错误。
     * 错误只会有两种：
     * 错误1，出现了两对不满足前小后大，将第一对的第一个元素与第二对的第二个元素交换。
     * 错误2，只出现一对不满足前小后大，交换这一对就行。
     *
     * @param root
     */

    private TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    private TreeNode first = null; //记录第一对的前一个
    private TreeNode second = null; //记录第一对或第二对的后一个

    public void recoverTree(TreeNode root) {
        recoverTree_func(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }

    public void recoverTree_func(TreeNode root) {
        if (root == null)
            return;
        recoverTree_func(root.left);
        if (root.val < pre.val && first == null) {
            first = pre;
        }
        if (root.val < pre.val && first != null) {
            second = root;
        }
        pre = root;
        recoverTree_func(root.right);
    }
}
