package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

    public List<Integer> inOrder(TreeNode root) {
        return getInOrder(root, new ArrayList<>());
    }

    public List<Integer> getInOrder(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null)
            return result;
        getInOrder(treeNode.left, result);
        result.add(treeNode.val);
        getInOrder(treeNode.right, result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        inOrderNoRecursion(root);
    }

    public static List<Integer> inOrderNoRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            System.out.println(root.val);
            root = root.right;
        }
        return result;
    }
}
