package leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    static ListNode remove(ListNode node) {
        System.out.println(node.next.val);
        ListNode temp = node.next;
        node.next=temp.next;
        return node.next;
    }
}
