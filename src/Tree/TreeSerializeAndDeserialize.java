package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode
 * 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 */
public class TreeSerializeAndDeserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode temp = queue.pollFirst();
            if (temp != null) {
                sb.append(temp.val).append(",");
                queue.offerLast(temp.left);
                queue.offerLast(temp.right);
            } else {
                sb.append("null").append(",");
            }
        }
        //删除最后一个逗号
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() <= 0)
            return null;
        String[] num = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(num[0]));
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int index = 0;
        while (!deque.isEmpty()) {
            TreeNode temp = deque.pollFirst();
            index++;
            if (index < num.length && !"null".equals(num[index])) {
                TreeNode left = new TreeNode(Integer.parseInt(num[index]));
                temp.left = left;
                deque.offerLast(left);
            }
            index++;
            if (index < num.length && !"null".equals(num[index])) {
                TreeNode right = new TreeNode(Integer.parseInt(num[index]));
                temp.right = right;
                deque.offerLast(right);
            }
        }
        return root;
    }
}
