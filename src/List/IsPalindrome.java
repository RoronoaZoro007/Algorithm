package List;

public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        ListNode dummyHead=new ListNode();
        dummyHead.next=head;
        ListNode preSlow=dummyHead;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            preSlow=preSlow.next;
            slow=slow.next;
            fast=fast.next.next;
        }
        preSlow.next=null;
        ListNode pre=null;
        ListNode next=null;
        while(slow!=null){
            next=slow.next;
            slow.next=pre;
            pre=slow;
            slow=next;
        }
        while (head!=null&&pre!=null){
            if(head.val!=pre.val)
                return false;
            head=head.next;
            pre=pre.next;
        }
        return true;
    }
}
