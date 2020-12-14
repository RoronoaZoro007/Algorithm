package Tree;

import java.util.ArrayList;
import java.util.List;

public class AllBinaryTreePath {

    /**
     * 257
     * 输入:
     * <p>
     * 1
     * /   \
     * 2     3
     * \
     * 5
     * <p>
     * 输出: ["1->2->5", "1->3"]
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     *
     * @param root
     * @return
     */
    List<String> result = null;

    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        if (root==null)
            return result;
        getBinaryTreePaths(root, "");
        return result;
    }

    public void getBinaryTreePaths(TreeNode root, String s) {
        if (root.left == null && root.right == null) {
            result.add(s + root.val);
            return;
        }
        if (root.left != null)
            getBinaryTreePaths(root.left, s + root.val + "->");
        if (root.right != null)
            getBinaryTreePaths(root.right, s + root.val + "->");
    }
}
