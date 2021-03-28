package Tree;

import java.util.Deque;
import java.util.LinkedList;

public class Codec {

    /**
     * 请实现两个函数，分别用来序列化和反序列化二叉树。
     * 示例: 
     * 你可以将以下二叉树：
     * <p>
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * 序列化为 "[1,2,3,null,null,4,5]"
     *
     * @param root
     * @return
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        Deque<TreeNode> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            if (node != null) {
                deque.add(node.left);
                deque.add(node.right);
                sb.append(node.val).append(",");
            } else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() <= 2)
            return null;
        String[] temp = data.substring(1, data.length() - 1).split(",");
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(temp[0]));
        deque.add(root);
        int nowPos = 0;
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            nowPos++;
            if (!"null".equals(temp[nowPos])) {
                TreeNode left = new TreeNode(Integer.valueOf(temp[nowPos]));
                node.left = left;
                deque.add(left);
            }
            nowPos++;
            if (!"null".equals(temp[nowPos])) {
                TreeNode right = new TreeNode(Integer.valueOf(temp[nowPos]));
                node.right = right;
                deque.add(right);
            }
        }
        return root;
    }


}
