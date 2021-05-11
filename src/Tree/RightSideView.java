package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public List<Integer> rightSideView_1(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        queue1.add(root);
        while (!queue1.isEmpty()||!queue2.isEmpty()){
            while(!queue1.isEmpty()){
                TreeNode node=queue1.poll();
                if(queue1.size()==0)
                    result.add(node.val);
                if(node.left!=null)
                    queue2.add(node.left);
                if(node.right!=null)
                    queue2.add(node.right);
            }
            while(!queue2.isEmpty()){
                TreeNode node=queue2.poll();
                if(queue2.size()==0)
                    result.add(node.val);
                if(node.left!=null)
                    queue1.add(node.left);
                if(node.right!=null)
                    queue1.add(node.right);
            }
        }
        return result;
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
