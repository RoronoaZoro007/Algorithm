package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

    public List<Integer> preOrder(TreeNode root) {
        return getPreOrder(root, new ArrayList<>());
    }

    public List<Integer> getPreOrder(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null)
            return result;
        result.add(treeNode.val);
        getPreOrder(treeNode.left, result);
        getPreOrder(treeNode.right, result);
        return result;
    }

    public List<Integer> preOrderNoRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null)
                stack.add(node.right);
            if (node.left != null)
                stack.add(node.left);
        }
        return result;
    }

    public List<Integer> MorrisPreOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode mostRight = cur.left;
                //找到最右节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    result.add(cur.val);
                    cur = cur.left;
                }
                if (mostRight.right == cur) {
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
        }
        return result;
    }
}
