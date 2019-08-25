package code;

public class 删除链表中重复的节点 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public  ListNode deleteDuplication(ListNode pHead)
    {
        ListNode first=new ListNode(-1);
        first.next=pHead;
        ListNode p=pHead,last=first;int val;
        while (p.next!=null&&p!=null){
            if (p.val==p.next.val){
                val=p.val;
                while (p.val==val&&p!=null){
                    p=p.next;
                }
                last.next=p;
            }else {
                last=p;
                p=p.next;
            }
        }
        if(first.next==null)
            return null;
        else
            return first.next;
    }
}
