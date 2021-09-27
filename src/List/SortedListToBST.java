package List;

import Tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;

public class SortedListToBST {

    public TreeNode sortedListToBST_1(ListNode head) {
        ArrayList<Integer> numList = new ArrayList<>();
        while (head != null) {
            numList.add(head.val);
            head = head.next;
        }
        return buildTree(numList, 0, numList.size() - 1);
    }

    private TreeNode buildTree(ArrayList<Integer> numList, int startPos, int endPos) {
        if (startPos > endPos) {
            return null;
        }
        ////因为要优先选择偏右的节点作为rootroot，所以+1
        int mid = (startPos + endPos + 1) >> 1;
        TreeNode root = new TreeNode(numList.get(mid));
        root.left = buildTree(numList, startPos, mid - 1);
        root.right = buildTree(numList, mid + 1, endPos);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        ListNode slow=head;
        ListNode fast=head;
        ListNode preSlow=null;
        while(fast!=null&&fast.next!=null){
            preSlow=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode root=new TreeNode(slow.val);
        if(preSlow!=null){
            preSlow.next=null;
            root.left=sortedListToBST(head);
        }
        root.right=sortedListToBST(slow.next);
        return root;
    }


}