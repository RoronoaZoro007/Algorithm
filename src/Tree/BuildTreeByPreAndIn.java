package Tree;

public class BuildTreeByPreAndIn {

    public static void main(String[] args) {
        buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    /**
     * 105.根据前序+中序恢复二叉树（假设树中的数值不重复）
     * @param preOrder
     * @param inOrder
     * @return
     */
    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
        return buildTreeByPreAndIn(preOrder, inOrder, 0, 0, inOrder.length - 1);
    }

    public static TreeNode buildTreeByPreAndIn(int[] preOrder, int[] inOrder, int preStartPos, int inStartPos, int inEndPos) {
        if (inStartPos > inEndPos)
            return null;
        TreeNode root = new TreeNode(preOrder[preStartPos]);
        int leftLen = 0;
        int rightLen = 0;
        for (int i = inStartPos; i <= inEndPos; i++) {
            if (inOrder[i] == preOrder[preStartPos]) {
                leftLen = i - inStartPos;
                rightLen = inEndPos - i;
                break;
            }
        }
        root.left = buildTreeByPreAndIn(preOrder, inOrder, preStartPos + 1, inStartPos, inStartPos + leftLen - 1);
        root.right = buildTreeByPreAndIn(preOrder, inOrder, preStartPos + leftLen + 1, inEndPos - rightLen + 1, inEndPos);
        return root;
    }
}
