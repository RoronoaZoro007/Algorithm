package List;

public class MergeInBetween {

    /**
     * 1669 合并两个链表
     * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
     * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
     * 下图中蓝色边和节点展示了操作后的结果：
     * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
     * 输出：[0,1,2,1000000,1000001,1000002,5]
     * 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummyHead=new ListNode();
        dummyHead.next=list1;
        ListNode preANode=dummyHead;
        //找的是a的前面一个
        while(a>0){
            preANode=preANode.next;
            a--;
        }
        //找的是b+1的前面一个，因此判断条件为=，较b多移动一下
        ListNode preBNode=dummyHead;
        while(b>=0){
            preBNode=preBNode.next;
            b--;
        }
        ListNode tail=list2;
        while(tail.next!=null){
            tail=tail.next;
        }
        preANode.next=list2;
        tail.next=preBNode.next;
        return dummyHead.next;
    }
}
