package Others;

import List.ListNode;

import java.util.Stack;

public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.val != stack.pop())
                return false;
            temp = temp.next;
        }
        return true;
    }

    public boolean isPalindromePlus(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode nowPos = slow.next;
        slow.next = null;

        ListNode pre = null;
        ListNode next = null;
        while (nowPos != null) {
            next = nowPos.next;
            nowPos.next = pre;
            pre = nowPos;
            nowPos = next;
        }
        nowPos = pre;

        ListNode head1 = head;
        ListNode head2 = nowPos;
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val)
                return false;
            head1 = head1.next;
            head2 = head2.next;
        }

        pre = null;
        while (nowPos != null) {
            next = nowPos.next;
            nowPos.next = pre;
            pre = nowPos;
            nowPos = next;
        }
        slow.next = pre;
        return true;
    }
}
