package Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {

    /**
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
     * 第三行再按照从左到右的顺序打印，其他行以此类推。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> tempList = new LinkedList<>();
            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    TreeNode node = queue1.pollLast();
                    tempList.add(node.val);
                    if (node.left != null)
                        queue2.offer(node.left);
                    if (node.right != null) {
                        queue2.offer(node.right);
                    }
                }
            } else {
                while (!queue2.isEmpty()) {
                    TreeNode node = queue2.pollLast();
                    tempList.add(node.val);
                    if (node.right != null) {
                        queue1.offer(node.right);
                    }
                    if (node.left != null)
                        queue1.offer(node.left);
                }
            }
            result.add(tempList);
        }
        return result;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> tempList = new LinkedList<>();
            if (!queue1.isEmpty()) {
                reverse(queue1, queue2, tempList);
            } else {
                reverse(queue2, queue1, tempList);
            }
            result.add(tempList);
        }
        return result;
    }

    private void reverse(Deque<TreeNode> queue1, Deque<TreeNode> queue2, List<Integer> tempList) {
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.pollFirst();
            tempList.add(node.val);
            if (node.left != null)
                queue2.offer(node.left);
            if (node.right != null) {
                queue2.offer(node.right);
            }
        }
    }
}
