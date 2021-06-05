package List;

public class RotateRight {

    /**
     * 61、旋转链表
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[4,5,1,2,3]
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k<=0)
            return head;
        ListNode temp = head;
        int len = 0;
        ListNode tail=null;
        while (temp != null) {
            if(temp.next==null)
                tail=temp;
            temp = temp.next;
            len++;
        }
        k = k % len;
        if(k==0)
            return head;
        //中间的分界点
        int needMove=len-k-1;
        temp=head;
        while (needMove>0){
            temp=temp.next;
            needMove--;
        }
        ListNode newHead=temp.next;
        temp.next=null;
        tail.next=head;
        return newHead;
    }
}
