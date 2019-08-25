package code;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class 找出第一个公共节点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if(pHead1==null||pHead2==null)
            return null;
        ListNode cur1=pHead1,cur2=pHead2;
        while (pHead1!=null&&pHead2!=null){
            pHead1=pHead1.next;
            pHead2=pHead2.next;
        }
        while (pHead1!=null){
            pHead1=pHead1.next;
            cur1=cur1.next;
        }
        while (pHead2!=null){
            pHead2=pHead2.next;
            cur2=cur2.next;
        }

        while (cur1!=cur2){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1==cur2?cur1:null;

    }

}
