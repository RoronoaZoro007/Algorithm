package List;

/**
 * 24.两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd = head;
        ListNode head1=odd;
        ListNode even = head.next;
        ListNode head2=even;
        while (odd != null&&even!=null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd == null ? null : odd.next;
            even = even.next;
        }
        ListNode dummyHead=new ListNode();
        ListNode nowPos=dummyHead;
        while (head2!=null||head1!=null){
            if(head2!=null){
                nowPos.next=head2;
                nowPos=nowPos.next;
                head2=head2.next;
            }
            if(head1!=null){
                nowPos.next=head1;
                nowPos=nowPos.next;
                head1=head1.next;
            }
        }
        return dummyHead.next;
    }
}
