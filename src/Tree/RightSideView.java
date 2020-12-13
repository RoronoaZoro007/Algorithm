package Tree;

import java.util.LinkedList;
import java.util.List;

public class RightSideView {

    /**
     * 199.给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     * 思路：找到二叉树的每一层的最右子节点
     * 广度优先遍历，每一层存在同一个list中，取list中的最后一个元素
     *
     * @param root
     * @return
     */
    private List<List<Integer>> result;

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        result = new LinkedList<>();
        getListByTree(root,0);
        List<Integer> returnVal=new LinkedList<>();
        for (int i = 0; i < result.size(); i++) {
            returnVal.add(result.get(i).get(result.get(i).size()-1));
        }
        return returnVal;
    }

    public void getListByTree(TreeNode root, int depth) {
        if (root == null)
            return;
        if (result.size()<depth) {
            result.add(new LinkedList<>());
        }
        result.get(depth).add(root.val);
        getListByTree(root.left,depth+1);
        getListByTree(root.right,depth+1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
