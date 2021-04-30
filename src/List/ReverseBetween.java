package List;

public class ReverseBetween {

    /**
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     * 链表中节点数目为 n
     * 1 <= n <= 500
     * -500 <= Node.val <= 500
     * 1 <= left <= right <= n
     * 例如：
     * 输入：head = [1,2,3,4,5], left = 2, right = 4
     * 输出：[1,4,3,2,5]
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left <= 0 || right <= 0 || left >= right)
            return head;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode leftPreNode = null;
        ListNode rightNode = null;
        ListNode temp = dummyHead;
        int pos = 0;
        while (temp != null) {
            if (pos == left - 1)
                leftPreNode = temp;
            if (pos == right)
                rightNode = temp;
            temp = temp.next;
            pos++;
        }
        if (leftPreNode == null)
            return head;
        ListNode leftNode = leftPreNode.next;
        ListNode nowPos = leftPreNode.next;
        leftPreNode.next = null;
        ListNode pre;
        if (rightNode == null) {
            //如果右节点在链表外
            pre = reverseList(nowPos);
            leftPreNode.next = pre;
        } else {
            //如果右节点在链表内
            ListNode rightPostNode = rightNode.next;
            rightNode.next = null;
            pre = reverseList(nowPos);
            leftPreNode.next = pre;
            leftNode.next = rightPostNode;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ReverseBetween reverseBetween=new ReverseBetween();
        ListNode head=new ListNode(3);
        ListNode tail=new ListNode(5);
        head.next=tail;
        reverseBetween.reverseBetween(head,1,2);
    }

    private ListNode reverseList(ListNode nowPos) {
        ListNode pre = null;
        ListNode next;
        while (nowPos != null) {
            next = nowPos.next;
            nowPos.next = pre;
            pre = nowPos;
            nowPos = next;
        }
        return pre;
    }

}
