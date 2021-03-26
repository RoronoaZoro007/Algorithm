package Tree;

public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0 || preorder.length != inorder.length)
            return null;
        return buildTreeNode(preorder, inorder, 0, preorder.length - 1,
                0, inorder.length - 1);
    }

    public TreeNode buildTreeNode(int[] preorder, int[] inorder, int preStart,
                                  int preEnd, int inStart, int inEnd) {
        if (preStart == preEnd)
            return new TreeNode(preorder[preStart]);
        TreeNode node = new TreeNode(preorder[preStart]);
        int inMid = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                inMid = i;
                break;
            }
        }
        int leftLen = inMid - inStart;
        int rightLen = inEnd - inMid;
        node.left = leftLen <= 0 ? null : buildTreeNode(preorder, inorder, preStart + 1, preStart + leftLen,
                inStart, inMid - 1);
        node.right = rightLen <= 0 ? null : buildTreeNode(preorder, inorder, preStart + leftLen + 1, preEnd,
                inMid + 1, inEnd);
        return node;
    }
}
