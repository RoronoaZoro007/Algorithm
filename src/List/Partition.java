package List;

/**
 * 86 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 */
public class Partition {

    public ListNode partition(ListNode head, int x) {
        if(head==null)
            return null;
        ListNode minDummyHead=new ListNode(-1);
        ListNode minHead=minDummyHead;
        ListNode maxDummyHead=new ListNode(-1);
        ListNode maxHead=maxDummyHead;
        while(head!=null){
            if(head.val<x){
                minHead.next=head;
                minHead=minHead.next;
                head=head.next;
                minHead.next=null;
            }else {
                maxHead.next=head;
                maxHead=maxHead.next;
                head=head.next;
                maxHead.next=null;
            }
        }
        minHead.next=maxDummyHead.next;
        maxDummyHead.next=null;
        return minDummyHead.next;
    }
}
