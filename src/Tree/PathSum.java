package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {

    /**
     * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     * 示例:
     * 给定如下二叉树，以及目标和 target = 22，
     * <p>
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \    / \
     * 7    2  5   1
     * 返回:
     * [
     * [5,4,11,2],
     * [5,8,4,5]
     * ]
     */

    List<List<Integer>> result;
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        result = new ArrayList<>();
        this.target = target;
        if (root != null)
            getPathSum(root, new LinkedList<>(), 0);
        return result;
    }

    public void getPathSum(TreeNode root, List<Integer> temp, int sum) {
        if (root.left == null && root.right == null) {
            if (sum + root.val == target) {
                ArrayList<Integer> out = new ArrayList<>(temp);
                out.add(root.val);
                result.add(out);
            }
            return;
        }
        temp.add(root.val);
        if (root.left != null) {
            getPathSum(root.left, temp, sum + root.val);
        }
        if (root.right != null) {
            getPathSum(root.right, temp, sum + root.val);
        }
        temp.remove(temp.size() - 1);
    }
}
