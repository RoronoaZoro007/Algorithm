package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NChildLevelOrder {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 429.N叉树层序遍历
     * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
     *
     * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        Queue<Node> queue_1=new LinkedList<>();
        Queue<Node> queue_2=new LinkedList<>();
        queue_1.add(root);
        while(!queue_1.isEmpty()||!queue_2.isEmpty()){
            if(!queue_1.isEmpty()){
                levelExtracted(result, queue_1, queue_2);
            }else{
                levelExtracted(result, queue_2, queue_1);
            }
        }
        return result;
    }

    private void levelExtracted(List<List<Integer>> result, Queue<Node> queue_1, Queue<Node> queue_2) {
        List<Integer> temp=new ArrayList<>();
        while (!queue_1.isEmpty()){
            Node node= queue_1.poll();
            queue_2.addAll(node.children);
            temp.add(node.val);
        }
        result.add(temp);
    }
}
