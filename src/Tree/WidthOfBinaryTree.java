package Tree;

import java.util.Deque;
import java.util.LinkedList;

public class WidthOfBinaryTree {

    public static void main(String[] args) {
        WidthOfBinaryTree widthOfBinaryTree=new WidthOfBinaryTree();
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(3);
        root.right=new TreeNode(2);
        TreeNode node=root;
        node=node.left;
        node.left=new TreeNode(5);
        widthOfBinaryTree.widthOfBinaryTree(root);

    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> deque1 = new LinkedList<>();
        Deque<TreeNode> deque2 = new LinkedList<>();
        Deque<Long> levelPos = new LinkedList<>();
        long maxWidth = 1;
        deque1.offerLast(root);
        levelPos.offerLast(0L);
        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            TreeNode temp;
            int nowPos;
            maxWidth = Math.max(maxWidth, levelPos.isEmpty()?1:levelPos.peekLast() - levelPos.peekFirst() + 1);
            if (!deque1.isEmpty())
                levelTraverse(deque1, deque2, levelPos);
            maxWidth = Math.max(maxWidth, levelPos.isEmpty()?1:levelPos.peekLast() - levelPos.peekFirst() + 1);
            if (!deque2.isEmpty())
                levelTraverse(deque2, deque1, levelPos);
        }
        return (int)maxWidth;
    }

    private void levelTraverse(Deque<TreeNode> deque1, Deque<TreeNode> deque2, Deque<Long> levelPos) {
        Long nowPos;
        TreeNode temp;
        while (!deque1.isEmpty()) {
            temp = deque1.pollFirst();
            nowPos = levelPos.pollFirst();
            if (temp.left != null) {
                deque2.offerLast(temp.left);
                levelPos.offerLast(nowPos * 2 + 1);
            }
            if (temp.right != null) {
                deque2.offerLast(temp.right);
                levelPos.offerLast(nowPos * 2 + 2);
            }
        }
    }
}
