package leetcode;


public class 两数相加 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode pre = new ListNode(0);//指向初始位置
        ListNode cur = pre;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + flag;
            flag = sum / 10;
            sum = sum % 10;//精髓！
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (flag == 1) {
            cur.next = new ListNode(flag);
        }
        return pre.next;
    }
}
