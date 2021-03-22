package List;

public class ReverseKGroup {

    /**
     * 25.K个一组翻转链表给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1)
            return head;
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode tail = head;
        int m = k;
        while (k > 1) {
            if (tail == null)
                return pre.next;
            tail = tail.next;
            k--;
        }
        if (tail == null)
            return pre.next;
        tail.next = reverseKGroup(tail.next, m);
        while (head != tail) {
            pre.next = head.next;
            head.next = tail.next;
            tail.next = head;
            head = pre.next;
        }
        return pre.next;
    }

//    public ListNode reverseKGroup1(ListNode head, int k) {
//        if (head == null || k <= 1)
//            return head;
//        int len = 0;
//        ListNode temp = head;
//        while (temp != null) {
//            len++;
//            temp = temp.next;
//        }
//        ListNode pre = new ListNode();
//        pre.next = head;
//        for (int i = 0; i < len / k; i++) {
//            ListNode everyPre = new ListNode();
//            everyPre.next = head;
//
//        }
//    }

    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = new ListNode();
        pre.next = head;
        while (head != tail) {
            pre.next = head.next;
            head.next = tail.next;
            tail.next = head;
            head = pre.next;
        }
        return pre.next;
    }

}
