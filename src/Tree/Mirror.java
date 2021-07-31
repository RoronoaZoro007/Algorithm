package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Mirror {

    public void Mirror(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode curr, temp;
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            curr = nodes.poll();
            temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (curr.left != null) nodes.offer(curr.left);
            if (curr.right != null) nodes.offer(curr.right);
        }
    }
}
