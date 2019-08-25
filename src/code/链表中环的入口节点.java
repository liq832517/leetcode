package code;

public class 链表中环的入口节点 {
    class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null)
            return null;
        ListNode cur1=pHead.next;//cur1 为一速指针
        if(cur1==null)
            return null;
        ListNode cur2=pHead.next.next;//cur2 为二速指针

        while (cur1!=cur2){//在环内相遇，此时count为cur2比cur1多走的步数，且cur2正好超出cur1一个环的长度。
            cur1=cur1.next;
            cur2=cur2.next.next;
        }

        while (cur1!=pHead){//此时cur1在距离起点一个环长度的位置，phead为起点，两个节点相遇时必定在环入口。
            cur1=cur1.next;
            pHead=pHead.next;
        }

        return pHead;

    }
}
