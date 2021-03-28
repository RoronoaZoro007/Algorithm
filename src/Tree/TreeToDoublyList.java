package Tree;

public class TreeToDoublyList {

    Node pre;
    Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        getResult(root);
        Node tail = head;
        while (tail != null && tail.right != null) {
            tail = tail.right;
        }
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void getResult(Node cur) {
        if (cur == null)
            return;
        getResult(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        getResult(cur.right);
    }

}
