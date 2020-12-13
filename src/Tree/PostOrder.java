package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {

    public List<Integer> postOrder(TreeNode root) {
        return getPostOrder(root, new ArrayList<>());
    }

    public List<Integer> getPostOrder(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null)
            return result;
        getPostOrder(treeNode.left, result);
        getPostOrder(treeNode.right, result);
        result.add(treeNode.val);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        TreeNode node = root.left;
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        System.out.println(postOrderNoRecursion_1(root));
        ;
    }

    public static List<Integer> postOrderNoRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (!stack.isEmpty() && stack.peek() == root) {
                if (root.right != null) {
                    stack.push(root.right);
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                    stack.push(root.left);
                }
            } else {
                result.add(root.val);
            }
        }
        return result;
    }

    public static List<Integer> postOrderNoRecursion_1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right != null && root.right != pre) {
                stack.push(root);
                root = root.right;
            } else {
                result.add(root.val);
                pre = root;
                root=null;
            }
        }
        return result;
    }

    public List<Integer> MorrisPostOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        TreeNode cur = root;
        while (cur != null) {

        }
        return result;
    }
}


