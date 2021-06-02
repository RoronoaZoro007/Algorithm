package List;

import java.util.HashMap;

/**
 * 138.复制带随机指针的链表
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * 返回复制链表的头节点。
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 */
public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //用map存映射关系，然后遍历两遍
    public Node copyRandomList(Node head) {
        if(head==null)
            return head;
        Node dummyHead=new Node(-1);
        Node newHead=new Node(head.val);
        dummyHead.next=newHead;
        Node tempHead=head;
        HashMap<Node,Node> map=new HashMap<>();
        while(tempHead!=null&&tempHead.next!=null){
            map.put(tempHead,newHead);
            newHead.next=new Node(tempHead.next.val);
            newHead=newHead.next;
            tempHead=tempHead.next;
        }
        map.put(tempHead,newHead);
        tempHead=head;
        newHead=dummyHead.next;
        while(tempHead!=null){
            Node random=tempHead.random;
            if(random!=null){
                newHead.random=map.get(random);
            }
            tempHead=tempHead.next;
            newHead=newHead.next;
        }
        return dummyHead.next;
    }

    /**
     * 先将每个节点的next设置为其拷贝
     * 然后设置每个新节点的random为其pre节点的random节点的next
     * 最后将奇偶链表断开
     * tip：注意空指针问题
     * @param head
     * @return
     */
    public Node copyRandomList_1(Node head) {
        if(head==null)
            return null;
        Node temp=head;
        while (temp!=null){
            Node newNode=new Node(temp.val);
            newNode.next=temp.next;
            temp.next=newNode;
            temp=temp.next.next;
        }
        temp=head;
        while (temp!=null){
            if(temp.random!=null){
                temp.next.random=temp.random.next;
            }
            temp=temp.next.next;
        }
        Node odd=head;
        Node first=odd;
        Node even=head.next;
        Node second=even;
        while(first!=null){
            first.next=second.next;
            first=first.next;
            if(first!=null){
                second.next=first.next;
                second=second.next;
            }
        }
        return even;
    }
}
