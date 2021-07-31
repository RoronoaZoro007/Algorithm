package Tree;

public class Connect {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //用来表示下一层的起始node
    Node nextStart = null;
    //用来表示遍历的下一层的当前节点的前一个节点
    Node nextPre = null;

    public Node connect(Node root) {
        if (root == null)
            return root;
        Node cur = root;
        while (cur != null) {
            //每次进入新的一层，都需要将nextStart和nextPre重新进行更新为null
            //后序根据是否为null，可以更新对应的下一层的nextStart和nextPre
            nextStart = null;
            nextPre = null;
            while (cur != null) {
                if (cur.left != null) {
                    connectChild(cur.left);
                }
                if(cur.right!=null){
                    connectChild(cur.right);
                }
                cur = cur.next;
            }
            cur = nextStart;
        }
        return root;
    }

    private void connectChild(Node node) {
        if (nextStart == null) {
            nextStart = node;
        }
        if (nextPre != null) {
            nextPre.next = node;
        }
        nextPre = node;
    }
}
