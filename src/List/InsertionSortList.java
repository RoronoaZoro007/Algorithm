package List;

public class InsertionSortList {

    /**
     * 147 链表的插入排序
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * 示例 2：
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode dummyHead=new ListNode(Integer.MIN_VALUE);
        //preNode表示插入位置的前一个节点
        ListNode preNode=dummyHead;
        while(head!=null){
            while(preNode.next!=null&&preNode.next.val<head.val){
                preNode=preNode.next;
            }
            ListNode headNext=head.next;
            head.next=preNode.next;
            preNode.next=head;
            //复原
            head=headNext;
            preNode=dummyHead;
        }
        return dummyHead.next;
    }
}
