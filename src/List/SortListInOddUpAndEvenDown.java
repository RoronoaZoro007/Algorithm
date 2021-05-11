package List;

public class SortListInOddUpAndEvenDown {

    public static void main(String[] args) {
        ListNode root=new ListNode(-1);
        ListNode temp=root;
        int[] arr=new int[]{1,8,3,6,5,4,7,2};
        for (int i = 0; i < arr.length; i++) {
            temp.next=new ListNode(arr[i]);
            temp=temp.next;
        }
        SortListInOddUpAndEvenDown sortListInOddUpAndEvenDown=new SortListInOddUpAndEvenDown();
        ListNode node=sortListInOddUpAndEvenDown.sort(root.next);
        temp=node;
        while (temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }
    }


    //链表，奇数位置按序增长，偶数位置按序递减，如何能实现链表从小到大？
    public ListNode sort(ListNode node){
        if(node==null||node.next==null)
            return node;
        ListNode odd=node;
        ListNode oddHead=odd;
        ListNode even=node.next;
        ListNode evenHead=even;
        //拆分奇偶链表
        while(odd!=null&&even!=null){
            odd.next=even.next;
            odd=odd.next;
            if(odd!=null){
                even.next=odd.next;
                even=even.next;
            }
        }
        //反转偶链表
        ListNode evenPre=null;
        ListNode next=null;
        while(evenHead!=null){
            next=evenHead.next;
            evenHead.next=evenPre;
            evenPre=evenHead;
            evenHead=next;
        }
        evenHead=evenPre;
        //合并排序链表
        ListNode dummyHead=new ListNode();
        ListNode nowPos=dummyHead;
        while(oddHead!=null&&evenHead!=null){
            if(oddHead.val<evenHead.val){
                nowPos.next=oddHead;
                oddHead=oddHead.next;
                nowPos=nowPos.next;
            }else{
                nowPos.next=evenHead;
                evenHead=evenHead.next;
                nowPos=nowPos.next;
            }
        }
        nowPos.next=oddHead==null?evenHead:oddHead;
        return dummyHead.next;
    }
}
